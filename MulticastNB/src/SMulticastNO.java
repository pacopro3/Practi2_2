import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class SMulticastNO{
    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException{
            System.out.printf("Interfaz:%s\n",netint.getDisplayName());
            System.out.printf("Nombre:%s\n",netint.getName());
            Enumeration<InetAddress> inetAdresses = netint.getInetAddresses();
            for(InetAddress inetAddress:Collections.list(inetAdresses)){
                System.out.printf("InetAddress:%s\n",inetAddress);
            }
            System.out.println("\n");    
    }

    public static void main(String[] args) {
        int pto=2000;
        try {
            InetSocketAddress dir = new InetSocketAddress(pto);
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for(NetworkInterface netint:Collections.list(nets)){
                displayInterfaceInformation(netint);
            }
            NetworkInterface ni = NetworkInterface.getByName("eth3");
            DatagramChannel s = DatagramChannel.open(StandardProtocolFamily.INET);
            s.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            s.setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
            s.configureBlocking(false);
            Selector sel = Selector.open();
            s.register(sel, SelectionKey.OP_READ);
            InetAddress group = InetAddress.getByName("230.0.0.1");
            s.join(group, ni);
            s.socket().bind(dir);
            ByteBuffer b = ByteBuffer.allocate(4);
            System.out.println("Servidor listo");
            while (true) {
                sel.select();
                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey k = (SelectionKey)it.next();
                    it.remove();
                    if(k.isReadable()){
                        DatagramChannel ch = (DatagramChannel)k.channel();
                        b.clear();
                        SocketAddress emisor = ch.receive(b);
                        b.flip();
                        InetSocketAddress d = (InetSocketAddress)emisor;
                        System.out.println("Datagrama recibido desde " +d.getAddress() + ":"+ d.getPort());
                        System.out.println("Dato: "+b.getInt());
                        continue;
                    }
                }
            }
            } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
    }
}

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
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
    }
}

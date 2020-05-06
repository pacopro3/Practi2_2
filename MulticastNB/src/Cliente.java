
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sweet
 */
public class Cliente extends Thread{
    
    public static void main(String[] args) {
        int pto=4000;
        String hhost = "230.1.1.1";
        InetSocketAddress dir = new InetSocketAddress(pto);
        final SocketAddress remote = new InetSocketAddress(hhost, pto);
        final String persona;
        Inicio i = new Inicio();
        boolean f = true;
        Interfaz in = new Interfaz();
        String text="";
        
        //se conecta primero al chat, 
        //si la conexión es correcta se procede con las validaciones, 
        //sino es correcta entonces se tiene que cerrar la app
        
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for(NetworkInterface netint:Collections.list(nets)){
                //displayInterfaceInformation(netint);
            }
            NetworkInterface ni = NetworkInterface.getByName("eth2");
            DatagramChannel cl = DatagramChannel.open(StandardProtocolFamily.INET);
            cl.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            cl.setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
            cl.configureBlocking(false);
            cl.socket().bind(dir);
            InetAddress group = InetAddress.getByName("230.1.1.1");
            cl.join(group,ni);
            
            //hasta aquí se realiza la conexión de forma correcta
            
            i.setVisible(true);
            do{
                try {
                if(i.getValue()==true){ 
                    text=i.getText();
                    if(in.comprobar(text)){
                        i.returnValue();
                        text="";
                    }else f=false;
                }
                Thread.sleep(200);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }while(f);
            persona = text;
            i.setVisible(false);
            i.dispose();
            in.setVisible(true);
            in.insertarArray("Todos");
            //aquí ya se inicia el chat
            
            Thread reader = null;

                final Selector selector_read = Selector.open();
                
                cl.register(selector_read, SelectionKey.OP_READ);

                reader = new Thread() {

                    @Override
                    public void run() {
                        try {
                            ByteBuffer bb = ByteBuffer.allocate(256);
                            String people = persona;
                            while (true){
                                selector_read.select();
                                Iterator<SelectionKey> iterator = selector_read.selectedKeys().iterator();
                                while (iterator.hasNext()) {
                                    SelectionKey key = iterator.next();
                                    if (key.isReadable()) {
                                        DatagramChannel dc = (DatagramChannel) key.channel();
                                        SocketAddress emisor = dc.receive(bb);
                                        InetSocketAddress d = (InetSocketAddress)emisor;
                                        bb.flip();
                                        String converted = new String(bb.array(), "UTF-8");
                                        converted = converted.trim();
                                        if(converted.equals("100")){
                                            System.out.println("Entramos a un nuevo usuario");
                                        }else{
                                            System.err.println(converted  + " Mensaje recibido de " + people + "\n");
                                            in.writeMsj(converted);
                                        }
                                        bb.clear();
                                        iterator.remove();
                                    }
                                }
                            }
                        } catch (UnsupportedEncodingException ex) {
                            //Logger.getLogger(ReceiverApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            //Logger.getLogger(ReceiverApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                };
                reader.setName("reader");
                reader.start();
            
                Thread writer = null;
                final Selector selector_write = Selector.open();
                cl.register(selector_write, SelectionKey.OP_WRITE);
                writer = new Thread() {

                    @Override
                    public void run() {
                        try {
                            ByteBuffer bb = ByteBuffer.allocate(256);
                            String people = persona;
                            while (true) {
                                selector_write.select();
                                Iterator<SelectionKey> iterator = selector_write.selectedKeys().iterator();
                                while (iterator.hasNext()) {
                                    SelectionKey key = iterator.next();
                                    if (key.isWritable()) {
                                        DatagramChannel ch = (DatagramChannel)key.channel();
                                        bb.clear();
                                        if(in.getFlag()){
                                            String msj = in.getText();
                                            String tipo = "";
                                            String destino = "";
                                            String texto = msj;
                                            
                                            System.err.println("El texto que " + people + " envía: " + texto + "\n");
                                            bb = ByteBuffer.wrap(texto.getBytes("UTF-8"),0,texto.length());
                                            ch.send(bb, remote);
                                            in.setText("");
                                            in.setFlag(false);
                                        }
                                        try{Thread.sleep(500);}catch(Exception e){e.printStackTrace();}
                                        continue;  
                                    }
                                }
                            }
                        } catch (UnsupportedEncodingException ex) {
                            //Logger.getLogger(ReceiverApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            //Logger.getLogger(ReceiverApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                };
                writer.setName("writer");
                writer.start();
            

            Scanner readline = new Scanner(System.in);
            readline.nextLine();
            

            
            reader.interrupt();
            writer.interrupt();
                
           
        

        } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
    }
    
    public void run(){
        
    }
    
    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException{
            System.out.printf("Interfaz:%s\n",netint.getDisplayName());
            System.out.printf("Nombre:%s\n",netint.getName());
            Enumeration<InetAddress> inetAdresses = netint.getInetAddresses();
            for(InetAddress inetAddress:Collections.list(inetAdresses)){
                System.out.printf("InetAddress:%s\n",inetAddress);
            }
            System.out.println("\n");    
    }
    
}
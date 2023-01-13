package com.example.client;

import com.example.model.message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Connect implements Runnable{
    private static final String HASCONNECTED = "has connected";

    private static String picture;
    private Socket socket;
    public String hostname;
    public int port;
    private static ObjectOutputStream oos;
    private InputStream is;
    private ObjectInputStream input;
    private OutputStream outputStream;
    Logger logger = LoggerFactory.getLogger(Connect.class);


    public Connect(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(hostname, port);
            ClientConServer.getInstance().showScene();
            outputStream = socket.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            is = socket.getInputStream();
            input = new ObjectInputStream(is);

        } catch (IOException e) {
            ClientConServer.getInstance().showErrorDialog("Could not connect to server");
            logger.error("Could not Connect");
        }
        logger.info("Connection accepted " + socket.getInetAddress() + ":" + socket.getPort());

        logger.info("Sockets in and out ready!");
        while (socket.isConnected()){
            System.out.println("Conected");
            break;
        }
    }
  /*  public static void send(int meja,String order,String TotalHarga,String waktu,String Pembayaran) throws IOException {
        message createMessage = new message();
        createMessage.setMeja();
        createMessage.setOrder();
        createMessage.setTotalHarga();
        createMessage.setWaktu();
        createMessage.setPembayaran();
        oos.writeObject(createMessage);
        oos.flush();
    }*/
    public static void send(int meja,String order,String TotalHarga,String waktu,String Pembayaran) throws IOException {
        message createMessage = new message();
        createMessage.setMeja(meja);
        createMessage.setOrder(order);
        createMessage.setTotalHarga(TotalHarga);
        createMessage.setWaktu(waktu);
        createMessage.setPembayaran(Pembayaran);        oos.writeObject(createMessage);
        oos.flush();
    }




}

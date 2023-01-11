package com.example.server;

import javafx.scene.image.Image;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class coba {
    /*try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/rplt","user", "password");
        while (true){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            while (resultSet.next()) {
                Blob imager = resultSet.getBlob("image");
                int bloblength = (int) imager.length();
                byte[] blobAsBytes = imager.getBytes(1, bloblength);
                Image imge = new Image(new ByteArrayInputStream(blobAsBytes));

                String namaMenu = resultSet.getString("nama_menu");
                BigDecimal harga = resultSet.getBigDecimal("harga");
            }
        }
    }catch (IOException | ClassNotFoundException | SQLException e){e.printStackTrace();
    }*/
}

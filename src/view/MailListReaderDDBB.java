/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import kata5p2.Mail;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderDDBB {

    public static List<Mail> read(String fileName) {
        ArrayList<Mail> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM mails");

            while (rs.next()) {
                list.add(new Mail(rs.getString("mail")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

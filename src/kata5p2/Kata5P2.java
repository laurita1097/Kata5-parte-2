/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2;

import kata5p2.Histogram;
import kata5p2.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReaderDDBB;

import java.sql.*;
import java.util.Calendar;
import java.util.List;

public class Kata5P2 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM HISTORICO_CAMBIOS WHERE DIVISA_DESDE='EUR' AND DIVISA_A='USD'");

            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + " --> "
                        + rs.getString(2)
                        + " - " + rs.getDouble(3)
                        + " ≠ "
                        + rs.getTimestamp(6, Calendar.getInstance())
                        + " --- "
                        + rs.getTime(6, Calendar.getInstance()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void execute() {
        input();
        proccess();
        output();
    }

    private void input() {
        fileName = "KATA5.sqlite";
        mailList = MailListReaderDDBB.read(fileName);
    }

    private void proccess() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}

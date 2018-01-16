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
import java.util.List;

public class Kata5P2 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) {
        Kata5P2 kata = new Kata5P2();
        kata.execute();
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


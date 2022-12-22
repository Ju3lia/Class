/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.files;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import static com.sun.java.accessibility.util.EventID.KEY;
import static java.awt.PageAttributes.MediaType.D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.text.Collator.PRIMARY;

/**
 *
 * @author Student
 */
public class ReadTxt {
   public static void main(String[] args) throws Exception {
//        File file = new File("D:\\Документы\\NetBeansProjects\\files\\src\\main\\java\\com\\mycompany\\files\\description.txt");
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String st;
//            while ((st = br.readLine()) != null)
//            System.out.println(st);
    
    ReadLink.readLine("D:\\Документы\\NetBeansProjects\\files\\src\\main\\java\\com\\mycompany\\files\\nameFields.csv");
    String sql = "CREATE TABLE my_table (";
    CSVReader ReadLink;
   try {
        FileReader filereader = new FileReader("D:\\Документы\\NetBeansProjects\\files\\src\\main\\java\\com\\mycompany\\files\\nameFields.csv");
          CSVReader csvReader = new CSVReader(filereader);
          String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
            for (String str : nextRecord) {
              if (str.equals("PRIMARY KEY")) sql+= "PRIMARY KEY";
                      else sql +=");";
                              System.out.println(sql);
            }
        }
    } catch (CsvValidationException | IOException e) {
        e.printStackTrace();
    }
   
}
}

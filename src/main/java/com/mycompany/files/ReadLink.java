/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.files;
import com.opencsv.CSVReader;
import java.io.FileReader;

/**
 *
 * @author Student
 */
public class ReadLink {
    public static void readLine(String file)
{
    try {
        FileReader filereader = new FileReader(file);
          CSVReader csvReader = new CSVReader(filereader);
          String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
            System.out.print(cell + "\t");
            }
            System.out.println();
            }
        }
        catch (Exception e) {
        e.printStackTrace();
}
}
}
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Student
 */
public class SQL {

    public static void main(String[] args) {
         try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) 
        {
            if (conn == null) {
                System.out.println("Failed to make connection!");
                return;
            }
            Statement statement = conn.createStatement();
            
            String sqlBuff = "CREATE TABLE IF NOT EXISTS factory(" +
                                "factory_id serial PRIMARY KEY);";
            statement.execute(sqlBuff);
            
            sqlBuff = "CREATE TABLE IF NOT EXISTS station (" +
                        "station_id int," +
                        "station_name varchar(20) PRIMARY KEY," +
                        "time_open time(0)," +
                        "time_close time(0));";      
            statement.execute(sqlBuff);
            sqlBuff = "CREATE TABLE IF NOT EXISTS store (" 
                    +"store_id INT PRIMARY KEY," 
                    +"store_name VARCHAR(20)," 
                    +"store_product TEXT," 
                    +"store_open BOOLEAN);";      
            statement.execute(sqlBuff);
            statement.close();
            conn.close();          
        }
        
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


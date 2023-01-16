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
        
       // String[]column = {"col1","col2","col3","col4"};
       // String [] column1 = {"val1","val2", "val3"};
       // updateRows ("my_table", "col_to_upd", "cond_col", column, column1);
        var name = "my_table";
        var url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        var user = "postgres";
        var pass = "postgres";
        var handler = Post.getInstance();
        var flag = handler.connect(url, user, pass);
         if (flag) {
           System.out.println("Connected");
       
           var arr = new String[3];
           arr[0] = "id int PRIMARY KEY";
           arr[1] = "name text";
           arr[2] = "last_name varchar(100)";
           flag = handler.createTable("my_table", arr);
           if (flag) System.out.println("Created");
        
           
           String [] column = new String []{"id","name","last_name"};
           
           String[][] array = new String[3][3];
           String[] tmp = {"10","'sadfsaf'","'ytuy'"};
           array[0] = tmp.clone();
           String[] plp = {"20","'sadfs'","'yt'"};
           array[1] = plp.clone();
           String[] php = {"15","'sad'","'ytjhfjdh'"};
           array[2] = php.clone();
           int flug = handler.insert(array, name, column);
           System.out.println(flug);
           } String [] column = new String []{"id","name","last_name"};
           
//           String[][] array = new String[3][3];
//           String[] tmp = {"10","'sadfsaf'","'ytuy'"};
//           array[0] = tmp.clone();
//           String[] plp = {"20","'sadfs'","'yt'"};
//           array[1] = plp.clone();
//           String[] php = {"15","'sad'","'ytjhfjdh'"};
//           array[2] = php.clone();
//           int flug = handler.insert(array, name, column);
//           System.out.println(flug);
         
           var list = handler.select("name,id", name);
           System.out.println(list);
           
           String [] arr = {"10", "15"};
           String [] ar = {"qwerty", "poiuy"};
           int flug = handler.updateRows(name, "name", "id" , arr , ar);
           System.out.println(flug);
           
           String [] arrr = {"11111"};
           boolean flog = handler.updateColumns(name, column, arrr, "name like 'qwerty'");
           System.out.println(flog);
           list = handler.select("name,id", name);
           System.out.println(list);
           }
}
       
       
       /* try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) 
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
        }*/



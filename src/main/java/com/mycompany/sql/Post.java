/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sql;

import java.sql.Connection;

/**
 *
 * @author Student
 */
public class Post implements SQLint {

    @Override
    public Connection connect(String url, String username, String password) {
           if (username.length() < 5){
               System.out.println("Пользователь некорректен");
           }
           return null;
    }

    @Override
    public boolean createTable(String tableName, String[] params) {
       if (tableName.length() == 0) {
       System.out.println("Heoбходимо ввести имя таблицы");
       } else if (params.length == 0) {
         System.out.println("Heoбходимо добавить данные в таблицу");
      }
       return 
    }

    @Override
    public int insert(String[][] values) {
        if 
        
    }

    @Override
    public String[] select(String values) {
        
    }

    @Override
    public void close() throws Exception {
        
    }

    @Override
    public int updateRows(String tableName, String column, String conditionColumn, String[] conditions, String values) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateColumns(String tableName, String[] columns, String[] values, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String tableName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRows(String tableName, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addColumn(String tableName, String column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    


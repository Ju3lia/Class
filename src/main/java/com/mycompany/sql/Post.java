/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Student
 */
public class Post implements SQLint {

    private static Post instance;
    private Connection con;
    private Statement stm;
    
    private Post(){}
    
    public static Post getInstance(){
        if (instance == null) instance = new Post();
        return instance;
    }

    @Override
    public boolean connect(String url, String username, String password) {
        try {
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();
            return true;
        } catch (Exception ex) {
            con = null;
            stm = null;
            return false;
        }
    }

    @Override
    public boolean createTable(String tableName, String[] columns) {
        try {
            var stm = con.createStatement();
            String sql = "CREATE TABLE " + tableName + "( ";
            for (String column : columns) {
                sql += column + ',';
            }
            sql = sql.substring(0, sql.length() - 2);
            sql += "));";
            System.out.println(sql);
            stm.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int insert(String[][] values, String tableName) {
        try {
            String sql = "INSERT INTO " + tableName;
            for (String[] row : values) {
                sql += "(";
                for (String str : row) {
                    sql += str + ',';
                }
                sql = sql.substring(0, sql.length() - 2);
                sql += "),";
            }
            return stm.executeUpdate(sql);
        } catch (Exception e) {
            return (-1);
        }
    }

    @Override
    public LinkedList<LinkedList<String>> select(String values, String tableName) {
        LinkedList<LinkedList<String>> list = new LinkedList< LinkedList<String>>();

        try {
            String sql = "SELECT " + values + " FROM " + tableName + ";";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LinkedList<String> link = new LinkedList<String>();
                var length = values.split(",").length;
                for (int i = 1; i <= length; i++) {
                    rs.getString(i);
                }
            }
            return list;
        } catch (Exception e) {
            return list;
        }
//        return list;
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
        try{
            String sql = "DELETE " + tableName + ";";
            boolean ResultSet = stm.execute(sql);
            return ResultSet;
        }catch (Exception e) {
            return false;
        }
                
    }

    @Override
    public int deleteRows(String tableName, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addColumn(String tableName, String column) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        if (con!=null) {
            con.close();
        }
    }

}

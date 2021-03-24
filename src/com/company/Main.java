package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            //Check class is available
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //Make the connection
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/23032021?user=root&password=");
            Statement stmt = con.createStatement();
            //Executing SQL Statements
//            String createLehigh = "Create table Lehigh" + "(SSN Integer not null, Name VARCHAR(32),"+"Marks Integer)";
//            stmt.executeUpdate(createLehigh);

//            String insertLehigh = "Insert into Lehigh values (123456789,'ABC',100)";
//            stmt.executeUpdate(insertLehigh);

            //Get ResultSet
            String queryLehigh = "select * from Lehigh";
            ResultSet rs = stmt.executeQuery(queryLehigh);

            while (rs.next()){
                int ssn = rs.getInt("SSN");
                String name = rs.getString("NAME");
                int marks = rs.getInt("MARKS");
                System.out.println(ssn + " " + name + " " + marks);
            }

            //Close Connection
            stmt.close();
            con.close();

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }
}

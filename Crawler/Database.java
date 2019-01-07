/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Database {
    
    //#1: Create Connection object
    static Connection connection =null;
    
    public static void init()
    {
    if (connection ==null )//αν δεν υπαρχει αλλη ενεργη connection sthn vash
        {
            System.out.println("________________Oracle JDBC Connection testing______________________________");
            try
                {
                    //register jdbc driver=Με αυτόν τον τρόπο, το JVM(Java virtual machine) φορτώνει τον driver στην μνήμη ώστε να εκτελεί τα JDBC requests μας. (Χρειάζεται μόνο μία φορά στην αρχή του κώδικά μας)

                    Class.forName("oracle.jdbc.driver.OracleDriver");//swsto einai??
                    /*Creating a Database User//PASSWORD EXPIRE//USER sidney 
                    CREATE USER sidney 
                    IDENTIFIED BY out_standing1 
                    DEFAULT TABLESPACE example 
                    QUOTA 10M ON example 
                    TEMPORARY TABLESPACE temp
                    QUOTA 5M ON system 
                    PROFILE app_user 
                    PASSWORD EXPIRE;
                    */
                    
                    
                }
            catch(ClassNotFoundException e)//???
                {
                System.out.println("where is your oracle jdbc driver??");
                e.printStackTrace();
                return;
                }
            System.out.println("oracle jdbc driver registed");
            try
                {
                   // #3create a db url
                    String url="jdbc:oracle:thin:@10.100.51.123:1521:orcl";//(πχ. jdbc:oracle:thin:@hostname:port )   //@10.100.51.123/*=idServerPouYparxeiHVash*/1521=ONOMAvASHSpOU8eloumeNaSynde8oume,port.//onoma vashs /////. 
                    //your DBname ,DBpassword
                    String user="it21335";
                    String password="it21335";//ΠΡΟΣΟΧΗ!!!!:edw syndeomaste me to username kai to kwdiko pou sundeomaste kai sto ergasthrio stis vaseis dedomenwn sto sqldeveloper. OXI me ayton tou logariasmou ths database OYTE me ton logariasmo ths oracle gia na katevazw!!!
                    //#4make the connection to the db url
                    connection = DriverManager.getConnection(url, user, password);
                }
            catch(SQLException e)//???
                {
                System.out.println("Connection Failed check output console");
                e.printStackTrace();
                return;
                }
            
            if (connection!=null)//check if the connection succeded
            {
                System.out.println("you made it take control of your database now!!  ");
            }
            else
            {
             System.out.println("failed to make connection... :/ ");   
            }
        }
    }
  //create a new db table
  //insert data into table
    
}

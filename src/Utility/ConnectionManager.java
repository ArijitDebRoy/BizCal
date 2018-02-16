/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Events.ConnectionEstablishedListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RUH
 */
public class ConnectionManager {

    protected static String User = "root";
    protected static String Password = "Aric@rijit";
    protected static String DBName = "Bizcal";
    private static boolean CON_FLAG = false;
    private static ConnectionEstablishedListener listener;

    public void addConnectionEstablishedListener(ConnectionEstablishedListener listener) {
        this.listener = listener;
    }

    public boolean isConnectionEstablished() {
        return CON_FLAG;
    }

    public final static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + DBName, User, Password);
            if (con != null && listener != null) {
                CON_FLAG = true;
                listener.onConnectionEstablishment();
            } 

            return con;
        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
            String options[] = {"Retry"};
            int n = JOptionPane.showOptionDialog(null,
                    "Retry Connecting to Database?",
                    "Problem Connecting..",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            switch (n) {
                case 0:
                    return getConnection();
                default: CON_FLAG = false;
                    return null;
            }

        }
    }
}

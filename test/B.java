
import Events.ConnectionEstablishedListener;
import Utility.ConnectionManager;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RUH
 */
public class B {

    
    public static void main(String[] args) {
        
        ConnectionManager s1=new ConnectionManager();
        s1.addConnectionEstablishedListener(new ConnectionEstablishedListener() {
            @Override
            public void onConnectionEstablishment() {
//                System.out.println(s1.isConnectionEstablished());
            }
        });
        
        Connection con=ConnectionManager.getConnection();
        System.out.println(s1.isConnectionEstablished());
    }
    
}

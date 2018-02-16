package BizCal;

import Utility.SharedRes;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import Crypto.*;
import Utility.Email;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Login extends javax.swing.JFrame {

    private String pass_pick = "";

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        btnForgotPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setPreferredSize(new java.awt.Dimension(385, 248));
        setResizable(false);

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLogin.setText("L O G I N");

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsername.setText("USERNAME :");

        tfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsernameKeyPressed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPassword.setText("PASSWORD :");

        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPasswordKeyPressed(evt);
            }
        });

        btnSubmit.setText("S U B M I T");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnForgotPass.setText("Forgot Password?");
        btnForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnForgotPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnForgotPass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String temp[] = {"", ""};
            String username1 = SharedRes.chopQuotes(tfUsername.getText());

            String password1 = String.copyValueOf(tfPassword.getPassword());
            if (password1.equals(pass_pick) && !password1.equals("")) //mother doc still unedited
            {

                try {
                    String sql_qry = "SELECT owner,vat FROM signup WHERE username='" + username1 + "'";
                    PreparedStatement ob = con.prepareStatement(sql_qry);
                    ResultSet RS = ob.executeQuery();
                    if (RS.next()) {
                        String stemp[] = {RS.getString("owner"), RS.getString("vat")};
                        System.arraycopy(stemp, 0, temp, 0, stemp.length);
                    }

                } catch (Exception e) {

                }
                this.dispose();
                Choice.main(temp);
            } else {
                this.tfPassword.setBackground(Color.red);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void tfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyPressed
        if (evt.getKeyChar() == '\n') {
            btnSubmitActionPerformed(null);
        }
        if (evt.getKeyCode() == 38) {
            tfUsername.requestFocus();
        }

    }//GEN-LAST:event_tfPasswordKeyPressed

    private void tfUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsernameKeyPressed
        if (evt.getKeyCode() == 40) {
            tfPassword.requestFocus();
        }
    }//GEN-LAST:event_tfUsernameKeyPressed

    private void btnForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPassActionPerformed
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String sql_qry = "SELECT password FROM signup WHERE username='" + tfUsername.getText() + "'";
            PreparedStatement ob = Con.prepareStatement(sql_qry);
            ResultSet RS = ob.executeQuery();
            if (RS.next()) {
                new Email("Forgot Password for BizCal", 
                        "<div class=\"gmail_signature\" data-smartmail=\"gmail_signature\"><div dir=\"ltr\"><br id=\"docs-internal-guid-5e24828b-1aac-ab62-be45-9547cb5e04a2\"><div dir=\"ltr\" style=\"margin-left:-5.25pt;\"><table style=\"border:none;border-collapse:collapse\"><colgroup><col width=\"446\"></colgroup><tbody><tr style=\"height:122pt\"><td style=\"border-left:solid #000000 1pt;border-right:solid #000000 1pt;border-bottom:solid #20124d 3pt;border-top:solid #9900ff 3pt;vertical-align:top;padding:5pt 5pt 5pt 5pt;\"><br><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:11pt;font-family:Arial;color:#000000;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"><img src=\"https://lh6.googleusercontent.com/g14cu_E_XGkHq2YHjCCWtJL2yYzNSVDvxFCFylzGNBqnWsBUGQ50FJRKkCbwBulFkrmp4XomD2B1JSpYlTsvlXVIraPnqbiJtRzUl_rSOe5Aab5I_76trRHIk_6fED8MAUrD5OzW\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"brand.png\" height=\"121\" width=\"544\"></span></p></td></tr><tr style=\"height:95.25pt\"><td style=\"border-left:solid #000000 1pt;border-right:solid #000000 1pt;border-bottom:solid #351c75 3pt;border-top:solid #20124d 3pt;vertical-align:top;background-color:#b4a7d6;padding:5pt 5pt 5pt 5pt;\"><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Hi,</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Dear, "+tfUsername.getText()+"</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:12pt;font-family:Impact;color:#1c4587;background-color:transparent;font-weight:700;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> &nbsp;&nbsp;&nbsp;&nbsp;Your Password for BizCal Log-In is : "+ new DecryptionManager(RS.getString("password")).decrypt() +"</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Regards,</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Team BizCal</span></p></td></tr><tr style=\"height:154.5pt\"><td style=\"border-left:solid #000000 1pt;border-bottom:solid #351c75 2.25pt;border-top:solid #351c75 3pt;vertical-align:top;background-color:#f3f3f3;padding:5pt 5pt 5pt 5pt;\"><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:18pt;font-family:Arial;color:#3d85c6;background-color:transparent;font-weight:700;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">BizCal</span><span style=\"font-size:14pt;font-family:Arial;color:#e69138;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> </span><span style=\"font-size:14pt;font-family:Merriweather;color:#e69138;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">is a billing software that help you to keep track on your business.</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:11pt;font-family:'Permanent Marker';color:#0000ff;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">We believe that GOOD design is GOOD business...</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:10pt;font-family:Impact;color:#7f6000;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">If you have any suggestion regarding our software which can help us to make it better then contact us. </span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:11pt;font-family:Impact;color:#4c1130;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">For more query or technical support contact us at :</span><span style=\"font-size:11pt;font-family:Arial;color:#4c1130;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> </span><a href=\"mailto:bizcalteam@gmail.com\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:700;font-style:italic;font-variant:normal;text-decoration:underline;vertical-align:baseline;\">bizcalteam@gmail.com</span></a></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><a href=\"https://www.facebook.com/profile.php?viewas=100000686899395&amp;privacy_source=timeline_gear_menu\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:underline;vertical-align:baseline;\"><img src=\"https://lh5.googleusercontent.com/7qdOONardGb58-aMLhObiAwCHSuBeQbVzkEapj1ZQyelG7krpts51VigVOrnsI_2GuVXqrjXXnCROp3zThm2jQ-XtDZh2gMCgsJfLftujdCccASpjblL72suTlCwI8eX5vllnL8T\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"facebook.png\" height=\"45\" width=\"45\"></span></a><a href=\"https://plus.google.com/u/0/112078963228683848799\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:underline;vertical-align:baseline;\"><img src=\"https://lh3.googleusercontent.com/flXI0DVHgHnnLGxQoBrC23hmbJlU-6ZNHmn3IAqQoKqt3RtGhxLFPK5uP87f3C_AQZFEnr22rPox7DVx-eBQPB317_cYr1cCphmPZIlEsHMd6LeFy3MEa4hJu3lRoBc0bm-BGPVu\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"googleplus.png\" height=\"48\" width=\"48\"></span></a></p><br></td></tr></tbody></table></div><br></div></div>")
                        .send(tfUsername.getText());
            }
            else
                JOptionPane.showMessageDialog(null, "Email is not registered with the admin account");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Con.close();
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnForgotPassActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            Login l = new Login();
            l.setVisible(true);
            l.tfUsername.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    changedUpdate(e);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    Connection con = null;
                    try {
                        con = ConnectionManager.getConnection();

                        String qry = "SELECT password FROM signup WHERE username='" + l.tfUsername.getText() + "'";
                        PreparedStatement ob = con.prepareStatement(qry);
                        ResultSet RS = ob.executeQuery();
                        if (RS.next()) {
                            l.pass_pick = new DecryptionManager(RS.getString("password")).decrypt();
                        } else {
                            l.pass_pick = "";
                        }
                    } catch (Exception ex) {

                    } finally {
                        try {
                            con.close();
                        } catch (Exception ex) {

                        }
                    }
                }
            });

            l.setSize(335, 227);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgotPass;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}

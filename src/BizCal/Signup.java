package BizCal;

import Utility.SharedRes;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Crypto.*;
import Utility.Email;
import java.awt.Color;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Signup extends javax.swing.JFrame {

    private String TNSignUp = "signup";
    private String StoreOTP = "-5wrgem97*+6";

    public Signup() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVATRegNo = new javax.swing.JLabel();
        tfVATRegNo = new javax.swing.JTextField();
        lblPhoneNo = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        lblOwnerName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        tfPhoneNo = new javax.swing.JTextField();
        tfCompanyName = new javax.swing.JTextField();
        tfOwnerName = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        lblSignUp = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        tfCSTRegNo = new javax.swing.JTextField();
        lblMobileNo = new javax.swing.JLabel();
        lblCSTRegNo = new javax.swing.JLabel();
        tfMobileNo = new javax.swing.JTextField();
        lblCSTRegDate = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        tfVATRegDate = new javax.swing.JTextField();
        tfCSTRegDate = new javax.swing.JTextField();
        lblCPassword = new javax.swing.JLabel();
        tfCPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAddress = new javax.swing.JTextArea();
        lblVATRegDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfOtp = new javax.swing.JTextField();
        btnSendOtp = new javax.swing.JButton();
        lblOtp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up");
        setResizable(false);

        lblVATRegNo.setText("VAT REGISTRATION NO :");

        lblPhoneNo.setText("PHONE NO(OFFICE) :");

        lblCompanyName.setText("COMPANY :");

        lblOwnerName.setText("OWNER NAME :");
        lblOwnerName.setToolTipText("");

        lblEmail.setText("EMAIL ADDRESS :");

        lblPassword.setText("PASSWORD :");

        btnSubmit.setText("S U B M I T");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblSignUp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSignUp.setText("S I G N  U P");

        lblMobileNo.setText("MOBILE NO :");

        lblCSTRegNo.setText("C.S.T REGISTRATION NO :");

        lblCSTRegDate.setText("C.S.T REGISTRATION DATE :");

        lblAddress.setText("ADDRESS:");

        lblCPassword.setText("CONFIRM PASSWORD :");

        taAddress.setColumns(20);
        taAddress.setRows(5);
        jScrollPane1.setViewportView(taAddress);

        lblVATRegDate.setText("VAT REGISTRATION DATE :");

        jLabel1.setText("OTP :");

        btnSendOtp.setText("Send OTP");
        btnSendOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendOtpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVATRegDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSTRegNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSTRegDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVATRegNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMobileNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOwnerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompanyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfOwnerName)
                    .addComponent(tfPhoneNo)
                    .addComponent(tfMobileNo)
                    .addComponent(tfCSTRegNo)
                    .addComponent(tfCSTRegDate)
                    .addComponent(tfVATRegNo)
                    .addComponent(tfVATRegDate)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(tfEmail)
                    .addComponent(tfPassword)
                    .addComponent(tfCPassword)
                    .addComponent(tfCompanyName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCSTRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCSTRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCSTRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCSTRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVATRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVATRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfVATRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVATRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfOtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSendOtp))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tfCSTRegNo.getAccessibleContext().setAccessibleName("CST");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            String vat1 = tfVATRegNo.getText();

            String phone1 = tfPhoneNo.getText();

            String company1 = SharedRes.chopQuotes(tfCompanyName.getText());

            String owner1 = SharedRes.chopQuotes(tfOwnerName.getText());

            String username1 = tfEmail.getText();

            String password1 = String.copyValueOf(tfPassword.getPassword());

            String cst1 = tfCSTRegNo.getText();
            String cstdate1 = tfCSTRegDate.getText();
            String vatdate1 = tfVATRegDate.getText();
            String mobno1 = tfMobileNo.getText();

            String cpassword1 = String.copyValueOf(tfCPassword.getPassword());

            String address = SharedRes.chopQuotes(taAddress.getText());
            if (password1.equals(cpassword1) && SharedRes.isPhoneNoValid(phone1) && SharedRes.isPhoneNoValid(mobno1) && SharedRes.isDateValid(vatdate1, "yyyy-MM-dd") && SharedRes.isDateValid(cstdate1, "yyyy-MM-dd") && isRegNoValid() && !lblOtp.getText().equals("")) {
                String insert_qry = "insert into " + TNSignUp + "(vat,phone,company,owner,username,password,cst,cst_date,vat_date,mob_no,address) "
                        + "values('" + vat1 + "','" + phone1 + "','" + company1 + "','" + owner1 + "','" + username1 + "','" + new EncryptionManager(password1).encrypt() + "','" + cst1 + "','" + cstdate1 + "','" + vatdate1 + "','" + mobno1 + "','" + address + "')";

                Statement smt = (Statement) con.createStatement();
                int rs = smt.executeUpdate(insert_qry);
                if (rs == 1) {
                    JOptionPane.showMessageDialog(null, "You are now ready to start");
                    dispose();
                    String temp[] = {tfOwnerName.getText(), tfVATRegNo.getText()};
                    Choice.main(temp);
                }
            } else {
                if (!SharedRes.isPhoneNoValid(mobno1)) {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile No.");
                } else if (!SharedRes.isPhoneNoValid(phone1)) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone No.");
                } else if (!SharedRes.isDateValid(vatdate1, "yyyy-MM-dd")) {
                    JOptionPane.showMessageDialog(null, "Invalid VAT Registration Date\nEnter in yyyy-MM-dd format");
                } else if (!SharedRes.isDateValid(cstdate1, "yyyy-MM-dd")) {
                    JOptionPane.showMessageDialog(null, "Invalid CST Registration Date\nEnter in yyyy-MM-dd format");
                } else if (lblOtp.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Invalid OTP");
                } else {
                    JOptionPane.showMessageDialog(null, "Password Missmatch!!!");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                con.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnSendOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendOtpActionPerformed
        generateOTP();
        btnSendOtp.setText("Resend OTP");
        tfOtp.getDocument().addDocumentListener(new DocumentListener() {
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
                if (StoreOTP.equals(tfOtp.getText())) {
                    lblOtp.setForeground(Color.blue);
                    lblOtp.setText("Email Verified...");
                } else {
                    lblOtp.setText("");
                    lblOtp.setForeground(Color.black);
                }
            }
        });
    }//GEN-LAST:event_btnSendOtpActionPerformed
    private void generateOTP() {
        String to = tfEmail.getText();
        //Generate OTP
        Random r = new Random();
        String otp = new String();
        for (int i = 0; i <= 5; i++) {
            otp += r.nextInt(10);

        }
        StoreOTP = otp;

        new Email("OTP for BizCal Sign Up", 
                "<div class=\"gmail_signature\" data-smartmail=\"gmail_signature\"><div dir=\"ltr\"><br id=\"docs-internal-guid-5e24828b-1aac-ab62-be45-9547cb5e04a2\"><div dir=\"ltr\" style=\"margin-left:-5.25pt;\"><table style=\"border:none;border-collapse:collapse\"><colgroup><col width=\"446\"></colgroup><tbody><tr style=\"height:122pt\"><td style=\"border-left:solid #000000 1pt;border-right:solid #000000 1pt;border-bottom:solid #20124d 3pt;border-top:solid #9900ff 3pt;vertical-align:top;padding:5pt 5pt 5pt 5pt;\"><br><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:11pt;font-family:Arial;color:#000000;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"><img src=\"https://lh6.googleusercontent.com/g14cu_E_XGkHq2YHjCCWtJL2yYzNSVDvxFCFylzGNBqnWsBUGQ50FJRKkCbwBulFkrmp4XomD2B1JSpYlTsvlXVIraPnqbiJtRzUl_rSOe5Aab5I_76trRHIk_6fED8MAUrD5OzW\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"brand.png\" height=\"121\" width=\"544\"></span></p></td></tr><tr style=\"height:95.25pt\"><td style=\"border-left:solid #000000 1pt;border-right:solid #000000 1pt;border-bottom:solid #351c75 3pt;border-top:solid #20124d 3pt;vertical-align:top;background-color:#b4a7d6;padding:5pt 5pt 5pt 5pt;\"><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Hi,</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Dear, "+tfEmail.getText()+"</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:12pt;font-family:Impact;color:#1c4587;background-color:transparent;font-weight:700;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> &nbsp;&nbsp;&nbsp;&nbsp;Your OTP for BizCal Sign-up is : "+otp+"</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Regards,</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;margin-left: -4.5pt;\"><span style=\"font-size:14pt;font-family:'Permanent Marker';color:#000000;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">Team BizCal</span></p></td></tr><tr style=\"height:154.5pt\"><td style=\"border-left:solid #000000 1pt;border-bottom:solid #351c75 2.25pt;border-top:solid #351c75 3pt;vertical-align:top;background-color:#f3f3f3;padding:5pt 5pt 5pt 5pt;\"><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:18pt;font-family:Arial;color:#3d85c6;background-color:transparent;font-weight:700;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">BizCal</span><span style=\"font-size:14pt;font-family:Arial;color:#e69138;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> </span><span style=\"font-size:14pt;font-family:Merriweather;color:#e69138;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">is a billing software that help you to keep track on your business.</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:11pt;font-family:'Permanent Marker';color:#0000ff;background-color:transparent;font-weight:400;font-style:italic;font-variant:normal;text-decoration:none;vertical-align:baseline;\">We believe that GOOD design is GOOD business...</span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:10pt;font-family:Impact;color:#7f6000;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">If you have any suggestion regarding our software which can help us to make it better then contact us. </span></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><span style=\"font-size:11pt;font-family:Impact;color:#4c1130;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\">For more query or technical support contact us at :</span><span style=\"font-size:11pt;font-family:Arial;color:#4c1130;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:none;vertical-align:baseline;\"> </span><a href=\"mailto:bizcalteam@gmail.com\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:700;font-style:italic;font-variant:normal;text-decoration:underline;vertical-align:baseline;\">bizcalteam@gmail.com</span></a></p><p dir=\"ltr\" style=\"line-height:1.2;margin-top:0pt;margin-bottom:0pt;text-align: center;\"><a href=\"https://www.facebook.com/profile.php?viewas=100000686899395&amp;privacy_source=timeline_gear_menu\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:underline;vertical-align:baseline;\"><img src=\"https://lh5.googleusercontent.com/7qdOONardGb58-aMLhObiAwCHSuBeQbVzkEapj1ZQyelG7krpts51VigVOrnsI_2GuVXqrjXXnCROp3zThm2jQ-XtDZh2gMCgsJfLftujdCccASpjblL72suTlCwI8eX5vllnL8T\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"facebook.png\" height=\"45\" width=\"45\"></span></a><a href=\"https://plus.google.com/u/0/112078963228683848799\" style=\"text-decoration:none;\"><span style=\"font-size:11pt;font-family:Arial;color:#1155cc;background-color:transparent;font-weight:400;font-style:normal;font-variant:normal;text-decoration:underline;vertical-align:baseline;\"><img src=\"https://lh3.googleusercontent.com/flXI0DVHgHnnLGxQoBrC23hmbJlU-6ZNHmn3IAqQoKqt3RtGhxLFPK5uP87f3C_AQZFEnr22rPox7DVx-eBQPB317_cYr1cCphmPZIlEsHMd6LeFy3MEa4hJu3lRoBc0bm-BGPVu\" style=\"border: none; transform: rotate(0.00rad); -webkit-transform: rotate(0.00rad);\" alt=\"googleplus.png\" height=\"48\" width=\"48\"></span></a></p><br></td></tr></tbody></table></div><br></div></div>")
                .send(to);
    }

    private boolean isRegNoValid() {
        String vat = tfVATRegNo.getText();
        String cst = tfCSTRegNo.getText();
        if (vat.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid VAT Registration No.");
            return false;
        } else {
            for (int i = 0; i < vat.length(); i++) {
                if (!Character.isDigit(vat.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Invalid VAT Registration No.");
                    return false;
                }
            }
        }

        if (cst.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid CST Registration No.");
            return false;
        } else {
            for (int i = 0; i < cst.length(); i++) {
                if (!Character.isDigit(cst.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Invalid CST Registration No.");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPasswordValid() {
        char pass[] = this.tfPassword.getPassword();
        char cpass[] = this.tfCPassword.getPassword();
        if (pass.length != cpass.length) {
            return false;
        } else {
            for (int i = 0; i < pass.length; i++) {
                if (cpass[i] != pass[i]) {
                    return false;
                }
            }
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            Signup s = new Signup();
            s.tfCPassword.getDocument().addDocumentListener(new DocumentListener() {

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
                    if (s.isPasswordValid()) {
                        s.tfCPassword.setBackground(Color.green);
                        s.btnSubmit.setEnabled(true);
                    } else {
                        s.tfCPassword.setBackground(Color.red);
                        s.btnSubmit.setEnabled(false);
                    }
                }
            });
            s.btnSubmit.setEnabled(false);
            s.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendOtp;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCPassword;
    private javax.swing.JLabel lblCSTRegDate;
    private javax.swing.JLabel lblCSTRegNo;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMobileNo;
    private javax.swing.JLabel lblOtp;
    private javax.swing.JLabel lblOwnerName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblVATRegDate;
    private javax.swing.JLabel lblVATRegNo;
    private javax.swing.JTextArea taAddress;
    private javax.swing.JPasswordField tfCPassword;
    private javax.swing.JTextField tfCSTRegDate;
    private javax.swing.JTextField tfCSTRegNo;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMobileNo;
    private javax.swing.JTextField tfOtp;
    private javax.swing.JTextField tfOwnerName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhoneNo;
    private javax.swing.JTextField tfVATRegDate;
    private javax.swing.JTextField tfVATRegNo;
    // End of variables declaration//GEN-END:variables
}

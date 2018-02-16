package BizCal;

import Utility.SharedRes;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StockReceived extends javax.swing.JFrame {

    public StockReceived() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfBillNo = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        tfPerticular = new javax.swing.JTextField();
        tfProduct = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        tfRate = new javax.swing.JTextField();
        tfSeller = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfAmount = new javax.swing.JTextField();
        btnCurrentStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enter Stock Recieved");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("S T O C K   R E C E I V E D");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BILL NO  :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DATE  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PARTICULAR  :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("PRODUCT  :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("QUANTITY  :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("RATE  :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("SELLER  :");

        btnInsert.setText("I N S E R T");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TakaoPGothic", 1, 14)); // NOI18N
        jLabel9.setText(" AMOUNT(INC. VAT) :");

        btnCurrentStock.setText("SHOW CURRENT STOCK");
        btnCurrentStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnCurrentStock))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(btnInsert))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfBillNo, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(tfDate)
                                    .addComponent(tfPerticular)
                                    .addComponent(tfProduct)
                                    .addComponent(tfQuantity)
                                    .addComponent(tfRate)
                                    .addComponent(tfSeller)
                                    .addComponent(tfAmount))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCurrentStock)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPerticular, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsert)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isBillNoValid(String s) {
        if (s.equals("")) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            int check = 0;
            String bill1 = tfBillNo.getText();

            String date1 = tfDate.getText();

            String perticular1 = SharedRes.chopQuotes(tfPerticular.getText());

            String product1 = SharedRes.chopQuotes(tfProduct.getText());

            String quantity1 = tfQuantity.getText();

            String rate1 = tfRate.getText();

            String seller1 = SharedRes.chopQuotes(tfSeller.getText());
            String amount1 = tfAmount.getText();

            boolean flag = !seller1.equals("") && !product1.equals("") && SharedRes.isDateValid(tfDate.getText(), "yyyy-MM-dd") && isBillNoValid(tfBillNo.getText()) && SharedRes.isNumber(tfAmount.getText()) && SharedRes.isNumber(tfQuantity.getText()) && SharedRes.isNumber(tfRate.getText());

            String remark = "false";
            String qry = "Select product_name,qty,price from product_details";
            String qry11 = "select count(*) from product_details";
            PreparedStatement obj = con.prepareStatement(qry);
            ResultSet RS1 = obj.executeQuery();
            PreparedStatement ob = con.prepareStatement(qry11);
            ResultSet RS = ob.executeQuery();
            int c = 0;
            if (RS.next()) {
                c = RS.getInt(1);
            }
            //System.out.println(c);
            for (int i = 0; i < c; i++) {
                if (RS1.next()) {
                    String p = RS1.getString("product_name");
                    //System.out.println(p);
                    if (product1.equalsIgnoreCase(p)) {
                        check = 1;
                        break;
                    }
                }
            }

            if (flag) {
                if (check == 0) {

                    String insert_qry = "insert into stock_in(si_billno,si_date,si_perticular,si_product,si_qty,si_rate,si_seller)" + "values('" + bill1 + "','" + date1 + "','" + perticular1 + "','" + product1 + "','" + quantity1 + "','" + rate1 + "','" + seller1 + "')";
                    String i_qry1 = "insert into product_details(product_name,qty,price) values" + " ('" + product1 + "','" + quantity1 + "','" + rate1 + "')";
                    String pay_qry = "insert into payable(p_billno,p_date,p_petrticular,p_seller,p_amount,p_remark) values ('" + bill1 + "','" + date1 + "','" + perticular1 + "','" + seller1 + "','" + amount1 + "','" + remark + "')";
                    PreparedStatement obj1 = con.prepareStatement(i_qry1);
                    obj1.executeUpdate(i_qry1);
                    PreparedStatement o = con.prepareStatement(pay_qry);
                    o.executeUpdate(pay_qry);
                    Statement smt = (Statement) con.createStatement();
                    int rs = smt.executeUpdate(insert_qry);
                    if (rs == 1) {
                        JOptionPane.showMessageDialog(null, "New Stock Recieved..!!");

                    } else {
                        JOptionPane.showMessageDialog(null, "Check your details..!");
                    }
                } else {
                    String q = RS1.getString("qty");
                    double Quantity = Double.parseDouble(quantity1);
                    Quantity = Quantity + Double.parseDouble(RS1.getString("qty"));
                    String pay_qry = "insert into payable(p_billno,p_date,p_petrticular,p_seller,p_amount,p_remark) values ('" + bill1 + "','" + date1 + "','" + perticular1 + "','" + seller1 + "','" + amount1 + "','" + remark + "')";
                    PreparedStatement o = con.prepareStatement(pay_qry);
                    o.executeUpdate(pay_qry);
                    String qry1 = "update product_details set qty= '" + Quantity + "' where product_name= '" + product1 + "'";
                    PreparedStatement obj1 = con.prepareStatement(qry1);
                    obj1.executeUpdate(qry1);
                    String qry2 = "update product_details set price= '" + rate1 + "' where product_name= '" + product1 + "'";
                    PreparedStatement obj2 = con.prepareStatement(qry2);
                    obj2.executeUpdate(qry2);
                    String insert_qry = "insert into stock_in(si_billno,si_date,si_perticular,si_product,si_qty,si_rate,si_seller)" + "values('" + bill1 + "','" + date1 + "','" + perticular1 + "','" + product1 + "','" + quantity1 + "','" + rate1 + "','" + seller1 + "')";

                    Statement smt = (Statement) con.createStatement();
                    int R = smt.executeUpdate(insert_qry);

                    if (R == 1) {
                        JOptionPane.showMessageDialog(null, "New Stock Recieved..");

                    } else {
                        JOptionPane.showMessageDialog(null, "Check your details..!");
                    }
                }

            } else {

                if (product1.equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid Product");
                else if (seller1.equals(""))
                    JOptionPane.showMessageDialog(null, "Invalid Seller Name");
                else if (!isBillNoValid(tfBillNo.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Bill No.");
                } else if (!SharedRes.isDateValid(tfDate.getText(), "yyyy-MM-dd")) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                } else if (!SharedRes.isNumber(tfAmount.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Amount");
                } else if (!SharedRes.isNumber(tfQuantity.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity");
                } else if (!SharedRes.isNumber(tfRate.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Rate");
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
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnCurrentStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentStockActionPerformed

        new Show(Show.IN_STOCKS).setVisible(true);
    }//GEN-LAST:event_btnCurrentStockActionPerformed

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
            java.util.logging.Logger.getLogger(StockReceived.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockReceived.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockReceived.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockReceived.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StockReceived ob = new StockReceived();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.now();

                ob.tfDate.setText(dtf.format(localDate));

                ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ob.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurrentStock;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tfAmount;
    private javax.swing.JTextField tfBillNo;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfPerticular;
    private javax.swing.JTextField tfProduct;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfRate;
    private javax.swing.JTextField tfSeller;
    // End of variables declaration//GEN-END:variables
}

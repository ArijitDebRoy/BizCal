package BizCal;

import Utility.SharedRes;
import javax.swing.JOptionPane;

public class Choice extends javax.swing.JFrame {
    public Choice() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOwnerName = new javax.swing.JLabel();
        lblVATNo = new javax.swing.JLabel();
        btnBilling = new javax.swing.JButton();
        btnStockDetails = new javax.swing.JButton();
        btnClientDetails = new javax.swing.JButton();
        btnPaymentDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select");
        setResizable(false);

        lblOwnerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOwnerName.setText("jLabel1");
        lblOwnerName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.red, null));

        lblVATNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVATNo.setText("jLabel2");
        lblVATNo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.red, null));

        btnBilling.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBilling.setText("B I L L I N G");
        btnBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillingActionPerformed(evt);
            }
        });

        btnStockDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStockDetails.setText("S T O C K  D E T A I L S");
        btnStockDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockDetailsActionPerformed(evt);
            }
        });

        btnClientDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClientDetails.setText("C L I E N T  D E T A I L S");
        btnClientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientDetailsActionPerformed(evt);
            }
        });

        btnPaymentDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPaymentDetails.setText("P A Y M E N T  D E T A I L S");
        btnPaymentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(lblVATNo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnStockDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(btnBilling, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(btnClientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addComponent(btnPaymentDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVATNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStockDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaymentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillingActionPerformed
        BillingForm.main(null);
        this.dispose();
    }//GEN-LAST:event_btnBillingActionPerformed

    private void btnClientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientDetailsActionPerformed
        ClientDetails.main(null);
    }//GEN-LAST:event_btnClientDetailsActionPerformed

    private void btnStockDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockDetailsActionPerformed

        String options[] = {"Stock Issued", "Stock Recieved"};

        int n = JOptionPane.showOptionDialog(null,
                "What do you want to see?",
                "Choose one",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        switch (n) {
            case 0:
                new Show(Show.STOCK_ISSUED).setVisible(true);
                break;
            case 1:
                StockReceived.main(null);
                break;
        }
    }//GEN-LAST:event_btnStockDetailsActionPerformed

    private void btnPaymentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentDetailsActionPerformed
        String options[] = {"Amount Payable", "Amount Recievable"};

        int n = JOptionPane.showOptionDialog(null,
                "What do you want to see?",
                "Choose one",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        switch (n) {
            case 0:
                new Show(Show.AMOUNT_PAYABLE).setVisible(true);
                break;
            case 1:
                new Show(Show.AMOUNT_RECIEVABLE).setVisible(true);
                break;

        }
    }//GEN-LAST:event_btnPaymentDetailsActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Choice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Choice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Choice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Choice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Choice c = new Choice();
                c.lblOwnerName.setText("Owner:- " +args[0]);
                c.lblVATNo.setText("VAT No:- " +args[1]);
                c.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBilling;
    private javax.swing.JButton btnClientDetails;
    private javax.swing.JButton btnPaymentDetails;
    private javax.swing.JButton btnStockDetails;
    public static javax.swing.JLabel lblOwnerName;
    public static javax.swing.JLabel lblVATNo;
    // End of variables declaration//GEN-END:variables
}

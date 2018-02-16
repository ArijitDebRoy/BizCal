package BizCal;

import Carousals.BuyerCarousal;
import Carousals.OrderCarousal;
import Carousals.OrderedProductCarousal;
import Carousals.OwnerCarousal;
import Utility.ConnectionManager;
import Utility.GenerateBill;
import Utility.SharedRes;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;

public class BillingForm extends javax.swing.JFrame {

    private Connection Con;
    private final String TNUser = "signup", TNClientDetails = "client_details", TNProductDetails = "product_details", TNStockOut = "stock_out";// TN = Table Name
    private ResultSet RS;
    String name, rate, perticular = " ", gT;
    String remark = "false";
    double total_tax;
    private int NO_OF_PRODUCTS;

    private static BuyerCarousal buyer;
    private static OrderCarousal oc;
    private static OrderedProductCarousal op;
    private static OwnerCarousal owner;

    public BillingForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);

        new ConnectionManager().addConnectionEstablishedListener(() -> {
            if (taServerDetails.getText().equals("")) {
                fillTextArea("server");
            }
        });
        Con = ConnectionManager.getConnection();
    }

    private void fillTextArea(String side) {
        //Con = SharedRes.getConnection();
        try {
            switch (side) {
                case "server": {
                    String qry = "SELECT * FROM " + TNUser;
                    PreparedStatement obj = Con.prepareStatement(qry);
                    RS = obj.executeQuery();
                    if (RS.next()) {
                        this.taServerDetails.append("Company:- " + RS.getString("company") + "\n");
                        this.taServerDetails.append("Address:- " + RS.getString("address") + "\n");
                        this.taServerDetails.append(RS.getString("owner") + "\n");
                        this.taServerDetails.append("VAT No.:- " + RS.getString("vat") + "\n");
                        this.taServerDetails.append("Date :- " + RS.getString("vat_date") + "\n");
                        this.taServerDetails.append("C.S.T No.:- " + RS.getString("cst") + "\n");
                        this.taServerDetails.append("Date:- " + RS.getString("cst_date") + "\n");
                        this.taServerDetails.append("Mobile No.:- " + RS.getString("mob_no") + "\n");
                        this.taServerDetails.append("Phone No.:- " + RS.getString("phone"));
                        owner = new OwnerCarousal(RS.getString("phone"), RS.getString("mob_no"), RS.getString("vat"), RS.getString("vat_date"), RS.getString("cst"), RS.getString("cst_date"), RS.getString("address"), RS.getString("company"), RS.getString("owner"));
                    }
                    break;
                }
                case "client": {
                    Con = ConnectionManager.getConnection();
                    String qry = ("SELECT * FROM " + TNClientDetails + " WHERE vat=" + this.tfVatNo.getText());
                    PreparedStatement obj = Con.prepareStatement(qry);
                    RS = obj.executeQuery();
                    if (RS.next()) {
                        this.taClientDetails.setText("");
                        this.taClientDetails.append("Buyer's Vat No:- " + RS.getString("vat") + "\n");
                        this.taClientDetails.append("Buyer's Name:- " + RS.getString("name") + "\n");
                        this.taClientDetails.append("Buyer's Address:- " + RS.getString("address") + "\n");
                        name = RS.getString("name");
                        buyer = new BuyerCarousal(name, RS.getString("address"), RS.getString("vat"));
                    } else {
                        this.taClientDetails.setText("");
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (!taServerDetails.getText().equals("")) {
                    Con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    private void fillProductList(javax.swing.JList<String> lst) {
        try {
            Connection Con1 = ConnectionManager.getConnection();
            String qry = "SELECT product_name,price FROM " + TNProductDetails;
            PreparedStatement obj = Con1.prepareStatement(qry);
            ResultSet RS1 = obj.executeQuery();
            DefaultListModel<String> lm = new DefaultListModel<>();

            while (RS1.next()) {
                lm.addElement(RS1.getString("product_name"));
            }
            lst.setModel(lm);
            Con1.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        spServerDetails = new javax.swing.JScrollPane();
        taServerDetails = new javax.swing.JTextArea();
        spClientDetails = new javax.swing.JScrollPane();
        taClientDetails = new javax.swing.JTextArea();
        tfVatNo = new javax.swing.JTextField();
        lblVatNo = new javax.swing.JLabel();
        lbCashMemo = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblNoOfProducts = new javax.swing.JLabel();
        tfNoOfProducts = new javax.swing.JTextField();
        spContentScroll = new javax.swing.JScrollPane();
        panelProductDetails = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblGTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfVATip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        lblTaxInvoiceNo = new javax.swing.JLabel();
        lblOrderNo = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblChallanNo = new javax.swing.JLabel();
        tfTaxInvoiceNo = new javax.swing.JTextField();
        tfChallanNo = new javax.swing.JTextField();
        tfOrderNo = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        lblMessageBox = new javax.swing.JLabel();
        lblRate = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Billing");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("BizCalFrame"); // NOI18N
        setResizable(false);

        taServerDetails.setEditable(false);
        taServerDetails.setColumns(20);
        taServerDetails.setLineWrap(true);
        taServerDetails.setRows(5);
        spServerDetails.setViewportView(taServerDetails);

        taClientDetails.setEditable(false);
        taClientDetails.setColumns(20);
        taClientDetails.setLineWrap(true);
        taClientDetails.setRows(5);
        spClientDetails.setViewportView(taClientDetails);

        tfVatNo.setColumns(10);

        lblVatNo.setText("VAT NO:-");

        lbCashMemo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCashMemo.setText("CASH MEMO");

        lblProduct.setText("Product");

        lblQty.setText("Quantity");

        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmount.setText("Stock to be left - Amount");

        lblNoOfProducts.setText("Enter no. of products:");

        tfNoOfProducts.setColumns(3);

        javax.swing.GroupLayout panelProductDetailsLayout = new javax.swing.GroupLayout(panelProductDetails);
        panelProductDetails.setLayout(panelProductDetailsLayout);
        panelProductDetailsLayout.setHorizontalGroup(
            panelProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        panelProductDetailsLayout.setVerticalGroup(
            panelProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        spContentScroll.setViewportView(panelProductDetails);

        jLabel1.setText(" Total :");

        jLabel2.setText("(+) Vat");

        jLabel3.setText("%");

        jLabel5.setText("Amount Payable(Including VAT) :");

        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        lblTaxInvoiceNo.setText("Tax Invoice No.");

        lblOrderNo.setText("Order No.");

        lblDate.setText("Date");

        lblChallanNo.setText("Challan No.");

        lblMessageBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblRate.setText("Rate");

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setText("eg. YYYY-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblProduct))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNoOfProducts)
                                .addGap(18, 18, 18)
                                .addComponent(tfNoOfProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lbCashMemo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblQty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRate)
                                .addGap(67, 67, 67)
                                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spContentScroll)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spServerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnBack))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblVatNo)
                                        .addGap(26, 26, 26)
                                        .addComponent(tfVatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTaxInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblChallanNo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfChallanNo)
                                            .addComponent(tfTaxInvoiceNo)
                                            .addComponent(tfOrderNo)))
                                    .addComponent(spClientDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerateBill, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lblMessageBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfVATip, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfVatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spClientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTaxInvoiceNo)
                            .addComponent(tfTaxInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChallanNo)
                            .addComponent(tfChallanNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVatNo)
                            .addComponent(btnBack))
                        .addGap(5, 5, 5)
                        .addComponent(spServerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblOrderNo)
                        .addComponent(tfOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfDate)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNoOfProducts)
                                    .addComponent(tfNoOfProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbCashMemo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(lblProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRate)
                                .addComponent(lblAmount)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spContentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfVATip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMessageBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        boolean temp = isChallanNoValid();
        try {

            calculatePrice();
            calculateSum();
            oc = new OrderCarousal(tfTaxInvoiceNo.getText(), tfChallanNo.getText(), tfOrderNo.getText(), tfDate.getText());
            if (!tfDate.getText().equals("") && !tfChallanNo.getText().equals("")
                    && !tfOrderNo.getText().equals("") && !tfTaxInvoiceNo.getText().equals("")
                    && !tfVatNo.getText().equals("") && !tfNoOfProducts.getText().equals("")
                    && !tfVATip.getText().equals("") && temp) {
                update();
                new GenerateBill(buyer, oc, owner, op).generate();
                JOptionPane.showMessageDialog(null, "Your bill has been generated.");
                calculatePrice();
                calculateSum();
            } else {
                if (temp) {
                    JOptionPane.showMessageDialog(null, "One or more fields may be empty.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        String temp[] = {owner.name, owner.vat_no};
        Choice.main(temp);
    }//GEN-LAST:event_btnBackActionPerformed

    private void update() {
        try {
            Con = ConnectionManager.getConnection();
            Component ele[] = panelProductDetails.getComponents();
            int ColNo = 4;
            for (int j = 0; j < ele.length / ColNo; j++) {
                JLabel lbl = (JLabel) ele[3 + ColNo * j];
                JScrollPane sp = (JScrollPane) ele[0 + ColNo * j];
                JList lst = (JList) sp.getViewport().getView();
                JTextField tf = (JTextField) ele[1 + ColNo * j];
                JTextField tfRate = (JTextField) ele[2 + ColNo * j];
                ResultSet RS1;
                String sel_qry = "SELECT product_name,qty FROM " + TNProductDetails + " WHERE product_name='" + lst.getSelectedValue() + "'";
                PreparedStatement ob = Con.prepareStatement(sel_qry);
                RS1 = ob.executeQuery();
                double qty_left = 0;
                if (RS1.next()) {
                    double price_per = Double.parseDouble(tfRate.getText());
                    rate = tfRate.getText();
                    double qty;
                    if (tf.getText().equals("")) {
                        qty = 0;
                    } else {

                        qty = Double.parseDouble(tf.getText());
                    }
                    double inventory = Double.parseDouble(RS1.getString("qty"));
                    BigDecimal temp = new BigDecimal(inventory - qty);
                    qty_left = temp.setScale(4, java.math.RoundingMode.HALF_UP).doubleValue();
                    if (qty > inventory) {
                        lbl.setText("More than inventory stock");
                    } else {
                        lbl.setText("Stock left :" + qty_left + "kg - Rs: " + (qty * price_per));
                    }
                }

                String update_qry = "update " + TNProductDetails + " set qty='" + qty_left + "'where product_name='" + lst.getSelectedValue() + "'";
                PreparedStatement ob1 = Con.prepareStatement(update_qry);
                ob1.executeUpdate(update_qry);
                String i_qry = "insert into stock_out(so_billno,so_date,so_perticular,so_product,so_qty,so_rate,so_buyer) values('" + tfChallanNo.getText() + "','" + tfDate.getText() + "','" + perticular + "','" + lst.getSelectedValue() + "','" + tf.getText() + "','" + rate + "','" + name + "')";
                PreparedStatement ob2 = Con.prepareStatement(i_qry);
                ob2.executeUpdate(i_qry);
            }

            String in_qry = "insert into receivable(r_billno,r_date,r_perticular,r_buyer,r_amount,r_remark) values('" + tfChallanNo.getText() + "','" + tfDate.getText() + "','" + perticular + "','" + name + "','" + gT + "','" + remark + "')";
            PreparedStatement ob3 = Con.prepareStatement(in_qry);
            ob3.executeUpdate(in_qry);

            Con.close();
        } catch (Exception internal) {
            System.out.println(internal.toString());
        }
    }

    private void calculatePrice() {
        try {
            Con = ConnectionManager.getConnection();
            Component ele[] = panelProductDetails.getComponents();
            int ColNo = 4;
            String quantity[], product[], price_rate[], value[];
            quantity = new String[ele.length / ColNo];
            product = new String[ele.length / ColNo];
            price_rate = new String[ele.length / ColNo];
            value = new String[ele.length / ColNo];
            for (int j = 0; j < ele.length / ColNo; j++) {
                JLabel lbl = (JLabel) ele[3 + ColNo * j];
                JScrollPane sp = (JScrollPane) ele[0 + ColNo * j];
                JList lst = (JList) sp.getViewport().getView();
                JTextField tf = (JTextField) ele[1 + ColNo * j];
                JTextField tfRate = (JTextField) ele[2 + ColNo * j];
                ResultSet RS1;
                String sel_qry = "SELECT product_name,qty FROM " + TNProductDetails + " WHERE product_name='" + lst.getSelectedValue() + "'";
                PreparedStatement ob = Con.prepareStatement(sel_qry);
                RS1 = ob.executeQuery();

                if (RS1.next()) {

                    double price_per = Double.parseDouble(tfRate.getText());
                    double qty;
                    quantity[j] = tf.getText();
                    product[j] = (String) lst.getSelectedValue();
                    price_rate[j] = tfRate.getText();

                    if (tf.getText().equals("")) {
                        qty = 0;
                    } else {
                        qty = Double.parseDouble(tf.getText());

                    }
                    double inventory = Double.parseDouble(RS1.getString("qty"));
                    BigDecimal temp = new BigDecimal(inventory - qty);
                    double qty_left = temp.setScale(4, java.math.RoundingMode.HALF_UP).doubleValue();

                    if (qty > inventory) {
                        lbl.setText("More than inventory stock");
                    } else {
                        temp = new BigDecimal((qty * price_per));
                        double final_price = temp.setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
                        value[j] = String.valueOf(final_price);
                        lbl.setText("Stock left :" + qty_left + "kg - Rs:" + final_price);
                    }
                }
            }
            if (!lblTotal.getText().equals("") || !lblGTotal.getText().equals("")) {
                String temp = lblTotal.getText();
                temp = temp.substring(temp.lastIndexOf('s') + 1, temp.lastIndexOf('/'));
                double total = Double.parseDouble(temp);
                temp = lblGTotal.getText();
                temp = temp.substring(temp.lastIndexOf('s') + 1, temp.lastIndexOf('/'));
                double gtotal = Double.parseDouble(temp);
                if (!tfVATip.getText().equals("")) {
                    op = new OrderedProductCarousal(ele.length / ColNo, quantity, product, price_rate, value, Double.parseDouble(tfVATip.getText()), this.total_tax, total, gtotal);
                }

            }

            Con.close();
        } catch (Exception internal) {
            System.out.println(internal.toString());
            internal.printStackTrace();
        }
    }

    private void disableGenerateBill() {
        try {
            int flag = 1;
            Component ele[] = panelProductDetails.getComponents();
            int ColNo = 4;
            for (int j = 0; j < ele.length / ColNo; j++) {
                JLabel lbl = (JLabel) ele[3 + ColNo * j];
                if (lbl.getText().equalsIgnoreCase("More than inventory stock")) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0 || checkRedundancy()) {
                btnGenerateBill.setEnabled(false);
                if (flag != 0) {
                    textFilter(lblMessageBox, "failure", "Selcted product more than once", "");
                }
            } else {
                btnGenerateBill.setEnabled(true);
                lblMessageBox.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void calculateSum() {
        BigDecimal temp;
        int ColNo = 4;
        Component ele[] = panelProductDetails.getComponents();
        double sum = 0;
        int flag = 1;
        lblTotal.setText("Rs" + 0.0 + "/-");
        for (int j = 0; j < ele.length / ColNo; j++) {
            JLabel lbl = (JLabel) ele[3 + ColNo * j];
            String labelValue = lbl.getText();
            String labelPrice = (labelValue.substring(labelValue.lastIndexOf(":") + 1));

            for (int k = 0; k < labelPrice.length(); k++) {
                if (!Character.isDigit(labelPrice.charAt(k)) && labelPrice.charAt(k) != '.') {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                double price = Double.parseDouble(labelPrice);
                sum = sum + price;
                temp = new BigDecimal(sum);
                lblTotal.setText("Rs" + temp.setScale(2, java.math.RoundingMode.HALF_UP).doubleValue() + "/-");
            } else {
                textFilter(lblMessageBox, "failure", "Inapt. Sum amount", "");
            }
        }
        String Vat = tfVATip.getText();
        double vat = 0;
        if (!Vat.equals("")) {
            vat = Double.parseDouble(Vat);
        }
        total_tax = ((sum * vat) / 100);
        sum = sum + total_tax;
        temp = new BigDecimal(sum);
        gT = Double.toString(temp.setScale(2, java.math.RoundingMode.HALF_UP).doubleValue());
        lblGTotal.setText("Rs" + gT + "/-");

        disableGenerateBill();
    }

    private void onProductAlter() {
        Con = ConnectionManager.getConnection();
        try {
            String qry = "SELECT COUNT(*) FROM " + TNProductDetails;
            PreparedStatement obj = Con.prepareStatement(qry);
            RS = obj.executeQuery();

            if (RS.next()) {
                int ProNo = Integer.parseInt(this.tfNoOfProducts.getText());
                NO_OF_PRODUCTS = RS.getInt(1);
                int ColNo = 4;
                if (ProNo <= RS.getInt(1) && ProNo > 0) {
                    panelProductDetails.removeAll();
                    panelProductDetails.setLayout(new GridLayout(ProNo, ColNo, 0, 10));
                    for (int i = 0; i < ProNo; i++) {

                        JList<String> pro = new JList<>();
                        fillProductList(pro);
                        pro.setVisibleRowCount(1);
                        pro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        pro.setSelectedIndex(1);
                        JScrollPane sp = new JScrollPane();
                        sp.setViewportView(pro);
                        JTextField qty = new JTextField();
                        qty.setName("quantity");
                        qty.setText("0");
                        JTextField rate = new JTextField();
                        rate.setName("rate");
                        rate.setText("0.0");
                        JLabel price = new JLabel();

                        price.setText("Stock left :" + 0.0 + "kg - Rs:" + 0.0);

                        price.setHorizontalAlignment(SwingConstants.CENTER);
                        qty.setHorizontalAlignment(SwingConstants.CENTER);
                        rate.setHorizontalAlignment(SwingConstants.CENTER);

                        qty.getDocument().addDocumentListener(new DocumentListener() {

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
                                validateTextFields(qty, "Invalid Quantity");

                            }
                        });
                        rate.getDocument().addDocumentListener(new DocumentListener() {

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
                                validateTextFields(rate, "Invalid Rate");

                            }
                        });

                        pro.addListSelectionListener((ListSelectionEvent e) -> {

                            calculatePrice();
                            calculateSum();

                        });

                        panelProductDetails.add(sp, i, 0);
                        panelProductDetails.add(qty, i, 1);
                        panelProductDetails.add(rate, i, 2);
                        panelProductDetails.add(price, i, 3);

                    }

                } else {
                    panelProductDetails.removeAll();
                }

                /*
                 Problem in here
                 */
                calculatePrice();
                calculateSum();
            }
            this.revalidate();
            this.repaint();

        } catch (Exception e) {
            System.out.println(e.toString() + " 1");
        } finally {
            try {

                Con.close();
            } catch (Exception e) {
            }
        }
    }

    private boolean checkRedundancy() {
        int temp[] = new int[NO_OF_PRODUCTS];
        boolean flag = false;
        try {
            Component ele[] = panelProductDetails.getComponents();
            int ColNo = 4;
            for (int j = 0; j < ele.length / ColNo; j++) {
                JScrollPane sp = (JScrollPane) ele[0 + ColNo * j];
                JList lst = (JList) sp.getViewport().getView();
                temp[lst.getSelectedIndex()]++;
            }
            for (int j = 0; j < temp.length; j++) {
                //System.out.println(temp[j]);
                if (temp[j] > 1) {
                    flag = true;
                    break;
                }
            }

        } catch (Exception internal) {
            System.out.println(internal.toString());
            internal.printStackTrace();
        }
        return flag;
    }

    private void textFilter(javax.swing.JLabel ele, String type, String msg, String CaseType) {
        if (CaseType.equalsIgnoreCase("upper")) {
            msg = msg.toUpperCase();
        } else if (CaseType.equalsIgnoreCase("lower")) {
            msg = msg.toLowerCase();
        }
        if (type.equalsIgnoreCase("success")) {
            ele.setForeground(Color.green);
        } else if (type.equalsIgnoreCase("failure")) {
            ele.setForeground(Color.red);
        } else if (type.equalsIgnoreCase("normal")) {
            ele.setForeground(Color.black);
        }
        ele.setText(msg);
    }

    private void validateTextFields(JTextField tf, String messsage) {
        try {
            String temp = tf.getText();
            int flag = 1;
            for (int i = 0; i < temp.length(); i++) {
                if (!Character.isDigit(temp.charAt(i)) && temp.charAt(i) != '.') {
                    flag = 0;
                    break;
                }
            }
            if (tf.getText().equals("")) {
                flag = 0;
            }

            if (tf.getName().equals("product")) {
                if (tf.getText().equals("")) {
                    panelProductDetails.removeAll();
                    this.revalidate();
                    this.repaint();
                }
            }

            if (flag == 1) {
                textFilter(lblMessageBox, "normal", "", "");

                if (tf.getName().equals("product")) {
                    if (tf.getText().equals("")) {
                        panelProductDetails.removeAll();
                        this.revalidate();
                        this.repaint();
                    } else {
                        onProductAlter();
                    }
                } else if (tf.getName().equals("vat_rate") || tf.getName().equals("quantity") || tf.getName().equals("rate")) {
                    calculatePrice();
                    calculateSum();
                } else if (tf.getName().equals("vat")) {
                    fillTextArea("client");
                }

            } else {
                textFilter(lblMessageBox, "failure", messsage, "");

            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private boolean isChallanNoValid() {

        if (tfChallanNo.getText().equals("")) {
            return false;
        } else {
            try {
                Connection con = ConnectionManager.getConnection();
                String sql_qry = "SELECT COUNT(*) FROM " + TNStockOut + " WHERE so_billno=" + tfChallanNo.getText();
                PreparedStatement temp = con.prepareStatement(sql_qry);
                ResultSet RS1 = temp.executeQuery();
                if (RS1.next()) {
                    int c = RS1.getInt(1);
                    if (c > 0) {
                        JOptionPane.showMessageDialog(null, "Challan No. already exists");
                        return false;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            BillingForm ob = new BillingForm();

            ob.fillTextArea("server");
            ob.tfNoOfProducts.setName("product");
            ob.tfVATip.setName("vat_rate");
            ob.tfVatNo.setName("vat");
            ob.tfVatNo.getDocument().addDocumentListener(new DocumentListener() {

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
                    ob.validateTextFields(ob.tfVatNo, "Invalid VAT Number");
                }
            });
            ob.tfNoOfProducts.getDocument().addDocumentListener(new DocumentListener() {

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
                    ob.validateTextFields(ob.tfNoOfProducts, "Invalid No. of Products");
                }
            });
            ob.tfVATip.getDocument().addDocumentListener(new DocumentListener() {

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
                    ob.validateTextFields(ob.tfVATip, "Invalid VAT Rate");

                }
            });

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();

            ob.tfDate.setText(dtf.format(localDate));

            ob.spContentScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ob.spContentScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            ob.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbCashMemo;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblChallanNo;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGTotal;
    private javax.swing.JLabel lblMessageBox;
    private javax.swing.JLabel lblNoOfProducts;
    private javax.swing.JLabel lblOrderNo;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblTaxInvoiceNo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVatNo;
    private javax.swing.JPanel panelProductDetails;
    private javax.swing.JScrollPane spClientDetails;
    private javax.swing.JScrollPane spContentScroll;
    private javax.swing.JScrollPane spServerDetails;
    private javax.swing.JTextArea taClientDetails;
    private javax.swing.JTextArea taServerDetails;
    private javax.swing.JTextField tfChallanNo;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfNoOfProducts;
    private javax.swing.JTextField tfOrderNo;
    private javax.swing.JTextField tfTaxInvoiceNo;
    private javax.swing.JTextField tfVATip;
    private javax.swing.JTextField tfVatNo;
    // End of variables declaration//GEN-END:variables

}

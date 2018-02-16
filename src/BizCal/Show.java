package BizCal;

import Utility.SharedRes;
import Utility.ConnectionManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Show extends javax.swing.JFrame {

    private final static String TNStockIn = "stock_in", TNStockOut = "stock_out", TNAmountRecievable = "receivable", TNAmountPayable = "payable", TNClientDetails = "client_details";
    ;
    public final static int STOCK_ISSUED = 0, IN_STOCKS = 1, AMOUNT_RECIEVABLE = 2, AMOUNT_PAYABLE = 3, CLIENT_DETAILS = 4;
    private static int FrameType = 0;

    public Show(int FrameType) {
        this.FrameType = FrameType;
        initComponents();

        tfSearch.getDocument().addDocumentListener(new DocumentListener() {

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
                String temp = SharedRes.chopQuotes(tfSearch.getText());
                switch (FrameType) {
                    case STOCK_ISSUED:
                        if (temp.equals("")) {
                            searchStockIssued("all");
                        } else {
                            searchStockIssued("");
                        }
                        break;
                    case IN_STOCKS:
                        if (temp.equals("")) {
                            searchInStocks("all");
                        } else {
                            searchInStocks("");
                        }
                        break;
                    case AMOUNT_PAYABLE:
                        if (temp.equals("")) {
                            searchAmountPayable("all");
                        } else {
                            searchAmountPayable("");
                        }
                        break;
                    case AMOUNT_RECIEVABLE:
                        if (temp.equals("")) {
                            searchAmountRecievable("all");
                        } else {
                            searchAmountRecievable("");
                        }
                        break;
                    case CLIENT_DETAILS:
                        if (temp.equals("")) {
                            searchClientDetails("all");
                        } else {
                            searchClientDetails("");
                        }
                        break;

                }
            }
        });

        this.setLocationRelativeTo(null);
        this.setIconImage(SharedRes.icon);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfSearch = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        spContainer = new javax.swing.JScrollPane();
        panelTable = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitle.setText("Search By Bill Number, Name, Date (yyyy-MM-dd), Perticular....");

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        spContainer.setViewportView(panelTable);

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSearch)
                    .addComponent(spContainer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblTitle.setText("Search By Bill Number, Name, Date (yyyy-MM-dd), Perticular....");
        switch (FrameType) {
            case STOCK_ISSUED:
                this.setTitle("Stock Issued");
                searchStockIssued("all");
                break;
            case IN_STOCKS:
                this.setTitle("In Stock");
                searchInStocks("all");
                break;
            case AMOUNT_PAYABLE:
                this.setTitle("Amount Payable");
                searchAmountPayable("all");
                break;
            case AMOUNT_RECIEVABLE:
                this.setTitle("Amount Recievable");
                searchAmountRecievable("all");
                break;
            case CLIENT_DETAILS:
                lblTitle.setText("Search by VAT or Client  name.");
                this.setTitle("Client Details");
                searchClientDetails("all");
                break;

        }
    }//GEN-LAST:event_formWindowOpened

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        String temp = SharedRes.chopQuotes(tfSearch.getText());
        switch (FrameType) {
            case STOCK_ISSUED:
                if (temp.equals("")) {
                    searchStockIssued("all");
                } else {
                    searchStockIssued("");
                }
                break;
            case IN_STOCKS:
                if (temp.equals("")) {
                    searchInStocks("all");
                } else {
                    searchInStocks("");
                }
                break;
            case AMOUNT_PAYABLE:
                if (temp.equals("")) {
                    searchAmountPayable("all");
                } else {
                    searchAmountPayable("");
                }
                break;
            case AMOUNT_RECIEVABLE:
                if (temp.equals("")) {
                    searchAmountRecievable("all");
                } else {
                    searchAmountRecievable("");
                }
                break;
            case CLIENT_DETAILS:
                if (temp.equals("")) {
                    searchClientDetails("all");
                } else {
                    searchClientDetails("");
                }
                break;

        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void searchClientDetails(String filter) {
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String temp = SharedRes.chopQuotes(tfSearch.getText());
            String count_qry, sql;
            if (filter.equalsIgnoreCase("ALL")) {
                count_qry = "select count(*) from " + TNClientDetails;

                sql = "SELECT * FROM " + TNClientDetails;
            } else {
                count_qry = "select count(*) from " + TNClientDetails + " WHERE vat='" + temp
                        + "' OR name='" + temp + "'";
                sql = "SELECT * FROM " + TNClientDetails + " WHERE vat='" + temp
                        + "' OR name='" + temp + "'";
            }

            PreparedStatement ob = Con.prepareStatement(sql);
            ResultSet RS = ob.executeQuery();
            PreparedStatement ob1 = Con.prepareStatement(count_qry);
            ResultSet RS1 = ob1.executeQuery();
            int RowNo = 0, ColNo = 5;
            panelTable.removeAll();
            if (RS1.next()) {
                RowNo = RS1.getInt(1) + 1;

            }
            GridLayout layout = new GridLayout(RowNo, ColNo, 0, 10);
            panelTable.setLayout(layout);

            int i = 0;
            while (RS.next()) {
                if (RowNo > 0) {
                    JLabel vat = new JLabel(RS.getString("vat"));
                    vat.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel name = new JLabel(RS.getString("name"));
                    name.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel address = new JLabel(RS.getString("address"));
                    address.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel phone = new JLabel(RS.getString("ph_no"));
                    phone.setHorizontalAlignment(SwingConstants.CENTER);
                    JButton delete = new JButton("Delete");
                    delete.setHorizontalAlignment(SwingConstants.CENTER);
                    delete.setName(RS.getString("vat"));
                    spContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    spContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Connection con = null;
                            try {
                                con = ConnectionManager.getConnection();
                                String q = "delete from " + TNClientDetails + " where vat= " + delete.getName();
                                Statement smt1 = con.createStatement();
                                int rs1 = smt1.executeUpdate(q);

                                searchClientDetails("all");
                            } catch (SQLException s) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, s);
                            } finally {
                                try {
                                    con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    }
                    );
                    panelTable.add(vat, i,
                            0);
                    panelTable.add(name, i,
                            1);
                    panelTable.add(address, i,
                            2);
                    panelTable.add(phone, i,
                            3);
                    panelTable.add(delete, i, 4);
                }

                i++;
            }

            JLabel lbl = new JLabel();
            for (int j = 0; j < ColNo; j++) {
                switch (j) {
                    case 0:
                        lbl = new JLabel("VAT ");
                        break;
                    case 1:
                        lbl = new JLabel("Name ");
                        break;
                    case 2:
                        lbl = new JLabel("Address ");
                        break;
                    case 3:
                        lbl = new JLabel("Phone no ");
                        break;

                    case 4:
                        lbl = new JLabel("Delete ");
                        break;
                }
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.red);

                panelTable.add(lbl, 0, j);
                this.revalidate();
                this.repaint();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                Con.close();
            } catch (Exception e) {

            }
        }
    }

    private void searchInStocks(String filter) {
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String temp = SharedRes.chopQuotes(tfSearch.getText());
            String count_qry, sql;
            if (filter.equalsIgnoreCase("ALL")) {
                count_qry = "select count(*) from " + TNStockIn;

                sql = "SELECT * FROM " + TNStockIn;
            } else {
                count_qry = "select count(*) from " + TNStockIn + " WHERE si_billno='" + temp
                        + "' OR si_date='" + temp + "' OR si_product='" + temp
                        + "' OR si_seller='" + temp + "' OR si_perticular='" + temp + "'";

                sql = "SELECT * FROM " + TNStockIn + " WHERE si_billno='" + temp
                        + "' OR si_date='" + temp + "' OR si_product='" + temp
                        + "' OR si_seller='" + temp + "' OR si_perticular='" + temp + "'";
            }

            PreparedStatement ob = Con.prepareStatement(sql);
            ResultSet RS = ob.executeQuery();
            PreparedStatement ob1 = Con.prepareStatement(count_qry);
            ResultSet RS1 = ob1.executeQuery();
            int RowNo = 0, ColNo = 8;
            panelTable.removeAll();
            if (RS1.next()) {
                RowNo = RS1.getInt(1) + 1;

            }
            GridLayout layout = new GridLayout(RowNo, ColNo, 0, 10);
            panelTable.setLayout(layout);

            int i = 0;
            while (RS.next()) {
                if (RowNo > 0) {
                    JLabel billno = new JLabel(RS.getString("si_billno"));
                    billno.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel product = new JLabel(RS.getString("si_product"));
                    product.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel qty = new JLabel(RS.getString("si_qty"));
                    qty.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel rate = new JLabel(RS.getString("si_rate"));
                    rate.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel date = new JLabel(RS.getString("si_date"));
                    date.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel buyer = new JLabel(RS.getString("si_seller"));
                    buyer.setHorizontalAlignment(SwingConstants.CENTER);
                    JTextField perticular = new JTextField(RS.getString("si_perticular"));
                    perticular.setHorizontalAlignment(SwingConstants.CENTER);
                    perticular.setName(RS.getString("si_billno"));
                    JButton delete = new JButton("Delete");
                    delete.setHorizontalAlignment(SwingConstants.CENTER);
                    delete.setName(RS.getString("sl_no"));
                    spContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    spContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                    perticular.getDocument().addDocumentListener(new DocumentListener() {

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
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();

                                String sql = "UPDATE " + TNStockIn + " SET si_perticular='" + SharedRes.chopQuotes(perticular.getText().toUpperCase()) + "' WHERE si_billno=" + perticular.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();
                                String qry4 = "select * from " + TNStockIn + " where sl_no= " + delete.getName();
                                PreparedStatement obj4 = Con.prepareStatement(qry4);

                                ResultSet RS4 = obj4.executeQuery();

                                if (RS4.next()) {
                                }
                                String qry3 = "Select product_name,qty,price from product_details";
                                PreparedStatement obj = Con.prepareStatement(qry3);
                                ResultSet RS3 = obj.executeQuery();
                                String qry11 = "select count(*) from product_details";
                                PreparedStatement ob = Con.prepareStatement(qry11);
                                ResultSet RS = ob.executeQuery();

                                int c = 0;
                                if (RS.next()) {
                                    c = RS.getInt(1);
                                }
                                for (int i = 0; i < c; i++) {
                                    if (RS3.next()) {
                                        String p = RS3.getString("product_name");
                                        if (RS4.getString("si_product").equalsIgnoreCase(p)) {
                                            break;
                                        }
                                    }
                                }

                                String qty1 = RS4.getString("si_qty");
                                String qty2 = RS3.getString("qty");
                                double quantity = Double.parseDouble(qty2) - Double.parseDouble(qty1);

                                String qry6 = "update product_details set qty= '" + quantity + "' where product_name= '" + RS4.getString("si_product") + "'";
                                PreparedStatement obj6 = Con.prepareStatement(qry6);
                                obj6.executeUpdate(qry6);

                                String qry7 = "delete from payable where p_billno= '" + RS4.getString("si_billno") + "' and p_date= '" + RS4.getString("si_date") + "' and p_seller= '" + RS4.getString("si_seller") + "'";
                                PreparedStatement obj7 = Con.prepareStatement(qry7);
                                obj7.executeUpdate(qry7);

                                String q = "delete from " + TNStockIn + " where sl_no= " + delete.getName();
                                Statement smt1 = Con.createStatement();
                                int rs1 = smt1.executeUpdate(q);

                                searchInStocks("all");
                            } catch (SQLException s) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, s);
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    }
                    );
                    panelTable.add(billno, i,
                            0);
                    panelTable.add(product, i,
                            1);
                    panelTable.add(qty, i,
                            2);
                    panelTable.add(rate, i,
                            3);
                    panelTable.add(date, i,
                            4);
                    panelTable.add(buyer, i,
                            5);
                    panelTable.add(perticular, i,
                            6);
                    panelTable.add(delete, i,
                            7);

                }

                i++;
            }

            JLabel lbl = new JLabel();
            for (int j = 0; j < ColNo; j++) {
                switch (j) {
                    case 0:
                        lbl = new JLabel("Bill No ");
                        break;
                    case 1:
                        lbl = new JLabel("Product ");
                        break;
                    case 2:
                        lbl = new JLabel("Quantity ");
                        break;
                    case 3:
                        lbl = new JLabel("Rate ");
                        break;
                    case 4:
                        lbl = new JLabel("Date ");
                        break;
                    case 5:
                        lbl = new JLabel("Buyer ");
                        break;
                    case 6:
                        lbl = new JLabel("Perticular ");
                        break;
                    case 7:
                        lbl = new JLabel("Delete ");
                        break;
                }
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.red);

                panelTable.add(lbl, 0, j);
                this.revalidate();
                this.repaint();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                Con.close();
            } catch (Exception e) {

            }
        }
    }

    private void searchStockIssued(String filter) {
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String temp = SharedRes.chopQuotes(tfSearch.getText());
            String count_qry, sql;
            if (filter.equalsIgnoreCase("ALL")) {
                count_qry = "select count(*) from " + TNStockOut;

                sql = "SELECT * FROM " + TNStockOut;
            } else {
                count_qry = "select count(*) from " + TNStockOut + " WHERE so_billno='" + temp
                        + "' OR so_date='" + temp + "' OR so_product='" + temp
                        + "' OR so_buyer='" + temp + "' OR so_perticular='" + temp + "'";

                sql = "SELECT * FROM " + TNStockOut + " WHERE so_billno='" + temp
                        + "' OR so_date='" + temp + "' OR so_product='" + temp
                        + "' OR so_buyer='" + temp + "' OR so_perticular='" + temp + "'";
            }

            PreparedStatement ob = Con.prepareStatement(sql);
            ResultSet RS = ob.executeQuery();
            PreparedStatement ob1 = Con.prepareStatement(count_qry);
            ResultSet RS1 = ob1.executeQuery();
            int RowNo = 0, ColNo = 7;
            panelTable.removeAll();
            if (RS1.next()) {
                RowNo = RS1.getInt(1) + 1;

            }
            GridLayout layout = new GridLayout(RowNo, ColNo, 0, 10);
            panelTable.setLayout(layout);

            int i = 0;
            while (RS.next()) {
                if (RowNo > 0) {
                    JLabel billno = new JLabel(RS.getString("so_billno"));
                    billno.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel product = new JLabel(RS.getString("so_product"));
                    product.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel qty = new JLabel(RS.getString("so_qty"));
                    qty.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel rate = new JLabel(RS.getString("so_rate"));
                    rate.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel date = new JLabel(RS.getString("so_date"));
                    date.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel buyer = new JLabel(RS.getString("so_buyer"));
                    buyer.setHorizontalAlignment(SwingConstants.CENTER);
                    JTextField perticular = new JTextField(RS.getString("so_perticular"));
                    perticular.setHorizontalAlignment(SwingConstants.CENTER);

                    perticular.setName(RS.getString("so_billno"));

                    spContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    spContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                    perticular.getDocument().addDocumentListener(new DocumentListener() {

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
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();

                                String sql = "UPDATE " + TNStockOut + " SET so_perticular='" + SharedRes.chopQuotes(perticular.getText().toUpperCase()) + "' WHERE so_billno=" + perticular.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    panelTable.add(billno, i, 0);
                    panelTable.add(product, i, 1);
                    panelTable.add(qty, i, 2);
                    panelTable.add(rate, i, 3);
                    panelTable.add(date, i, 4);
                    panelTable.add(buyer, i, 5);
                    panelTable.add(perticular, i, 6);

                }

                i++;
            }

            JLabel lbl = new JLabel();
            for (int j = 0; j < ColNo; j++) {
                switch (j) {
                    case 0:
                        lbl = new JLabel("Bill No ");
                        break;
                    case 1:
                        lbl = new JLabel("Product ");
                        break;
                    case 2:
                        lbl = new JLabel("Quantity ");
                        break;
                    case 3:
                        lbl = new JLabel("Rate ");
                        break;
                    case 4:
                        lbl = new JLabel("Date ");
                        break;
                    case 5:
                        lbl = new JLabel("Buyer ");
                        break;
                    case 6:
                        lbl = new JLabel("Perticular ");
                        break;
                }
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.red);

                panelTable.add(lbl, 0, j);
                this.revalidate();
                this.repaint();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                Con.close();
            } catch (Exception e) {

            }
        }
    }

    private void searchAmountRecievable(String filter) {
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String temp = SharedRes.chopQuotes(tfSearch.getText());
            String count_qry, sql;
            if (filter.equalsIgnoreCase("ALL")) {
                count_qry = "select count(*) from " + TNAmountRecievable;

                sql = "SELECT * FROM " + TNAmountRecievable;
            } else {
                count_qry = "select count(*) from " + TNAmountRecievable + " WHERE r_billno='" + temp
                        + "' OR r_date='" + temp + "' OR r_buyer='" + temp
                        + "' OR r_perticular='" + temp + "'";

                sql = "SELECT * FROM " + TNAmountRecievable + " WHERE r_billno='" + temp
                        + "' OR r_date='" + temp + "' OR r_buyer='" + temp
                        + "' OR r_perticular='" + temp + "'";
            }

            PreparedStatement ob = Con.prepareStatement(sql);
            ResultSet RS = ob.executeQuery();
            PreparedStatement ob1 = Con.prepareStatement(count_qry);
            ResultSet RS1 = ob1.executeQuery();
            int RowNo = 0, ColNo = 6;
            panelTable.removeAll();
            if (RS1.next()) {
                RowNo = RS1.getInt(1) + 1;
            }
            GridLayout layout = new GridLayout(RowNo, ColNo, 0, 10);
            panelTable.setLayout(layout);//new GridLayout(RowNo, 7, 0, 100));
            int i = 0;
            while (RS.next()) {
                if (RowNo > 0) {
                    JLabel billno = new JLabel(RS.getString("r_billno"));
                    billno.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel date = new JLabel(RS.getString("r_date"));
                    date.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel seller = new JLabel(RS.getString("r_buyer"));
                    seller.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel amount = new JLabel(RS.getString("r_amount"));
                    amount.setHorizontalAlignment(SwingConstants.CENTER);
                    JTextField perticular = new JTextField(RS.getString("r_perticular"));
                    perticular.setHorizontalAlignment(SwingConstants.CENTER);
                    perticular.setName(RS.getString("r_billno"));
                    JCheckBox remark = new JCheckBox();
                    remark.setName(RS.getString("r_billno"));
                    remark.setHorizontalAlignment(JCheckBox.CENTER);

                    if (RS.getString("r_remark").equalsIgnoreCase("true")) {
                        remark.setSelected(true);
                    } else if (RS.getString("r_remark").equalsIgnoreCase("false")) {
                        remark.setSelected(false);
                    }
                    perticular.getDocument().addDocumentListener(new DocumentListener() {

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
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();

                                String sql = "UPDATE " + TNAmountRecievable + " SET r_perticular='" + SharedRes.chopQuotes(perticular.getText().toUpperCase()) + "' WHERE r_billno=" + perticular.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    remark.addItemListener(new ItemListener() {

                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();
                                String sql = "UPDATE " + TNAmountRecievable + " SET r_remark='" + remark.isSelected() + "' WHERE r_billno=" + remark.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                System.out.println(ex.toString());
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    spContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    spContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                    panelTable.add(billno, i, 0);
                    panelTable.add(date, i, 1);
                    panelTable.add(perticular, i, 2);
                    panelTable.add(seller, i, 3);
                    panelTable.add(amount, i, 4);
                    panelTable.add(remark, i, 5);

                }

                i++;
            }

            JLabel lbl = new JLabel();
            for (int j = 0; j < ColNo; j++) {
                switch (j) {
                    case 0:
                        lbl = new JLabel("Bill No ");
                        break;
                    case 1:
                        lbl = new JLabel("Date ");
                        break;
                    case 2:
                        lbl = new JLabel("Perticular ");
                        break;
                    case 3:
                        lbl = new JLabel("Buyer ");
                        break;
                    case 4:
                        lbl = new JLabel("Amount ");
                        break;
                    case 5:
                        lbl = new JLabel("Remark ");
                        break;
                }
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.red);
                panelTable.add(lbl, 0, j);
                this.revalidate();
                this.repaint();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                Con.close();
            } catch (Exception e) {

            }
        }
    }

    private void searchAmountPayable(String filter) {
        Connection Con = null;
        try {
            Con = ConnectionManager.getConnection();
            String temp = SharedRes.chopQuotes(tfSearch.getText());
            String count_qry, sql;
            if (filter.equalsIgnoreCase("ALL")) {
                count_qry = "select count(*) from " + TNAmountPayable;

                sql = "SELECT * FROM " + TNAmountPayable;
            } else {
                count_qry = "select count(*) from " + TNAmountPayable + " WHERE p_billno='" + temp
                        + "' OR p_date='" + temp + "' OR p_seller='" + temp
                        + "' OR p_petrticular='" + temp + "'";

                sql = "SELECT * FROM " + TNAmountPayable + " WHERE p_billno='" + temp
                        + "' OR p_date='" + temp + "' OR p_seller='" + temp
                        + "' OR p_petrticular='" + temp + "'";
            }

            PreparedStatement ob = Con.prepareStatement(sql);
            ResultSet RS = ob.executeQuery();
            PreparedStatement ob1 = Con.prepareStatement(count_qry);
            ResultSet RS1 = ob1.executeQuery();
            int RowNo = 0, ColNo = 6;
            panelTable.removeAll();
            if (RS1.next()) {
                RowNo = RS1.getInt(1) + 1;
            }
            GridLayout layout = new GridLayout(RowNo, ColNo, 0, 10);
            panelTable.setLayout(layout);

            int i = 0;
            while (RS.next()) {
                if (RowNo > 0) {
                    JLabel billno = new JLabel(RS.getString("p_billno"));
                    billno.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel date = new JLabel(RS.getString("p_date"));
                    date.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel seller = new JLabel(RS.getString("p_seller"));
                    seller.setHorizontalAlignment(SwingConstants.CENTER);
                    JLabel amount = new JLabel(RS.getString("p_amount"));
                    amount.setHorizontalAlignment(SwingConstants.CENTER);
                    JTextField perticular = new JTextField(RS.getString("p_petrticular"));
                    perticular.setHorizontalAlignment(SwingConstants.CENTER);
                    perticular.setName(RS.getString("p_billno"));
                    JCheckBox remark = new JCheckBox();
                    remark.setName(RS.getString("p_billno"));
                    remark.setHorizontalAlignment(JCheckBox.CENTER);

                    if (RS.getString("p_remark").equalsIgnoreCase("true")) {
                        remark.setSelected(true);
                    } else if (RS.getString("p_remark").equalsIgnoreCase("false")) {
                        remark.setSelected(false);
                    }
                    perticular.getDocument().addDocumentListener(new DocumentListener() {

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
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();

                                String sql = "UPDATE " + TNAmountPayable + " SET p_petrticular='" + SharedRes.chopQuotes(perticular.getText().toUpperCase()) + "' WHERE p_billno=" + perticular.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    remark.addItemListener(new ItemListener() {

                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            Connection Con = null;
                            try {
                                Con = ConnectionManager.getConnection();
                                String sql = "UPDATE " + TNAmountPayable + " SET p_remark='" + remark.isSelected() + "' WHERE p_billno=" + remark.getName();
                                Statement smt = Con.createStatement();
                                int rs = smt.executeUpdate(sql);

                            } catch (SQLException ex) {
                                System.out.println(ex.toString());
                            } finally {
                                try {
                                    Con.close();
                                } catch (Exception ex) {

                                }
                            }
                        }
                    });

                    spContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    spContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                    panelTable.add(billno, i, 0);
                    panelTable.add(date, i, 1);
                    panelTable.add(perticular, i, 2);
                    panelTable.add(seller, i, 3);
                    panelTable.add(amount, i, 4);
                    panelTable.add(remark, i, 5);

                }

                i++;
            }

            JLabel lbl = new JLabel();//[] = new JLabel[ColNo];
            for (int j = 0; j < ColNo; j++) {
                switch (j) {
                    case 0:
                        lbl = new JLabel("Bill No ");
                        break;
                    case 1:
                        lbl = new JLabel("Date ");
                        break;
                    case 2:
                        lbl = new JLabel("Perticular ");
                        break;
                    case 3:
                        lbl = new JLabel("Seller ");
                        break;
                    case 4:
                        lbl = new JLabel("Amount ");
                        break;
                    case 5:
                        lbl = new JLabel("Remark ");
                        break;
                }
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.red);
                panelTable.add(lbl, 0, j);
                this.revalidate();
                this.repaint();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                Con.close();
            } catch (Exception e) {

            }
        }
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
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Show ob = new Show(FrameType);
                ob.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelTable;
    private javax.swing.JScrollPane spContainer;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}

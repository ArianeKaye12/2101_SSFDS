
package frontdesksystem;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin extends javax.swing.JFrame {

    
    public Admin() {
        initComponents();
        Connect();
        LoadProductNo ();
        Fetch();
        LoadNo ();
        FetchData();
        LoadCat();
        FetchCat();
        LoadPost();
        FetchPost();
        updateCombo();
        updateComboCat();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;


    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void LoadProductNo (){
        
        try {
        pst = con.prepareStatement("SELECT id FROM product");
        rs = pst.executeQuery();
        if (rs.next()) {
            jTextFieldPID.setText(rs.getString(1));  
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM product");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable2.getModel();
            df.setRowCount(0);
            while (rs.next()){
                Vector v2= new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getBigDecimal("price"));
                    v2.add(rs.getInt("quantity"));
                    
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void LoadNo (){
        
        try {
        pst = con.prepareStatement("SELECT id FROM employee");
        rs = pst.executeQuery();
        if (rs.next()) {
            jTextFieldEID.setText(rs.getString(1));  
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }   
    private void FetchData(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM employee");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTableME.getModel();
            df.setRowCount(0);
            while (rs.next()){
                Vector v2= new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("FirstName"));
                    v2.add(rs.getString("LastName"));
                    v2.add(rs.getString("PhoneNumber"));
                    v2.add(rs.getString("Position"));
                    v2.add(rs.getString("Services"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void LoadCat (){
        
        try {
        pst = con.prepareStatement("SELECT id FROM category");
        rs = pst.executeQuery();
        if (rs.next()) {
            jTextFieldCID.setText(rs.getString(1));  
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    } 
    private void FetchCat(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM category");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTableCat.getModel();
            df.setRowCount(0);
            while (rs.next()){
                Vector v2= new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("CategoryName"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void LoadPost (){
        
        try {
        pst = con.prepareStatement("SELECT id FROM position");
        rs = pst.executeQuery();
        if (rs.next()) {
            jTextFieldPostID.setText(rs.getString(1));  
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }  
    private void FetchPost(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM position");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)PostTable.getModel();
            df.setRowCount(0);
            while (rs.next()){
                Vector v2= new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("PositionName"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateCombo() {
        String sql = "SELECT * FROM position";
        try {
            // Prepare the query
            pst = con.prepareStatement(sql);
            
            // Execute the query and get the result
            rs = pst.executeQuery();
            
            // Populate the ComboBox with categories from the database
            while (rs.next()) {
                jComboBoxPos.addItem(rs.getString("PositionName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading position.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources (optional: can be improved with try-with-resources)
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void updateComboCat() {
        String sql = "SELECT * FROM category";
        try {
            // Prepare the query
            pst = con.prepareStatement(sql);
            
            // Execute the query and get the result
            rs = pst.executeQuery();
            
            // Populate the ComboBox with categories from the database
            while (rs.next()) {
                jComboBoxCat.addItem(rs.getString("CategoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading categories.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources (optional: can be improved with try-with-resources)
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jTextFieldPName = new javax.swing.JTextField();
        jTextFieldQty = new javax.swing.JTextField();
        jButtonADD = new javax.swing.JButton();
        jButtonUPDATE = new javax.swing.JButton();
        jButtonDELETE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonSEARCH = new javax.swing.JButton();
        jTextFieldPID = new javax.swing.JTextField();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxPos = new javax.swing.JComboBox<>();
        jTextFieldEID = new javax.swing.JTextField();
        jTextFieldFName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableME = new javax.swing.JTable();
        ADD = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        SEARCH = new javax.swing.JButton();
        jTextFieldLName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNum = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxSer = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCat = new javax.swing.JTable();
        btnADD = new javax.swing.JButton();
        btnSEARCH = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        jTextFieldCID = new javax.swing.JTextField();
        jTextFieldCName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldPostName = new javax.swing.JTextField();
        jTextFieldPostID = new javax.swing.JTextField();
        PostADD = new javax.swing.JButton();
        PostSEARCH = new javax.swing.JButton();
        PostUPDATE = new javax.swing.JButton();
        PostDELETE = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        PostTable = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setText("MANAGE PRODUCTS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("MANAGE PRODUCTS");

        jLabel2.setText("ProductID");

        jLabel4.setText("Category");

        jLabel3.setText("Name");

        jLabel6.setText("Quantity");

        jLabel7.setText("Price");

        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jButtonUPDATE.setText("UPDATE");
        jButtonUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUPDATEActionPerformed(evt);
            }
        });

        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Price", "Quantity"
            }
        ));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jButtonSEARCH.setText("SEARCH");
        jButtonSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSEARCHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jComboBoxCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldPName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPID))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrice)
                            .addComponent(jTextFieldQty))
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonADD)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonUPDATE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonDELETE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonSEARCH)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonADD)
                    .addComponent(jButtonUPDATE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDELETE)
                        .addComponent(jButtonSEARCH)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PRODUCTS", jPanel1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setText("MANAGE EMPLOYEES");

        jLabel9.setText("EmployeeID");

        jLabel10.setText("First Name");

        jLabel11.setText("Position");

        jTableME.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Phone Number", "Position", "Service"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableME.setShowGrid(true);
        jScrollPane1.setViewportView(jTableME);

        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        SEARCH.setText("SEARCH");
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });

        jLabel16.setText("Last Name");

        jLabel17.setText("Phone #");

        jLabel18.setText("Service");

        jComboBoxSer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spa Services", "Salon Services" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(31, 31, 31)
                                .addComponent(jTextFieldEID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNum, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jComboBoxPos, 0, 212, Short.MAX_VALUE)
                            .addComponent(jComboBoxSer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(ADD)
                        .addGap(29, 29, 29)
                        .addComponent(UPDATE)
                        .addGap(41, 41, 41)
                        .addComponent(DELETE)
                        .addGap(48, 48, 48)
                        .addComponent(SEARCH)))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTextFieldEID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(jComboBoxSer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADD)
                    .addComponent(UPDATE)
                    .addComponent(DELETE)
                    .addComponent(SEARCH))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );

        jTabbedPane1.addTab("EMPLOYEE", jPanel3);

        jLabel12.setText("CatgoryID");

        jLabel13.setText("Category Name");

        jTableCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category ID", "Category Name"
            }
        ));
        jTableCat.setShowGrid(true);
        jScrollPane4.setViewportView(jTableCat);

        btnADD.setText("ADD");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        btnSEARCH.setText("SEARCH");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });

        btnUPDATE.setText("UPDATE");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnDELETE.setText("DELETE");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnADD)
                        .addGap(77, 77, 77)
                        .addComponent(btnUPDATE)
                        .addGap(72, 72, 72)
                        .addComponent(btnDELETE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSEARCH))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextFieldCID, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(11, 11, 11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnADD)
                    .addComponent(btnSEARCH)
                    .addComponent(btnUPDATE)
                    .addComponent(btnDELETE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE CATEGORIES", jPanel2);

        jLabel14.setText("PositionID");

        jLabel15.setText("Position Name");

        PostADD.setText("ADD");
        PostADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostADDActionPerformed(evt);
            }
        });

        PostSEARCH.setText("SEARCH");
        PostSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostSEARCHActionPerformed(evt);
            }
        });

        PostUPDATE.setText("UPDATE");
        PostUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostUPDATEActionPerformed(evt);
            }
        });

        PostDELETE.setText("DELETE");
        PostDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostDELETEActionPerformed(evt);
            }
        });

        PostTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "PositionID", "PositionName"
            }
        ));
        PostTable.setShowGrid(true);
        jScrollPane5.setViewportView(PostTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(PostADD)
                                .addGap(45, 45, 45)
                                .addComponent(PostUPDATE)
                                .addGap(48, 48, 48)
                                .addComponent(PostDELETE)
                                .addGap(50, 50, 50)
                                .addComponent(PostSEARCH)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextFieldPostID, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPostName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPostID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTextFieldPostName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PostADD)
                    .addComponent(PostUPDATE)
                    .addComponent(PostSEARCH)
                    .addComponent(PostDELETE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE POSITION", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
        try {
        String pname = jTextFieldPName.getText();
        String category = jComboBoxCat.getSelectedItem().toString();  
        BigDecimal price = null;
        
        try {
            price = new BigDecimal(jTextFieldPrice.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price input.");
        }
        
        int quantity = 0;
        try {
            quantity = Integer.parseInt(jTextFieldQty.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity input.");
        }
        
        if (pname.isEmpty() || category.isEmpty() || price == null || price.compareTo(BigDecimal.ZERO) <= 0 || quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields correctly. No field should be left empty, and price/quantity must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 

        // Prompt to confirm adding the product
        int confirmation = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to add this product?\nName: " + pname + "\nCategory: " + category + "\nPrice: " + price + "\nQuantity: " + quantity,
            "Confirm Add",
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

        if (confirmation == JOptionPane.NO_OPTION) {
            return;  // Do nothing if user selects "No"
        }

        // Proceed with adding the data if the user confirms
        pst = con.prepareStatement("INSERT INTO product (pname, price, quantity, category) VALUES (?,?,?,?)");
        pst.setString(1, pname);  
        pst.setBigDecimal(2, price);  
        pst.setInt(3, quantity);  
        pst.setString(4, category);  
        
        int k = pst.executeUpdate();  

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record Added Successfully!!");
            
            jTextFieldPName.setText("");
            jComboBoxCat.setSelectedIndex(-1);  
            jTextFieldPrice.setText("");
            jTextFieldQty.setText("");
            Fetch();
            LoadProductNo();
            
        } else {
            JOptionPane.showMessageDialog(this, "Record Failed to Save!!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }     
    }//GEN-LAST:event_jButtonADDActionPerformed

    private void jButtonSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSEARCHActionPerformed
        String pid = jTextFieldPID.getText();  
    
    // Show a confirmation dialog asking if they want to search for the product
    int response = JOptionPane.showConfirmDialog(this, "Do you want to search for the product?", 
                                                 "Search Confirmation", JOptionPane.YES_NO_OPTION);
    
    if (response == JOptionPane.YES_OPTION) {
        try {
            pst = con.prepareStatement("SELECT * FROM product WHERE id = ?");
            pst.setString(1, pid); 
            rs = pst.executeQuery();
            
            if (rs.next()) {
                jTextFieldPName.setText(rs.getString(2));
                BigDecimal price = rs.getBigDecimal(3);
                
                if (price != null) {
                    jTextFieldPrice.setText(price.toString());  
                } else {
                    jTextFieldPrice.setText("");  
                }
                
                int quantity = rs.getInt(4);
                jTextFieldQty.setText(String.valueOf(quantity));  
                jComboBoxCat.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(this, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error searching for product", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Optionally handle the case when the user selects "No"
        JOptionPane.showMessageDialog(this, "Search cancelled", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButtonSEARCHActionPerformed

    private void jButtonUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUPDATEActionPerformed
        try {
        String pname = jTextFieldPName.getText();   
        String category = jComboBoxCat.getSelectedItem().toString();  
        BigDecimal price = null;
        try {
            price = new BigDecimal(jTextFieldPrice.getText().trim());  
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price input. Please enter a valid decimal value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int quantity = 0;
        try {
            quantity = Integer.parseInt(jTextFieldQty.getText().trim());  
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String pid = jTextFieldPID.getText();       

        if (pid.isEmpty() || pname.isEmpty() || category.isEmpty() || price == null || quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty, and price/quantity must be valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String query = "UPDATE product SET pname = ?, price = ?, quantity = ?, category = ? WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, pname);    
        pst.setBigDecimal(2, price); 
        pst.setInt(3, quantity);      
        pst.setString(4, category);   
        pst.setString(5, pid);  
        
        int k = pst.executeUpdate();
        
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been Successfully Updated!!");

            jTextFieldPName.setText("");
            jComboBoxCat.setSelectedIndex(-1);  
            jTextFieldPrice.setText("");
            jTextFieldQty.setText("");
            jTextFieldPName.requestFocus();
            Fetch();
            LoadProductNo();
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Product ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonUPDATEActionPerformed

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        try {
            String pid = jTextFieldPID.getText();
            pst = con.prepareStatement ("DELETE FROM product WHERE id=?");
            pst.setString (1,pid);
            
            int k =pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been Successfully Deleted!");
                jTextFieldPName.setText("");
                jComboBoxCat.setSelectedIndex(-1);  
                jTextFieldPrice.setText("");
                jTextFieldQty.setText("");
                jTextFieldPName.requestFocus(); 
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to Delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonDELETEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        try {
        String FirstName = jTextFieldFName.getText();
        String LastName = jTextFieldLName.getText();
        String PhoneNumber = jTextFieldNum.getText();  
        String Position = jComboBoxPos.getSelectedItem().toString();
        String Services = jComboBoxSer.getSelectedItem().toString();
 
        if (FirstName.isEmpty() || LastName.isEmpty() || PhoneNumber.isEmpty() || Position.isEmpty() || Services.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        pst = con.prepareStatement("INSERT INTO employee (FirstName, LastName, PhoneNumber, Position, Services) VALUES (?,?,?,?,?)");
        pst.setString(1, FirstName);  
        pst.setString(2, LastName);  
        pst.setString(3, PhoneNumber);  
        pst.setString(4, Position);
        pst.setString(5, Services);
        

        int k = pst.executeUpdate(); 

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record Added Successfully!!");

            jTextFieldFName.setText("");
            jTextFieldLName.setText("");
            jTextFieldNum.setText("");
            jComboBoxPos.setSelectedIndex(-1); 
            jComboBoxSer.setSelectedIndex(-1);
            FetchData();
            LoadNo();
        } else {
            JOptionPane.showMessageDialog(this, "Record Failed to Save!!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ADDActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        try {
        String FirstName = jTextFieldFName.getText();
        String LastName = jTextFieldLName.getText();
        String PhoneNumber = jTextFieldNum.getText();  
        String Position = jComboBoxPos.getSelectedItem().toString();
        String Services = jComboBoxSer.getSelectedItem().toString();      
        String eid = jTextFieldEID.getText();
        if (eid.isEmpty() || FirstName.isEmpty() || LastName.isEmpty() || PhoneNumber.isEmpty() || Position.isEmpty() || Services.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String query = "UPDATE employee SET FirstName = ?, LastName = ?, PhoneNumber = ?, Position = ?, Services=? WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, FirstName);  
        pst.setString(2, LastName);  
        pst.setString(3, PhoneNumber);  
        pst.setString(4, Position); 
        pst.setString(5, Services);
        pst.setString(6, eid);
        
        int k = pst.executeUpdate();
        
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been Successfully Updated!!");

            jTextFieldFName.setText("");
            jTextFieldLName.setText("");
            jTextFieldNum.setText("");
            jComboBoxPos.setSelectedIndex(-1); 
            jComboBoxSer.setSelectedIndex(-1);
            FetchData();
            LoadNo();
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Product ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
        String eid = jTextFieldEID.getText();  

    try {
        pst = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
        pst.setString(1, eid); 
        rs = pst.executeQuery();

        if (rs.next()==true) {
            jTextFieldFName.setText(rs.getString(2));
            jTextFieldLName.setText(rs.getString(3));
            jTextFieldNum.setText(rs.getString(4));
            jComboBoxPos.setSelectedItem(rs.getString(5));
            jComboBoxSer.setSelectedItem(rs.getString(6));
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error searching for employee", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SEARCHActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        try {
            String eid = jTextFieldEID.getText();
            pst = con.prepareStatement ("DELETE FROM employee WHERE id=?");
            pst.setString (1,eid);
            
            int k =pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully Deleted!");
                jTextFieldFName.setText("");
                jTextFieldLName.setText("");
                jTextFieldNum.setText("");              
                jComboBoxPos.setSelectedIndex(-1); 
                jComboBoxSer.setSelectedIndex(-1); 
                FetchData();
                LoadNo();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to Delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        String CategoryName = jTextFieldCName.getText();

    if (CategoryName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        pst = con.prepareStatement("SELECT COUNT(*) FROM category WHERE CategoryName = ?");
        pst.setString(1, CategoryName);
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Category name already exists! Please choose a different name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pst = con.prepareStatement("INSERT INTO category (CategoryName) VALUES (?)");
        pst.setString(1, CategoryName);
        
        int k = pst.executeUpdate();  

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record Added Successfully!!");
            jTextFieldCName.setText("");  
            FetchCat();  
            LoadCat();   
        } else {
            JOptionPane.showMessageDialog(this, "Record Failed to Save!!");
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database", "root", "");

        Statement stm = con.createStatement();
        ResultSet rs2 = stm.executeQuery("SELECT CategoryName FROM category"); 

        jComboBoxCat.removeAllItems();  
        
        while (rs2.next()) {
            String name = rs2.getString("CategoryName"); 
            jComboBoxCat.addItem(name); 
        }
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        String cid = jTextFieldCID.getText();  
    try {
        pst = con.prepareStatement("SELECT * FROM category WHERE id = ?");
        pst.setString(1, cid); 
        rs = pst.executeQuery();

        if (rs.next()==true) {
            jTextFieldCName.setText(rs.getString(2));
        } else {
            JOptionPane.showMessageDialog(this, "Category not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error searching for category", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        try {
        String CategoryName = jTextFieldCName.getText();   
        String cid = jTextFieldCID.getText();      

        if (cid.isEmpty()|| CategoryName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "UPDATE category SET CategoryName = ? WHERE id = ?";
        pst = con.prepareStatement(query);

        pst.setString(1, CategoryName);    
        pst.setString(2, cid);     

        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");
            
            jTextFieldCName.setText("");
            jTextFieldCName.requestFocus();
            FetchCat();
            LoadCat();        
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Category ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating category: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
            String cid = jTextFieldCID.getText();
            pst = con.prepareStatement ("DELETE FROM category WHERE id=?");
            pst.setString (1,cid);
            
            int k =pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully Deleted!");
                jTextFieldCName.setText("");
                jTextFieldCName.requestFocus(); 
                FetchCat();
                LoadCat();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to Delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void PostADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostADDActionPerformed
        try {
    String PositionName = jTextFieldPostName.getText();

    if (PositionName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;  
    }

    // Step 1: Check if the PositionName already exists
    pst = con.prepareStatement("SELECT * FROM position WHERE PositionName = ?");
    pst.setString(1, PositionName);
    ResultSet rsCheck = pst.executeQuery();

    if (rsCheck.next()) {  // If a result is found, the PositionName already exists
        JOptionPane.showMessageDialog(this, "Position Name already exists. Please enter a different name.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Step 2: Insert the new position if it does not exist
    pst = con.prepareStatement("INSERT INTO position (PositionName) VALUES (?)");
    pst.setString(1, PositionName);
    
    int k = pst.executeUpdate();  

    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Record Added Successfully!!");
        
        // Clear the input field after adding the record
        jTextFieldPostName.setText("");
        
        // Refresh the list and the table
        FetchPost();
        LoadPost();  
    } else {
        JOptionPane.showMessageDialog(this, "Record Failed to Save!!");
    }

    // Load the positions into the JComboBox
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }

    con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database", "root", "");
    Statement stm = con.createStatement();
    ResultSet rs2 = stm.executeQuery("SELECT PositionName FROM position"); 

    jComboBoxPos.removeAllItems();  
    while (rs2.next()) {
        String name = rs2.getString("PositionName"); 
        jComboBoxPos.addItem(name); 
    }
    con.close();
} catch (SQLException ex) {
    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_PostADDActionPerformed

    private void PostSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostSEARCHActionPerformed
        String postid = jTextFieldPostID.getText();  
    try {
    pst = con.prepareStatement("SELECT * FROM position WHERE id = ?");
    pst.setString(1, postid);
    rs = pst.executeQuery();
    if (rs.next()==true) {
        jTextFieldPostName.setText(rs.getString(2));
    } else {
        JOptionPane.showMessageDialog(this, "Position not found", "Error", JOptionPane.ERROR_MESSAGE);
    }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error searching for category", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_PostSEARCHActionPerformed

    private void PostDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostDELETEActionPerformed
        try {
            String postid = jTextFieldPostID.getText();
            pst = con.prepareStatement ("DELETE FROM position WHERE id=?");
            pst.setString (1,postid);
            
            int k =pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully Deleted!");
                jTextFieldPostName.setText("");
                jTextFieldPostName.requestFocus(); 
                FetchPost();
                LoadPost();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to Delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PostDELETEActionPerformed

    private void PostUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostUPDATEActionPerformed
        try {
        String PositionName = jTextFieldPostName.getText();   
        String postid = jTextFieldPostID.getText();      

        if (postid.isEmpty() || PositionName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String query = "UPDATE position SET PositionName = ? WHERE id = ?";
        pst = con.prepareStatement(query);

        pst.setString(1, PositionName);    
        pst.setString(2, postid);     

        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");
            
            jTextFieldPostName.setText("");
            jTextFieldPostName.requestFocus();
            FetchPost();
            LoadPost();        
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Position ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating position: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_PostUPDATEActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton PostADD;
    private javax.swing.JButton PostDELETE;
    private javax.swing.JButton PostSEARCH;
    private javax.swing.JTable PostTable;
    private javax.swing.JButton PostUPDATE;
    private javax.swing.JButton SEARCH;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JButton jButtonSEARCH;
    private javax.swing.JButton jButtonUPDATE;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JComboBox<String> jComboBoxPos;
    private javax.swing.JComboBox<String> jComboBoxSer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableCat;
    private javax.swing.JTable jTableME;
    private javax.swing.JTextField jTextFieldCID;
    private javax.swing.JTextField jTextFieldCName;
    private javax.swing.JTextField jTextFieldEID;
    private javax.swing.JTextField jTextFieldFName;
    private javax.swing.JTextField jTextFieldLName;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldPID;
    private javax.swing.JTextField jTextFieldPName;
    private javax.swing.JTextField jTextFieldPostID;
    private javax.swing.JTextField jTextFieldPostName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}

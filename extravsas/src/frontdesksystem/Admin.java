
package frontdesksystem;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
        try {
        // Ensure the connection is open
        if (con.isClosed()) {
            con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database", "root", "");
        }

        // Query to fetch the updated position names
        String query = "SELECT PositionName FROM position";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Clear existing items in JComboBox
        jComboBoxPos.removeAllItems();

        // Add the updated Position names to JComboBox
        while (rs.next()) {
            String name = rs.getString("PositionName");
            jComboBoxPos.addItem(name);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating the ComboBox: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        feedback = new javax.swing.JTabbedPane();
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
        jLabel24 = new javax.swing.JLabel();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
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
        jLabel21 = new javax.swing.JLabel();
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
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sales = new javax.swing.JTextArea();
        totalsales = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PHP = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        FeedBack = new javax.swing.JTextArea();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        lagout = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        billField = new javax.swing.JTextArea();
        showBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        feedback.setBackground(new java.awt.Color(51, 0, 0));
        feedback.setForeground(new java.awt.Color(255, 255, 255));
        feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedbackMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 0, 0));

        jLabel8.setFont(new java.awt.Font("Perpetua", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MANAGE EMPLOYEES");

        jLabel9.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EmployeeID");

        jLabel10.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("First Name");

        jLabel11.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Position");

        jComboBoxPos.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTextFieldEID.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTextFieldFName.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTableME.setBackground(new java.awt.Color(51, 0, 0));
        jTableME.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTableME.setForeground(new java.awt.Color(255, 255, 255));
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

        ADD.setBackground(new java.awt.Color(102, 0, 0));
        ADD.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 255, 255));
        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        UPDATE.setBackground(new java.awt.Color(102, 0, 0));
        UPDATE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(102, 0, 0));
        DELETE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        SEARCH.setBackground(new java.awt.Color(102, 0, 0));
        SEARCH.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        SEARCH.setForeground(new java.awt.Color(255, 255, 255));
        SEARCH.setText("SEARCH");
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });

        jTextFieldLName.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Last Name");

        jTextFieldNum.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextFieldNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Phone #");

        jLabel18.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Service");

        jComboBoxSer.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jComboBoxSer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spa Services", "Salon Services" }));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/462537887_580053814602662_2758245647023974022_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(44, 138, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(ADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DELETE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SEARCH)
                        .addGap(0, 297, Short.MAX_VALUE)))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(367, 367, 367))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxPos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ADD)
                            .addComponent(UPDATE)
                            .addComponent(DELETE)
                            .addComponent(SEARCH)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        feedback.addTab("EMPLOYEE", jPanel3);

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MANAGE PRODUCTS");

        jLabel2.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ProductID");

        jLabel4.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category");

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        jLabel6.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Price");

        jTextFieldPrice.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPriceActionPerformed(evt);
            }
        });

        jTextFieldPName.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTextFieldQty.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jButtonADD.setBackground(new java.awt.Color(102, 0, 0));
        jButtonADD.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonADD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jButtonUPDATE.setBackground(new java.awt.Color(102, 0, 0));
        jButtonUPDATE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUPDATE.setText("UPDATE");
        jButtonUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUPDATEActionPerformed(evt);
            }
        });

        jButtonDELETE.setBackground(new java.awt.Color(102, 0, 0));
        jButtonDELETE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonDELETE.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(51, 0, 0));
        jTable2.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(51, 0, 0));
        jTable2.setSelectionBackground(new java.awt.Color(51, 0, 0));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jButtonSEARCH.setBackground(new java.awt.Color(102, 0, 0));
        jButtonSEARCH.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSEARCH.setText("SEARCH");
        jButtonSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSEARCHActionPerformed(evt);
            }
        });

        jTextFieldPID.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jComboBoxCat.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/462537887_580053814602662_2758245647023974022_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108)
                .addComponent(jLabel25)
                .addGap(9, 9, 9))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonADD)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUPDATE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDELETE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSEARCH)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPID, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(jTextFieldPrice))
                        .addGap(86, 86, 86))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonADD)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonDELETE)
                                .addComponent(jButtonSEARCH)
                                .addComponent(jButtonUPDATE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel19)
                .addGap(55, 55, 55))
        );

        feedback.addTab("PRODUCTS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 0, 0));

        jLabel12.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CatgoryID");

        jLabel13.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Category Name");

        jTableCat.setBackground(new java.awt.Color(51, 0, 0));
        jTableCat.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTableCat.setForeground(new java.awt.Color(255, 255, 255));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCat.setShowGrid(true);
        jScrollPane4.setViewportView(jTableCat);

        btnADD.setBackground(new java.awt.Color(102, 0, 0));
        btnADD.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnADD.setForeground(new java.awt.Color(255, 255, 255));
        btnADD.setText("ADD");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        btnSEARCH.setBackground(new java.awt.Color(102, 0, 0));
        btnSEARCH.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        btnSEARCH.setText("SEARCH");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });

        btnUPDATE.setBackground(new java.awt.Color(102, 0, 0));
        btnUPDATE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setText("UPDATE");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnDELETE.setBackground(new java.awt.Color(102, 0, 0));
        btnDELETE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setText("DELETE");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        jTextFieldCID.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTextFieldCName.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextFieldCName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCNameActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/462537887_580053814602662_2758245647023974022_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(143, 143, 143))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnADD)
                        .addGap(52, 52, 52)
                        .addComponent(btnUPDATE)
                        .addGap(66, 66, 66)
                        .addComponent(btnDELETE)
                        .addGap(45, 45, 45)
                        .addComponent(btnSEARCH))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel21)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnADD)
                    .addComponent(btnUPDATE)
                    .addComponent(btnDELETE)
                    .addComponent(btnSEARCH))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(22, 22, 22))
        );

        feedback.addTab("MANAGE CATEGORIES", jPanel2);

        jPanel4.setBackground(new java.awt.Color(51, 0, 0));

        jLabel14.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PositionID");

        jLabel15.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Position Name");

        jTextFieldPostName.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        jTextFieldPostID.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        PostADD.setBackground(new java.awt.Color(102, 0, 0));
        PostADD.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PostADD.setForeground(new java.awt.Color(255, 255, 255));
        PostADD.setText("ADD");
        PostADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostADDActionPerformed(evt);
            }
        });

        PostSEARCH.setBackground(new java.awt.Color(102, 0, 0));
        PostSEARCH.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PostSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        PostSEARCH.setText("SEARCH");
        PostSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostSEARCHActionPerformed(evt);
            }
        });

        PostUPDATE.setBackground(new java.awt.Color(102, 0, 0));
        PostUPDATE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PostUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        PostUPDATE.setText("UPDATE");
        PostUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostUPDATEActionPerformed(evt);
            }
        });

        PostDELETE.setBackground(new java.awt.Color(102, 0, 0));
        PostDELETE.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PostDELETE.setForeground(new java.awt.Color(255, 255, 255));
        PostDELETE.setText("DELETE");
        PostDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostDELETEActionPerformed(evt);
            }
        });

        PostTable.setBackground(new java.awt.Color(51, 0, 0));
        PostTable.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PostTable.setForeground(new java.awt.Color(255, 255, 255));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PostTable.setShowGrid(true);
        jScrollPane5.setViewportView(PostTable);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/462537887_580053814602662_2758245647023974022_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPostID, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldPostName, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(PostADD)
                        .addGap(36, 36, 36)
                        .addComponent(PostUPDATE)
                        .addGap(38, 38, 38)
                        .addComponent(PostDELETE)
                        .addGap(33, 33, 33)
                        .addComponent(PostSEARCH)))
                .addGap(0, 46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(387, 387, 387))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPostName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPostID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PostADD)
                    .addComponent(PostUPDATE)
                    .addComponent(PostDELETE)
                    .addComponent(PostSEARCH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        feedback.addTab("MANAGE POSITION", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 0, 0));

        sales.setColumns(20);
        sales.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        sales.setRows(5);
        jScrollPane3.setViewportView(sales);

        totalsales.setBackground(new java.awt.Color(102, 0, 0));
        totalsales.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        totalsales.setForeground(new java.awt.Color(255, 255, 255));
        totalsales.setText("SEE TOTAL SALES");
        totalsales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalsalesMouseClicked(evt);
            }
        });
        totalsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalsalesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total:");

        PHP.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        PHP.setForeground(new java.awt.Color(255, 255, 255));
        PHP.setText("PHP");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/462537887_580053814602662_2758245647023974022_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 125, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(PHP))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(totalsales)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalsales, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PHP))
                .addGap(78, 78, 78))
        );

        feedback.addTab("TOTAL SALES", jPanel5);

        jPanel7.setBackground(new java.awt.Color(51, 0, 0));

        jLabel26.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("All Feedbacks From The Customer");

        FeedBack.setColumns(20);
        FeedBack.setRows(5);
        jScrollPane7.setViewportView(FeedBack);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel26))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        feedback.addTab("FEEDBACK", jPanel7);

        getContentPane().add(feedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 930, 580));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 30, 30));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 30, 30));

        lagout.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lagout.setForeground(new java.awt.Color(255, 255, 255));
        lagout.setText("LOGOUT");
        lagout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lagoutMouseClicked(evt);
            }
        });
        getContentPane().add(lagout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundLandscape2.jpg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1430, 800));

        billField.setColumns(20);
        billField.setRows(5);
        jScrollPane6.setViewportView(billField);

        showBill.setText("SHOW BILL LISTS");
        showBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showBill)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(showBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBillActionPerformed
        // TODO add your handling code here:

        billField.setText("");

        // Variables to accumulate the total expenses
        double productTotal = 0.0;
        double serviceTotal = 0.0;

        // Prepare SQL queries
        String queryShowBill = "SELECT servicename, serviceprice, EmployeeName, Time FROM showbill";
        String queryAvailServices = "SELECT servicename, serviceprice FROM availser";

        try {
            // Execute the query to fetch product purchase data
            pst = con.prepareStatement(queryShowBill);
            rs = pst.executeQuery();

            // Append product purchase data to the Billtextarea and calculate the total
            billField.append("Service information:\n");
            while (rs.next()) {

                String serviceName = rs.getString("servicename");
                double servicePrice = rs.getDouble("serviceprice");
                String employeeName = rs.getString("EmployeeName");
                String time = rs.getString("Time");

                billField.append("\nService Name: " + serviceName + "\n" + "Service Price: " +  servicePrice + "\n" + "Employee Name: " + employeeName + "\n" + "Time: " + time + "\n");
            }

            // Execute the query to fetch available services data

            // Calculate the overall total
            double totalExpenses = productTotal + serviceTotal;

            // Display the total expenses in the PHP JLabel
            PHP.setText("Sales: " + totalExpenses);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving bill data.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_showBillActionPerformed

    private void lagoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lagoutMouseClicked
        Login lgf = new Login();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_lagoutMouseClicked

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

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        try {
        String pid = jTextFieldPID.getText();
        
        // Ask for confirmation before deleting the product
        int confirm = JOptionPane.showConfirmDialog(this, 
                                                   "Are you sure you want to delete this product?", 
                                                   "Confirm Deletion", 
                                                   JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Exit the method if the user selects 'No'
        }

        pst = con.prepareStatement("DELETE FROM product WHERE id=?");
        pst.setString(1, pid);

        int k = pst.executeUpdate();
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");
            jTextFieldPName.setText("");
            jComboBoxCat.setSelectedIndex(-1);
            jTextFieldPrice.setText("");
            jTextFieldQty.setText("");
            jTextFieldPName.requestFocus();
            Fetch();
            LoadProductNo();
        } else {
            JOptionPane.showMessageDialog(this, "Record failed to delete!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error deleting product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonDELETEActionPerformed

    private void jButtonUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUPDATEActionPerformed
        try {
    String pname = jTextFieldPName.getText();
    String category = jComboBoxCat.getSelectedItem().toString();
    BigDecimal price = null;
    
    // Handle price input validation
    try {
        price = new BigDecimal(jTextFieldPrice.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid price input. Please enter a valid decimal value.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int quantity = 0;
    
    // Handle quantity input validation
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

    // Ask for confirmation before updating the product data
    int confirm = JOptionPane.showConfirmDialog(this, 
                                               "Are you sure you want to update this product?", 
                                               "Confirm Update", 
                                               JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Exit the method if the user selects 'No'
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

        // Clear input fields after update
        jTextFieldPName.setText("");
        jComboBoxCat.setSelectedIndex(-1);
        jTextFieldPrice.setText("");
        jTextFieldQty.setText("");
        jTextFieldPName.requestFocus();
        
        // Refresh the product list or product number
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

    private void jTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPriceActionPerformed

    private void totalsalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalsalesMouseClicked
        // Clear any previous data from the Billtextarea
        sales.setText("");

        // Variables to accumulate the total expenses
        double productTotal = 0.0;
        double serviceTotal = 0.0;

        // Prepare SQL queries
        String queryProductPurchase = "SELECT productname, quantity, price, total FROM pp";
        String queryAvailServices = "SELECT servicename, serviceprice FROM availser";

        try {
            // Execute the query to fetch product purchase data
            pst = con.prepareStatement(queryProductPurchase);
            rs = pst.executeQuery();

            // Append product purchase data to the Billtextarea and calculate the total
            sales.append("Products Purchased:\n");
            while (rs.next()) {
                String productName = rs.getString("productname");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double total = rs.getDouble("total");
                productTotal += total;  // Accumulate total for product purchases
                sales.append("Product: " + productName + ", Quantity: " + quantity + ", Price: " + price + ", Total: " + total + "\n");
            }

            // Execute the query to fetch available services data
            pst = con.prepareStatement(queryAvailServices);
            rs = pst.executeQuery();

            // Append available services data to the Billtextarea and calculate the total
            sales.append("\nAvailable Services:\n");
            while (rs.next()) {
                String serviceName = rs.getString("servicename");
                double servicePrice = rs.getDouble("serviceprice");
                serviceTotal += servicePrice;  // Accumulate total for services
                sales.append("Service: " + serviceName + ", Price: " + servicePrice + "\n");
            }

            // Calculate the overall total
            double totalExpenses = productTotal + serviceTotal;

            // Display the total expenses in the PHP JLabel
            PHP.setText("Sales: " + totalExpenses);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving bill data.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_totalsalesMouseClicked

    private void PostDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostDELETEActionPerformed
        try {
        String postid = jTextFieldPostID.getText();

        // Check if the Post ID is empty
        if (postid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Post ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before deleting the position
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this position?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) {
            // If the user clicks "No", exit the method and do nothing
            return;
        }

        // Prepare the SQL delete statement
        pst = con.prepareStatement("DELETE FROM position WHERE id = ?");
        pst.setString(1, postid);

        // Execute the delete query
        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");

            // Clear the input fields
            jTextFieldPostName.setText("");
            jTextFieldPostID.setText("");
            jTextFieldPostName.requestFocus();

            // Fetch and reload the positions into the table
            FetchPost();
            LoadPost();

            // Update the JComboBox to reflect the deletion
            updateCombo();
        } else {
            JOptionPane.showMessageDialog(this, "Record failed to delete. Please check the Post ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error deleting position: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_PostDELETEActionPerformed

    private void PostUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostUPDATEActionPerformed
        try {
        String PositionName = jTextFieldPostName.getText();
        String postid = jTextFieldPostID.getText();

        // Check if either PositionName or PostID is empty
        if (postid.isEmpty() || PositionName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before proceeding with the update
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to update this position?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) {
            // If the user clicks "No", exit the method and do nothing
            return;
        }

        // Prepare the SQL update statement
        String query = "UPDATE position SET PositionName = ? WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, PositionName);
        pst.setString(2, postid);

        // Execute the update
        int k = pst.executeUpdate();

        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");

            // Clear the input fields and reset focus
            jTextFieldPostName.setText("");
            jTextFieldPostID.setText("");
            jTextFieldPostName.requestFocus();

            // Fetch and load the updated data in the table (if needed)
            FetchPost();
            LoadPost();

            // Update the JComboBox with the new data
            updateCombo();

        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Position ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating position: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_PostUPDATEActionPerformed

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

    private void PostADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostADDActionPerformed
        try {
        String PositionName = jTextFieldPostName.getText();

        // Check if the input field is empty
        if (PositionName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before proceeding
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this position?", "Confirm Addition", JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) {
            // If the user clicks "No", exit the method and do nothing
            return;
        }

        // Step 2: Check if the PositionName already exists
        pst = con.prepareStatement("SELECT * FROM position WHERE PositionName = ?");
        pst.setString(1, PositionName);
        ResultSet rsCheck = pst.executeQuery();

        if (rsCheck.next()) {  // If a result is found, the PositionName already exists
            JOptionPane.showMessageDialog(this, "Position Name already exists. Please enter a different name.", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 3: Insert the new position if it does not exist
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
            // Ensure the connection is open and not closed prematurely
            if (con.isClosed()) {
                con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database", "root", "");
            }

            Statement stm = con.createStatement();
            ResultSet rs2 = stm.executeQuery("SELECT PositionName FROM position");

            jComboBoxPos.removeAllItems();  // Clear existing items in JComboBox
            while (rs2.next()) {
                String name = rs2.getString("PositionName");
                jComboBoxPos.addItem(name);  // Add positions to JComboBox
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading positions: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_PostADDActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
    String cid = jTextFieldCID.getText();

    // Ask for confirmation before deleting the category
    int confirm = JOptionPane.showConfirmDialog(this, 
                                               "Are you sure you want to delete this category?", 
                                               "Confirm Deletion", 
                                               JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Exit the method if the user selects 'No'
    }

    pst = con.prepareStatement("DELETE FROM category WHERE id=?");
    pst.setString(1, cid);

    int k = pst.executeUpdate();
    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");
        jTextFieldCName.setText("");
        jTextFieldCName.requestFocus();
        FetchCat();
        LoadCat();
    } else {
        JOptionPane.showMessageDialog(this, "Record failed to delete!");
    }
} catch (SQLException ex) {
    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Error deleting category: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        try {
        String CategoryName = jTextFieldCName.getText();
        String cid = jTextFieldCID.getText();

        if (cid.isEmpty() || CategoryName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ask for confirmation before updating the category
        int confirm = JOptionPane.showConfirmDialog(this, 
                                                   "Are you sure you want to update this category?", 
                                                   "Confirm Update", 
                                                   JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Exit the method if the user selects 'No'
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

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        String CategoryName = jTextFieldCName.getText();

    if (CategoryName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Ask for confirmation before adding the category
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to add this category?", "Confirm Addition", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Exit the method if user selects 'No'
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
        // Retrieve the employee ID from the text field
        String eid = jTextFieldEID.getText();

        // Check if the employee ID is empty
        if (eid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before deleting the employee record
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete this employee's record?", 
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION);

        // If the user clicks "No", exit the method without deleting the record
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Step 2: Prepare the SQL delete query
        pst = con.prepareStatement("DELETE FROM employee WHERE id = ?");
        pst.setString(1, eid);

        // Step 3: Execute the delete query
        int k = pst.executeUpdate();

        // Step 4: Handle the result of the delete operation
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");

            // Clear the input fields
            jTextFieldFName.setText("");
            jTextFieldLName.setText("");
            jTextFieldNum.setText("");
            jComboBoxPos.setSelectedIndex(-1);
            jComboBoxSer.setSelectedIndex(-1);

            // Refresh the data (fetch and load employee information)
            FetchData();
            LoadNo();
        } else {
            JOptionPane.showMessageDialog(this, "Record failed to delete. Please check the Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error deleting employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        try {
        // Retrieve input values from text fields and combo boxes
        String FirstName = jTextFieldFName.getText();
        String LastName = jTextFieldLName.getText();
        String PhoneNumber = jTextFieldNum.getText();
        String Position = jComboBoxPos.getSelectedItem().toString();
        String Services = jComboBoxSer.getSelectedItem().toString();
        String eid = jTextFieldEID.getText();

        // Check if any field is empty
        if (eid.isEmpty() || FirstName.isEmpty() || LastName.isEmpty() || PhoneNumber.isEmpty() || Position.isEmpty() || Services.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before updating the employee data
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to update this employee's data?", 
                "Confirm Update", 
                JOptionPane.YES_NO_OPTION);
        
        // If the user clicks "No", exit the method without updating the employee data
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Step 2: Prepare the SQL update query
        String query = "UPDATE employee SET FirstName = ?, LastName = ?, PhoneNumber = ?, Position = ?, Services=? WHERE id = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, FirstName);
        pst.setString(2, LastName);
        pst.setString(3, PhoneNumber);
        pst.setString(4, Position);
        pst.setString(5, Services);
        pst.setString(6, eid);

        // Step 3: Execute the update query
        int k = pst.executeUpdate();

        // Step 4: Handle the result of the update operation
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");

            // Clear the input fields and reset the combo boxes
            jTextFieldFName.setText("");
            jTextFieldLName.setText("");
            jTextFieldNum.setText("");
            jComboBoxPos.setSelectedIndex(-1);
            jComboBoxSer.setSelectedIndex(-1);

            // Refresh the data (fetch and load employee information)
            FetchData();
            LoadNo();
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please check the Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error updating employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        try {
        String FirstName = jTextFieldFName.getText();
        String LastName = jTextFieldLName.getText();
        String PhoneNumber = jTextFieldNum.getText();
        String Position = jComboBoxPos.getSelectedItem().toString();
        String Services = jComboBoxSer.getSelectedItem().toString();

        // Check if any field is empty
        if (FirstName.isEmpty() || LastName.isEmpty() || PhoneNumber.isEmpty() || Position.isEmpty() || Services.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields. No field should be left empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 1: Ask for confirmation before adding the employee
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to add this employee?", 
                "Confirm Addition", 
                JOptionPane.YES_NO_OPTION);
        
        // If the user clicks "No", exit the method without adding the employee
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Step 2: Prepare the SQL insert statement
        pst = con.prepareStatement("INSERT INTO employee (FirstName, LastName, PhoneNumber, Position, Services) VALUES (?,?,?,?,?)");
        pst.setString(1, FirstName);
        pst.setString(2, LastName);
        pst.setString(3, PhoneNumber);
        pst.setString(4, Position);
        pst.setString(5, Services);

        // Execute the insert query
        int k = pst.executeUpdate();

        // Step 3: Handle the result of the insert operation
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Record Added Successfully!!");

            // Clear the input fields and reset the combo boxes
            jTextFieldFName.setText("");
            jTextFieldLName.setText("");
            jTextFieldNum.setText("");
            jComboBoxPos.setSelectedIndex(-1);
            jComboBoxSer.setSelectedIndex(-1);

            // Refresh the data
            FetchData();
            LoadNo();
        } else {
            JOptionPane.showMessageDialog(this, "Record Failed to Save!!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ADDActionPerformed

    private void totalsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalsalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalsalesActionPerformed

    private void jTextFieldCNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCNameActionPerformed

    private void jTextFieldNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void feedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feedbackMouseClicked
         // SQL query to retrieve all feedback messages from the database
    String query = "SELECT message FROM feedback";
    
    // StringBuilder to collect all feedback messages
    StringBuilder feedbackMessages = new StringBuilder();
    
    try {
        // Prepare the SQL statement
        pst = con.prepareStatement(query);
        
        // Execute the query and get the result
        rs = pst.executeQuery();
        
        // Check if there are any results
        while (rs.next()) {
            // Get each feedback message
            String feedbackMessage = rs.getString("message");
            
            // Append the feedback message to the StringBuilder
            feedbackMessages.append(feedbackMessage).append("\n\n");  // Adding extra space for separation
        }
        
        // Display all feedback messages in the JTextArea named FeedBack
        if (feedbackMessages.length() > 0) {
            FeedBack.setText(feedbackMessages.toString());  // Assuming FeedBack is the JTextArea for displaying feedback
        } else {
            // If there are no feedback messages in the database
            FeedBack.setText("No feedback messages found.");
        }
    } catch (SQLException e) {
        // Handle any SQL exceptions
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_feedbackMouseClicked

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
    private javax.swing.JTextArea FeedBack;
    private javax.swing.JLabel PHP;
    private javax.swing.JButton PostADD;
    private javax.swing.JButton PostDELETE;
    private javax.swing.JButton PostSEARCH;
    private javax.swing.JTable PostTable;
    private javax.swing.JButton PostUPDATE;
    private javax.swing.JButton SEARCH;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextArea billField;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JTabbedPane feedback;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
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
    private javax.swing.JLabel lagout;
    private javax.swing.JTextArea sales;
    private javax.swing.JButton showBill;
    private javax.swing.JButton totalsales;
    // End of variables declaration//GEN-END:variables
}

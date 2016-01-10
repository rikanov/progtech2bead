package Szerviz;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel;

public class tabMunkalap extends javax.swing.JPanel {
    private ResultSet rsMunkalapok;
    private ResultSet rsUgyfel;
    private ResultSet rsDolgozo;
    private ResultSet rsMegnevezes;
    private ResultSet rsTetelek;
    private ResultSet rsAnyMun;
        
    SzervizCommon c;
    SzervizSP cSP = new SzervizSP();
    
    public tabMunkalap() {
        initComponents();
        getData();
        setData();
        setControls();
    }
    
    private void setControls(){
        txtMunkalapID.setEnabled(false);
        txtUjID.setEnabled(false);
        cmbUgyfel.setEnabled(false);
        cmbDolgozo.setEnabled(false);
        txtRendszam.setEnabled(false);
        cmbMegnevezes.setEnabled(false);
        cmdHozzaad.setEnabled(false);
        cmdTorol.setEnabled(false);        
        txtFelvetelDatum.setEnabled(false);  
        cmdMent.setEnabled(false);
        cmdMegsem.setEnabled(false);
        txtFelvetelDatum.setEnabled(false);
    }
    
    private void getData(){
        
        try{
            c = new SzervizCommon("jdbc:derby://localhost:1527/Szerviz", "admin_", "root");
            rsMunkalapok = c.getData(cSP.getMunkalapok());            
            rsUgyfel = c.getData(cSP.getugyfelek());
            rsDolgozo = c.getData(cSP.getDolgozok());
            rsMegnevezes = c.getData(cSP.getMegnevezesek());
            rsAnyMun = c.getData(cSP.getAnyMun());
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabMunkalap.this, err.getMessage());
        }        
    }
    
    private void setData(){
        String sSor;
        
        try{            
            while(rsMunkalapok.next()){
                sSor = rsMunkalapok.getString("NEV") + " - " + rsMunkalapok.getString("RENDSZAM") + " - " + rsMunkalapok.getString("FELVETEL_DATUM");
                cmbMunkalapok.addItem(sSor);
            }
            
            while(rsUgyfel.next()){
                sSor = rsUgyfel.getString("NEV");
                cmbUgyfel.addItem(sSor);
            }
            
            while(rsDolgozo.next()){
                sSor = rsDolgozo.getString("NEV");
                cmbDolgozo.addItem(sSor);
            }
            
            while(rsMegnevezes.next()){
                sSor = rsMegnevezes.getString("CIKKSZAM") + " - " + rsMegnevezes.getString("NEV");
                cmbMegnevezes.addItem(sSor);
            }
            
            //ha még nem volt munkalap...
            if(rsMunkalapok.first()){
                txtUjID.setText(Integer.toString(c.getNextID(rsMunkalapok)));
            }
            else{
                txtUjID.setText("1");
            }
            
            DateFormat dFormat = new SimpleDateFormat("yyyy.MM.dd");

            java.util.Date dFelvDatum = new java.util.Date();
            txtFelvetelDatum.setText(dFormat.format(dFelvDatum)); 
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabMunkalap.this, err.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMunkalapID = new javax.swing.JLabel();
        txtMunkalapID = new javax.swing.JTextField();
        lbMunkalapok = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbUjID = new javax.swing.JLabel();
        txtUjID = new javax.swing.JTextField();
        lbUgyfel = new javax.swing.JLabel();
        cmbUgyfel = new javax.swing.JComboBox();
        lbDolgozo = new javax.swing.JLabel();
        cmbDolgozo = new javax.swing.JComboBox();
        lbRendszam = new javax.swing.JLabel();
        txtRendszam = new javax.swing.JTextField();
        cmbMunkalapok = new javax.swing.JComboBox();
        cmdUj = new javax.swing.JButton();
        lbFelvetelDatum = new javax.swing.JLabel();
        txtFelvetelDatum = new javax.swing.JTextField();
        lbMegnevezes = new javax.swing.JLabel();
        cmbMegnevezes = new javax.swing.JComboBox();
        cmdHozzaad = new javax.swing.JButton();
        cmdTorol = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTetelek = new javax.swing.JTable();
        cmdMent = new javax.swing.JButton();
        cmdKilep = new javax.swing.JButton();
        cmdMegsem = new javax.swing.JButton();

        lbMunkalapID.setText("ID:");

        txtMunkalapID.setEditable(false);

        lbMunkalapok.setText("Munkalapok:");

        lbUjID.setText("Új ID:");

        txtUjID.setEditable(false);

        lbUgyfel.setText("Ügyfél neve:");

        cmbUgyfel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));
        cmbUgyfel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUgyfelActionPerformed(evt);
            }
        });

        lbDolgozo.setText("Munkafelvevő neve:");

        cmbDolgozo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));

        lbRendszam.setText("Rendszám:");

        cmbMunkalapok.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));
        cmbMunkalapok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMunkalapokActionPerformed(evt);
            }
        });

        cmdUj.setText("ÚJ");
        cmdUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUjActionPerformed(evt);
            }
        });

        lbFelvetelDatum.setText("Felvétel dátuma:");

        txtFelvetelDatum.setEditable(false);

        lbMegnevezes.setText("Tétel:");

        cmbMegnevezes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));

        cmdHozzaad.setText("Hozzáad");
        cmdHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHozzaadActionPerformed(evt);
            }
        });

        cmdTorol.setText("Töröl");
        cmdTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTorolActionPerformed(evt);
            }
        });

        tblTetelek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cikkszám", "Név", "Egységár Ft", "anyag_id", "munkalap_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTetelek);
        tblTetelek.getColumnModel().getColumn(4).setMinWidth(0);
        tblTetelek.getColumnModel().getColumn(4).setPreferredWidth(0);
        tblTetelek.getColumnModel().getColumn(4).setMaxWidth(0);
        tblTetelek.getColumnModel().getColumn(5).setMinWidth(0);
        tblTetelek.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblTetelek.getColumnModel().getColumn(5).setMaxWidth(0);

        cmdMent.setText("Ment");
        cmdMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMentActionPerformed(evt);
            }
        });

        cmdKilep.setText("Kilép");
        cmdKilep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKilepActionPerformed(evt);
            }
        });

        cmdMegsem.setText("Mégsem");
        cmdMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(cmdTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(cmdMegsem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMunkalapID)
                        .addGap(23, 23, 23)
                        .addComponent(txtMunkalapID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbMunkalapok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMunkalapok, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdUj, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUjID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUjID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUgyfel)
                            .addComponent(lbRendszam)
                            .addComponent(lbFelvetelDatum)
                            .addComponent(lbDolgozo)
                            .addComponent(lbMegnevezes))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbDolgozo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbUgyfel, 0, 235, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFelvetelDatum, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRendszam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbMegnevezes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(cmdMent, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdKilep, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMunkalapID)
                    .addComponent(txtMunkalapID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMunkalapok)
                    .addComponent(cmbMunkalapok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdUj))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUjID)
                    .addComponent(txtUjID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUgyfel)
                    .addComponent(cmbUgyfel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDolgozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRendszam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRendszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFelvetelDatum)
                    .addComponent(txtFelvetelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMegnevezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMegnevezes))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdHozzaad)
                            .addComponent(cmdTorol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdMent)
                            .addComponent(cmdKilep)))
                    .addComponent(cmdMegsem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUgyfelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUgyfelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUgyfelActionPerformed

    private void cmbMunkalapokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMunkalapokActionPerformed
        txtMunkalapID.setText(Integer.toString(cmbMunkalapok.getSelectedIndex()));
        //TODO: a táblát tölteni kell, ha az ID nem nulla...
        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();
        tblMod.setRowCount(0);
        try{
            if(cmbMunkalapok.getSelectedIndex() !=0){
                rsTetelek = c.getData(cSP.getMunkalap(Integer.parseInt(txtMunkalapID.getText())));

                int iID, iAr, jID, iAnyagID, iMunkalapID;
                String sCikkszam, sNev;

                while(rsTetelek.next()){
                    iID = rsTetelek.getInt("ANYAGM_ID");
                    sCikkszam = rsTetelek.getString("CIKKSZAM");
                    sNev = rsTetelek.getString("NEV");
                    iAr = rsTetelek.getInt("EGYSEGAR");
                    tblMod.addRow(new Object[]{iID, sCikkszam, sNev, iAr});
                }
            }
            else{
                //TODO: a tábla tartalmát törölni kell, ha van mit...

            }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_cmbMunkalapokActionPerformed

    private void cmdUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUjActionPerformed
        
        //
        try{
            rsUgyfel = c.getData(cSP.getugyfelek());
            String sSor;
            cmbUgyfel.removeAllItems();
            cmbUgyfel.addItem("[nincs]");
            while(rsUgyfel.next()){
                sSor = rsUgyfel.getString("NEV");
                cmbUgyfel.addItem(sSor);
            }
            
            cmbDolgozo.removeAllItems();
            cmbDolgozo.addItem("[nincs]");
            rsDolgozo = c.getData(cSP.getDolgozok());            
            while(rsDolgozo.next()){
                sSor = rsDolgozo.getString("NEV");
                cmbDolgozo.addItem(sSor);
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabMunkalap.this, err.getMessage());
        }
        
        //
        cmbUgyfel.setEnabled(true);
        cmbDolgozo.setEnabled(true);
        txtRendszam.setEnabled(true);
        cmbMegnevezes.setEnabled(true);
        cmdHozzaad.setEnabled(true);
        //TODO: ha már van a táblában akkor
        cmdTorol.setEnabled(true);
        //egyébként
        cmdTorol.setEnabled(false);

        //txtFelvetelDatum.setEnabled(true);
        cmdMegsem.setEnabled(true);

        cmdUj.setEnabled(false);
        cmbMunkalapok.setEnabled(false);

        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();
        tblMod.setRowCount(0);        
    }//GEN-LAST:event_cmdUjActionPerformed

    private void cmdHozzaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHozzaadActionPerformed
        cmdMent.setEnabled(true);
        cmdTorol.setEnabled(true);

        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();
        //tblMod.setRowCount(0);
        int iID = 0, iAr = 0, iAnyagID = 0, iMunkalapID = 0;
        String sCikkszam, sNev;

        int iSelectedID = cmbMegnevezes.getSelectedIndex();
        if(iSelectedID > 0){
            try{
                rsMegnevezes.first();
                while(rsMegnevezes.getInt(1) != iSelectedID){
                    rsMegnevezes.next();
                }

                iID = rsMegnevezes.getInt("ANYAG_ID");
                sCikkszam = rsMegnevezes.getString("CIKKSZAM");
                sNev = rsMegnevezes.getString("NEV");
                iAr = rsMegnevezes.getInt("EGYSEGAR");
                iAnyagID = rsMegnevezes.getInt("ANYAG_ID");
                iMunkalapID = Integer.parseInt(txtUjID.getText());

                //TODO: Ellenőrző feltétel, minden mező ki van-e töltve
                if(cmbMegnevezes.getSelectedIndex() != 0){
                    tblMod.addRow(new Object[]{iID, sCikkszam, sNev, iAr, iAnyagID, iMunkalapID});
                }
                else{
                    JOptionPane.showMessageDialog(tabMunkalap.this, "Nincs kiválasztva tétel!");
                }
            }
            catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(tabMunkalap.this, "Nincs kiválasztva tétel!");
            cmdMent.setEnabled(false);
        }
    }//GEN-LAST:event_cmdHozzaadActionPerformed

    private void cmdTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTorolActionPerformed
        //TODO: Ellenőrző feltétel, van-e a táblában vmi
        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();
        int iSelectedRow = tblTetelek.getSelectedRow();
        if(tblMod.getRowCount() > 0){
            tblMod.removeRow(iSelectedRow);
        }
        else{
            JOptionPane.showMessageDialog(tabMunkalap.this, "Üres táblából nem lehet törölni!");
        }
    }//GEN-LAST:event_cmdTorolActionPerformed

    private void cmdMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMentActionPerformed
        //TODO: adatellenőrzés, hogy minden ki van-e töltve
        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();

        int iVevoID = cmbUgyfel.getSelectedIndex();
        int iDolgozoID = cmbDolgozo.getSelectedIndex();
        String sRendszam = txtRendszam.getText();
        int iRowCount = tblMod.getRowCount();
        
        if(iVevoID > 0 && iDolgozoID > 0 && !"".equals(sRendszam) && iRowCount > 0){

            //TODO: mindkét táblába batch-el kell kiírni az adatokat...
            //munkalap kiírása
            int iID = Integer.parseInt(txtUjID.getText());
            //int iVevoID = cmbUgyfel.getSelectedIndex();
            //String sRendszam = txtRendszam.getText();
            //int iDolgozoID = cmbDolgozo.getSelectedIndex();
            String sFelvDatum = txtFelvetelDatum.getText();

            //*****
            try{
                Connection conn;
                Statement stmt;
                ResultSet rsSetMunkalap;
                
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Szerviz", "admin_", "root"); 
                stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
                rsSetMunkalap = stmt.executeQuery("SELECT * FROM MUNKALAP WHERE MUNKALAP_ID = -1");
                
                rsSetMunkalap.moveToInsertRow();
                
                rsSetMunkalap.updateInt("MUNKALAP_ID",iID);
                rsSetMunkalap.updateInt("VEVO_ID",iVevoID);
                rsSetMunkalap.updateString("RENDSZAM",sRendszam);
                rsSetMunkalap.updateInt("DOLGOZO_ID",iDolgozoID);
                rsSetMunkalap.updateString("FELVETEL_DATUM",sFelvDatum);

                rsSetMunkalap.insertRow();
                
                stmt.close();
                conn.close();
                
                //tábla kiírása
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Szerviz", "admin_", "root"); 
                PreparedStatement pstmt;
                int iRow = tblTetelek.getRowCount();
                pstmt = null;
                pstmt = conn.prepareStatement(cSP.getInsertTetelek());

                for (int i = 0 ; i < iRow ; i++){
                    pstmt.setInt(1, i + 1);
                    pstmt.setInt(2, (int) tblTetelek.getValueAt(i,4));
                    pstmt.setInt(3, (int) tblTetelek.getValueAt(i,5));

                    pstmt.addBatch();
                }


                int[] countT = pstmt.executeBatch();
                conn.commit();
                pstmt.close();
                conn.close();                                
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(tabMunkalap.this, err.getMessage());
            }
            //*****
            
            //c.insertMunkaTable(cSP.getInsertMunkalap(), iID, iVevoID, sRendszam, iDolgozoID, sFelvDatum,
            //    tblTetelek,cSP.getInsertTetelek());

            // meghívom a mégsemet...
            cmbUgyfel.setEnabled(false);
            cmbDolgozo.setEnabled(false);
            txtRendszam.setEnabled(false);
            cmbMegnevezes.setEnabled(false);
            cmdHozzaad.setEnabled(false);
            cmdTorol.setEnabled(false);
            txtFelvetelDatum.setEnabled(false);
            cmdMent.setEnabled(false);

            cmdUj.setEnabled(true);
            cmbMunkalapok.setEnabled(true);
            String sSor;
            sSor = cmbUgyfel.getSelectedItem() + " - " + sRendszam + " - " + sFelvDatum;
            cmbMunkalapok.addItem(sSor);
            tblMod.setRowCount(0);
            iID++;
            txtUjID.setText(Integer.toString(iID));
            JOptionPane.showMessageDialog(tabMunkalap.this, "Az adatmentés sikerült!");
        }
        else{
            JOptionPane.showMessageDialog(tabMunkalap.this, "Minden mezőt ki kell tölteni!");
        }
    }//GEN-LAST:event_cmdMentActionPerformed

    private void cmdKilepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKilepActionPerformed
        c.closeConn();
    }//GEN-LAST:event_cmdKilepActionPerformed

    private void cmdMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMegsemActionPerformed
        cmbUgyfel.setEnabled(false);
        cmbDolgozo.setEnabled(false);
        txtRendszam.setEnabled(false);
        cmbMegnevezes.setEnabled(false);
        cmdHozzaad.setEnabled(false);
        cmdTorol.setEnabled(false);
        txtFelvetelDatum.setEnabled(false);
        cmdMent.setEnabled(false);

        cmdUj.setEnabled(true);
        cmbMunkalapok.setEnabled(true);

        //TODO: Ellenőrző feltétel, hogy üres-e a tábla, szóljon, hogy elvesznek az adatok...
        DefaultTableModel tblMod = (DefaultTableModel) tblTetelek.getModel();
        tblMod.setRowCount(0);

    }//GEN-LAST:event_cmdMegsemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDolgozo;
    private javax.swing.JComboBox cmbMegnevezes;
    private javax.swing.JComboBox cmbMunkalapok;
    private javax.swing.JComboBox cmbUgyfel;
    private javax.swing.JButton cmdHozzaad;
    private javax.swing.JButton cmdKilep;
    private javax.swing.JButton cmdMegsem;
    private javax.swing.JButton cmdMent;
    private javax.swing.JButton cmdTorol;
    private javax.swing.JButton cmdUj;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDolgozo;
    private javax.swing.JLabel lbFelvetelDatum;
    private javax.swing.JLabel lbMegnevezes;
    private javax.swing.JLabel lbMunkalapID;
    private javax.swing.JLabel lbMunkalapok;
    private javax.swing.JLabel lbRendszam;
    private javax.swing.JLabel lbUgyfel;
    private javax.swing.JLabel lbUjID;
    private javax.swing.JTable tblTetelek;
    private javax.swing.JTextField txtFelvetelDatum;
    private javax.swing.JTextField txtMunkalapID;
    private javax.swing.JTextField txtRendszam;
    private javax.swing.JTextField txtUjID;
    // End of variables declaration//GEN-END:variables
}

package Szerviz;

    import java.sql.Statement;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;

public class tabDolgozo extends javax.swing.JPanel {
    Connection con;
    Statement stmt;
    ResultSet rsDolgozo;
    String sql = "SELECT * FROM DOLGOZO";
    String sqlGetDolgozok = "SELECT * FROM DOLGOZO WHERE DOLGOZO.DOLGOZO_ID=";
    String host = "jdbc:derby://localhost:1527/Szerviz";
    String uName = "admin_";
    String uPwd = "root";
    
    public tabDolgozo() {
        initComponents();
        DoConnect(true);
        setControls();
    }

    public void DoConnect(boolean init){
        try{  
            con = DriverManager.getConnection(host, uName, uPwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rsDolgozo = stmt.executeQuery(sql);
            
            if(init){
                while(rsDolgozo.next()){
                    cmbDolgozok.addItem(rsDolgozo.getString("NEV"));
                }
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabDolgozo.this, err.getMessage());
        }
    }    
    
    //kiírás után ürítem a mezők tartalmát
    private void setControls(){
        txtDolgozoNeve.setText("");
        txtVaros.setText("");
        txtIrsz.setText("");
        txtUtca.setText("");
        txtTel.setText("");
        txtOradij.setText("");
        
        cmdDolgozoModosit.setEnabled(false); 
        
        lbNevlHiba.setText("");
        lbVarosHiba.setText("");
        lbIrszHiba.setText("");
        lbUtcaHiba.setText("");
        lbTelHiba.setText("");
        lbOradijHiba.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDolgozo = new javax.swing.JPanel();
        lbVarosHiba = new javax.swing.JLabel();
        lbNevlHiba = new javax.swing.JLabel();
        lbUtcaHiba = new javax.swing.JLabel();
        lbIrszHiba = new javax.swing.JLabel();
        cmbDolgozok = new javax.swing.JComboBox();
        cmdDolgozoModosit = new javax.swing.JButton();
        cmdDolgozoMegse = new javax.swing.JButton();
        lbDolgozok = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        cmdDolgozoMent = new javax.swing.JButton();
        txtUtca = new javax.swing.JTextField();
        lbTel = new javax.swing.JLabel();
        lbDolgozoNeve = new javax.swing.JLabel();
        lbUtca = new javax.swing.JLabel();
        txtVaros = new javax.swing.JTextField();
        lbVaros = new javax.swing.JLabel();
        lbCime = new javax.swing.JLabel();
        txtDolgozoNeve = new javax.swing.JTextField();
        lbTelHiba = new javax.swing.JLabel();
        txtIrsz = new javax.swing.JTextField();
        lbIrsz = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtOradij = new javax.swing.JTextField();
        lbFt = new javax.swing.JLabel();
        lbOradijHiba = new javax.swing.JLabel();

        lbVarosHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbNevlHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbUtcaHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbIrszHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        cmbDolgozok.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));
        cmbDolgozok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDolgozokActionPerformed(evt);
            }
        });

        cmdDolgozoModosit.setText("Módosít");
        cmdDolgozoModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDolgozoModositActionPerformed(evt);
            }
        });

        cmdDolgozoMegse.setText("Mégsem");
        cmdDolgozoMegse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDolgozoMegseActionPerformed(evt);
            }
        });

        lbDolgozok.setText("Dolgozók:");

        cmdDolgozoMent.setText("Ment");
        cmdDolgozoMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDolgozoMentActionPerformed(evt);
            }
        });

        lbTel.setText("Telefon:");

        lbDolgozoNeve.setText("Dolgozó neve:");

        lbUtca.setText("Utca:");

        lbVaros.setText("Város:");

        lbCime.setText("Címe");

        lbTelHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbIrsz.setText("Irsz:");

        jLabel1.setText("Óradíja:");

        lbFt.setText("Ft");

        lbOradijHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        javax.swing.GroupLayout panelDolgozoLayout = new javax.swing.GroupLayout(panelDolgozo);
        panelDolgozo.setLayout(panelDolgozoLayout);
        panelDolgozoLayout.setHorizontalGroup(
            panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDolgozoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCime)
                    .addGroup(panelDolgozoLayout.createSequentialGroup()
                        .addComponent(cmdDolgozoMent, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(cmdDolgozoModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDolgozoLayout.createSequentialGroup()
                        .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDolgozoNeve)
                            .addComponent(lbVaros)
                            .addComponent(lbIrsz)
                            .addComponent(lbUtca)
                            .addComponent(lbTel)
                            .addComponent(lbDolgozok))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDolgozok, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDolgozoLayout.createSequentialGroup()
                                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDolgozoNeve, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtVaros)
                                    .addComponent(txtIrsz))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbVarosHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrszHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDolgozoLayout.createSequentialGroup()
                                        .addComponent(lbNevlHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOradij, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbFt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbOradijHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelDolgozoLayout.createSequentialGroup()
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTelHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDolgozoLayout.createSequentialGroup()
                                .addComponent(txtUtca, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdDolgozoMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbUtcaHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelDolgozoLayout.setVerticalGroup(
            panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDolgozoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDolgozok)
                    .addComponent(cmbDolgozok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbNevlHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDolgozoLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(lbFt))
                        .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDolgozoNeve)
                            .addComponent(txtDolgozoNeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtOradij, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbOradijHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbVaros)
                        .addComponent(txtVaros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbVarosHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDolgozoLayout.createSequentialGroup()
                        .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIrsz)
                            .addComponent(txtIrsz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbUtca, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUtca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbUtcaHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbIrszHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdDolgozoModosit)
                    .addGroup(panelDolgozoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdDolgozoMent)
                        .addComponent(cmdDolgozoMegse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDolgozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDolgozokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDolgozokActionPerformed
        if(cmbDolgozok.getSelectedIndex() != 0){
            cmdDolgozoMent.setEnabled(false);
            cmdDolgozoModosit.setEnabled(true);
            
            try{
                int iID = cmbDolgozok.getSelectedIndex();
                ResultSet rsDolgozok = stmt.executeQuery(sqlGetDolgozok + Integer.toString(iID));
                rsDolgozok.next();
                
                txtDolgozoNeve.setText(rsDolgozok.getString("NEV"));
                txtVaros.setText(rsDolgozok.getString("VAROS"));
                txtIrsz.setText(rsDolgozok.getString("IRSZ"));
                txtUtca.setText(rsDolgozok.getString("UTCA"));
                txtTel.setText(rsDolgozok.getString("TEL"));
                txtOradij.setText(Integer.toString(rsDolgozok.getInt("ORADIJ")));
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(tabDolgozo.this, err.getMessage());
            }
        }
        else{
            cmdDolgozoMent.setEnabled(true);
            setControls();
        }
    }//GEN-LAST:event_cmbDolgozokActionPerformed

    private void cmdDolgozoModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDolgozoModositActionPerformed
        int iID = cmbDolgozok.getSelectedIndex();
        String sNev = txtDolgozoNeve.getText();
        String sVaros = txtVaros.getText();
        String sIrsz = txtIrsz.getText();
        String sUtca = txtUtca.getText();
        String sTel = txtTel.getText();
        String sOradij = txtOradij.getText();

        cmdDolgozoModosit.setEnabled(true);
        ResultSet rsUpdateDolgozo;

        try{
            rsUpdateDolgozo = stmt.executeQuery("SELECT * FROM DOLGOZO WHERE DOLGOZO.DOLGOZO_ID="+Integer.toString(iID));
            rsUpdateDolgozo.next();

            rsUpdateDolgozo.updateInt("DOLGOZO_ID", iID);
            rsUpdateDolgozo.updateString("NEV", sNev);
            rsUpdateDolgozo.updateString("VAROS", sVaros);
            rsUpdateDolgozo.updateString("IRSZ", sIrsz);
            rsUpdateDolgozo.updateString("UTCA", sUtca);
            rsUpdateDolgozo.updateString("TEL", sTel);
            rsUpdateDolgozo.updateInt("ORADIJ", Integer.parseInt(sOradij));
            
            rsUpdateDolgozo.updateRow();

            rsUpdateDolgozo.close();
            cmbDolgozok.setSelectedIndex(0);
            setControls();
            JOptionPane.showMessageDialog(tabDolgozo.this, "A frissítés sikerült!");
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabDolgozo.this, err.getMessage());
        }
    }//GEN-LAST:event_cmdDolgozoModositActionPerformed

    private void cmdDolgozoMegseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDolgozoMegseActionPerformed
        cmbDolgozok.setSelectedIndex(0);
        cmdDolgozoMent.setEnabled(true);
        setControls();
    }//GEN-LAST:event_cmdDolgozoMegseActionPerformed

    private void cmdDolgozoMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDolgozoMentActionPerformed
        //TODO: minden mező kitöltve ellenőrzés!
        boolean bolValid = true;

        lbNevlHiba.setText("");
        lbVarosHiba.setText("");
        lbIrszHiba.setText("");
        lbUtcaHiba.setText("");
        lbTelHiba.setText("");
        lbOradijHiba.setText("");

        if("".equals(txtDolgozoNeve.getText())){
            bolValid = false;
            lbNevlHiba.setText("*");
        }
        if("".equals(txtVaros.getText())){
            bolValid = false;
            lbVarosHiba.setText("*");
        }
        if("".equals(txtIrsz.getText())){
            bolValid = false;
            lbIrszHiba.setText("*");
        }
        if("".equals(txtUtca.getText())){
            bolValid = false;
            lbUtcaHiba.setText("*");
        }
        if("".equals(txtTel.getText())){
            bolValid = false;
            lbTelHiba.setText("*");
        }
        if("".equals(txtOradij.getText())){
            bolValid = false;
            lbOradijHiba.setText("*");
        }
        if(bolValid){
            try{
                int iNextRow = 0;
                rsDolgozo.last();
                iNextRow = rsDolgozo.getRow();
                iNextRow++;

                String sNev = txtDolgozoNeve.getText();
                String sVaros = txtVaros.getText();
                String sIrsz = txtIrsz.getText();
                String sUtca = txtUtca.getText();
                String sTel = txtTel.getText();
                int iOradij = Integer.parseInt(txtOradij.getText());
                
                rsDolgozo.moveToInsertRow();

                rsDolgozo.updateInt("DOLGOZO_ID",iNextRow);
                rsDolgozo.updateString("NEV",sNev);
                rsDolgozo.updateString("VAROS",sVaros);
                rsDolgozo.updateString("IRSZ",sIrsz);
                rsDolgozo.updateString("UTCA",sUtca);
                rsDolgozo.updateString("TEL",sTel);
                rsDolgozo.updateInt("ORADIJ",iOradij);

                rsDolgozo.insertRow();

                stmt.close();
                con.close();

                cmbDolgozok.addItem(sNev);
                cmbDolgozok.setSelectedIndex(0);

                DoConnect(false);
                setControls();
                JOptionPane.showMessageDialog(tabDolgozo.this, "A mentés sikerült!");
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(tabDolgozo.this, err.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(tabDolgozo.this, "Minden mezőt ki kell tölteni!");
        }
    }//GEN-LAST:event_cmdDolgozoMentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDolgozok;
    private javax.swing.JButton cmdDolgozoMegse;
    private javax.swing.JButton cmdDolgozoMent;
    private javax.swing.JButton cmdDolgozoModosit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCime;
    private javax.swing.JLabel lbDolgozoNeve;
    private javax.swing.JLabel lbDolgozok;
    private javax.swing.JLabel lbFt;
    private javax.swing.JLabel lbIrsz;
    private javax.swing.JLabel lbIrszHiba;
    private javax.swing.JLabel lbNevlHiba;
    private javax.swing.JLabel lbOradijHiba;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbTelHiba;
    private javax.swing.JLabel lbUtca;
    private javax.swing.JLabel lbUtcaHiba;
    private javax.swing.JLabel lbVaros;
    private javax.swing.JLabel lbVarosHiba;
    private javax.swing.JPanel panelDolgozo;
    private javax.swing.JTextField txtDolgozoNeve;
    private javax.swing.JTextField txtIrsz;
    private javax.swing.JTextField txtOradij;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUtca;
    private javax.swing.JTextField txtVaros;
    // End of variables declaration//GEN-END:variables
}

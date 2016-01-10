/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Szerviz;

    import java.sql.Statement;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
/**
 *
 * @author Gyenes Balázs (bgyenes), Ikanov Róbert (rikanov)
 */
public class tabUgyfel extends javax.swing.JPanel {
    Connection con;
    Statement stmt;
    ResultSet rsUgyfel;
    String sql = "SELECT * FROM UGYFEL";
    String sqlGetUgyfel = "SELECT * FROM UGYFEL WHERE UGYFEL.UGYFEL_ID=";
    String host = "jdbc:derby://localhost:1527/Szerviz";
    String uName = "admin_";
    String uPwd = "root";
    /**
     * Creates new form tabUgyfel
     */
    public tabUgyfel() {
        initComponents();
        DoConnect(true);
        setControls();
    }

    public void DoConnect(boolean init){
        try{  
            con = DriverManager.getConnection(host, uName, uPwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rsUgyfel = stmt.executeQuery(sql);
            
            if(init){
                while(rsUgyfel.next()){
                    cmbUgyfelek.addItem(rsUgyfel.getString("NEV"));
                }
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabUgyfel.this, err.getMessage());
        }
    }
    
    
    //kiírás után ürítem a mezők tartalmát
    private void setControls(){
        txtUgyfelNeve.setText("");
        txtVaros.setText("");
        txtIrsz.setText("");
        txtUtca.setText("");
        txtTel.setText("");
        cmdUgyfelModosit.setEnabled(false); 
        lbNevlHiba.setText("");
        lbVarosHiba.setText("");
        lbIrszHiba.setText("");
        lbUtcaHiba.setText("");
        lbTelHiba.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbVarosHiba = new javax.swing.JLabel();
        lbNevlHiba = new javax.swing.JLabel();
        lbUtcaHiba = new javax.swing.JLabel();
        lbIrszHiba = new javax.swing.JLabel();
        cmbUgyfelek = new javax.swing.JComboBox();
        cmdUgyfelModosit = new javax.swing.JButton();
        cmdUgyfelMegse = new javax.swing.JButton();
        lbUgyfelek = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        cmdUgyfelMent = new javax.swing.JButton();
        txtUtca = new javax.swing.JTextField();
        lbTel = new javax.swing.JLabel();
        lbUgyfelNeve = new javax.swing.JLabel();
        lbUtca = new javax.swing.JLabel();
        txtVaros = new javax.swing.JTextField();
        lbVaros = new javax.swing.JLabel();
        lbCime = new javax.swing.JLabel();
        txtUgyfelNeve = new javax.swing.JTextField();
        lbTelHiba = new javax.swing.JLabel();
        txtIrsz = new javax.swing.JTextField();
        lbIrsz = new javax.swing.JLabel();

        lbVarosHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbNevlHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbUtcaHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbIrszHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        cmbUgyfelek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[nincs]" }));
        cmbUgyfelek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUgyfelekActionPerformed(evt);
            }
        });

        cmdUgyfelModosit.setText("Módosít");
        cmdUgyfelModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUgyfelModositActionPerformed(evt);
            }
        });

        cmdUgyfelMegse.setText("Mégsem");
        cmdUgyfelMegse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUgyfelMegseActionPerformed(evt);
            }
        });

        lbUgyfelek.setText("Ügyfelek:");

        cmdUgyfelMent.setText("Ment");
        cmdUgyfelMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUgyfelMentActionPerformed(evt);
            }
        });

        lbTel.setText("Telefon:");

        lbUgyfelNeve.setText("Ügyfél neve:");

        lbUtca.setText("Utca:");

        lbVaros.setText("Város:");

        lbCime.setText("Címe");

        lbTelHiba.setForeground(javax.swing.UIManager.getDefaults().getColor("Hyperlink.activeColor"));

        lbIrsz.setText("Irsz:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCime)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdUgyfelMent, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(cmdUgyfelModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUgyfelNeve)
                            .addComponent(lbVaros)
                            .addComponent(lbIrsz)
                            .addComponent(lbUtca)
                            .addComponent(lbTel)
                            .addComponent(lbUgyfelek))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUgyfelek, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUgyfelNeve, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtVaros)
                                    .addComponent(txtIrsz))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNevlHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbVarosHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrszHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTelHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUtca, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdUgyfelMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbUtcaHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUgyfelek)
                    .addComponent(cmbUgyfelek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUgyfelNeve)
                    .addComponent(txtUgyfelNeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNevlHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbVaros)
                        .addComponent(txtVaros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbVarosHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIrsz)
                            .addComponent(txtIrsz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbUtca, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUtca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbUtcaHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbIrszHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelHiba, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdUgyfelModosit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdUgyfelMent)
                        .addComponent(cmdUgyfelMegse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void cmbUgyfelekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUgyfelekActionPerformed
        if(cmbUgyfelek.getSelectedIndex() != 0){
            cmdUgyfelMent.setEnabled(false);
            cmdUgyfelModosit.setEnabled(true);
            try{
                int iID = cmbUgyfelek.getSelectedIndex();
                ResultSet rsUgyfelek = stmt.executeQuery(sqlGetUgyfel+Integer.toString(iID));
                rsUgyfelek.next();
                txtUgyfelNeve.setText(rsUgyfelek.getString("NEV"));
                txtVaros.setText(rsUgyfelek.getString("VAROS"));
                txtIrsz.setText(rsUgyfelek.getString("IRSZ"));
                txtUtca.setText(rsUgyfelek.getString("UTCA"));
                txtTel.setText(rsUgyfelek.getString("TEL"));
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(tabUgyfel.this, err.getMessage());
            }
        }
        else{
            cmdUgyfelMent.setEnabled(true);
            setControls();
        }
    }//GEN-LAST:event_cmbUgyfelekActionPerformed

    private void cmdUgyfelModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUgyfelModositActionPerformed
        int iID = cmbUgyfelek.getSelectedIndex();
        String sNev = txtUgyfelNeve.getText();
        String sVaros = txtVaros.getText();
        String sIrsz = txtIrsz.getText();
        String sUtca = txtUtca.getText();
        String sTel = txtTel.getText();

        cmdUgyfelModosit.setEnabled(true);
        ResultSet rsUpdateUgyfel;

        try{
            rsUpdateUgyfel = stmt.executeQuery("SELECT * FROM UGYFEL WHERE UGYFEL.UGYFEL_ID="+Integer.toString(iID));
            rsUpdateUgyfel.next();

            rsUpdateUgyfel.updateInt("UGYFEL_ID", iID);
            rsUpdateUgyfel.updateString("NEV", sNev);
            rsUpdateUgyfel.updateString("VAROS", sVaros);
            rsUpdateUgyfel.updateString("IRSZ", sIrsz);
            rsUpdateUgyfel.updateString("UTCA", sUtca);
            rsUpdateUgyfel.updateString("TEL", sTel);

            rsUpdateUgyfel.updateRow();

            rsUpdateUgyfel.close();
            cmbUgyfelek.setSelectedIndex(0);
            setControls();
            JOptionPane.showMessageDialog(tabUgyfel.this, "A frissítés sikerült!");
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(tabUgyfel.this, err.getMessage());
        }

    }//GEN-LAST:event_cmdUgyfelModositActionPerformed

    private void cmdUgyfelMegseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUgyfelMegseActionPerformed
        cmbUgyfelek.setSelectedIndex(0);
        cmdUgyfelMent.setEnabled(true);
        setControls();
    }//GEN-LAST:event_cmdUgyfelMegseActionPerformed

    private void cmdUgyfelMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUgyfelMentActionPerformed
        //TODO: minden mező kitöltve ellenőrzés!
        boolean bolValid = true;

        lbNevlHiba.setText("");
        lbVarosHiba.setText("");
        lbIrszHiba.setText("");
        lbUtcaHiba.setText("");
        lbTelHiba.setText("");

        if("".equals(txtUgyfelNeve.getText())){
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

        if(bolValid){
            try{
                int iNextRow = 0;
                rsUgyfel.last();
                iNextRow = rsUgyfel.getRow();
                iNextRow++;

                String sNev = txtUgyfelNeve.getText();
                String sVaros = txtVaros.getText();
                String sIrsz = txtIrsz.getText();
                String sUtca = txtUtca.getText();
                String sTel = txtTel.getText();

                rsUgyfel.moveToInsertRow();

                rsUgyfel.updateInt("UGYFEL_ID",iNextRow);
                rsUgyfel.updateString("NEV",sNev);
                rsUgyfel.updateString("VAROS",sVaros);
                rsUgyfel.updateString("IRSZ",sIrsz);
                rsUgyfel.updateString("UTCA",sUtca);
                rsUgyfel.updateString("TEL",sTel);

                rsUgyfel.insertRow();

                stmt.close();
                con.close();

                cmbUgyfelek.addItem(sNev);
                cmbUgyfelek.setSelectedIndex(0);

                DoConnect(false);
                setControls();
                JOptionPane.showMessageDialog(tabUgyfel.this, "A mentés sikerült!");
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(tabUgyfel.this, err.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(tabUgyfel.this, "Minden mezőt ki kell tölteni!");
        }
    }//GEN-LAST:event_cmdUgyfelMentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbUgyfelek;
    private javax.swing.JButton cmdUgyfelMegse;
    private javax.swing.JButton cmdUgyfelMent;
    private javax.swing.JButton cmdUgyfelModosit;
    private javax.swing.JLabel lbCime;
    private javax.swing.JLabel lbIrsz;
    private javax.swing.JLabel lbIrszHiba;
    private javax.swing.JLabel lbNevlHiba;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbTelHiba;
    private javax.swing.JLabel lbUgyfelNeve;
    private javax.swing.JLabel lbUgyfelek;
    private javax.swing.JLabel lbUtca;
    private javax.swing.JLabel lbUtcaHiba;
    private javax.swing.JLabel lbVaros;
    private javax.swing.JLabel lbVarosHiba;
    private javax.swing.JTextField txtIrsz;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUgyfelNeve;
    private javax.swing.JTextField txtUtca;
    private javax.swing.JTextField txtVaros;
    // End of variables declaration//GEN-END:variables
}

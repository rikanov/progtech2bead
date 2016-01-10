package Szerviz;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.PreparedStatement;
    import javax.swing.JTable;

public class SzervizCommon {
    
    String sHost;
    String sName;
    String sPwd;
    Connection con;
    Statement stmt;
        
    public SzervizCommon(String host, String name, String pwd) throws SQLException {
        sHost = host;
        sName = name;
        sPwd = pwd;
       
        con = DriverManager.getConnection(sHost, sName, sPwd);
    }
    
    public SzervizCommon() throws SQLException{
        
    }
    
    public ResultSet getData(String query) throws SQLException{
        ResultSet rsQuery;
        stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
        /*ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_UPDATABLE,
                                    ResultSet.CLOSE_CURSORS_AT_COMMIT*/
        rsQuery = stmt.executeQuery(query);
        return rsQuery;        
    }
    
    public int getNextID(ResultSet rs) throws SQLException{
        int iAktID = 0;
        
        rs.last();
        iAktID = rs.getInt(1);
        return ++iAktID;        
    }
    
    public void insertMunkaTable(String sqlM, int ID, int vevo_id, 
            String rendszam, int dolgozo_id, String felvetel_datum, JTable table, String sqlT){
        
        try{     
            con.setAutoCommit(false);
            
            PreparedStatement pstmt;
            
            pstmt = con.prepareStatement(sqlM);
            
            pstmt.setInt(1, ID);
            pstmt.setInt(2, vevo_id);
            pstmt.setString(3, rendszam);
            pstmt.setInt(4, dolgozo_id);
            pstmt.setString(5, felvetel_datum);
            
            pstmt.addBatch();
           
            //táblából az adatok berakása a batch-be            
            int iRow = table.getRowCount();
            
            int[] count = pstmt.executeBatch();
            con.commit();
            
            pstmt = null;
            pstmt = con.prepareStatement(sqlT);
            
            for (int i = 0 ; i < iRow ; i++){
                pstmt.setInt(1, i + 1);
                pstmt.setInt(2, (int) table.getValueAt(i,4));
                pstmt.setInt(3, (int) table.getValueAt(i,5));

                pstmt.addBatch();
            }
                  
            
            int[] countT = pstmt.executeBatch();
            con.commit();
                    
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    public void closeConn(){
        try{  
            //con.commit();  
            stmt.close();
            con.close();
            
            //con = DriverManager.getConnection(sHost, sName, sPwd);
            //stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            //                        ResultSet.CONCUR_UPDATABLE,
            //                        ResultSet.CLOSE_CURSORS_AT_COMMIT); 
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }   
}

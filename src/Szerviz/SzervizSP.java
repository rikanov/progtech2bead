/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Szerviz;

public class SzervizSP {
    private String sGetDefaultDatabase = "CREATE TABLE Munkalap\n" +
                                    "(\n" +
                                    "      munkalap_id INT NOT NULL PRIMARY KEY,\n" +
                                    "      vevo_id INT NOT NULL,\n" +
                                    "      rendszam VARCHAR(10) NOT NULL,\n" +
                                    "      dolgozo_id INT NOT NULL,\n" +
                                    "      felvetel_datum VARCHAR(10) NOT NULL\n" +
                                    ");\n" +
                                    "\n" +
                                    "CREATE TABLE Dolgozo\n" +
                                    "(\n" +
                                    "    dolgozo_id INT NOT NULL PRIMARY KEY,\n" +
                                    "    nev VARCHAR(40) NOT NULL,\n" +
                                    "    varos VARCHAR(40) NOT NULL,\n" +
                                    "    irsz VARCHAR(10) NOT NULL,\n" +
                                    "    utca VARCHAR(40) NOT NULL,\n" +
                                    "    tel VARCHAR(25) NOT NULL,\n" +
                                    "    oradij INT NOT NULL\n" +
                                    ");\n" +
                                    "\n" +
                                    "CREATE TABLE Ugyfel\n" +
                                    "(\n" +
                                    "    ugyfel_id INT NOT NULL PRIMARY KEY,\n" +
                                    "    nev VARCHAR(40) NOT NULL,\n" +
                                    "    varos VARCHAR(40) NOT NULL,\n" +
                                    "    irsz VARCHAR(10) NOT NULL,\n" +
                                    "    utca VARCHAR(40) NOT NULL,\n" +
                                    "    tel VARCHAR(25) NOT NULL\n" +
                                    ");\n" +
                                    "\n" +
                                    "CREATE TABLE AnyAlk\n" +
                                    "(\n" +
                                    "    anyag_id INT NOT NULL PRIMARY KEY,\n" +
                                    "    cikkszam VARCHAR(20) NOT NULL,\n" +
                                    "    nev VARCHAR(40) NOT NULL,\n" +
                                    "    egysegar INT NOT NULL \n" +
                                    ");\n" +
                                    "\n" +
                                    "CREATE TABLE AnyMun\n" +
                                    "(\n" +
                                    "    anyagm_id INT NOT NULL,\n" +
                                    "    anyag_id INT NOT NULL,\n" +
                                    "    munkalap_id INT NOT NULL \n" +
                                    ");\n" +
                                    "\n" +
                                    "INSERT INTO ANYALK (ANYAG_ID, CIKKSZAM, NEV, EGYSEGAR) VALUES \n" +
                                    "(1,'06-01101','OX339/2D Mahle olajszűrő',3140),\n" +
                                    "(2,'06-03040','LA138 Mahle pollenszűrő',4095),\n" +
                                    "(3,'06-02149','S3262A Sofima levegőszűrő',4490),\n" +
                                    "(4,'11-00234','Quartz 9000 Energy 5W-40 5L',9500),\n" +
                                    "(5,'16-00770','Ablaktörlő Valeo VM417 700/650',11648),\n" +
                                    "(6,'14-00639','6PK1050C Contitech hosszbordásszíj',4790),\n" +
                                    "(7,'26-04348','34.47.710 Starline lengőkar gömbfej',3385),\n" +
                                    "(8,'10-00043','Munkadíj',3000),\n" +
                                    "(9,'05-00146','Izzó 12V 5W ba15s',83),\n" +
                                    "(10,'05-00148','Izzó 12V 5W üvegfoglalatos W2, 1x9, 5d',70),\n" +
                                    "(11,'05-00165','Izzó H1 12V 55W',572),\n" +
                                    "(12,'26-00017','Kipufogódob szgk.',12400),\n" +
                                    "(13,'26-03470','AK.30054 Akron motortartó gumibak',21700),\n" +
                                    "(14,'18-00145','DIN 933 Hlf. Csavar 10x70 8.8',51),\n" +
                                    "(15,'26-00107','LZKAR7A NGK gyújtógyertya',1880),\n" +
                                    "(16,'10-00035','Abroncshotel',760),\n" +
                                    "(17,'10-00019','Gumiszerelés',1150),\n" +
                                    "(18,'26-02557','53569 Sidem stabilizátor',5095),\n" +
                                    "(19,'26-02558','TA2463 Delphi axiálcsukló',5820),\n" +
                                    "(20,'26-01170','TA977 Delphi kormány gömbfej',2835),\n" +
                                    "(21,'16-00268','Kábelkötegelő 286x4,8',23),\n" +
                                    "(22,'16-00688','Kábelkötegelő 380x7,8',51),\n" +
                                    "(23,'05-00137','Izzó 12V 21W Ba15s',95),\n" +
                                    "(24,'10-00030','Futóműállítás szgk.',5080),\n" +
                                    "(25,'03-00446','195/65R15 Nokian W+ 91T',15490),\n" +
                                    "(26,'03-01227','Szelep TR-414',100),\n" +
                                    "(27,'11-00234','Fagyálló 1kg -72C G12',590),\n" +
                                    "(28,'26-00719','VKMC03258 SKF vezérműszíj készlet',47460),\n" +
                                    "(29,'26-00720','FSL1399 Ferodo fékbetét',7730),\n" +
                                    "(30,'26-00721','DDF1140 Ferodo féktárcsa',14400),\n" +
                                    "(31,'50.20.11.4','Műszaki vizsgadíj',9550),\n" +
                                    "(32,'85113000','Gyújtó trafó',35550),\n" +
                                    "(33,'64009A','Pollenszűrő',1944),\n" +
                                    "(34,'95R01A','Service - Systematic Operation',13610),\n" +
                                    "(35,'38190000','Fékfolyadék',1770),\n" +
                                    "(36,'84213100','Féktisztító',960),\n" +
                                    "(37,'95600000','Klímatisztítás',10000);\n" +
                                    "\n" +
                                    "INSERT INTO UGYFEL (UGYFEL_ID, NEV, VAROS, IRSZ, UTCA, TEL) VALUES \n" +
                                    "(1,'Tele5 Taxi','Budapest','1555','Malom út 9.','+36-1-555-5555');";
    
    private String sGetMunkalapok = "SELECT\n" +
                                    "munkalap.MUNKALAP_ID,\n" +
                                    "ugyfel.NEV,\n" +
                                    "munkalap.RENDSZAM,\n" +
                                    "munkalap.FELVETEL_DATUM\n" +
                                    "\n" +
                                    "FROM munkalap\n" +
                                    "\n" +
                                    "JOIN ugyfel ON ugyfel.UGYFEL_ID = munkalap.VEVO_ID";
    
    private String sGetUgyfelek = "SELECT * FROM UGYFEL";
    
    private String sGetDolgozok = "SELECT * FROM DOLGOZO";
    
    private String sGetMegnevezesek = "SELECT * FROM ANYALK";
    
    private String sGetMunkalap = "SELECT\n" +
                                  "ANYMUN.ANYAGM_ID,\n" +
                                  "ANYALK.CIKKSZAM,\n" +
                                  "ANYALK.NEV,\n" +
                                  "ANYALK.EGYSEGAR\n" +
                                  "\n" +
                                  "FROM ANYMUN\n" +
                                  "\n" +
                                  "JOIN ANYALK ON ANYALK.ANYAG_ID = ANYMUN.ANYAG_ID\n" +
                                  "\n" +
                                  "WHERE\n" +
                                  "ANYMUN.MUNKALAP_ID = ";
    
    private String sGetAnyMun = "SELECT * FROM ANYMUN WHERE ANYAGM_ID = -1";
    
    private String sInsertMunkalap = "INSERT INTO MUNKALAP ("
                    + "MUNKALAP_ID, VEVO_ID, RENDSZAM, DOLGOZO_ID, FELVETEL_DATUM)"
                    + "VALUES(?, ?, ?, ?, ?)";
    
    private String sInsertTetelek = "INSERT INTO ANYMUN ("
                    + "ANYAGM_ID, ANYAG_ID, MUNKALAP_ID)"
                    + "VALUES(?, ?, ?)";
    
    private String sNewUgyfel = "SELECT * FROM UGYFEL WHERE UGYFEL.UGYFEL_ID = -1";
    
    private String sNewDolgozo = "SELECT * FROM DOLGOZO WHERE DOLGOZO.DOLGOZO_ID = -1";
    
    public String getMunkalapok(){
        return sGetMunkalapok;
    }
    
    public String getugyfelek(){
        return sGetUgyfelek;
    }
    
    public String getDolgozok(){        
        return sGetDolgozok;
    }
    
    public String getMegnevezesek(){
        return sGetMegnevezesek;
    }
    
    public String getMunkalap(int ID){        
        return sGetMunkalap + Integer.toString(ID);
    }
    
    public String getAnyMun(){
        return sGetAnyMun;
    }
    
    public String getInsertMunkalap(){
        return sInsertMunkalap;
    }
    
    public String getInsertTetelek(){
        return sInsertTetelek;
    }
    
    public String getUjUgyfel(){
        return sNewUgyfel;
    }
        
    public String getUjDolgozo(){
        return sNewDolgozo;
    }
    
    public String getTempData(){
        return sGetDefaultDatabase;
    }
}
package kata5P2.Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5P2.Modelo.Mail;

public class MailListReaderDDBB {
    
    public static List<Mail> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:/Usuario/Desktop/DAVID/Universidad/IS2/Practica Lab 5/SQLiteDatabaseBrowserPortable/Data/KATA5.db");
        
        List<Mail> mailList= new ArrayList<>();
        
        String query = "select * from emails";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){  
            String mails = rs.getString("Mail");
            mailList.add(new Mail(mails));
        }
        query = "select count (*) from emails";
        rs = stmt.executeQuery(query);
        while (rs.next()){           
            int num = rs.getInt(1);
            System.out.println(num);
        }
        stmt.close();
        rs.close();
        return mailList;
        
    }
    
    
    
    
}
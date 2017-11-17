package kata5P2.Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5P2.Modelo.Histogram;
import kata5P2.Modelo.Mail;
import kata5P2.Vista.HistogramDisplay;
import kata5P2.Vista.MailHistogramBuilder;
import kata5P2.Vista.MailListReader;
import kata5P2.Vista.MailListReaderDDBB;

public class Kata5P2 {
    
/*
Se modifica la clase de Control, Kata4, usando el patrón de
diseño CIPO: se deben crear los módulos de control execute(), de
entrada input(), de proceso process() y de salida output().
*/

    
    private List<Mail> mailList;
    private Histogram<String> histogram;
   
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
      Kata5P2 kata4=new Kata5P2();
      kata4.execute();
    }
    
    void execute() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    void input() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        String fileName="emails.txt";
        mailList = MailListReaderDDBB.read(); //Almacena los emails accediendo a una base de datos
        //mailList=MailListReader.read(fileName); //Almacena los emails accediendo a un archivo txt
        
    }
    
    void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}

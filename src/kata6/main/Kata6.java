package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.Attribute;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private HistogramBuilder<Mail> builder;
    private List<Mail> listMail;
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }
    
    
    private void input() throws IOException {
        String nameFile="emails.txt";
        listMail = MailListReader.read(nameFile);
    }
    
    
    private void process() {
        builder = new HistogramBuilder<>(listMail);
    }
    
    
    private void output() {
        Histogram<String> domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
    
        new HistogramDisplay(domains, "Dominios").execute();
        
        Histogram<Character> letters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(letters,"Primer Caracter").execute();
        
    }
    
}

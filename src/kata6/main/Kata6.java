package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        Kata6 kata4 = new Kata6();
        kata4.execute();
    }
    
    private Histogram<String> histogram;
    private List<Mail> mailList;
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }
    
    
    private void input() throws IOException {
        String fileName="emails.txt";
        mailList = MailListReader.read(fileName);
    }
    
    
    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}

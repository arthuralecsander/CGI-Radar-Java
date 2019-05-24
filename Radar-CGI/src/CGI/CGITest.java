package CGI;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import jxl.read.biff.BiffException;

public class CGITest {
    public static void main(String[] args)  throws IOException, BiffException {
        CGI cg = new CGI();
        JFrame frame = new JFrame();
        frame.add(cg);
        frame.setSize(954, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        cg.setBackground(Color.BLACK);
        cg.move();
       
    }
    
    
}

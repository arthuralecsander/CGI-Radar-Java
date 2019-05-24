package CGI;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import voo.LA2203;
import voo.GZ0331;
import voo.AZ0032;
import voo.AZ0157;
import voo.GZ0667;

public class excelRead {
    
    public void criaVoo(LA2203[] la2203, GZ0331[] gz0331, AZ0032[] az0032, AZ0157[] az0157, GZ0667[] gz0667) throws IOException, BiffException {

        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\arthur.alecsander\\Documents\\NetBeansProjects\\Radar-CGI\\src\\files\\radar.xls"));
        Sheet sheet = workbook.getSheet(0);
        int cont1 =0;
        int cont2 =0;
        int cont3 =0;
        int cont4 =0;
        int cont5 =0;

        int linhas = sheet.getRows();

        for (int i = 1; i < linhas; i++) {
            Cell a0 = sheet.getCell(0, i);
            Cell a1 = sheet.getCell(1, i);
            Cell a2 = sheet.getCell(2, i);
            Cell a3 = sheet.getCell(3, i);
            Cell a4 = sheet.getCell(4, i);
            Cell a5 = sheet.getCell(5, i);
            Cell a6 = sheet.getCell(6, i);
            Cell a7 = sheet.getCell(7, i);
            
            String t = a0.getContents();
            String status = a1.getContents();
            String voo = a2.getContents();
            String dist = a3.getContents();
            String vel = a4.getContents();
            String x = a5.getContents();
            String y = a6.getContents();
            String z = a7.getContents();
            if (t.length() > 1) {
            //System.out.println("T:" +t+" Status:"+status+" Voo:"+voo+" Dist:"+dist+" Vel:"+vel+" X:"+x+" Y:"+y+" Z:"+z);
             switch(voo){
                 case "LA 2203":
                     la2203[cont1] = new LA2203();
                     la2203[cont1].setT(t);
                     la2203[cont1].setStatus(status);
                     la2203[cont1].setVoo(voo);
                     la2203[cont1].setDist(dist);
                     la2203[cont1].setVel(vel);
                     la2203[cont1].setX(Integer.parseInt(x));
                     la2203[cont1].setY(Integer.parseInt(y));
                     la2203[cont1].setZ(Integer.parseInt(z));
                     cont1++;
                     break;
                     
                 case "GZ 0331":
                     gz0331[cont2] = new GZ0331();
                     gz0331[cont2].setT(t);
                     gz0331[cont2].setStatus(status);
                     gz0331[cont2].setVoo(voo);
                     gz0331[cont2].setDist(dist);
                     gz0331[cont2].setVel(vel);
                     gz0331[cont2].setX(Integer.parseInt(x));
                     gz0331[cont2].setY(Integer.parseInt(y));
                     gz0331[cont2].setZ(Integer.parseInt(z));
                     cont2++;
                     break;
                     
                 case "AZ 0032":
                     az0032[cont3] = new AZ0032();
                     az0032[cont3].setT(t);
                     az0032[cont3].setStatus(status);
                     az0032[cont3].setVoo(voo);
                     az0032[cont3].setDist(dist);
                     az0032[cont3].setVel(vel);
                     az0032[cont3].setX(Integer.parseInt(x));
                     az0032[cont3].setY(Integer.parseInt(y));
                     az0032[cont3].setZ(Integer.parseInt(z));
                     cont3++;
                     break;
                     
                 case "AZ 0157": 
                     az0157[cont4] = new AZ0157();
                     az0157[cont4].setT(t);
                     az0157[cont4].setStatus(status);
                     az0157[cont4].setVoo(voo);
                     az0157[cont4].setDist(dist);
                     az0157[cont4].setVel(vel);
                     az0157[cont4].setX(Integer.parseInt(x));
                     az0157[cont4].setY(Integer.parseInt(y));
                     az0157[cont4].setZ(Integer.parseInt(z));
                     cont4++;
                     break;
                 
                 case "GZ 0667":    
                     gz0667[cont5] = new GZ0667();
                     gz0667[cont5].setT(t);
                     gz0667[cont5].setStatus(status);
                     gz0667[cont5].setVoo(voo);
                     gz0667[cont5].setDist(dist);
                     gz0667[cont5].setVel(vel);
                     gz0667[cont5].setX(Integer.parseInt(x));
                     gz0667[cont5].setY(Integer.parseInt(y));
                     gz0667[cont5].setZ(Integer.parseInt(z));
                     cont5++;
                     break;
             }
            }
           
        }
        workbook.close();
    }
    
}

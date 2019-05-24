package CGI;

/**
 *
 * @author arthu
 */
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import voo.AZ0032;
import voo.AZ0157;
import voo.GZ0331;
import voo.GZ0667;
import voo.LA2203;

public class CGI extends JPanel {

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension scrnsize = toolkit.getScreenSize();
    excelRead excel = new excelRead();
    AZ0032 az0032[] = new AZ0032[15];
    AZ0157 az0157[] = new AZ0157[15];
    GZ0331 gz0331[] = new GZ0331[15];
    GZ0667 gz0667[] = new GZ0667[15];
    LA2203 la2203[] = new LA2203[15];

    private int x1, x2, y1, y2, dX, dY, xInc, yInc, p;
    int contadorx = 0, contadory = 0;

    /*float altura, largura;
    Toolkit tool = Toolkit.getDefaultToolkit();
    Dimension screen = tool.getScreenSize();
    Graphics g;*/
    //public CGIFrame() {
    //}
    public void AllVoos() {
        int i = 0;
        for (LA2203 info : la2203) {
            System.out.printf("[" + i + "]" + " T:" + info.getT() + " Status:" + info.getStatus() + " Voo:" + info.getVoo() + " Dist:" + info.getDist() + " Vel:" + info.getVel() + " X:" + info.getX() + " Y:" + info.getY() + " Z:" + info.getZ() + "\n");
            i++;
        }
        System.out.println("");
        i = 0;
        for (GZ0331 info : gz0331) {
            System.out.printf("[" + i + "]" + " T:" + info.getT() + " Status:" + info.getStatus() + " Voo:" + info.getVoo() + " Dist:" + info.getDist() + " Vel:" + info.getVel() + " X:" + info.getX() + " Y:" + info.getY() + " Z:" + info.getZ() + "\n");
            i++;
        }
        System.out.println("");
        i = 0;
        for (AZ0032 info : az0032) {
            System.out.printf("[" + i + "]" + " T:" + info.getT() + " Status:" + info.getStatus() + " Voo:" + info.getVoo() + " Dist:" + info.getDist() + " Vel:" + info.getVel() + " X:" + info.getX() + " Y:" + info.getY() + " Z:" + info.getZ() + "\n");
            i++;
        }
        System.out.println("");
        i = 0;
        for (AZ0157 info : az0157) {
            System.out.printf("[" + i + "]" + " T:" + info.getT() + " Status:" + info.getStatus() + " Voo:" + info.getVoo() + " Dist:" + info.getDist() + " Vel:" + info.getVel() + " X:" + info.getX() + " Y:" + info.getY() + " Z:" + info.getZ() + "\n");
            i++;
        }
        System.out.println("");
        i = 0;
        for (GZ0667 info : gz0667) {
            System.out.printf("[" + i + "]" + " T:" + info.getT() + " Status:" + info.getStatus() + " Voo:" + info.getVoo() + " Dist:" + info.getDist() + " Vel:" + info.getVel() + " X:" + info.getX() + " Y:" + info.getY() + " Z:" + info.getZ() + "\n");
            i++;
        }
    }

    int AZ0032X = 0;
    int AZ0032Y = 0;
    //int AZ0032Z = az0032[1].getZ();

    int AZ0157X = 0;
    int AZ0157Y = 0;
    //int AZ0157Z = az0157[1].getZ();

    int GZ0331X = 0;
    int GZ0331Y = 0;
    //int GZ0331Z = gz0331[1].getZ();

    int GZ0667X = 0;
    int GZ0667Y = 0;
    //int GZ0667Z = gz0667[1].getZ();

    int LA2203X = 0;
    int LA2203Y = 0;
    //int LA2203Z = la2203[1].getZ();*/

    void move() throws IOException, BiffException {
        excel.criaVoo(la2203, gz0331, az0032, az0157, gz0667);
        //AllVoos();

        while (true) {
            trajetoAZ0032();
            trajetoGZ0331();

        try {
                Thread.sleep(60);
            } catch (Exception e) {

            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        drawLines(0, 0, 400, 400, g);   //Desenho do radar
        drawLines(0, 0, -400, -400, g); //Desenho do radar
        drawLines(0, 0, 400, -400, g);  //Desenho do radar
        drawLines(0, 0, -400, 400, g);  //Desenho do radar
        drawLines(-400, 0, 0, 0, g);    //Desenho do radar
        drawLines(0, 0, 400, 0, g);     //Desenho do radar
        drawLines(0, -400, 0, 0, g);    //Desenho do radar
        drawLines(0, 0, 0, 400, g);     //Desenho do radar

        drawPista(-45, -25, 45, 25, g);           //Pistas do radar
        //drawCopista(252, 7, 152, 82, g);         //Listras ao lado das pistas
        /*drawPista(-130, 350, -250, 310, g);      //Pistas do radar
        drawCopista(-132, 353, -252, 313, g);    //Listras ao lado das pistas
        drawPista(150, -235, 245, -250, g);      //Pistas do radar
        drawCopista(152, -232, 247, -247, g);    //Listras ao lado das pistas
        drawPista(-250, -105, -250, 5, g);       //Pistas do radar
        drawCopista(-248, -105, -248, 5, g);     //Listras ao lado das pistas*/

        int pontos;
        pontos = 1500; // Quantidade de pontos no circulo
        drawCircle(g, 0, 0, 365, pontos);   //Circulos do radar
        drawCircle(g, 0, 0, 265, pontos);   //Circulos do radar
        drawCircle(g, 0, 0, 165, pontos);   //Circulos do radar
        drawCircle(g, 0, 0, 65, pontos);    //Circulos do radar

        drawPlane("AZ 0032", g, AZ0032X, AZ0032Y);
        drawPlane("GZ 0331", g, GZ0331X, GZ0331Y);

    }

    public void drawPixel(int x, int y, Graphics g, Color color) {
        g.setColor(color);
        x += 954 / 2;
        y += 1000 / 2;
        g.fillRect(x, y, 2, 2);
    }

    public void AviaoTest(int x, int y, Graphics g, Color color) {
        g.setColor(color);
        x += 954 / 2;
        y += 1000 / 2;
        g.fillRect(x, y, 10, 10);
    }

    int contador = 0;

    public void drawLines(int x, int y, int xx, int yy, Graphics g) {

        contador++;
        //System.out.println("Linha desenhada % x" + contador);
        x1 = x;
        y1 = y;
        x2 = xx;
        y2 = yy;
        dX = x2 - x1;
        dY = y2 - y1;
        xInc = 1;
        yInc = 1;
        if (dX < 0) {
            xInc = - 1;
            dX = -dX;
        }
        if (dY < 0) {
            yInc = - 1;
            dY = -dY;
        }
        if (dY <= dX) {
            p = dX / 2;
            while (x1 != x2) {
                if (contadorx % 5 == 1 || contadorx % 5 == 2 || contadorx % 5 == 3) {
                    contadorx = contadorx + 1;
                    drawPixel(x1, y1, g, Color.BLACK);
                    p = p - dY;
                    if (p < 0) {
                        y1 = y1 + yInc;
                        p = p + dX;
                    }
                    x1 = x1 + xInc;
                } else {
                    contadorx = contadorx + 1;
                    drawPixel(x1, y1, g, Color.GREEN);
                    p = p - dY;
                    if (p < 0) {
                        y1 = y1 + yInc;
                        p = p + dX;
                    }
                    x1 = x1 + xInc;
                }

            }
        } else {
            p = dY / 2;
            while (y1 != y2) {
                if (contadory % 5 == 1 || contadory % 5 == 2 || contadory % 5 == 3) {
                    contadory = contadory + 1;
                    drawPixel(x1, y1, g, Color.BLACK);
                    p = p - dX;
                    if (p < 0) {
                        x1 = x1 + xInc;
                        p = p + dY;
                    } else {
                        y1 = y1 + xInc;
                    }
                } else {
                    contadory = contadory + 1;
                    drawPixel(x1, y1, g, Color.GREEN);
                    p = p - dX;
                    if (p < 0) {
                        x1 = x1 + xInc;
                        p = p + dY;
                    } else {
                        y1 = y1 + xInc;
                    }
                }

            }
            drawPixel(x1, y1, g, Color.GREEN);
        }

    }

    public void drawPista(int x, int y, int xx, int yy, Graphics g) {

        x1 = x;
        y1 = y;
        x2 = xx;
        y2 = yy;
        dX = x2 - x1;
        dY = y2 - y1;
        xInc = 1;
        yInc = 1;
        if (dX < 0) {
            xInc = - 1;
            dX = -dX;
        }
        if (dY < 0) {
            yInc = - 1;
            dY = -dY;
        }
        if (dY <= dX) {
            p = dX / 2;
            while (x1 != x2) {
                drawPixel(x1, y1, g, Color.GRAY);
                p = p - dY;
                if (p < 0) {
                    y1 = y1 + yInc;
                    p = p + dX;
                }
                x1 = x1 + xInc;
            }
        } else {
            p = dY / 2;
            while (y1 != y2) {
                drawPixel(x1, y1, g, Color.GRAY);
                p = p - dX;
                if (p < 0) {
                    x1 = x1 + xInc;
                    p = p + dY;
                } else {
                    y1 = y1 + xInc;
                }
            }
        }
        drawPixel(x1, y1, g, Color.GRAY);

    }
    int contadorC = 0;

    public void drawCircle(Graphics g, int px, int py, int raio, int qntDePontos) {
        contadorC++;
        // System.out.println("circulo: " + contadorC);
        double distanciaEntrePontos = 2 * Math.PI / qntDePontos;
        for (int i = 0; i < qntDePontos; i++) {
            double cos = Math.cos(i * distanciaEntrePontos);
            double sin = Math.sin(i * distanciaEntrePontos);

            int x = (int) (cos * raio + px);
            int y = (int) (sin * raio + py);

            drawPixel(x, y, g, Color.GREEN);
        }
    }

    public void drawPlane(String nome, Graphics g, int aviaoX, int aviaoY) {
        int x = aviaoX + 954 / 2;
        int y = aviaoY + 1000 / 2;
        g.drawString(nome, (int) x, (int) y - 10);
        g.drawString("X; " + String.valueOf(x), (int) x + 10, (int) y - 20);
        g.drawString("Y; " + String.valueOf(y), (int) x + 10, (int) y - 30);
        AviaoTest(aviaoX, aviaoY, g, Color.GREEN);
    }

    public void trajetoAZ0032() {

        if (AZ0032X <= az0032[8].getX() / 10) {
            AZ0032X++;
            repaint();
        }

        if (AZ0032Y <= az0032[8].getY() / 10) {
            AZ0032Y++;
            repaint();
        }

    }

    public void trajetoGZ0331() {
        if (GZ0331X >= gz0331[3].getX()/10) {
            GZ0331X--;
            repaint();
        }

        if (GZ0331Y < gz0331[3].getY() / 10) {
            GZ0331Y++;
            repaint();
        }

    }

}

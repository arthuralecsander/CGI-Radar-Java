package CGI;

import java.io.IOException;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;
import jxl.read.biff.BiffException;
import static oracle.jrockit.jfr.events.Bits.intValue;
import voo.AZ0032;
import voo.AZ0157;
import voo.GZ0331;
import voo.GZ0667;
import voo.LA2203;

public class CGI extends JPanel implements MouseWheelListener {

    int ang = 0;
    boolean quit = true;
    int contadorAZ1 = 0, contadorAZ2 = 0, contadorGZ1 = 0, contadorGZ2 = 0, contadorLA = 0;
    int contadorViaoAz1 = 13, contadorViaoAz2 = 13, contadorViaoGz1 = 13, contadorViaoGz2 = 13, contadorViaoLA = 13;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension scrnsize = toolkit.getScreenSize();
    excelRead excel = new excelRead();

    AZ0032 az0032[] = new AZ0032[15];
    AZ0157 az0157[] = new AZ0157[15];
    GZ0331 gz0331[] = new GZ0331[15];
    GZ0667 gz0667[] = new GZ0667[15];
    LA2203 la2203[] = new LA2203[15];

    char Saz0032[] = new char[15];
    char Saz0157[] = new char[15];
    char Sgz0331[] = new char[15];
    char Sgz0667[] = new char[15];
    char Sla2203[] = new char[15];

    int Xaz0032[] = new int[15];
    int Xaz0157[] = new int[15];
    int Xgz0331[] = new int[15];
    int Xgz0667[] = new int[15];
    int Xla2203[] = new int[15];

    int Yaz0032[] = new int[15];
    int Yaz0157[] = new int[15];
    int Ygz0331[] = new int[15];
    int Ygz0667[] = new int[15];
    int Yla2203[] = new int[15];

    int Fzao = 20000, fzinho = 1000;

    int AZ0032X;
    int AZ0032Y;
    char AZ0032S;

    int AZ0157X;
    int AZ0157Y;
    char AZ0157S;

    int GZ0331X;
    int GZ0331Y;
    char GZ0331S;

    int GZ0667X;
    int GZ0667Y;
    char GZ0667S;

    int LA2203X;
    int LA2203Y;
    char LA2203S;

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

    void move() throws IOException, BiffException {
        excel.criaVoo(la2203, gz0331, az0032, az0157, gz0667);
        //AllVoos();
        //printAos();
        while (true) {

            try {
                Thread.sleep(1000);

                trajetoAZ0032(contadorAZ1);
                trajetoAZ0157(contadorAZ2);
                trajetoGZ0331(contadorGZ1);
                trajetoGZ0667(contadorGZ2);
                trajetoLA2203(contadorLA);

                contadorAZ1++;
                contadorAZ2++;
                contadorGZ1++;
                contadorGZ2++;
                contadorLA++;

            } catch (Exception e) {

            }
        }

    }

    public void printAos() {
        for (int i = 0; i <= 14; i++) {
            System.out.printf(i + " AZ0032X : " + Xaz0032[i]);
            System.out.printf("\n");
            System.out.printf(i + " AZ0032Y : " + Yaz0032[i]);
            System.out.printf("\n");
        }
        for (int i = 0; i <= 14; i++) {
            System.out.printf(i + " AZ0157X : " + Xaz0157[i]);
            System.out.printf("\n");
            System.out.printf(i + " AZ0157Y : " + Yaz0157[i]);
            System.out.printf("\n");
        }
        for (int i = 0; i <= 14; i++) {
            System.out.printf(i + " GZ0667X : " + Xgz0667[i]);
            System.out.printf("\n");
            System.out.printf(i + " GZ0667Y : " + Ygz0667[i]);
            System.out.printf("\n");
        }
        for (int i = 0; i <= 14; i++) {
            System.out.printf(i + " LA2203X : " + Xla2203[i]);
            System.out.printf("\n");
            System.out.printf(i + " LA2203Y : " + Yla2203[i]);
            System.out.printf("\n");
        }
        for (int i = 0; i <= 14; i++) {
            System.out.printf(i + " GZ0331X : " + Xgz0331[i]);
            System.out.printf("\n");
            System.out.printf(i + " GZ0331Y : " + Ygz0331[i]);
            System.out.printf("\n");
        }

    }

    public void setInicCord() throws IOException, BiffException {
        excel.criaVoo(la2203, gz0331, az0032, az0157, gz0667);

        calcX();
        calcY();
        StatusString();
        AZ0032X = Xaz0032[14];
        AZ0032Y = Yaz0032[14];

        AZ0157X = Xaz0157[14];
        AZ0157Y = Yaz0157[14];

        GZ0331X = Xgz0331[14];
        GZ0331Y = Ygz0331[14];

        GZ0667X = Xgz0667[14];
        GZ0667Y = Ygz0667[14];

        LA2203X = Xla2203[14];
        LA2203Y = Yla2203[14];
        //System.out.println(Xaz0032[0]);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLineFalhada(0, 0, 400, 400, g, Color.GRAY);   //Desenho do radar
        drawLineFalhada(0, 0, -400, -400, g, Color.GRAY); //Desenho do radar
        drawLineFalhada(0, 0, 400, -400, g, Color.GRAY);  //Desenho do radar
        drawLineFalhada(0, 0, -400, 400, g, Color.GRAY);  //Desenho do radar
        drawLineFalhada(-400, 0, 0, 0, g, Color.GRAY);    //Desenho do radar
        drawLineFalhada(0, 0, 400, 0, g, Color.GRAY);     //Desenho do radar
        drawLineFalhada(0, -400, 0, 0, g, Color.GRAY);    //Desenho do radar
        drawLineFalhada(0, 0, 0, 400, g, Color.GRAY);     //Desenho do radar

        drawLines(-45, -25, 45, 25, g, Color.BLUE);           //Pistas do radar

        int pontos;
        pontos = 1000; // Quantidade de pontos no circulo
        drawCircle(g, 0, 0, 365, pontos, Color.GRAY);   //Circulos do radar
        drawCircle(g, 0, 0, 265, pontos, Color.GRAY);   //Circulos do radar
        drawCircle(g, 0, 0, 165, pontos, Color.GRAY);   //Circulos do radar
        drawCircle(g, 0, 0, 65, pontos, Color.GRAY);    //Circulos do radar

        drawPlane("AZ 0032", g, AZ0032X, AZ0032Y, AZ0032S);
        drawPlane("AZ 0157", g, AZ0157X, AZ0157Y, AZ0157S);
        drawPlane("GZ 0667", g, GZ0667X, GZ0667Y, GZ0667S);
        drawPlane("LA 2203", g, LA2203X, LA2203Y, LA2203S);
        drawPlane("GZ 0331", g, GZ0331X, GZ0331Y, GZ0331S);

    }

    public void drawPixel(int x, int y, Graphics g, Color color) {
        g.setColor(color);
        x += 954 / 2;
        y += 1000 / 2;
        g.fillRect(x, y, 2, 2);
    }

    public void drawLines(int x1, int y1, int x2, int y2, Graphics g, Color color) {
        int x, y, dx, dy, xInc, yInc, p;
        x = x1;
        y = y1;
        p = 0;
        dx = x2 - x1;
        dy = y2 - y1;
        xInc = 1;
        yInc = 1;
        if (dx < 0) {
            xInc = -1;
            dx = -dx;
        }

        if (dy < 0) {
            yInc = -1;
            dy = -dy;
        }

        if (dy <= dx) {
            p = dx / 2;
            while (x != x2) {
                drawPixel(x, y, g, color);
                p = p - dy;
                if (p < 0) {
                    y = y + yInc;
                    p = p + dx;
                }
                x = x + xInc;
            }

        } else {
            p = dy / 2;
            while (y != y2) {
                drawPixel(x, y, g, color);
                p = p - dx;
                if (p < 0) {
                    x = x + xInc;
                    p = p + dy;
                }
                y = y + yInc;
            }

        }
        drawPixel(x, y, g, color);
    }

    public void drawLineFalhada(int x1, int y1, int x2, int y2, Graphics g, Color color) {
        int x, y, dx, dy, xInc, yInc, p;
        int contadorx = 0, contadory = 0;
        x = x1;
        y = y1;
        p = 0;
        dx = x2 - x1;
        dy = y2 - y1;
        xInc = 1;
        yInc = 1;
        if (dx < 0) {
            xInc = -1;
            dx = -dx;
        }

        if (dy < 0) {
            yInc = -1;
            dy = -dy;
        }

        if (dy <= dx) {

            p = dx / 2;
            while (x != x2) {
                if (contadorx % 5 == 1 || contadorx % 5 == 2 || contadorx % 5 == 3) {
                    contadorx = contadorx + 1;
                    drawPixel(x, y, g, Color.BLACK);
                    p = p - dy;
                    if (p < 0) {
                        y = y + yInc;
                        p = p + dx;
                    }
                    x = x + xInc;
                } else {
                    contadorx = contadorx + 1;
                    drawPixel(x, y, g, color);
                    p = p - dy;
                    if (p < 0) {
                        y = y + yInc;
                        p = p + dx;
                    }
                    x = x + xInc;
                }

            }

        } else {
            p = dy / 2;
            while (y != y2) {
                if (contadory % 5 == 1 || contadory % 5 == 2 || contadory % 5 == 3) {
                    contadory = contadory + 1;
                    drawPixel(x, y, g, Color.BLACK);
                    p = p - dx;
                    if (p < 0) {
                        x = x + xInc;
                        p = p + dy;
                    }

                    y = y + yInc;
                } else {
                    contadory = contadory + 1;
                    drawPixel(x, y, g, color);
                    p = p - dx;
                    if (p < 0) {
                        x = x + xInc;
                        p = p + dy;
                    }

                    y = y + yInc;
                }

            }

        }
        drawPixel(x, y, g, color);
    }

    public void aviaoPlotado(int ox1, int oy1, int ox2, int oy2, int ox3, int oy3, Graphics g, Color color) {
        Color cor = color;
        g.setColor(cor);
        drawLines(ox2, oy2, ox1, oy1, g, cor);
        drawLines(ox1, oy1, ox3, oy3, g, cor);
        drawLines(ox2, oy2, ox3, oy3, g, cor);
    }

    public void aviao(int cpx, int cpy, Graphics g, char status, Color color) {
        Color cor = color;
        int ox1, oy1, ox2, oy2, ox3, oy3;
        int xr1 = 0, yr1 = 0, xr2 = 0, yr2 = 0, xr3 = 0, yr3 = 0;
        int x1f = 0, y1f = 0, x2f = 0, y2f = 0, x3f = 0, y3f = 0;

        ox1 = 10;
        oy1 = 0;

        ox2 = 0;
        oy2 = 0;

        ox3 = 0;
        oy3 = 0;

        ox2 = -5;
        oy2 = 5;

        ox3 = -5;
        oy3 = -5;
        int d = intValue(Math.sqrt(cpx * cpx + cpy * cpy));

        if (cpx == 0 && status == 'P') {
            x1f = intValue(ox1 * Math.cos(Math.toRadians(0)) - oy1 * Math.sin(Math.toRadians(0)));
            y1f = intValue(oy1 * Math.cos(Math.toRadians(0)) + ox1 * Math.sin(Math.toRadians(0)));
            x2f = intValue(ox2 * Math.cos(Math.toRadians(0)) - oy2 * Math.sin(Math.toRadians(0)));
            y2f = intValue(oy2 * Math.cos(Math.toRadians(0)) + ox2 * Math.sin(Math.toRadians(0)));
            x3f = intValue(ox3 * Math.cos(Math.toRadians(0)) - oy3 * Math.sin(Math.toRadians(0)));
            y3f = intValue(oy3 * Math.cos(Math.toRadians(0)) + ox3 * Math.sin(Math.toRadians(0)));

            xr1 = x1f + cpx;
            yr1 = y1f + cpy;
            xr2 = x2f + cpx;
            yr2 = y2f + cpy;
            xr3 = x3f + cpx;
            yr3 = y3f + cpy;
            aviaoPlotado(xr1, yr1, xr2, yr2, xr3, yr3, g, cor);

        }
        if (cpx == 0 && status == 'D') {
            x1f = intValue(ox1 * Math.cos(Math.toRadians(0) + Math.PI) - oy1 * Math.sin(Math.toRadians(0) + Math.PI));
            y1f = intValue(oy1 * Math.cos(Math.toRadians(0) + Math.PI) + ox1 * Math.sin(Math.toRadians(0) + Math.PI));
            x2f = intValue(ox2 * Math.cos(Math.toRadians(0) + Math.PI) - oy2 * Math.sin(Math.toRadians(0) + Math.PI));
            y2f = intValue(oy2 * Math.cos(Math.toRadians(0) + Math.PI) + ox2 * Math.sin(Math.toRadians(0) + Math.PI));
            x3f = intValue(ox3 * Math.cos(Math.toRadians(0) + Math.PI) - oy3 * Math.sin(Math.toRadians(0) + Math.PI));
            y3f = intValue(oy3 * Math.cos(Math.toRadians(0) + Math.PI) + ox3 * Math.sin(Math.toRadians(0) + Math.PI));

            xr1 = x1f + cpx;
            yr1 = y1f + cpy;
            xr2 = x2f + cpx;
            yr2 = y2f + cpy;
            xr3 = x3f + cpx;
            yr3 = y3f + cpy;

            aviaoPlotado(xr1, yr1, xr2, yr2, xr3, yr3, g, cor);
        }

        if (cpx != 0) {

            ang = intValue(Math.acos(cpx / d));

            if (cpx > 0 && cpy < 0) {
                ang = intValue(ang + Math.PI);
            }
            if (cpx > 0 && cpy > 0) {
                ang = intValue(ang + Math.PI);
            }
            if (cpx < 0 && cpy < 0) {
                ang = intValue(ang + Math.PI);
            }
            if (cpx < 0 && cpy > 0) {
                ang = intValue(ang + Math.PI / 2);
            }

            if (status == 'P') {
                x1f = intValue(ox1 * Math.cos(ang) - oy1 * Math.sin(ang));
                y1f = intValue(oy1 * Math.cos(ang) + ox1 * Math.sin(ang));
                x2f = intValue(ox2 * Math.cos(ang) - oy2 * Math.sin(ang));
                y2f = intValue(oy2 * Math.cos(ang) + ox2 * Math.sin(ang));
                x3f = intValue(ox3 * Math.cos(ang) - oy3 * Math.sin(ang));
                y3f = intValue(oy3 * Math.cos(ang) + ox3 * Math.sin(ang));
                /*x1f = intValue(ox1 * Math.cos(ang + Math.PI) - oy1 * Math.sin(ang + Math.PI));
                 y1f = intValue(oy1 * Math.cos(ang + Math.PI) + ox1 * Math.sin(ang + Math.PI));
                 x2f = intValue(ox2 * Math.cos(ang + Math.PI) - oy2 * Math.sin(ang + Math.PI));
                 y2f = intValue(oy2 * Math.cos(ang + Math.PI) + ox2 * Math.sin(ang + Math.PI));
                 x3f = intValue(ox3 * Math.cos(ang + Math.PI) - oy3 * Math.sin(ang + Math.PI));
                 y3f = intValue(oy3 * Math.cos(ang + Math.PI) + ox3 * Math.sin(ang + Math.PI));*/

                xr1 = x1f + cpx;
                yr1 = y1f + cpy;
                xr2 = x2f + cpx;
                yr2 = y2f + cpy;
                xr3 = x3f + cpx;
                yr3 = y3f + cpy;

                aviaoPlotado(xr1, yr1, xr2, yr2, xr3, yr3, g, cor);

            }
            if (status == 'D') {
                x1f = intValue(ox1 * Math.cos(ang) - oy1 * Math.sin(ang));
                y1f = intValue(oy1 * Math.cos(ang) + ox1 * Math.sin(ang));
                x2f = intValue(ox2 * Math.cos(ang) - oy2 * Math.sin(ang));
                y2f = intValue(oy2 * Math.cos(ang) + ox2 * Math.sin(ang));
                x3f = intValue(ox3 * Math.cos(ang) - oy3 * Math.sin(ang));
                y3f = intValue(oy3 * Math.cos(ang) + ox3 * Math.sin(ang));

                xr1 = x1f + cpx;
                yr1 = y1f + cpy;
                xr2 = x2f + cpx;
                yr2 = y2f + cpy;
                xr3 = x3f + cpx;
                yr3 = y3f + cpy;
                aviaoPlotado(xr1, yr1, xr2, yr2, xr3, yr3, g, cor);
            }
        }
    }

    public void drawCircle(Graphics g, int px, int py, int raio, int qntDePontos, Color color) {

        double distanciaEntrePontos = 2 * Math.PI / qntDePontos;
        for (int i = 0; i < qntDePontos; i++) {
            double cos = Math.cos(i * distanciaEntrePontos);
            double sin = Math.sin(i * distanciaEntrePontos);

            int x = (int) (cos * raio + px);
            int y = (int) (sin * raio + py);

            drawPixel(x, y, g, color);

        }
    }

    public void drawPlane(String nome, Graphics g, int aviaoX, int aviaoY, char Status) {
        g.setColor(Color.GREEN);
        g.drawString("F : " + Fzao, 5, 10);
        g.drawString("f : " + fzinho, 5, 25);
        int x = aviaoX + 954 / 2;
        int y = aviaoY + 1000 / 2;
        if (x == 477 && y == 500) {
            g.setColor(Color.RED);
            Color cor = Color.RED;
            g.drawString(nome, (int) x + 10, (int) y - 10);
            g.drawString("X: " + String.valueOf(x - 477), (int) x + 10, (int) y - 20);
            g.drawString("Y: " + String.valueOf(y - 500), (int) x + 10, (int) y - 30);
            g.drawString("Status: " + Status, (int) x + 10, (int) y - 40);
            aviao(aviaoX, aviaoY, g, Status, cor);
            //AviaoTest(aviaoX, aviaoY, g, Color.RED);
        } else {
            g.setColor(Color.GREEN);
            Color cor = Color.GREEN;
            g.drawString(nome, (int) x + 10, (int) y - 10);
            g.drawString("X: " + String.valueOf(x - 477), (int) x + 10, (int) y - 20);
            g.drawString("Y: " + String.valueOf(y - 500), (int) x + 10, (int) y - 30);
            g.drawString("Status: " + Status, (int) x + 10, (int) y - 40);
            aviao(aviaoX, aviaoY, g, Status, cor);
            //AviaoTest(aviaoX, aviaoY, g, Color.GREEN);
        }

    }

    public void trajetoAZ0032(int contadorAZ1) {
        if (contadorViaoAz1 >= 0) {
            AZ0032X = Xaz0032[contadorViaoAz1];
            AZ0032Y = Yaz0032[contadorViaoAz1];
            AZ0032S = Saz0032[contadorViaoAz1];
            //System.out.println(Saz0032[contadorViaoAz1]);
            repaint();
            System.out.println(contadorViaoAz1);
            if (contadorViaoAz1 > 0) {
                contadorViaoAz1--;
            }

        }
        contadorAZ1 = 0;
    }

    public void trajetoGZ0331(int contadorGZ1) {
        if (contadorViaoGz1 >= 0) {
            GZ0331X = Xgz0331[contadorViaoGz1];
            GZ0331Y = Ygz0331[contadorViaoGz1];
            GZ0331S = Sgz0331[contadorViaoGz1];
            //System.out.println(Sgz0331[contadorViaoGz1]);
            repaint();
            if (contadorViaoGz1 > 0) {
                contadorViaoGz1--;
            }
        }
        contadorGZ1 = 0;

    }

    public void trajetoAZ0157(int contadorAZ2) {
        if (contadorViaoAz2 >= 0) {
            AZ0157X = Xaz0157[contadorViaoAz2];
            AZ0157Y = Yaz0157[contadorViaoAz2];
            AZ0157S = Saz0157[contadorViaoAz2];
            repaint();
            if (contadorViaoAz2 > 0) {
                contadorViaoAz2--;
            }

        }
        contadorAZ2 = 0;
    }

    public void trajetoGZ0667(int contadorGZ2) {
        if (contadorViaoGz2 >= 0) {
            GZ0667X = Xgz0667[contadorViaoGz2];
            GZ0667Y = Ygz0667[contadorViaoGz2];
            GZ0667S = Sgz0667[contadorViaoGz2];
            repaint();
            if (contadorViaoGz2 > 0) {
                contadorViaoGz2--;
            }
        }
        contadorGZ2 = 0;
    }

    public void trajetoLA2203(int contadorLA) {
        if (contadorViaoLA >= 0) {
            LA2203X = Xla2203[contadorViaoLA];
            LA2203Y = Yla2203[contadorViaoLA];
            LA2203S = Sla2203[contadorViaoLA];
            repaint();

            if (contadorViaoLA > 0) {
                contadorViaoLA--;
            }
        }
        contadorLA = 0;
    }

    public void StatusString() {
        String x;
        int i = 0;

        for (LA2203 info : la2203) {
            x = info.getStatus();
            Sla2203[i] = x.charAt(0);
            i++;
        }

        i = 0;
        for (GZ0331 info : gz0331) {
            x = info.getStatus();
            Sgz0331[i] = x.charAt(0);
            i++;

        }

        i = 0;
        for (AZ0032 info : az0032) {
            x = info.getStatus();
            Saz0032[i] = x.charAt(0);
            i++;
        }

        i = 0;
        for (AZ0157 info : az0157) {
            x = info.getStatus();
            Saz0157[i] = x.charAt(0);
            i++;
        }

        i = 0;
        for (GZ0667 info : gz0667) {
            x = info.getStatus();
            Sgz0667[i] = x.charAt(0);
            i++;
        }

    }

    public void calcX() {
        int x;
        int i = 0;

        for (LA2203 info : la2203) {
            x = (fzinho * info.getX()) / (Fzao - info.getZ());
            Xla2203[i] = x;
            i++;
        }

        i = 0;
        for (GZ0331 info : gz0331) {

            x = (fzinho * info.getX()) / (Fzao - info.getZ());
            Xgz0331[i] = x;
            i++;

        }

        i = 0;
        for (AZ0032 info : az0032) {
            x = (fzinho * info.getX()) / (Fzao - info.getZ());
            Xaz0032[i] = x;
            i++;
        }

        i = 0;
        for (AZ0157 info : az0157) {
            x = (fzinho * info.getX()) / (Fzao - info.getZ());
            Xaz0157[i] = x;
            i++;
        }

        i = 0;
        for (GZ0667 info : gz0667) {
            x = (fzinho * info.getX()) / (Fzao - info.getZ());
            Xgz0667[i] = x;
            i++;
        }

    }

    public void calcY() {
        int y;
        int i = 0;

        for (LA2203 info : la2203) {
            y = (fzinho * info.getY()) / (Fzao - info.getZ());
            Yla2203[i] = y;
            i++;
        }

        i = 0;
        for (GZ0331 info : gz0331) {

            y = (fzinho * info.getY()) / (Fzao - info.getZ());
            Ygz0331[i] = y;
            i++;

        }

        i = 0;
        for (AZ0032 info : az0032) {
            y = (fzinho * info.getY()) / (Fzao - info.getZ());
            Yaz0032[i] = y;
            i++;
        }

        i = 0;
        for (AZ0157 info : az0157) {
            y = (fzinho * info.getY()) / (Fzao - info.getZ());
            Yaz0157[i] = y;
            i++;
        }

        i = 0;
        for (GZ0667 info : gz0667) {
            y = (fzinho * info.getY()) / (Fzao - info.getZ());
            Ygz0667[i] = y;
            i++;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            fzinho = fzinho + 100;
            calcY();
            calcX();
            repaint();

            if (contadorViaoLA == 0) {
                AZ0032X = Xaz0032[0];
                AZ0032Y = Yaz0032[0];
                AZ0157X = Xaz0157[0];
                AZ0157Y = Yaz0157[0];
                GZ0331X = Xgz0331[0];
                GZ0331Y = Ygz0331[0];
                GZ0667X = Xgz0667[0];
                GZ0667Y = Ygz0667[0];
                LA2203X = Xla2203[0];
                LA2203Y = Yla2203[0];
                repaint();

            }

        } else {
            if (fzinho > 0) {
                fzinho = fzinho - 100;
                calcY();
                calcX();
                repaint();
                if (contadorViaoLA == 0) {
                    AZ0032X = Xaz0032[0];
                    AZ0032Y = Yaz0032[0];
                    AZ0157X = Xaz0157[0];
                    AZ0157Y = Yaz0157[0];
                    GZ0331X = Xgz0331[0];
                    GZ0331Y = Ygz0331[0];
                    GZ0667X = Xgz0667[0];
                    GZ0667Y = Ygz0667[0];
                    LA2203X = Xla2203[0];
                    LA2203Y = Yla2203[0];
                    repaint();

                }
            }

        }

    }

}

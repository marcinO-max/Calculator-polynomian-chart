import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Painter extends JPanel {
    static HashMap<Integer,Integer> punkty= new HashMap<>();
    static int ilePunktow;
    static int tabx[]= new int[ilePunktow];
    static int tabY[] = new int[ilePunktow];
    static Integer a,b,c,d;


    public Painter(Integer aa, Integer bb, Integer cc, Integer dd){
        this.setVisible(true);
        a=aa;
        b=bb;
        c=cc;
        d=dd;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(0, (d - c) / 2, getWidth(), (d - c) / 2);   //rysuje os X
            g.drawLine((b - a) / 2, 0, (b - a) / 2, getHeight()); //rysuje os Y
            g.setColor(Color.BLUE);

            for (int i = -ilePunktow / 2; i < ilePunktow; i++) {
                Integer liczbaX = i + (b - c) / 2;
                Integer liczbaY = (d - c) / 2;
                tabx[i + ilePunktow / 2] = liczbaX;
                tabY[i + ilePunktow / 2] = liczbaY;

                punkty.put(liczbaX + 8, liczbaY + 30);  // przesuniecie, pierwszy piksel na pozycji(8,30)
                System.out.println(punkty.get(liczbaX));
            }
                g.drawPolyline(tabx, tabY, ilePunktow);

        }
    }




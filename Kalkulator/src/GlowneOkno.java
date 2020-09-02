import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GlowneOkno extends JFrame {


PanelWszystkichWielomianow pww = new PanelWszystkichWielomianow();
Painter p;
int xpoczatek,xkoniec,ypoczatek,ykoniec;

    public GlowneOkno(){

setResizable(false);
        setSize(600,800);
        setLayout(new GridLayout(1,3));
        JTabbedPane jtb1 = new JTabbedPane();

        Kalkulator pusty = new Kalkulator();
        xpoczatek=0;
        xkoniec=getHeight()/2;
        ypoczatek=0;
        ykoniec=getWidth()/2;
         p = new Painter(getHeight()/2,1000,getWidth()/2,1000);
        jtb1.addTab("Wykres",p);
        jtb1.addTab("Graficzny",pusty);
        jtb1.addTab("Tekstowy" ,pww);
        add(jtb1);




        setVisible(true);
        setDefaultCloseOperation(3);
    }

}

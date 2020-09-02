import com.sun.deploy.panel.JreTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelWszystkichWielomianow extends JPanel {

    JButton dodajbutton = new JButton("DODAJ");
    JButton usunbutton = new JButton("USUN");
    PanelWszystkichWielomianow tenpanel = this;
    ArrayList<PanelWielomianu> wszystkiePaneleWielomianu = new ArrayList<>();


    public PanelWszystkichWielomianow(){
      //  setSize(400,500);
        setBorder(BorderFactory.createBevelBorder(0));
        setLayout(new GridLayout(5,1));

        JPanel guziki = new JPanel();

        guziki.setLayout(new GridLayout(1,2));
        guziki.add(dodajbutton);
        guziki.add(usunbutton);

        add(BorderLayout.PAGE_START,guziki);





        usunbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<wszystkiePaneleWielomianu.size();i++){
                    if(wszystkiePaneleWielomianu.get(i).czyDoUsunieciaCheckbox.isSelected()){
                        tenpanel.remove(wszystkiePaneleWielomianu.get(i));
                        wszystkiePaneleWielomianu.remove(i);
                        i--;
                    }

                }

                SwingUtilities.updateComponentTreeUI(tenpanel);
            }
        });


        dodajbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelWielomianu temp = new PanelWielomianu();
                tenpanel.add(temp);
                wszystkiePaneleWielomianu.add(temp);
                SwingUtilities.updateComponentTreeUI(tenpanel);
            }
        });

    }

}

import com.sun.webkit.ColorChooser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelWielomianu extends JPanel {


   static JTextArea polewielomianu = new JTextArea();
    ArrayList<Punkt> punkty = new ArrayList<>();
    JCheckBox czyAktywnyCheckbox = new JCheckBox();
    JCheckBox czyDoUsunieciaCheckbox = new JCheckBox();
    Color mojkolor = Color.BLACK;
    static JColorChooser jcc = new JColorChooser();

    public PanelWielomianu(){
       setBorder(BorderFactory.createBevelBorder(0));
        setLayout(new GridLayout(1,2));
        JPanel guzikiikolor = new JPanel();
        guzikiikolor.setLayout(new GridLayout(1,2));
        JPanel guziki = new JPanel();
        guziki.setLayout(new GridLayout(2,1));

        JLabel czyAktywnyJLabel = new JLabel("Czy wyswietlany: ");
        JLabel czyDoUsunieciaJLabel = new JLabel("Zaznaczenie: ");

        guziki.add(czyAktywnyJLabel);
        guziki.add(czyAktywnyCheckbox);
        guziki.add(czyDoUsunieciaJLabel);
        guziki.add(czyDoUsunieciaCheckbox);
        JButton wybierzKolorButton = new JButton("KOLOR");


        wybierzKolorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mojkolor=jcc.showDialog(null,"Wybierz kolor",Color.BLACK);
                wybierzKolorButton.setBackground(mojkolor);
            }
        });


        add(polewielomianu);
        guzikiikolor.add(guziki);
        guzikiikolor.add(wybierzKolorButton);
        add(guzikiikolor);


czyAktywnyCheckbox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      if(czyAktywnyCheckbox.isSelected()) {
          punkty.clear();
          countPoints(100);

      }

    }
}

);


    }

    public boolean validateWielomian(){
        String wielomian = polewielomianu.getText();

        for(int i=0;i<wielomian.length();i++){
            if(Character.isLetter(wielomian.charAt(i))){
                return false;
            }
        }
        return true;

    }

    public int countY(int x) throws ScriptException {
        int wynik=0;
        try {

            String temp = polewielomianu.getText();
            String budowanie = "";
            String budowaniefinal="";
            int counter = 1;


            //dodawanie mnozenia
for(int i=0;i<temp.length();i++){

    if(temp.charAt(i)=='x'){

        if(i==0){
            budowanie+=x;
            continue;
        }
        if(Character.isDigit(temp.charAt(i-1))){
            budowanie+="*"+x;
        }else{
            budowanie+=x;
        }


    }else{
        budowanie+=temp.charAt(i);
    }
}




//zamiana na potegi

String[] tablica = budowanie.split("\\+");
for(int i=0;i<tablica.length;i++){
    if(tablica[i].contains("^")){
        int potega = Integer.parseInt(tablica[i].split("\\^")[1]);
        for(int j=0;j<potega;j++){
            if(j==potega-1){
                budowaniefinal+=x;
            }else {
                budowaniefinal += x + "*";
            }
        }


    }else{
        budowaniefinal+=tablica[i]+"+";
    }
}


            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("cos");
            wynik=(int)engine.eval(budowaniefinal);


        } catch (ScriptException se) {
            System.out.println(se);
        }

        return wynik;
    }


    public void countPoints(int ilePunktow){
        for(int i=0;i<ilePunktow;i++){
            try {
                punkty.add(new Punkt(i,countY(i)));

            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }

    }






}

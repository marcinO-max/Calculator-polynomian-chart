import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JPanel implements ActionListener {
    double a,b,result;
    int operator;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b0;
    JButton clear;
    JButton dodawanie;
    JButton rowny;
    JButton odejmowanie;
    JButton mnozenie;
    JButton dzielenie;
    JButton pierwiastek;
    JButton potega;
    JButton kropka;
    JTextField jtf;

    public Kalkulator(){
        setLayout(new GridLayout(2,1));
        JPanel wprowadzanie = new JPanel();
        JPanel liczby = new JPanel();
        jtf = new JTextField();
        add(jtf);

        liczby.setLayout(new GridLayout(6,3));





        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        clear = new JButton("c");
        dodawanie = new JButton("+");
        rowny = new JButton("=");
        odejmowanie = new JButton("-");
        mnozenie = new JButton("*");
        dzielenie = new JButton("/");
        pierwiastek = new JButton("sqrt");
        potega = new JButton("^");
        kropka = new JButton(".");


        liczby.add(b1);
        liczby.add(b2);
        liczby.add(b3);
        liczby.add(b4);
        liczby.add(b5);
        liczby.add(b6);
        liczby.add(b7);
        liczby.add(b8);
        liczby.add(b9);
        liczby.add(b0);
        liczby.add(rowny);
        liczby.add(dodawanie);
        liczby.add(odejmowanie);
        liczby.add(mnozenie);
        liczby.add(dzielenie);
        liczby.add(potega);
        liczby.add(pierwiastek);
        liczby.add(clear);
        liczby.add(kropka);

        add(liczby);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        dodawanie.addActionListener(this);
        odejmowanie.addActionListener(this);
        rowny.addActionListener(this);
        mnozenie.addActionListener(this);
        dzielenie.addActionListener(this);
        clear.addActionListener(this);
        kropka.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
            jtf.setText(jtf.getText().concat("1"));

        if(e.getSource()==b2)
            jtf.setText(jtf.getText().concat("2"));

        if(e.getSource()==b3)
            jtf.setText(jtf.getText().concat("3"));

        if(e.getSource()==b4)
            jtf.setText(jtf.getText().concat("4"));

        if(e.getSource()==b5)
            jtf.setText(jtf.getText().concat("5"));

        if(e.getSource()==b6)
            jtf.setText(jtf.getText().concat("6"));

        if(e.getSource()==b7)
            jtf.setText(jtf.getText().concat("7"));

        if(e.getSource()==b8)
            jtf.setText(jtf.getText().concat("8"));

        if(e.getSource()==b9)
            jtf.setText(jtf.getText().concat("9"));

        if(e.getSource()==b0)
            jtf.setText(jtf.getText().concat("0"));

        if(e.getSource()==kropka)
            jtf.setText(jtf.getText().concat("."));


        if(e.getSource()==dodawanie)
        {
            a=Double.parseDouble(jtf.getText());
            operator=1;
            jtf.setText("");
        }

        if(e.getSource()==odejmowanie)
        {
            a=Double.parseDouble(jtf.getText());
            operator=2;
            jtf.setText("");
        }

        if(e.getSource()==mnozenie)
        {
            a=Double.parseDouble(jtf.getText());
            operator=3;
            jtf.setText("");
        }

        if(e.getSource()==dzielenie)
        {
            a=Double.parseDouble(jtf.getText());
            operator=4;
            jtf.setText("");
        }

        if(e.getSource()==rowny)
        {
            b=Double.parseDouble(jtf.getText());

            switch(operator)
            {
                case 1: result=a+b;
                    break;

                case 2: result=a-b;
                    break;

                case 3: result=a*b;
                    break;

                case 4: result=a/b;
                    break;


                default: result=0;
            }

            jtf.setText(""+result);
        }

        if(e.getSource()==clear)
            jtf.setText("");


    }
}


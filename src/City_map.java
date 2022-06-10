import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;

import static java.lang.Integer.parseInt;

public class City_map extends JFrame implements ActionListener {

    JPanel menu = new JPanel();
    JPanel mapa = new JPanel();
    int size_x = 30;
    int size_y = 30;
    JPanel[][] panels = new JPanel[size_x][size_y];

    JTextField[] in = new JTextField[12];
    JLabel[] out = new JLabel[12];
    JButton[] buttons = new JButton[2];
    boolean run = false;
    static int[] dane = new int[15];
    JButton buuton = new JButton();

    City_map() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        menu.setLayout(new GridLayout(26,1,0,5));
        mapa.setLayout(new GridLayout(size_x, size_y, 2, 2));
        //mapa.setBounds(10,10,800,400);
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.gray);
                mapa.add(panels[i][j]);
            }
        }

        for(int i=0;i<12;i++){
            out[i] = new JLabel();
            in[i] = new JTextField();
            out[i].setHorizontalAlignment(JLabel.CENTER);
        }
        out[0].setText("Podaj liczbe policjantow");
        out[1].setText("Podaj liczbe drifterów");
        out[2].setText("Podaj liczbe Zwykłych kierowców");
        out[3].setText("Mnimalna ilość kanistrów");
        out[4].setText("Maksymalna ilość kanistrów");
        out[5].setText("Minimalna ilość opon");
        out[6].setText("Maksymalna ilość opon");
        out[7].setText("Minmalna ilość chleba");
        out[8].setText("Maksymalna ilość chleba");
        out[9].setText("Minimalna ilość cukierków");
        out[10].setText("Maksymalna ilość cukierków");
        out[11].setText("Ilość fotoradarów");





        for(int i=0;i<12;i++){
            in[i].setPreferredSize(new Dimension(30,20));
            menu.add(out[i]);
            menu.add(in[i]);
        }


        buttons[0] = new JButton();
        buttons[0].addActionListener(this);
        buttons[1] = new JButton();
        buttons[1].addActionListener(this);
        buttons[0].setText("Zatwierdź i wystartuj");
        buttons[1].setText("Resetuj i zapisz do pliku");



        menu.setPreferredSize(new Dimension(200,1000));
        this.add(mapa,BorderLayout.CENTER);
        this.add(menu,BorderLayout.WEST);

        menu.add(buttons[0]);
        menu.add(buttons[1]);





        this.setVisible(true);

        Random random = new Random();

        System.out.println(random.nextInt(100));



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int k=0;
        char[] chars;
        StringBuilder sb;
        String text;
        if(e.getSource()==buttons[0]) {
            for (int i = 0; i < 12; i++) {
                sb = new StringBuilder();
                if(!Objects.equals(in[i].getText(), "")){
                chars = in[i].getText().toCharArray();
                System.out.println("chars: "+ Arrays.toString(chars));
                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }text = String.valueOf(sb);
                System.out.println("text"+text);
                if(!Objects.equals(text, "")){
                    dane[i] = parseInt(text);
                    in[i].setEditable(false);
                    k+=1;
                }
            }else{
                k+=1;
                in[i].setEditable(false);
                dane[i] = 0;
                }
            }
            if(k==12){
                run = true;
                buttons[0].setEnabled(false);
                buttons[1].setEnabled(true);
            }
        }else if(e.getSource()==buttons[1]){
            run = false;
            buttons[0].setEnabled(true);
            buttons[1].setEnabled(false);
            for(int i=0;i<12;i++){
                in[i].setEditable(true);
            }

        }

    }
}



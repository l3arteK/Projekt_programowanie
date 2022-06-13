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
    JPanel legenda = new JPanel();
    JPanel[] elementy_legendy = new JPanel[9];
    JLabel[] tekst_legendy = new JLabel[10];
    int size_x;
    int size_y;

    JTextField[] in = new JTextField[14];
    JLabel[] out = new JLabel[14];
    JButton[] buttons = new JButton[2];
    boolean run = false;
    static int[] dane = new int[15];
    JPanel[] box = new JPanel[9];
    JPanel[][] panels;
    void tworzenie_mapy(int x, int y){
         panels = new JPanel[x][y];
        mapa.setLayout(new GridLayout(x, y, 2, 2));
        size_y = y;
        size_x = x;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.gray);
                mapa.add(panels[i][j]);
            }
        }
        this.add(mapa,BorderLayout.CENTER);
        this.revalidate();
    }
    City_map() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLayout(new BorderLayout());

        menu.setLayout(new GridLayout(30,1,0,5));
        legenda.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
        legenda.setPreferredSize(new Dimension(120,this.getHeight()));
        menu.setPreferredSize(new Dimension(this.getWidth()/4,this.getHeight()));

        //#TWORZENIE LEGENDY
        tekst_legendy[9] = new JLabel();
        tekst_legendy[9].setText("LEGENDA");
        tekst_legendy[9].setFont(new Font("Serif",Font.BOLD,15));
        legenda.add(tekst_legendy[9]);

        for(int i=0;i<9;i++){
            box[i] = new JPanel();
            box[i].setLayout(new FlowLayout(FlowLayout.CENTER,40,0));
            box[i].setPreferredSize(new Dimension(120,40));
            elementy_legendy[i] = new JPanel();
            tekst_legendy[i] = new JLabel();
            elementy_legendy[i].setPreferredSize(new Dimension(20,20));
            box[i].add(elementy_legendy[i]);
            box[i].add(tekst_legendy[i]);
            legenda.add(box[i]);
        }

        elementy_legendy[0].setBackground(Color.gray);
        tekst_legendy[0].setText("Puste pole");
        elementy_legendy[1].setBackground(Color.cyan);
        tekst_legendy[1].setText("Zwykły kierowca");
        elementy_legendy[2].setBackground(Color.black);
        tekst_legendy[2].setText("Drifter");
        elementy_legendy[3].setBackground(Color.green);
        tekst_legendy[3].setText("Dobry chłopak");
        elementy_legendy[4].setBackground(Color.blue);
        tekst_legendy[4].setText("Policja");
        elementy_legendy[5].setBackground(Color.red);
        tekst_legendy[5].setText("Kanister");
        elementy_legendy[6].setBackground(Color.magenta);
        tekst_legendy[6].setText("Fotoradar");
        elementy_legendy[7].setBackground(Color.yellow);
        tekst_legendy[7].setText("Cukierki");
        elementy_legendy[8].setBackground(Color.darkGray);
        tekst_legendy[8].setText("Opony");

        //#TWORZENIE MENU
        for(int i=0;i<14;i++){
            out[i] = new JLabel();
            in[i] = new JTextField();
            out[i].setHorizontalAlignment(JLabel.CENTER);
        }

        out[0].setText("Rozmiar mapy w pionie");
        out[1].setText("Rozmiar mapy w poziomie");
        out[2].setText("Podaj liczbe policjantow");
        out[3].setText("Podaj liczbe drifterów");
        out[4].setText("Podaj liczbe Zwykłych kierowców");
        out[5].setText("Mnimalna ilość kanistrów");
        out[6].setText("Maksymalna ilość kanistrów");
        out[7].setText("Minimalna ilość opon");
        out[8].setText("Maksymalna ilość opon");
        out[9].setText("Minmalna ilość chleba");
        out[10].setText("Maksymalna ilość chleba");
        out[11].setText("Minimalna ilość cukierków");
        out[12].setText("Maksymalna ilość cukierków");
        out[13].setText("Ilość fotoradarów");

        for(int i=0;i<14;i++){
            //in[i].setPreferredSize(new Dimension(30,20));
            menu.add(out[i]);
            menu.add(in[i]);
        }

        //#TWORZENIE PRZYCISKOW
        buttons[0] = new JButton();
        buttons[0].addActionListener(this);
        buttons[1] = new JButton();
        buttons[1].addActionListener(this);
        buttons[0].setText("Zatwierdź i wystartuj");
        buttons[1].setText("Resetuj i zapisz do pliku");



        menu.setPreferredSize(new Dimension(200,1000));
        this.add(menu,BorderLayout.WEST);
        this.add(legenda,BorderLayout.EAST);

        menu.add(buttons[0]);
        menu.add(buttons[1]);


        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int k=0;
        char[] chars;
        StringBuilder sb;
        String text;
        if(e.getSource()==buttons[0]) {
            for (int i = 0; i < 14; i++) {
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
                }else if(i>=2){
                    k+=1;
                    in[i].setEditable(false);
                    dane[i] = 0;
                }
            }
            if(k==14){
                tworzenie_mapy(dane[0],dane[1]);
                buttons[0].setEnabled(false);
                buttons[1].setEnabled(true);
                run = true;
            }
        }else if(e.getSource()==buttons[1]){
            run = false;
            buttons[0].setEnabled(true);
            buttons[1].setEnabled(false);
            for(int i=0;i<14;i++){
                in[i].setEditable(true);
            }

        }

    }
}



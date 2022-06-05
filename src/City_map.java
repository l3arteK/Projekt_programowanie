import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
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

    JTextField[] in = new JTextField[3];
    JLabel[] out = new JLabel[3];
    JButton[] buttons = new JButton[2];
    boolean run = false;
    static int[] dane = new int[10];
    JButton buuton = new JButton();
    String daaaneee;

    City_map() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(new BorderLayout());
        menu.setLayout(new GridLayout(10,1,0,5));
        mapa.setLayout(new GridLayout(size_x, size_y, 2, 2));
        //mapa.setBounds(10,10,800,400);
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.gray);
                mapa.add(panels[i][j]);
            }
        }

        for(int i=0;i<3;i++){
            out[i] = new JLabel();
            in[i] = new JTextField();
            out[i].setHorizontalAlignment(JLabel.CENTER);
        }
        out[0].setText("Podaj liczbe policjantow");
        out[1].setText("Podaj liczbe drifterów");
        out[2].setText("Podaj liczbe Zwykłych kierowców");





        for(int i=0;i<3;i++){
            in[i].setPreferredSize(new Dimension(30,20));
            menu.add(out[i]);
            menu.add(in[i]);
        }


        buttons[0] = new JButton();
        buttons[0].addActionListener(this);
        buttons[1] = new JButton();
        buttons[1].addActionListener(this);
        buttons[0].setText("Zatwierdź i wystartuj");
        buttons[1].setText("Reset");



        menu.setMaximumSize(new Dimension(50,50));
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
        if(e.getSource()==buttons[0]){
            buttons[0].setEnabled(false);
            for(int i=0;i<3;i++){
                dane[i] = Integer.parseInt(in[i].getText());
                System.out.println("Daaane z mapyy"+dane[i]);
                in[i].setEditable(false);
            }
            run = true;
        }else if(e.getSource()==buttons[1]){

        }

    }
}



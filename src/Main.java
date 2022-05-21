
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Main {
    static JFrame frame = new JFrame();
    public static void main(String[] args) throws InterruptedException {
        //frame.setLayout(new GridLayout(10,10,1,1));


        ArrayList<Drivers> drivers = new ArrayList<>();
        ArrayList<Objects> objects = new ArrayList<>();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(10,10,2,2));
        //frame.setVisible(true);
        JPanel[][] panels = new JPanel[10][10];
        //Jlabel label = new JLabel();
        for(int i=0; i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                //JPanel panel =
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.gray);
                //panel.setBounds(j*80,i*80,78,78);
                //panels[i][j] = panel;
                frame.add(panels[i][j]);
            }
        }
        frame.setVisible(true);

        JPanel test = new JPanel();
        test.setBackground(Color.green);
        //frame.add(test);

        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        System.out.println("x: "+x+"y: "+y);



        for(;;){
            panels[x][y].setBackground(Color.BLUE);
            TimeUnit.SECONDS.sleep(1);
            panels[x][y].setBackground(Color.gray);
            switch (rand.nextInt(4)){
                case 0:
                    if(x<9){x=x+1;}
                    //System.out.println(0);
                    break;
                case 1:
                    if(y<9){y=y+1;}
                    //.out.println(0);
                    break;
                case 2:
                    if(y>1){y=y-1;}
                   // System.out.println(0);
                    break;

                case 3:
                    if(x>1){x=x-1;}
                   // System.out.println(0);
                    break;
            }

        }



    }

}
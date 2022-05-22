import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class City_map {

    JFrame frame = new JFrame();
    int size_x = 10;
    int size_y = 10;
    JPanel[][] panels = new JPanel[size_x][size_y];

    City_map() {
        //try {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setLayout(new GridLayout(size_x, size_y, 2, 2));
            for (int i = 0; i < size_x; i++) {
                for (int j = 0; j < size_y; j++) {
                    panels[i][j] = new JPanel();
                    panels[i][j].setBackground(Color.gray);
                    frame.add(panels[i][j]);
                }
            }
            frame.setVisible(true);

            Random rand = new Random();
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);

        /*

        for(;;){
            panels[x][y].setBackground(Color.BLUE);
            TimeUnit.SECONDS.sleep(1);
            panels[x][y].setBackground(Color.gray);
            switch (rand.nextInt(4)){
                case 0:
                    if(x<9){x=x+1;}
                    break;
                case 1:
                    if(y<9){y=y+1;}
                    break;
                case 2:
                    if(y>1){y=y-1;}
                    break;

                case 3:
                    if(x>1){x=x-1;}
                    break;
            }

        }

    } catch (Exception e){
        e.printStackTrace();}

         */
        }


    }



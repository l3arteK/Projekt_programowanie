import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class City_map {

    JFrame frame = new JFrame();
    int size_x = 3;
    int size_y = 3;
    JPanel[][] panels = new JPanel[size_x][size_y];

    City_map() {
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

        }
        //int collision(){



      //  }


    }



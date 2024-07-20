package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FromTest extends JDialog{
    private JPanel TestPanel;
    private JLabel ok;

    public FromTest(){
        try {
            URL url = new URL("https://th.bing.com/th/id/R.5d81e5ecce3463062c81332c84b0780e?rik=qqp0UWhXTlLH7g&riu=http%3a%2f%2fupload.wikimedia.org%2fwikipedia%2fcommons%2fa%2fa4%2fDome_tent.JPG&ehk=mJIVTSm2UA%2fYOBPzvel40rG%2fG2i8P4ifU6X0p4yYUGk%3d&risl=&pid=ImgRaw&r=0");
            ok.setIcon(new ImageIcon(ImageIO.read(url)));
        }catch (Exception e) {
            System.err.println("dhdhd");
        }

        add(TestPanel);

        setTitle("ok");
        setMinimumSize(new Dimension(450,575));
        setModal(true);

        setVisible(true);
    }

}

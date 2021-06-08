package core;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Muhammad
 * This class has a static method "play()" which is called when login credentials are authenticated.
 * The player can choose which level of game he/she wants to play
 * There are buttons for viewing "Guide menu" and "How to play" as well
 *
 */
public class level_menu  {
    private JFrame frame;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    level_menu window = new level_menu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public level_menu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

//This is the default page for selection of level and navigation buttons to open new page fro viewing the guide menu
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(0, 0, 600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("AntVsSomeBees Menu");


        JButton btnPlay = new JButton("Play Game");
        btnPlay.setForeground(Color.red);
        Font newButtonFont=new Font(btnPlay.getFont().getName(),btnPlay.getFont().getStyle(),16);
        btnPlay.setFont(newButtonFont);
        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                AntsVsSomeBees.playGame();
                frame.dispose();
            }
        });

        JButton GuideMenu = new JButton("Guide Menu");
        GuideMenu.addActionListener(e -> {
            System.out.println("hi");
            openGuideMenuFrame();
            

        });

        JLabel lblLevel = new JLabel("SELECT LEVEL :");

        // initialize game with level 0 that is easy level
        JRadioButton radioEasy = new JRadioButton("Easy");
        radioEasy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 0;
            }
        });

        // initialize game with level 1 that is medium level
        JRadioButton radioMedium = new JRadioButton("Medium");
        radioMedium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 1;
            }
        });

        // initialize game with level 2 that is hard level
        JRadioButton radioHard = new JRadioButton("Hard");
        radioHard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 2;
            }
        });

        JRadioButton radioPro = new JRadioButton("Insane");
        radioPro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 3;
            }
        });


        JButton gameExplaination = new JButton("How to play");
        gameExplaination.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openHowToPlayFrame();
            }
        });
            GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(lblLevel)
					.addContainerGap(317, Short.MAX_VALUE))
                    .addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(radioPro)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(GuideMenu)
							.addGap(68))
                            .addComponent(gameExplaination)
                    .addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(radioHard)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(radioEasy)
										.addComponent(radioMedium))
                    .addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
									.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())))
                    );
		groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblLevel)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(73))
                    .addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(radioEasy)
							.addGap(28)
							.addComponent(radioMedium)
							.addGap(30)
							.addComponent(radioHard)
                            .addGap(20)
                            .addComponent(radioPro)))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(GuideMenu)
                        .addComponent(gameExplaination)
						.addComponent(radioPro))
                    .addGap(19))
                    );
		frame.getContentPane().setLayout(groupLayout);
        }
        // loads guide menu images and adds to a new frame
    //@author Muhammad
    public static void openGuideMenuFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("Guide Menu");

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);
                //TextArea textArea = new JTextArea(15, 50);
                Image myPicture = null;
                try {
                    myPicture = ImageIO.read(new File("img/guide_menu.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                panel.add(picLabel);
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(true);

            }
        });
    }

    // laods a new frame and attaches gui_explaination image to it
    //@author Muhammad
    public static void openHowToPlayFrame() {
        JFrame frame = new JFrame("How to Play");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        //TextArea textArea = new JTextArea(15, 50);
        Image myPicture = null;
        try {
            myPicture = ImageIO.read(new File("img/gui_explanation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        panel.add(picLabel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(true);
    }

}

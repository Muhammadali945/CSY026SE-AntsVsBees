package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;




public class level_menu {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnPlay = new JButton("Play");
        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                AntsVsSomeBees.playGame();
            }
        });

        JButton lblPlugYourHeadphones = new JButton("Guide Menu");

        JLabel lblLevel = new JLabel("LEVEL :");

        JRadioButton radioEasy = new JRadioButton("Easy");
        radioEasy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 0;
            }
        });

        JRadioButton radioMedium = new JRadioButton("Medium");
        radioMedium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AntsVsSomeBees.level = 1;
            }
        });

        JRadioButton radioHard = new JRadioButton("Hard");
        radioHard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //core.AntsVsSomeBees.level = 2;
            }
        });

        JRadioButton radioPro = new JRadioButton("Insane");
        radioPro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //core.AntsVsSomeBees.level = 3;
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
							.addComponent(lblPlugYourHeadphones)
							.addGap(68))
                    .addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(radioHard)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(radioEasy)
										.addComponent(radioMedium))
                    .addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
									.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
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
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(73))
                    .addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(radioEasy)
							.addGap(28)
							.addComponent(radioMedium)
							.addGap(30)
							.addComponent(radioHard)
							.addGap(28)))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlugYourHeadphones)
						.addComponent(radioPro))
                    .addGap(19))
                    );
		frame.getContentPane().setLayout(groupLayout);
        }
}
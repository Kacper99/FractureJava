import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Window for the game and shows the UI
 */
public class FFrame extends JFrame {

    Fracture game;
    PlayersFrame pf;

    public static void main(String[] args) {
        new FFrame();
    }

    public FFrame() {
        super("Fracture Drinking Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,400);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        try {
            game = new Fracture();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        pf = new PlayersFrame(game);

        //Game scene
        JPanel gamePanel = new JPanel(new GridBagLayout());
        gamePanel.setBackground(Color.ORANGE);

        JLabel challengeText = new JLabel("Challenge");
        challengeText.setFont(new Font("font", Font.BOLD, 30));

        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                challengeText.setText("<html>" + game.getNextChallenge() + "</html>");
            }
        });

        gamePanel.addKeyListener(new KeyAdapter() { //TODO: Fix the key listener
            @Override
            public void keyPressed(KeyEvent e) {
                if  (e.getKeyChar() == 'n')
                    challengeText.setText("<html>" + game.getNextChallenge() + "</html>");

            }
        });
        //Add names button
        JButton addNamesButton = new JButton("Add names");
        addNamesButton.addActionListener(e -> {
            pf.setVisible(true);
        });

        //Add all elements
        gamePanel.add(challengeText);
        c.add(gamePanel, BorderLayout.CENTER);
        c.add(addNamesButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;

/**
 * Window for the game and shows the UI
 */
public class FFrame extends JFrame {

    public FFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        //Game scene
        JPanel gamePanel = new JPanel(new GridBagLayout());
        gamePanel.setBackground(Color.ORANGE);
        JLabel challengeText = new JLabel("Challenge");
        challengeText.setFont(new Font("font", Font.BOLD, 18));

        //Add names button
        JButton addNamesButton = new JButton("Add names");

        //Add all elements
        gamePanel.add(challengeText);
        c.add(gamePanel, BorderLayout.CENTER);
        c.add(addNamesButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}

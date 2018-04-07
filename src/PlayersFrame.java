import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayersFrame extends JFrame{

    public PlayersFrame() {
        super("Add or remove players");
        this.setVisible(true);

        this.setSize(300,500);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        //Title
        c.add(new JLabel("Enter the player names"), BorderLayout.NORTH);

        //Player name area
        JPanel namesList = new JPanel(new GridLayout(8,1)); //TODO: CHANGE THIS
        for (int i = 0; i < 8; i++) {
            namesList.add(new NameInputBox(i + 1));
        }

        //Submit button
        JButton submitButton = new JButton("Submit names");

        c.add(namesList, BorderLayout.CENTER);
        c.add(submitButton, BorderLayout.SOUTH);

        this.pack();
    }

    public ArrayList<String> getPlayers() {
        ArrayList<String> players = new ArrayList<>();

        return players;
    }
}

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
        JPanel namesBoxGUI = new JPanel(new GridLayout(8,1)); //TODO: CHANGE THIS
        ArrayList<NameInputBox> nameBoxes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            NameInputBox nameInput = new NameInputBox(i + 1);
            nameBoxes.add(nameInput);
            namesBoxGUI.add(nameInput);
        }

        //Submit button
        JButton submitButton = new JButton("Submit names");

        c.add(namesBoxGUI, BorderLayout.CENTER);
        c.add(submitButton, BorderLayout.SOUTH);

        this.pack();
    }

    public ArrayList<String> getPlayers() {
        ArrayList<String> players = new ArrayList<>();

        return players;
    }
}

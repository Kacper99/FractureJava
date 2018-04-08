import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayersFrame extends JFrame{

    ArrayList<NameInputBox> nameBoxes;

    public PlayersFrame(Fracture game) {
        super("Add or remove players");
        //this.setVisible(true);

        this.setSize(300,500);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        //Title
        c.add(new JLabel("Enter the player names"), BorderLayout.NORTH);

        //Player name area
        JPanel namesBoxGUI = new JPanel(new GridLayout(8,1)); //TODO: CHANGE THIS
        nameBoxes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            NameInputBox nameInput = new NameInputBox(i + 1);
            nameBoxes.add(nameInput);
            namesBoxGUI.add(nameInput);
        }

        //Submit button
        JButton submitButton = new JButton("Submit names");
        submitButton.addActionListener(e -> {
            this.setVisible(false);
            ArrayList<String> players = new ArrayList<>();
            for (NameInputBox box: nameBoxes) {
                players.add(box.getText());
            }
            game.updatePlayers(players);
        });

        c.add(namesBoxGUI, BorderLayout.CENTER);
        c.add(submitButton, BorderLayout.SOUTH);

        this.pack();
    }
}

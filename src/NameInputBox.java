import javax.swing.*;
import java.awt.*;

public class NameInputBox extends JPanel{

    public NameInputBox(Integer num) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(num.toString()), BorderLayout.WEST);
        this.add(new JTextField("Enter name"), BorderLayout.CENTER);
        this.add(new JButton("X"), BorderLayout.EAST);
    }
}

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class NameInputBox extends JPanel{

    private JTextField nameField;

    public NameInputBox(Integer num) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(num.toString()), WEST);
        nameField = new JTextField("Enter name");
        this.add(nameField, CENTER);
    }

    public String getText() {
        return nameField.getText().equals("Enter name") ? null : nameField.getText();
    }

}

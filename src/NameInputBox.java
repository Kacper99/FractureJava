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

    /**
     * Will check if an actual name has been added or if it's just the default text/something blank
     * @return THe text within the JTextBox
     */
    public String getText() {
        return (nameField.getText().equals("Enter name") || nameField.getText().equals("")) ? null : nameField.getText();
    }

}

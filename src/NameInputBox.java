import javax.swing.*;
import java.awt.*;

public class NameInputBox extends JPanel{

    private JTextField nameField;

    public NameInputBox(Integer num) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(num.toString()), BorderLayout.WEST);
        nameField = new JTextField("Enter name");
        this.add(nameField, BorderLayout.CENTER);
    }

    public String getText() {
        return nameField.getText().equals("Enter name") ? null : nameField.getText();
    }

}

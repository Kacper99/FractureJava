import javax.swing.*;
import java.awt.*;

public class NameInputBox extends JPanel{

    private JTextField nameField;

    public NameInputBox(Integer num) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(num.toString()), BorderLayout.WEST);
        nameField.setText("Enter name");
    }

    public String getText() {
        return nameField.getText().equals("Enter name") ? null : nameField.getText();
    }
}

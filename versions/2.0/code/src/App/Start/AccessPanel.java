package App.Start;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class AccessPanel extends JPanel{
    public abstract JButton getAccessButton();
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void clearFields();
    public abstract void setUsername();
    public abstract void setPassword();
}

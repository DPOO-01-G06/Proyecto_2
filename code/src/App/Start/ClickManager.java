package App.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClickManager implements ActionListener{
    private StartFrame home;

    public ClickManager(StartFrame home) {
        this.home = home;
    }

    @Override
    public void actionPerformed(ActionEvent e) throws RuntimeException{
        JButton button = (JButton) e.getSource();
        if (button == home.getAccessButton()) {
            // Validate user information
            try { home.setUser(); } catch (Exception ex) { throw new RuntimeException(ex); }
            home.setAccessStatus(true);
            home.moveToMenuFrame();
        }
    }
    
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsScreen extends JFrame {
    public static JFrame setScreen;
    SettingsScreen(){
        setScreen = this;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Settings");
        // Sets an icon for the frame
        ImageIcon ico = new ImageIcon(getClass().getResource("/Images/settings.png"));
        this.setIconImage(ico.getImage());

        ImageIcon bg = new ImageIcon(getClass().getResource("/Images/wp2.gif"));
        JLabel bgLabel = new JLabel(bg);

        JButton close = new JButton("Close");
        close.setSize(100, 40);
        close.setFocusable(false);
        close.setLocation(550, 400);
        close.addActionListener(new CloseListener());
        bgLabel.add(close);
        this.add(bgLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setScreen.setVisible(false);

        }
    }
}

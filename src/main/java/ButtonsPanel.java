import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JFrame {

    public ButtonsPanel(int x, int y, int width, int height, Color bacground){
        JLabel enterProfile= new JLabel("ENTER PROFILE");
        JButton searchFacebookProfile = new JButton("send");
        searchFacebookProfile.setBackground(new Color(3,168,36));
        JTextField textField=new JTextField();
        this.setBounds(x,y,width,height);
        this.setBackground(bacground);
        this.setLayout(null);
        this.add(enterProfile).setBounds((this.getWidth()-Window_main.SCREEN_WIDTH)/2,10,Window_main.ELEMENT_WIDTH,Window_main.ELEMENT_HEIGHT);
        this.add(textField).setBounds(enterProfile.getX(),enterProfile.getY()+Window_main.ELEMENT_HEIGHT,Window_main.ELEMENT_WIDTH,Window_main.ELEMENT_HEIGHT);
        this.add(searchFacebookProfile).setBounds(textField.getX(),textField.getY()+Window_main.ELEMENT_HEIGHT,Window_main.ELEMENT_WIDTH,Window_main.ELEMENT_HEIGHT);
        this.setVisible(true);

    }

}

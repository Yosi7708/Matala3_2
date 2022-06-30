import javax.swing.*;

public class ImageBox extends JLabel implements SizeToApp{
    public ImageBox(int x,int y){
        super();
        this.setBounds(x,y,ELEMENT_WIDTH,ELEMENT_HEIGHT);
    }
}

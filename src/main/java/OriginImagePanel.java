import java.awt.*;

public class OriginImagePanel extends MyPanels implements SizeToApp{
    public OriginImagePanel(int x, Color color) {
        super(x, color);
        this.add(ORIGINIAL_IMAGE);
        ORIGINIAL_IMAGE.setText("Original Image");
    }
}

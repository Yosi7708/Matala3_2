import javax.swing.*;
import java.awt.*;

public class NewImagePanel extends MyPanels implements SizeToApp {
    public NewImagePanel(int x, Color color) {
        super(x, color);
        this.add(NEW_IMAGE);
        NEW_IMAGE.setText("New Image");
    }
}

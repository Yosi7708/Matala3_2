import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MyPanels  extends JPanel implements SizeToApp {
    public MyPanels(int x, Color color) {
        this.setBounds(x, 0, SCREEN_WIDTH / 3, SCREEN_HEIGHT);
        this.setBackground(color);
        this.setLayout(null);
        this.setVisible(true);

    }

}


import javax.swing.*;
import java.awt.*;


public class Window_main extends JFrame implements SizeToApp {

    Window_main() {


        //left panel
        OriginImagePanel originImagePanel = new OriginImagePanel(0, new Color(255,255,204));
        this.add(originImagePanel);
        //middle panel
        ButtonsPanel buttonsPanel = new ButtonsPanel(SCREEN_WIDTH / 3, new Color(255,229,204));
        this.add(buttonsPanel);
        //right panel
        NewImagePanel newImagePanel = new NewImagePanel(buttonsPanel.getX() + buttonsPanel.getWidth(), new Color(255,255,204));
        this.add(newImagePanel);
//        // הגדרת חלון בסיסית


        this.setTitle("IMAGE PROCCESSING");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //פונקצייה מובנית הבונה את גודל החלון בהתאם לגודל הפנלים
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        //נראות ומיקום החלון
        this.setVisible(true);


    }


    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "./chromedriver104.exe");

        // יצירת חלון  חדש
        new Window_main();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ButtonsPanel extends MyPanels implements SizeToApp {
    private ChromeDriver driver;
    private JButton searchFacebookProfile;
    private BufferedImage scanImage;
    private static BufferedImage scanImage2;
    private static URL imageUrl;

    public static URL getImageUrl() {
        return imageUrl;
    }

    public static void setScanImage2(URL imageUrl) {
        try {
            scanImage2= ImageIO.read(ButtonsPanel.getImageUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ButtonsPanel(int x, Color background) {
        super(x, background);
        JLabel enterProfile = new JLabel("ENTER PROFILE");
        this.searchFacebookProfile = new JButton("send");
        this.searchFacebookProfile.setBackground(new Color(3, 168, 36));
        JTextField textField = new JTextField();
        this.add(enterProfile).setBounds((this.getWidth() - ELEMENT_WIDTH) / 2, 10, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(textField).setBounds(enterProfile.getX(), enterProfile.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(this.searchFacebookProfile).setBounds(textField.getX(), textField.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.searchFacebookProfile.addActionListener((event) -> {
            String profileName = textField.getText();
            try {
                //download the image
                downloadImage(profileName);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void addButtons() {
        ImageIcon myPicture = new ImageIcon(scanImage);
        ImageIcon copyOfPicture = new ImageIcon(scanImage2);
        ORIGINIAL_IMAGE.setIcon(myPicture);
        ORIGINIAL_IMAGE.setBounds(ORIGINIAL_IMAGE.getX(), ORIGINIAL_IMAGE.getY(), myPicture.getIconWidth(), myPicture.getIconHeight());
        NEW_IMAGE.setIcon(copyOfPicture);
        NEW_IMAGE.setBounds(NEW_IMAGE.getX(), NEW_IMAGE.getY(), copyOfPicture.getIconWidth(), copyOfPicture.getIconHeight());
        repaint();


        JButton button1 = new JButton("Grayscale");
        button1.addActionListener((event) -> {

            try {

                Actions.Grayscale(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button2 = new JButton("Color Shift Right");
        button2.addActionListener((event) -> {

            try {

                Actions.ColorShiftRight(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button3 = new JButton("Color Shift Left");
        button3.addActionListener((event) -> {

            try {

                Actions.ColorShiftLeft(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button4 = new JButton("Mirror");
        button4.addActionListener((event) -> {

            try {

                Actions.mirror(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });

        JButton button5 = new JButton("Eliminate Red");
        button5.addActionListener((event) -> {

            try {

                Actions.EliminateRed(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });

        JButton button6 = new JButton("Negative");
        button6.addActionListener((event) -> {

            try {

                Actions.negative(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button7 = new JButton("Contract");
        button7.addActionListener((event) -> {

            try {

                Actions.contract(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button8 = new JButton("Sepia");
        button8.addActionListener((event) -> {

            try {

                Actions.sepia(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button9 = new JButton("Lighter");
        button9.addActionListener((event) -> {

            try {

                Actions.lighter(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        JButton button10 = new JButton("Darker");
        button10.addActionListener((event) -> {

            try {

                Actions.darker(scanImage2);

            } catch (Exception e) {
                error(e);
            }
        });
        this.add(button1).setBounds(this.searchFacebookProfile.getX(), this.searchFacebookProfile.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button2).setBounds(button1.getX(), button1.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button3).setBounds(button2.getX(), button2.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button4).setBounds(button3.getX(), button3.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button5).setBounds(button4.getX(), button4.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button6).setBounds(button4.getX(), button4.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button7).setBounds(button6.getX(), button6.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button8).setBounds(button7.getX(), button7.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button9).setBounds(button8.getX(), button8.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        this.add(button10).setBounds(button9.getX(), button9.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);
       // this.add(button11).setBounds(button10.getX(), button10.getY() + ELEMENT_HEIGHT, ELEMENT_WIDTH, ELEMENT_HEIGHT);


    }


    private void downloadImage(String profileName) throws IOException {
        this.driver = new ChromeDriver();
        this.driver.get("https://facebook.com/" + profileName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // find the element of the profile photo and display it
        WebElement element = driver.findElement(By.tagName("image"));
        String src = element.getAttribute("xlink:href");
        imageUrl = new URL(src);
        this.scanImage = ImageIO.read(imageUrl);
        this.scanImage2 = ImageIO.read(imageUrl);

        driver.quit();
        addButtons();

    }
    private void error (Exception e){
        JOptionPane.showMessageDialog(new JFrame(),
                e.getMessage(),
                "error",
                JOptionPane.PLAIN_MESSAGE);
    }


}
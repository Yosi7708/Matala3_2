import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Window_main extends JFrame  {
    final int SCREEN_WIDTH=900;
    final int SCREEN_HEIGHT=800;

    static JPanel originImagePanel, buttonsPanel, newImagePanel;

    JButton searchFacebookProfile,tryButton;
    public BufferedImage image;
    int ELEMENT_WIDTH=150;
    int ELEMENT_HEIGHT=50;
    static ImageIcon myPicture,copyOfPicture;
    static JLabel picLabel,picLabel2;
    ChromeDriver driver ;
    static BufferedImage scanImage, scanImage2;
    static URL imageUrl;


    Window_main()  {

        JLabel enterProfile= new JLabel("ENTER PROFILE");
        JLabel originImageText= new JLabel("Original Image");
        JLabel newImageText= new JLabel("New Image");


        JTextField textField=new JTextField();

        searchFacebookProfile= new JButton("send");
        searchFacebookProfile.setBackground(new Color(3,168,36));

        //left panel
        originImagePanel = new JPanel();
        originImagePanel.setBounds(0,0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        originImagePanel.setBackground(Color.orange);
        originImagePanel.setVisible(true);
        originImagePanel.setLayout(null);
        originImagePanel.add(originImageText).setBounds((originImagePanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);


        //middle panel
        buttonsPanel= new JPanel();
        buttonsPanel.setBounds(originImagePanel.getX()+originImagePanel.getWidth(),0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setVisible(true);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(enterProfile).setBounds((buttonsPanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(textField).setBounds(enterProfile.getX(),enterProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(searchFacebookProfile).setBounds(textField.getX(),textField.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);


        //right panel
        newImagePanel = new JPanel();
        newImagePanel.setBounds(buttonsPanel.getX()+buttonsPanel.getWidth(),0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        newImagePanel.setBackground(Color.GREEN);
        newImagePanel.setVisible(true);
        newImagePanel.setLayout(null);
        newImagePanel.add(newImageText).setBounds((newImagePanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        this.add(newImagePanel).setBounds(600,0,300,900);
        this.add(buttonsPanel).setBounds(300,0,300,900);

        this.add(originImagePanel).setBounds(0,0,300,900);

        //search the profile on facebook
        searchFacebookProfile.addActionListener( (event) -> {
            String profileName = textField.getText();
            try {
                //download the image
                downloadImage(profileName);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });



//        // הגדרת חלון בסיסית


        this.setTitle("IMAGE PROCCESSING");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //פונקצייה מובנית הבונה את גודל החלון בהתאם לגודל הפנלים
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setLayout(null);
        //נראות ומיקום החלון
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    public void downloadImage(String profileName) throws IOException {

        originImagePanel.removeAll();
        driver = new ChromeDriver();
        driver.get("https://facebook.com/"+profileName);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // find the element of the profile photo and display it
        WebElement element = driver.findElement(By.xpath("//div[@class='b3onmgus e5nlhep0 ph5uu5jm ecm0bbzt spb7xbtv bkmhp75w emlxlaya s45kfl79 cwj9ozl2']//div[@class='q9uorilb l9j0dhe7 pzggbiyp du4w35lb']//*[name()='svg']//*[name()='g' and contains(@mask,'url(#jsc_c')]//*[name()='image' and contains(@x,'0')]"));
        String src = element.getAttribute("xlink:href");
        imageUrl = new URL(src);
        scanImage = ImageIO.read(imageUrl);
        scanImage2 = ImageIO.read(imageUrl);

        driver.quit();

        addButtons();

    }
    public void addButtons() {
        myPicture = new ImageIcon(scanImage);
        copyOfPicture= new ImageIcon(scanImage2);
        picLabel = new JLabel(myPicture);
        picLabel2=new JLabel(copyOfPicture);
        newImagePanel.removeAll();
        //אפשר לעשות מערך של כפתורים במקום
        originImagePanel.add(picLabel).setBounds((originImagePanel.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());
        originImagePanel.revalidate();


        newImagePanel.add(picLabel2).setBounds((newImagePanel.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());
        newImagePanel.revalidate();



        JButton button1= new JButton("Grayscale");
        button1.addActionListener( (event) -> {

            try {

                Actions.Grayscale(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button2= new JButton("Color Shift Right");
        button2.addActionListener( (event) -> {

            try {

                Actions.ColorShiftRight(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button3= new JButton("Color Shift Left");
        button3.addActionListener( (event) -> {

            try {

                Actions.ColorShiftLeft(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button4= new JButton("Mirror");
        button4.addActionListener( (event) -> {

            try {

                Actions.mirror(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button5= new JButton("Show Borders");
        button5.addActionListener( (event) -> {

            try {

                Actions.ShowBorders(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button6= new JButton("Eliminate Red");
        button6.addActionListener( (event) -> {

            try {

                Actions.EliminateRed(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });

        JButton button7= new JButton("Negative");
        button7.addActionListener( (event) -> {

            try {

                Actions.negative(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button8= new JButton("Contract");
        button8.addActionListener( (event) -> {

            try {

                Actions.contract(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button9= new JButton("Sepia");
        button9.addActionListener( (event) -> {

            try {

                Actions.sepia(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button10= new JButton("Lighter");
        button10.addActionListener( (event) -> {

            try {

                Actions.lighter(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button11= new JButton("Darker");
        button11.addActionListener( (event) -> {

            try {

                Actions.darker(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        buttonsPanel.add(button1).setBounds(searchFacebookProfile.getX(),searchFacebookProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button2).setBounds(button1.getX(),button1.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button3).setBounds(button2.getX(),button2.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button4).setBounds(button3.getX(),button3.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button5).setBounds(button4.getX(),button4.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button6).setBounds(button5.getX(),button5.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button7).setBounds(button6.getX(),button6.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button8).setBounds(button7.getX(),button7.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button9).setBounds(button8.getX(),button8.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button10).setBounds(button9.getX(),button9.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button11).setBounds(button10.getX(),button10.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);



    }


    public static void updatePhoto() throws IOException{
        newImagePanel.removeAll();

        JLabel picLabel3=new JLabel(new ImageIcon( scanImage2));



        try{
            newImagePanel.add(picLabel3).setBounds((newImagePanel.getWidth()-copyOfPicture.getIconWidth())/2,150,copyOfPicture.getIconWidth(),myPicture.getIconHeight());
            newImagePanel.setLayout(null);
            newImagePanel.revalidate();
            picLabel3.setVisible(true);
        }catch (Exception e){
            System.out.println("dont add");
        }
        scanImage2= ImageIO.read(imageUrl);

    }


    public static void main(String[] args)  {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\files2\\chromedriver.exe");

        // יצירת חלון  חדש
        new Window_main();
    }
}

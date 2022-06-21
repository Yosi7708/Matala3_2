import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Actions {


    public static void Grayscale(BufferedImage img) {
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //calculate average
                int avg = (r + g + b) / 3;

                //replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                img.setRGB(x, y, p);
            }
        }

//        try {
//            File output = new File("C:\\files2\\027.png");
//            ImageIO.write(img, "png", output);
            Window_main.updatePhoto();


//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //2.
    public static void mirror(BufferedImage img) {



        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel);
                img.setRGB(img.getWidth() - 1 - x, y, color.getRGB());
                // int red = color.getRed();
                //  int green = color.getGreen();
                // int blue = color.getBlue();
                //  int average = (red+green+blue)/3;
                //Color newColor = new Color(255-red, 255-green,255-blue);
                //Color newC
            }
//                try {
//                    File output = new File("C:\\files2\\027.png");
//                    ImageIO.write(img, "png", output);
                    Window_main.updatePhoto();


//                } catch (IOException e) {
//                    e.printStackTrace();
//                }



        }
    }
    public static void sepia(BufferedImage img){
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Retrieving the values of a pixel
                int pixel = img.getRGB(x,y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, true);
                //Retrieving the R G B values
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int avg = (red+green+blue)/3;
                int depth = 20;
                int intensity = 30;
                red= avg+(depth*2);
                green = avg+depth;
                blue = avg-intensity;
                //Making sure that RGB values lies between 0-255
                if (red > 255)red = 255;
                if (green > 255)green = 255;
                if (blue > 255)blue = 255;
                if (blue<0)blue=0;
                //Creating new Color object
                color = new Color(red, green, blue);
                //Setting new Color object to the image
                img.setRGB(x, y, color.getRGB());
            }
        }
        Window_main.updatePhoto();
    }
    public static void negative(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        // Convert to negative
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }
        Window_main.updatePhoto();
    }
}



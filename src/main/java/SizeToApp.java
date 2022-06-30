import java.awt.image.BufferedImage;

public interface SizeToApp {
    public  final int SCREEN_WIDTH=900;
    public  final int SCREEN_HEIGHT=800;
    public final int ELEMENT_WIDTH=150;
    public  final int ELEMENT_HEIGHT=50;
    public final ImageBox ORIGINIAL_IMAGE=new ImageBox(SCREEN_WIDTH/3/2/2,SCREEN_WIDTH-SizeToApp.SCREEN_HEIGHT);
    public final ImageBox NEW_IMAGE=new ImageBox(SCREEN_WIDTH/3/2/2,SCREEN_WIDTH-SizeToApp.SCREEN_HEIGHT);
}

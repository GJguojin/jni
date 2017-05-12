package png;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.pngquant.PngQuant;

public class PngTest {
	
    public void pngTest() throws IOException {
    	PngQuant pngQuant = new PngQuant();
    	pngQuant.setQuality(20);
    	BufferedImage image = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\pngQuant\\1.png"));
    	
    	BufferedImage remapped = pngQuant.getRemapped(image);
    	ImageIO.write(remapped, "png", new File("C:\\Users\\Administrator\\Desktop\\pngQuant\\1_test.png"));
    	
	}

}

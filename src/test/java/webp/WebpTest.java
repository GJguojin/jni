package webp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import org.junit.Test;

import com.luciad.imageio.webp.imageio.WebPWriteParam;

public class WebpTest {
	
	@Test
	public void webpTest() throws IOException {
		
		// Obtain an image to encode from somewhere
		BufferedImage image = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\webp\\docimg1.png"));

		long t1 = System.currentTimeMillis();

		// Obtain a WebP ImageWriter instance
		ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

		// Configure encoding parameters
		WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
		writeParam.setCompressionMode(WebPWriteParam.LOSSLESS_COMPRESSION);

		// Configure the output on the ImageWriter
		writer.setOutput(new FileImageOutputStream(new File("C:\\Users\\Administrator\\Desktop\\webp\\docimg3.webp")));

		// Encode
		writer.write(null, new IIOImage(image, null, null), writeParam);

		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

}

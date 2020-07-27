import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image {
	BufferedImage bufferedImage ;
	BufferedImage newImage ;
	public Image(String fileImage) {
		try {
			this.bufferedImage = ImageIO.read(new File(fileImage));
		} catch (Exception e) {
			System.out.println("Image can not be opened");
		}
	}
	public void resize( int targetWidth, int targetHeight) throws IOException{
		this.newImage  = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = this.newImage.createGraphics();
	    graphics2D.drawImage(this.bufferedImage, 0, 0, targetWidth, targetHeight, null);
	    graphics2D.dispose();
	}
	public void showImage() {
	  JFrame frame = new JFrame();
//	  ImageIcon icon = new ImageIcon("androidBook.jpg");
	  JLabel label = new JLabel(new ImageIcon(newImage));
	  frame.add(label);
	  frame.setDefaultCloseOperation
	         (JFrame.EXIT_ON_CLOSE);
	  frame.pack();
	  frame.setVisible(true);
	}
	
}

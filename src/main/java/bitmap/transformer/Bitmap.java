package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    File inputFilePath;
    File outputFilePath;
    String transformName;

    public Bitmap() throws IOException {

    }

//    File bmpFile = new File("bmpImage.bmp");
//    BufferedImage image = ImageIO.read(bmpFile);

    public Bitmap(File inputFilePath, File outFilePath, String transformName) throws IOException {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outFilePath;
        this.transformName = transformName;
    }

    public changeWidth(int width) {
    }


}

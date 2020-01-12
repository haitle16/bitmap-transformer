package bitmap.transformer;

import java.awt.*;
import java.io.File;
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

    public Bitmap(String inputFilePath, String outFilePath, String transformName) throws IOException {
        this.inputFilePath = new File(inputFilePath);
        this.outputFilePath = new File(outFilePath + "/" + transformName);
        this.transformName = transformName;
    }

    public Bitmap greyScale (){
        try {
            // read the input file and set as image
            BufferedImage image = ImageIO.read(this.inputFilePath);
            for(int i = 0; i < image.getHeight(); i++){
                for(int j = 0; j < image.getWidth(); j++){
                    // get the rgb from image
                    Color bMColor = new Color(image.getRGB(i, j));
                    int blue = (int)(bMColor.getBlue());
                    int red = (int)(bMColor.getRed());
                    int green = (int)(bMColor.getGreen());
                    int avg = (red+green+blue) / 3;
                    // set new color with the average of rgb / 3
                    Color newBMColor = new Color(avg, avg, avg);
                    image.setRGB(i, j, newBMColor.getRGB());
                }
            }
            ImageIO.write(image, "bmp", this.outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap mirror (){
        try {
            BufferedImage image = ImageIO.read(this.inputFilePath);
            for(int i = 0; i < image.getHeight(); i++){
                for(int j = image.getWidth() -1; j > image.getWidth() /2; j--){
                    Color bMColor = new Color(image.getRGB(i, j));
                    image.setRGB(i, image.getWidth() -1 -j, bMColor.getRGB());
                }
            }
            ImageIO.write(image, "bmp", this.outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Bitmap yellify (){
        try {
            // read the input file and set as image
            BufferedImage image = ImageIO.read(this.inputFilePath);
            for(int i = 0; i < image.getHeight(); i++){
                for(int j = 0; j < image.getWidth(); j++){
                    // get the rgb from image
                    Color bMColor = new Color(image.getRGB(i, j));

                    int blue = (int)(bMColor.getBlue());
                    int red = (int)(bMColor.getRed());
                    int green = (int)(bMColor.getGreen());
                    int avg = (red+green+blue) / 3;
                    // set new color with the average of rgb / 3
                    Color newBMColor = new Color(avg, avg, 0);
                    image.setRGB(i/3, j/3, newBMColor.getRGB());
                }
            }
            ImageIO.write(image, "bmp", this.outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

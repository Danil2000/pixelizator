package world.ucode.module;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Pixelate {
    public BufferedImage image;
    public InputStream toPixel(InputStream in, int size) throws IOException {
        image = ImageIO.read(in);
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage imageRes = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        System.out.println(size);
        for (int i = 0; i < width; i += size) {
            for (int j = 0; j < height; j += size) {
                int pixel = makePicture(image, i, j, size);
                for (int dw = i; (dw < i + size) && (dw < imageRes.getWidth()); dw++)
                    for (int dh = j; (dh < j + size) && (dh < imageRes.getHeight()); dh++)
                        imageRes.setRGB(dw, dh, pixel);
            }
        }
//        toFile(imageRes);
        return toStream(imageRes);
    }
//    private void toFile(BufferedImage img) throws IOException {
//        File newFile = new File("src/main/webapp/img.jpg");
//        ImageIO.write(img, "jpg", newFile);
//    }

    private InputStream toStream(BufferedImage imageRes) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(imageRes, "jpeg", stream);
        return new ByteArrayInputStream(stream.toByteArray());
    }

    private int makePicture(BufferedImage image, int i, int j, int sizeOfPixel) {
        sizeOfPixel = ++sizeOfPixel / 2;
        int wCenter = i + sizeOfPixel < image.getWidth() ? i + sizeOfPixel : i;
        int hCenter = j + sizeOfPixel < image.getHeight() ? j + sizeOfPixel : j;
        return image.getRGB(hCenter, wCenter);
    }
}

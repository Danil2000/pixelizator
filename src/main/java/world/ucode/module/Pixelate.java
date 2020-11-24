package world.ucode.module;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pixelate {
    public InputStream toPixel(InputStream in) throws IOException {
        BufferedImage image = ImageIO.read(in);
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage imageRes = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int sizeOfPixel = 900;

        for (int i = 0; i < width; i += sizeOfPixel) {
            for (int j = 0; j < height; j += sizeOfPixel) {
                int pixel = makePicture(image, i, j, sizeOfPixel);
                for (int dw = i; (dw < i + sizeOfPixel) && (dw < imageRes.getWidth()); dw++)
                    for (int dh = j; (dh < j + sizeOfPixel) && (dh < imageRes.getHeight()); dh++)
                        imageRes.setRGB(dw, dh, pixel);
            }
        }
        return toStream(imageRes);
    }

    private InputStream toStream(BufferedImage imageRes) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(imageRes, "jpeg", stream);
        return new ByteArrayInputStream(stream.toByteArray());
    }

    private int makePicture(BufferedImage image, int i, int j, int sizeOfPixel) {
        sizeOfPixel = ++sizeOfPixel/ 2;
        int wCenter = i + sizeOfPixel < image.getWidth() ? i + sizeOfPixel : i;
        int hCenter = j + sizeOfPixel < image.getHeight() ? j + sizeOfPixel : j;
        return image.getRGB(hCenter, wCenter);
    }

}

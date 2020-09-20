package com.zrzhen.imghash.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgUtil {


    public static BufferedImage path2Img(String path) throws IOException {
        return ImageIO.read(new File(path));
    }


    /**
     * 按比例缩放
     *
     * @param scale 缩放比例,大于1为放大，小于1为缩小
     * @throws IOException
     */
    public static BufferedImage resizeByScale(BufferedImage img, double scale) throws IOException {
        int width = img.getWidth();
        int height = img.getHeight();
        //获取缩放后的长和宽
        int _width = (int) (scale * width);
        int _height = (int) (scale * height);
        //获取缩放后的Image对象
        Image _img = img.getScaledInstance(_width, _height, Image.SCALE_DEFAULT);
        //新建一个和Image对象相同大小的画布
        BufferedImage image = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D graphics = image.createGraphics();
        //将Image对象画在画布上,最后一个参数,ImageObserver:接收有关 Image 信息通知的异步更新接口,没用到直接传空
        graphics.drawImage(_img, 0, 0, null);
        //释放资源
        graphics.dispose();
        return image;
    }

    public static BufferedImage resizeBySize(BufferedImage img, int width, int height) throws IOException {
        //与按比例缩放的不同只在于,不需要获取新的长和宽,其余相同.
        Image _img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(_img, 0, 0, null);
        graphics.dispose();
        return image;
    }

    /**
     * 图片大小缩放
     *
     * @param srcImage 源图片
     * @param width    宽
     * @param height   高
     * @return
     */
    public static BufferedImage resize(BufferedImage srcImage, int width, int height) {
        //文件转成9*8像素，为算法比较通用的长宽
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        return buffImg;
    }


    /**
     * 保存图片
     *
     * @param image
     * @param path
     * @return
     * @throws IOException
     */
    public static boolean imgSave(BufferedImage image, String path) throws IOException {
        int index = path.lastIndexOf(".");
        String ext = path.substring(index + 1);
        return ImageIO.write(image, ext, new File(path));
    }

    /**
     * rbg转gray
     *
     * @param rgb
     * @return
     */
    public static int rbg2Gray(int rgb) {
        int alpha = (0xFF << 24);
        int red = (rgb & 0x00FF0000) >> 16;
        int green = (rgb & 0x0000FF00) >> 8;
        int blue = rgb & 0x000000FF;

        int grey = (int) (red * 0.3 + green * 0.59 + blue * 0.11);
        grey = (alpha | (grey << 16) | (grey << 8) | grey);


//        int r = rgb >> 16 & 0xff;
//        int g = rgb >> 8 & 0xff;
//        int b = rgb & 0xff;
//        int gray = (r * 30 + g * 59 + b * 11) / 100;

        return grey;
    }

    public static BufferedImage img2Gray(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage image = img.getSubimage(0, 0, img.getWidth(), img.getHeight());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                int gray = ImgUtil.rbg2Gray(rgb);
                image.setRGB(x, y, gray);
                if (rgb > 0 && rgb < 255) {
                    System.out.println(rgb);
                }
            }
        }
        return image;
    }

    public static int[] img2Array(BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();
        int[] array = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                int index = x + width * y;
                array[index] = rgb;
            }
        }
        return array;
    }

    public static boolean compareGrey(int current, int next) {
        if (current > next) {
            return true;
        }
        return false;
    }

}

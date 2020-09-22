package com.zrzhen.imghash;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 把两张图片合并
 *
 * @version 2018-2-27 上午11:12:09
 */
public class Picture1 {
    private Graphics2D g = null;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {

        try {
            int w = b.getWidth();
            int h = b.getHeight();

            g = d.createGraphics();
            g.drawImage(b, 300, -800, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Picture1 tt = new Picture1();

        BufferedImage d = tt.loadImageLocal("E:\\github\\imghash\\data\\lena.jpg");
        BufferedImage b = tt.loadImageLocal("E:\\github\\imghash\\data\\lenaGray.jpg");

        tt.writeImageLocal("E:\\github\\imghash\\data\\lenaCombind.jpg", tt.modifyImagetogeter(b, d));
        //将多张图片合在一起
        System.out.println("success");
    }
}
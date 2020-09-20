package com.zrzhen.imghash.core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.zrzhen.imghash.core.ImgUtil.*;

public class AHash {

    public static String imgAHash(String path) throws IOException {
        //原图
        BufferedImage srcImg = path2Img(path);
        //缩小后的原图
        BufferedImage resideImg = resize(srcImg, 9, 9);
        //缩小后的灰度图
        BufferedImage resideImgGrayImg = img2Gray(resideImg);
        int[] imgGrayArray = img2Array(resideImgGrayImg);
        String hash1 = aHash(imgGrayArray);
        return hash1;
    }

    public static String aHash(int[] pixels) {
        int average = average(pixels);
        String result = binHash(pixels, average);
        return result;
    }

    public static int average(int[] pixels) {
        int sum = 0;
        for (int i = 0; i < pixels.length; i++) {
            sum += pixels[i];
        }
        int average = (Math.round(sum / pixels.length));
        return average;
    }

    private static String binHash(int[] pixels, int average) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pixels.length; i++) {
            boolean d = compareGrey(pixels[i], average);
            if (d) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

}

package com.zrzhen.imghash.core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.zrzhen.imghash.core.ImgUtil.*;

public class DHash {

    public static String dHash(int[] pixels) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pixels.length - 1; i++) {
            boolean d = compareGrey(pixels[i], pixels[i + 1]);
            if (d) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }



    public static String imgDHash(String path) throws IOException {
        //原图
        BufferedImage srcImg = path2Img(path);
        //缩小后的原图
        BufferedImage resideImg = resize(srcImg, 9, 8);
        //缩小后的灰度图
        BufferedImage resideImgGrayImg = img2Gray(resideImg);
        int[] imgGrayArray = img2Array(resideImgGrayImg);
        String hash1 = dHash(imgGrayArray);
        return hash1;
    }
}

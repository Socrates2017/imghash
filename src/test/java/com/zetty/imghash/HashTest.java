package com.zetty.imghash;

import com.zrzhen.imghash.core.*;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class HashTest {
    @Test
    public void relativePath() throws IOException {
        //原图
        String path = FileUtil.rePath2AbPath("data/lena.jpg");
        BufferedImage srcImg = ImgUtil.path2Img(path);

        //灰度图
        BufferedImage grayImg = ImgUtil.img2Gray(srcImg);
        String grayImgPath = FileUtil.rePath2AbPath("data/lenaGray.jpg");
        ImgUtil.imgSave(grayImg, grayImgPath);

        //缩小后的原图
        BufferedImage resideImg = ImgUtil.resize(srcImg, 9, 8);
        String resideImgPath = FileUtil.rePath2AbPath("data/lenaResize.jpg");
        ImgUtil.imgSave(resideImg, resideImgPath);

        //缩小后的灰度图
        BufferedImage resideImgGrayImg = ImgUtil.img2Gray(resideImg);
        String resideGrayImgPath = FileUtil.rePath2AbPath("data/lenaResizeGray.jpg");
        ImgUtil.imgSave(resideImgGrayImg, resideGrayImgPath);

        int[] imgGrayArray = ImgUtil.img2Array(resideImgGrayImg);
        int[] resideImgArray = ImgUtil.img2Array(resideImg);

        String aHash1 = AHash.aHash(imgGrayArray);
        String aHash2 = AHash.aHash(resideImgArray);

        System.out.println(aHash1);
        System.out.println(aHash2);

        int hamming = HammingDistanceUtil.hammingDistance(aHash1, aHash2);
        System.out.println(hamming);
    }
}

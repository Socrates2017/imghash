package com.zetty.imghash;

import com.zrzhen.imghash.core.FileUtil;
import com.zrzhen.imghash.core.ImgUtil;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgTest {

    /**
     * 图片灰度化
     * @throws IOException
     */
    @Test
    public void rgb2Gray() throws IOException {
        //原图路径
        String path = FileUtil.rePath2AbPath("data/lena.jpg");
        //灰度图保存路径
        String grayImgPath = FileUtil.rePath2AbPath("data/lenaGray.jpg");

        BufferedImage srcImg = ImgUtil.path2Img(path);

        BufferedImage grayImg = ImgUtil.img2Gray(srcImg);

        //保存灰度图片
        ImgUtil.imgSave(grayImg, grayImgPath);
    }

    /**
     * 图片缩放
     * @throws IOException
     */
    @Test
    public void resize() throws IOException {
        //原图路径
        String path = FileUtil.rePath2AbPath("data/lena.jpg");
        //灰度图保存路径
        String resideImgPath = FileUtil.rePath2AbPath("data/lenaResize.jpg");

        BufferedImage srcImg = ImgUtil.path2Img(path);
        BufferedImage resideImg = ImgUtil.resize(srcImg, 900, 80);

        //保存缩小后的图片
        ImgUtil.imgSave(resideImg, resideImgPath);
    }
}

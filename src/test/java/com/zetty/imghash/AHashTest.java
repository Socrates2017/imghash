package com.zetty.imghash;

import com.zrzhen.imghash.core.AHash;
import com.zrzhen.imghash.core.FileUtil;
import com.zrzhen.imghash.core.HammingDistanceUtil;
import com.zrzhen.imghash.core.ImgUtil;
import org.junit.Test;

import java.io.IOException;

public class AHashTest {
    @Test
    public void isSameImg() throws IOException {

        //图片1
        String img1 = FileUtil.rePath2AbPath("data/lena.jpg");
        //图片2
        String img2 = FileUtil.rePath2AbPath("data/lenaResize.jpg");

        String hash1 = AHash.imgAHash(img1);
        String hash2 = AHash.imgAHash(img2);

        System.out.println("图片1哈希值：" + hash1);
        System.out.println("图片2哈希值：" + hash2);

        int hamming = HammingDistanceUtil.hammingDistance(hash1, hash2);
        System.out.println("汉明距离：" + hamming);

        boolean isSameImg = hamming < 7 ? true : false;

        System.out.println("两张图片是同一张图片？：" + isSameImg);

    }
}

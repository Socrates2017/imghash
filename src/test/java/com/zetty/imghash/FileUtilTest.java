package com.zetty.imghash;

import com.zrzhen.imghash.core.FileUtil;
import org.junit.Test;

public class FileUtilTest {


    @Test
    public void rePath2AbPath(){

        String lena = "data/lena.jpg";
        String lenaAbPath= FileUtil.rePath2AbPath(lena);
        System.out.println(lenaAbPath);
    }
}

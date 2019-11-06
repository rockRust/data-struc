package bit.arithmetic.demo.application;

import java.io.*;

/**
 * create at:  2019-07-25  14:14
 *
 * @author : js
 * @description: 图片加解密
 */
public class PictureEncryption {
    public final static int key = 0x99; //加密解密秘钥
    private static int dataOfFile = 0; //文件字节内容

    public static void main(String[] args) {
        File srcFile = new File("/Users/js/pic/identityCard.png"); //初始文件
        File encFile = new File("/Users/js/pic/encrypt/encFile"); //加密文件
        File decFile = new File("/Users/js/pic/decrypt/dec.png"); //解密文件

        try {
//            xor(srcFile, encFile); //加密操作
            xor(encFile, decFile);//解密操作
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void xor(File srcFile, File encFile) throws Exception {
        if (!srcFile.exists()) {
            System.out.println("source file not exixt");
            return;
        }

        if (!encFile.exists()) {
            System.out.println("encrypt file created");
            encFile.createNewFile();
        }
        InputStream fis = new FileInputStream(srcFile);
        OutputStream fos = new FileOutputStream(encFile);

        while ((dataOfFile = fis.read()) > -1) {
//            System.out.println((char) dataOfFile);
            fos.write(dataOfFile ^ key);
        }

        fis.close();
        fos.flush();
        fos.close();
    }
}

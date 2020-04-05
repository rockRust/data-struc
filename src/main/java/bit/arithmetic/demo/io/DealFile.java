package bit.arithmetic.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author jiaosong
 * @desc
 * @date 2020/2/18
 */
public class DealFile {
    public static void main(String[] args) {
        File csvFile = new File("");
        try (FileInputStream fileInputStream = new FileInputStream(csvFile)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

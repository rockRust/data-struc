package bit.arithmetic.demo.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * create at:  2019-07-31  11:23
 *
 * @author : js
 * @description:
 */
public class ByteTest {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedInputStream bif = null;
        try {
            socket = new Socket("203.198.238.4", 29005);

            bif = new BufferedInputStream(socket.getInputStream());
            int read = 0;
            byte[] buffer = new byte[1024];

            while ((read = bif.read(buffer)) != -1) {
                String chunk = new String(buffer, 0,read,"UTF-8");
                System.out.print(chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bif != null) {
                try {
                    bif.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

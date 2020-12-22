package bit.arithmetic.demo.message;

/**
 * @author jiaosong
 * @desc
 * @date 2020/12/22
 */
public interface MessageClient {
    /**
     * 连接
     */
    void connect();

    /**
     * 断开连接
     */
    void disConnect();

    /**
     * 重连
     */
    void reconnect();

    /**
     * 发送消息
     * 可能会有参数未补充
     */
    void sendMsg();


}

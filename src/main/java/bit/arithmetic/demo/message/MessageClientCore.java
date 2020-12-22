package bit.arithmetic.demo.message;

/**
 * @author jiaosong
 * @desc 控制client方法，只有在这里面才能操作client，对外提供的service调用这个core
 * @date 2020/12/22
 */
public class MessageClientCore {

    public void sendMsg() {
        // 这里面实现滑动窗口
        //
    }

    public void heartBeat() {
        // 这里面进行心跳检测，发送心跳的消息，然后等待60s，有一把锁，与response公用的，调用锁的wait方法，
        // 然后判断标识位是否被修改，未修改则调用client的重连方法
    }

    public void heartBeatResponse() {
        // 当有心跳回调在这里处理。修改一个标识位，然后利用锁.notify() 唤醒上面的心跳
    }



}

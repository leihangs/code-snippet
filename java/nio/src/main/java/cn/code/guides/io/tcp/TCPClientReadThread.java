package cn.code.guides.io.tcp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 描述：线程信息
 */
public class TCPClientReadThread implements Runnable {
    private Selector selector;

    public TCPClientReadThread(Selector selector) {
        this.selector = selector;
    }

    public void run() {
        try {
            //select()方法只能使用一次，用了之后就会自动删除,每个连接到服务器的选择器都是独立的
            while (selector.select() > 0) {
                // 遍历每个有可用IO操作Channel对应的SelectionKey
                for (SelectionKey sk : selector.selectedKeys()) {
                    //使用NIO读取Channel中的数据
                    if (sk.isReadable()) {
                        //获取通道信息
                        SocketChannel sc = (SocketChannel) sk.channel();
                        //分配缓冲区大小
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取通道里面的数据放在缓冲区内
                        sc.read(buffer);
                        //设置buffer为读模式，写-->读。
                        buffer.flip();
                        String receiveString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();

                        System.out.println("客户端：接收到服务器的返回：" + receiveString);
                        // 为下一次读取作准备
                        sk.interestOps(SelectionKey.OP_READ);
                    }
                    //删除已经处理的key
                    selector.selectedKeys().remove(sk);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

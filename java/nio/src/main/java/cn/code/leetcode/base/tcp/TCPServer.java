package cn.code.leetcode.base.tcp;

import cn.code.leetcode.base.utils.DataHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * TCP服务
 */
public class TCPServer {

    //缓存区大小，KB
    private static final int BUFFER_SIZE = 1024;
    //超时时间，毫秒
    private static final int TIME_OUT = 3000;
    //监听端口
    private static final int PORT = 9527;

    public static void main(String[] args) throws IOException {
        //创建消息处理类
        DataHandler dataHandler = new TCPDataHandler(BUFFER_SIZE);

        //创建选择器
        Selector selector = Selector.open();
        //打开监听Channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //将选择器注册到该监听通道，指定该Channel可以进行accept操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待，监听端口
        while (true) {
            //等待channel就绪，或超时
            if (selector.select(TIME_OUT) == 0) {
                System.out.println("continue waiting...");
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                //Selector的四种事件（接受，连接，读，写）是否就绪
                if (key.isAcceptable()) {
                    dataHandler.handleAccept(key);
                } else if (key.isConnectable()) {
                    System.out.println("连接");
                } else if (key.isReadable()) {
                    //a channel is ready for reading ，有数据进来
                    dataHandler.handleRead(key);
                } else if (key.isWritable()) {
                    //判断是否有效及可以发送给客户端
                    dataHandler.handleWrite(key);
                }
                //异常处理过的key
                keyIterator.remove();
            }
        }

    }
}

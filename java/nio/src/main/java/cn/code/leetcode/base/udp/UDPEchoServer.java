package cn.code.leetcode.base.udp;

import cn.code.leetcode.base.utils.DataHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * 描述：UDP服务端
 */
public class UDPEchoServer {

    private static final int TIME_OUT = 3000;

    public static void main(String[] args) throws IOException {

        DataHandler dataHandler = new UDPDataHandler(1024);

        Selector selector = Selector.open();
        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(5500));
//        channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        channel.register(selector, SelectionKey.OP_READ, new UDPDataHandler.ClientRecord());

        while (true) {
            if (selector.select(TIME_OUT) == 0) {
                System.out.println("continue...");
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isReadable()) {
                    dataHandler.handleRead(key);
                } else if (key.isWritable()) {
                    dataHandler.handleWrite(key);
                }
                keyIterator.remove();
            }
        }
    }
}

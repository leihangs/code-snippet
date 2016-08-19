package cn.code.guides.io.udp;

import cn.code.guides.io.utils.DataHandler;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.charset.Charset;

/**
 * 描述：
 */
public class UDPDataHandler implements DataHandler {

    private static final int ECHOMAX = 1024;

    static class ClientRecord {
        public SocketAddress clientAddress;
        public ByteBuffer buffer = ByteBuffer.allocate(ECHOMAX);
    }


    int bufferSize;

    public UDPDataHandler(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void handleAccept(SelectionKey key) throws IOException {

    }

    public void handleRead(SelectionKey key) throws IOException {
        DatagramChannel channel = (DatagramChannel) key.channel();
        ClientRecord clntRec = (ClientRecord) key.attachment();
        //切换为写模式
        clntRec.buffer.clear();
        //读取buffer
        clntRec.clientAddress = channel.receive(clntRec.buffer);
        if (clntRec.clientAddress != null) {
            key.interestOps(SelectionKey.OP_WRITE);
        }

    }

    public void handleWrite(SelectionKey key) throws IOException {
        DatagramChannel channel = (DatagramChannel) key.channel();
//        ByteBuffer buffer = (ByteBuffer) key.attachment();
        ClientRecord clntRec = (ClientRecord) key.attachment();
        clntRec.buffer.flip();
//      //输出数据
        String receiveString = Charset.forName("UTF-8").newDecoder().decode(clntRec.buffer).toString();
        System.out.println("服务端收到：" + receiveString);

        ByteBuffer buffer = ByteBuffer.wrap(receiveString.getBytes("UTF-8"));
        int bytesSent = channel.send(buffer, clntRec.clientAddress);
        if (bytesSent != 0) {
            key.interestOps(SelectionKey.OP_READ);
        }
    }
}

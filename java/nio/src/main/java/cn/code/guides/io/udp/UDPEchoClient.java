package cn.code.guides.io.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 描述：UDP客户端
 */
public class UDPEchoClient {

    private static final int TIME_OUT = 3000;

    public static void main(String[] args) throws IOException {

        DatagramChannel datagramChannel = DatagramChannel.open();
        //非阻塞模式
        datagramChannel.configureBlocking(false);
        datagramChannel.socket().setSoTimeout(TIME_OUT);

        String sendMessage = "hello,this is a message ";

        ByteBuffer writeBuffer = ByteBuffer.wrap(sendMessage.getBytes("UTF-8"));
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        datagramChannel = datagramChannel.connect(new InetSocketAddress("127.0.0.1", 5500));
        int totalBytesReceived = 0;
        int bytesReceived = 0;
        datagramChannel.write(writeBuffer);
        while (totalBytesReceived < sendMessage.length()) {
            if (writeBuffer.hasRemaining()) {
                datagramChannel.write(writeBuffer);
            }
            bytesReceived = datagramChannel.read(readBuffer);
            if (bytesReceived == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            totalBytesReceived += bytesReceived;
            System.out.println("获取数据：" + bytesReceived);
        }

        System.out.println("Received: " + new String(readBuffer.array(), 0, totalBytesReceived));
        datagramChannel.close();
    }
}

package cn.code.guides.io.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 描述：客户端，发送数据
 */
public class TCPClient {

    //选择器
    private Selector selector;

    //与服务器通信的信道
    SocketChannel socketChannel;

    //要连接的服务器IP地址和端口
    private String hostIp;
    private int port;

    public TCPClient(String hostIp, int port) {
        this.hostIp = hostIp;
        this.port = port;
    }

    public void initialize() throws IOException {
        //打开监听通道，
        socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, port));
        //设置为非阻塞模式
        socketChannel.configureBlocking(false);
        //注册选择器
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);
        //启动读线程
        new Thread(new TCPClientReadThread(selector)).start();
    }

    /**
     * 发送消息
     *
     * @param msg
     * @throws IOException
     */
    public void sendMsg(String msg) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes("UTF-8"));
        socketChannel.write(buffer);
    }

    //测试
    static boolean continueFlag = true;

    public static void main(String[] args) throws IOException {
        final TCPClient tcpClient = new TCPClient("127.0.0.1", 9527);
        tcpClient.initialize();

        //线程循环发送信息
        new Thread() {
            @Override
            public void run() {
                try {
                    tcpClient.sendMsg("通知:明天休息，不用上班！");
                    while (continueFlag) {
                        Scanner scanner = new Scanner(System.in);
                        tcpClient.sendMsg(scanner.next());
                    }

                } catch (IOException e) {
                    continueFlag = false;
                    e.printStackTrace();
                } finally {
                    continueFlag = false;
                }

            }
        }.start();

    }

}

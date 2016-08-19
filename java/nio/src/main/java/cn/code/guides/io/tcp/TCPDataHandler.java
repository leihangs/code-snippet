package cn.code.guides.io.tcp;

import cn.code.guides.io.utils.DataHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPDataHandler implements DataHandler {

    int  bufferSize;

    public TCPDataHandler(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void handleAccept(SelectionKey key) throws IOException {
        //创建此key的通道，接收客户端建立连接请求，并返回SocketChannel对象
        SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
        //设置通道为非阻塞式
        channel.configureBlocking(false);
        //注册selector
        channel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    //读取数据
    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        //得到并情况缓存区？
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        //读取
        int readBytes = channel.read(buffer);
        if (readBytes == -1) {
            //没有任何内容
            channel.close();
        } else {
            //设置缓存区为读模式
            buffer.flip();
            //将字节转换为utf-8的字节串
            String receiveString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
            String sendString = "您好，你发送的信息“" + receiveString + "”，已收到，请知悉!";
            System.out.println("服务端："+sendString);

            buffer = ByteBuffer.wrap(sendString.getBytes("UTF-8"));
            channel.write(buffer);
            //设置为下一次读或者写做准备
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }

    public void handleWrite(SelectionKey key) throws IOException {
//        System.out.println("handleWrite....");
    }
}

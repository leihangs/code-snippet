package cn.code.guides.io.utils;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * 数据处理
 */
public interface DataHandler {

    /**
     * 接收一个SocketChannel的处理
     *
     * @param key
     * @throws IOException
     */
    void handleAccept(SelectionKey key) throws IOException;

    /**
     * 从一个SocketChannel里读取信息
     *
     * @param key
     * @throws IOException
     */
    void handleRead(SelectionKey key) throws IOException;

    /**
     * 向一个SocketChannel写入信息
     *
     * @param key
     * @throws IOException
     */
    void handleWrite(SelectionKey key) throws IOException;
}

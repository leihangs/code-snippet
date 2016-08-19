package cn.code.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 描述：文件操作类
 */
public class FileUtils {


    /**
     * 文件移动，剪切操作
     *
     * @param sourceFile 原文件
     * @param targetDir  目标路径
     */
    public static void moveFile(File sourceFile, String targetDir) {
        File target = new File(targetDir);
        if (target == null || !target.isDirectory()) {
            target.mkdirs();
        }
        fileChannelCopy(sourceFile, new File(target + sourceFile.getName()));
        sourceFile.delete();
    }


    public static void fileChannelCopy(File sourceFile, File targetFile) {

        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(sourceFile);
            fo = new FileOutputStream(targetFile);
            in = fi.getChannel();
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
        } finally {
            try {
                if (fi != null) {
                    fi.close();
                }
                if (in != null) {
                    in.close();
                }
                if (fo != null) {
                    fo.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
    }
}

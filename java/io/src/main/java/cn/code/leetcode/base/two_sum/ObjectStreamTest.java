package cn.code.leetcode.base.two_sum;

import cn.code.leetcode.base.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 描述：ObjectOutputStream&&ObjectInputStream
 */
public class ObjectStreamTest {

    public static void main(String[] args) {
        List<Bill> dataList = createData();
        String filePath = "c://object.txt";
        createFile(filePath, dataList);
        readFile(filePath);
    }

    private static List<Bill> createData() {
        List<Bill> dataList = new ArrayList<Bill>();
        int dataSize = 50000;
        for (int i = 0; i < dataSize; i++) {
            int max = 99999;
            int min = 10000;
            Random random = new Random();
            int s = random.nextInt(max) % (max - min + 1) + min;
            String phone = 150650 + "" + s;

            Bill bill = new Bill();
            bill.setBillId(i);
            bill.setPhone(phone);
            bill.setStartDate(new Date());
            bill.setEndDate(new Date());
            dataList.add(bill);
        }
        return dataList;
    }

    public static void createFile(String filePath, List<Bill> dataList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(dataList);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void readFile(String filePath) {
        File dealfile = new File(filePath);
        FileInputStream fin = null;
        ObjectInputStream in = null;
        try {
            fin = new FileInputStream(dealfile);
            in = new ObjectInputStream(fin);
            List<Bill> list = (ArrayList) in.readObject();
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

package cn.code.leetcode.base.two_sum;

import cn.code.leetcode.base.Bill;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 描述：文件流，解析对象
 */
public class FileStreamTest {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void main(String[] args) throws Exception {

        String path = "c:\\input-text.txt";
        File file = new File(path);
        List<Bill> list = createData();
        writeTxt(list, path);
        readTxtData(path);
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

    public static void writeTxt(List<Bill> list, String path) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
        for (Bill bill : list) {
            StringBuffer fileBody = new StringBuffer();
            fileBody.append(bill.getBillId()).append("|");
            fileBody.append(bill.getPhone()).append("|");
            fileBody.append(simpleDateFormat.format(bill.getStartDate())).append("|");
            fileBody.append(simpleDateFormat.format(bill.getEndDate()));
            writer.write(fileBody.toString() + "\n");
        }
        writer.close();
        fileOutputStream.close();
    }

    public static List<Bill> readTxtData(String path) throws Exception {
        List<Bill> list = new ArrayList<Bill>();
        BufferedReader bufferedReader = null;
        try {
            InputStream is = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String dataInfo;
            while ((dataInfo = bufferedReader.readLine()) != null) {
                String[] data = dataInfo.split("\\|");
                Bill bill = new Bill();
                bill.setBillId(Long.parseLong(data[0]));
                bill.setPhone(data[1]);
                bill.setStartDate(simpleDateFormat.parse(data[2]));
                bill.setEndDate(simpleDateFormat.parse(data[2]));
                list.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        System.out.println("list size :" + list.size());
        return list;
    }

}

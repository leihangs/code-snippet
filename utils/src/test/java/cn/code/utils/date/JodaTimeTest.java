package cn.code.utils.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Joda Time使用示例
 */

public class JodaTimeTest {

    /**
     * 1、时间初始化：
     */
    @Test
    public void initMethod() {
        DateTime now = DateTime.now();
        //年,月,日,时,分
        DateTime dateTime1=new DateTime(2016, 07, 31, 23, 40);
        //年,月,日,时,分,秒
        DateTime dateTime2=new DateTime(2016, 07, 31, 23, 40,15);
        //年,月,日,时,分,秒,毫秒
        DateTime dateTime3=new DateTime(2016, 07, 31, 23, 40,15,333);
        //毫秒初始化
        DateTime dateTime4=new DateTime(System.currentTimeMillis());

        System.out.println("now="+now);
        System.out.println("dateTime1="+dateTime1);
        System.out.println("dateTime2="+dateTime2);
        System.out.println("dateTime3="+dateTime3);
        System.out.println("dateTime4="+dateTime4);
    }

    /**
     * 2.格式化方法
     */
    @Test
    public void formatMethod() {
        //Date to String
        DateTime dateTime=new DateTime(System.currentTimeMillis());
        System.out.println("dateTime="+dateTime.toString(DateFormatConstant.FORMAT_10));
        System.out.println("dateTime="+dateTime.toString(DateFormatConstant.FORMAT_14));
        System.out.println("dateTime="+dateTime.toString(DateFormatConstant.FORMAT_19));
        System.out.println("dateTime="+dateTime.toString(DateTimeFormat .forPattern(DateFormatConstant.FORMAT_19)));

        //String to Date
        //默认转换年月日
        String dateStr ="2016-07-31";
        DateTime date= DateTime.parse(dateStr);
        System.out.println(date);

        String dateStr1 ="2016-07-31 23:56:00";
        DateTime date1= DateTime.parse(dateStr1,DateTimeFormat.forPattern(DateFormatConstant.FORMAT_19));
        System.out.println(date1);

    }

    /**
     * 2.比较方法
     */
    @Test
    public void compareMethod() {

    }

}

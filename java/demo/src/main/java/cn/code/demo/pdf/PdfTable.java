package cn.code.demo.pdf;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
/**
 * Created by Administrator on 2016/9/1.
 */
public class PdfTable {

    public static void main(String[] args) throws Exception {
        Map dateMap = new HashMap();

        createTable(dateMap);
    }

    private static void createTable(Map map) throws Exception {

//        BaseFont bfChineseNormal = BaseFont.createFont("G:\\template\\JDBSJ.TTF", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);

        BaseFont bfChineseNormal = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);


        Font f12 = new Font(bfChineseNormal, 12, Font.NORMAL, Color.BLACK);
        Font f30 = new Font(bfChineseNormal, 30, Font.NORMAL, Color.BLACK);

        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        PdfWriter.getInstance(document, new FileOutputStream("d:/Helloworld2.PDF"));
        document.open();

        int headerHeight = 50;
        int defaultHeight = 25;
        int spaceHeight = 5;

        PdfPTable table = new PdfPTable(7);
        table.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

        table.addCell(createCell("单卡日通信详单", f30, 7, headerHeight, PdfPCell.ALIGN_CENTER));

        table.addCell(createCell(" ", f12, 7, spaceHeight, PdfPCell.ALIGN_LEFT));

        //第一排
        table.addCell(createCell("卡号：14765850705", f12, 3, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell(" ", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("处理时间：2016-06-21", f12, 3, defaultHeight, PdfPCell.ALIGN_LEFT));
        //第二排
        table.addCell(createCell(" ", f12, 7, spaceHeight, PdfPCell.ALIGN_LEFT));

        //第三排
        table.addCell(createCell("语音服务：", f12, 7, defaultHeight, PdfPCell.ALIGN_LEFT));
        //第4排
        table.addCell(createCell("", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("账期：2016-06", f12, 6, defaultHeight, PdfPCell.ALIGN_LEFT));
        //第5排
        table.addCell(createCell("", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("主叫分钟数：189", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("被叫分钟数：22", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("总通话分钟数：1045", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));

        //数据服务：
        table.addCell(createCell("语音服务：", f12, 7, defaultHeight, PdfPCell.ALIGN_LEFT));

        table.addCell(createCell("", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("APN：CMMOT", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("账期：2016-06", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("使用流量(KB)：1024", f12, 2, defaultHeight, PdfPCell.ALIGN_LEFT));

        //短信服务：
        table.addCell(createCell("短信服务：", f12, 7, defaultHeight, PdfPCell.ALIGN_LEFT));

        table.addCell(createCell("", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("短信账期：2016-06", f12, 6, defaultHeight, PdfPCell.ALIGN_LEFT));

        table.addCell(createCell("", f12, 1, defaultHeight, PdfPCell.ALIGN_LEFT));
        table.addCell(createCell("短信上行条数：5000", f12, 6, defaultHeight, PdfPCell.ALIGN_LEFT));

        document.add(table);
        document.close();
    }

    private static void createTable() throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("d:/Helloworld.PDF"));
        document.open();
        document.add(new Paragraph("Hello World"));
        Table table = new Table(3);
        table.setBorderWidth(1);
        table.setBorderColor(new Color(0, 0, 255));
        table.setPadding(5);
        table.setSpacing(5);
        Cell cell = new Cell("header");
        cell.setHeader(true);
        cell.setColspan(3);
        table.addCell(cell);
        table.endHeaders();
        cell = new Cell("example cell with colspan 1 and rowspan 2");
        cell.setRowspan(2);
        cell.setBorderColor(new Color(255, 0, 0));
        table.addCell(cell);
        table.addCell("1.1");
        table.addCell("2.1");
        table.addCell("1.2");
        table.addCell("2.2");
        table.addCell("cell test1");
        cell = new Cell("big cell");
        cell.setRowspan(2);
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("cell test2");
        document.add(table);
        document.close();
    }

    private static PdfPCell createCell(String value, Font cellFont, int colspan, int minHeight, int hAlign) throws Exception {
        PdfPCell cell = new PdfPCell(new Paragraph(value, cellFont));
        cell.setColspan(colspan);
        cell.setBorder(0);
        cell.setHorizontalAlignment(hAlign);
        cell.setMinimumHeight(minHeight);
        return cell;
    }
}

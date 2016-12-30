package cn.code.leetcode.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：数据对象，账单数据
 */
public class Bill implements Serializable {
    private long billId;
    private String phone;
    private Date startDate;
    private Date endDate;

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

package cn.code.design.observer.cancel;

/**
 * @author: leihang@live.cn
 * @date: 2016-11-17 17:01
 * @description:
 */

public class FinanceObserver implements OrderCancelObserver {
    public void cancel(String orderId) {
        System.out.println("收到消息：退款结算，优惠卷回收...");
    }
}


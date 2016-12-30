package cn.code.design.observer.cancel;

/**
 * @author: leihang@live.cn
 * @date: 2016-11-17 16:59
 * @description:
 */

public class StoreObserver implements OrderCancelObserver {
    public void cancel(String orderId) {
        System.out.println("收到消息：查询订单中的物品情况，通知管理员，根据订单目前的情况，取消配送物品或者回收入库");
    }
}

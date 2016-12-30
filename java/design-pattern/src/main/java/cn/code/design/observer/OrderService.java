package cn.code.design.observer;

import cn.code.design.observer.cancel.FinanceObserver;
import cn.code.design.observer.cancel.Order;
import cn.code.design.observer.cancel.StoreObserver;

/**
 * @author: leihang@live.cn
 * @date: 2016-11-17 16:54
 * @description: 订单服务
 */
public class OrderService {

    public static void main(String[] args) {
        Order order = new Order();
        order.addWatcher(new StoreObserver());
        order.addWatcher(new FinanceObserver());
        order.cancel("ORDERID_0011");
    }

}

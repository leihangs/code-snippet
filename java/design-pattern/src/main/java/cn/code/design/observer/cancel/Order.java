package cn.code.design.observer.cancel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: leihang@live.cn
 * @date: 2016-11-24 14:55
 * @description: 被观察者，订单
 */

public class Order {

    private List<OrderCancelObserver> observers = new ArrayList<OrderCancelObserver>();

    public void cancel(String orderId){
        System.out.println("订单已经取消...请执行后续操作");
        notifyWatchers(orderId);
    }

    public void addWatcher(OrderCancelObserver watcher) {
        observers.add(watcher);
    }

    public void removeWatcher(OrderCancelObserver watcher) {
        observers.remove(watcher);
    }

    public void notifyWatchers(String orderId) {
        for (OrderCancelObserver watcher : observers) {
            watcher.cancel(orderId);
        }
    }

}

package cn.code.design.observer.cancel;

/**
 * @author: leihang@live.cn
 * @date: 2016-11-17 16:57
 * @description:
 */

public interface OrderCancelObserver {
    public void cancel(String orderId);
}

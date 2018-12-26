package com.ykf.suanfa.seqnumber.snow;

/**
 * @author sunyq
 * @date 2018/6/1
 */
public class SnowFlakeUtil {
    private final static long DATA_CENTER_ID = 1;
    private final static long MACHINE_ID = 1;
    private final static SnowFlake snowFlake = new SnowFlake(DATA_CENTER_ID, MACHINE_ID);

    /**
     * 获取订单号
     *
     * @return
     */
    public static long getOrderCode() {
        return snowFlake.nextId();
    }

    /**
     * 获取支付单号
     *
     * @return
     */
    public static long getPayNumber() {
        return snowFlake.nextId();
    }
}

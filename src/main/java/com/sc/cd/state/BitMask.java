package com.sc.cd.state;

public class BitMask {
    // 0001
    public static final int WAIT = 1 << 0;
    // 0010
    public static final int PROCESSING = 1 << 1;
    // 0100
    public static final int SUCCESS = 1 << 2;
    // 1000
    public static final int FAIL = 1 << 3;


    private static int orderSyncState;


    public static void enable(int state) {
        orderSyncState |= state;
    }

    // 检查订单头是否包含特定状态
    public boolean hasStatus(int status) {
        return (orderSyncState & status) != 0;
    }

    // 添加状态到位掩码
    public void addStatus(int status) {
        if (!hasStatus(status)) { // 如果当前状态未包含，则添加
            orderSyncState |= status;
        }
    }

    // 移除状态
    public void removeStatus(int status) {
        if (hasStatus(status)) { // 如果当前状态包含，则移除
            orderSyncState &= ~status; // 使用按位与非操作移除状态
        }
    }


    public static void main(String[] args) {
        System.out.println("WAIT" + WAIT);
        System.out.println("PROCESSING" + PROCESSING);
        System.out.println("SUCCESS" + SUCCESS);
        System.out.println("FAIL" + FAIL);


        enable(SUCCESS);
        enable(FAIL);
        enable(PROCESSING);

        System.out.println("orderSyncState" + orderSyncState);


        orderSyncState = 0;

        enable(WAIT);
        enable(FAIL);
        enable(PROCESSING);

        System.out.println("orderSyncState" + orderSyncState);

        orderSyncState = 0;

        enable(WAIT);
        enable(FAIL);

        System.out.println("orderSyncState" + orderSyncState);

        orderSyncState = 0;

        enable(WAIT);
        enable(PROCESSING);

        System.out.println("orderSyncState" + orderSyncState);
        System.out.println("============");

        orderSyncState = 0;

        enable(SUCCESS);
        enable(PROCESSING);


        System.out.println("orderSyncState" + orderSyncState);

        enable(SUCCESS);
        System.out.println("orderSyncState" + orderSyncState);

        enable(PROCESSING);
        System.out.println("orderSyncState" + orderSyncState);

    }

}

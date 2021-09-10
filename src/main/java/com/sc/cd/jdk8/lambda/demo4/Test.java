package com.sc.cd.jdk8.lambda.demo4;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:45
 */
public class Test {
    public static void main(String[] args) {
        // lambda
        MyInterface myInterface = (int a, int b) -> {return a + b; };
        System.out.println(myInterface.sum(1,2));
        // lambda 简写
        myInterface = (a, b) -> {return a + b; };
        System.out.println(myInterface.sum(1,2));

        myInterface = (a, b) ->  a + b;
        System.out.println(myInterface.sum(1,22));

        System.out.println("d7+ZO+9e/ahVgnTeSJR/bj4t7TsENQh6Wr5DriQHx7avBfrqEGJplAhbwXWuJazYuuWFnvWofjEAldX7e5FzpPT95AQ702B17VIBwJYgMyc7a+942jriandbsKJtTsPDSqDH0eirDCMb0DG9ea+aZuJ3eA1Zronk2k8z+kVPQ/lX97HZn8vSwWj2yJe83omI0niF6+cpysY46TrJ5cEsbQr3nCJ8Ji+P9dcPN5wTh1k=".length());
    }
}

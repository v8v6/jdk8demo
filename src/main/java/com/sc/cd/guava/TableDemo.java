package com.sc.cd.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-28 21:45
 */
public class TableDemo {
    public static void main(String[] args) {
        Table<Integer, Integer, Integer> table = HashBasedTable.<Integer, Integer, Integer>create();
        table.put(1, 2, 3);
        //允许row和column确定的二维点重复
        table.put(1, 6, 3);
        //判断row和column确定的二维点是否存在
        if(table.contains(1, 2)) {
            table.put(1, 4, 4);
            table.put(2, 5, 4);
        }
        System.out.println(table);
        System.out.println(table.rowMap().getClass());

        System.out.println("-------------------------------------");
        //获取column为5的数据集
        Map<Integer, Integer> column = table.column(5);
        System.out.println(column);
        //获取rowkey为1的数据集
        Map<Integer, Integer> row = table.row(1);
        System.out.println(row);
        //获取rowKey为1，columnKey为2的的结果
        Integer value = table.get(1, 2);
        System.out.println(value);
        //判断是否包含columnKey的值
        System.out.println(table.containsColumn(3));
        //判断是否包含rowKey为1的视图
        System.out.println(table.containsRow(1));
        //判断是否包含值为2的集合
        System.out.println(table.containsValue(2));
        //将table转换为Map套Map格式
        Map<Integer, Map<Integer, Integer>> rowMap = table.rowMap();
        System.out.println(rowMap);
        //获取所有的rowKey值的集合
        Set<Integer> keySet = table.rowKeySet();
        System.out.println(keySet);
        //删除rowKey为1，columnKey为2的元素，返回删除元素的值
        Integer res = table.remove(1, 2);
        //清空集合
        table.clear();
        System.out.println(res);
        System.out.println(table);
    }
}

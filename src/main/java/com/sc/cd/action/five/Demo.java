package com.sc.cd.action.five;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-24 09:17
 */
public class Demo {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> list = transactions.stream().filter(d -> d.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(list);

        // 交易员都在哪些不同的城市工作过？
        List<String> stringList = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(stringList);
        Set<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(collect1);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge")).sorted(comparing(Trader::getCity)).collect(Collectors.toList());
        System.out.println(cambridge);

        // 返回所有交易员的姓名字符串，按字母顺序排序
        String s = transactions.stream().map(d -> d.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 +","+ n2);
        System.out.println(s);

        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());


        // 有没有交易员是在米兰工作的？
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).distinct().filter(t -> Objects.equals(t.getCity(), "Milan")).collect(Collectors.toList());
        System.out.println(traders);

        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println(milanBased);

        transactions.stream().filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        Optional<Integer> optional = transactions.stream().filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge")).map(Transaction::getValue).reduce(Integer::max);
        optional.ifPresent(System.out::println);
        Optional<Transaction> min = transactions.stream().min(comparing(Transaction::getValue));
        min.ifPresent(System.out::println);

    }
}

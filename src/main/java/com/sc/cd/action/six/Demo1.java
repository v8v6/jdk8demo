package com.sc.cd.action.six;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-24 14:50
 */
public class Demo1 {

    public static void main(String[] args) {
        boolean prime = isPrime(7);
        System.out.println(prime);
        IntStream range = IntStream.range(2, 6);
        range.boxed().forEach(System.out::println);

        System.out.println("===============");
        Map<Boolean, List<Integer>> map = partitionPrimes(9);
        System.out.println(map);
        System.out.println("===============");
        int candidateRoot = (int) Math.sqrt((double) 9);
        System.out.println(candidateRoot);

        long l = parallelSum(100);
        System.out.println(l);
        System.out.println("==========================");

        Long reduce = Stream.iterate(1L, i -> i + 1)
                .parallel()
                .filter(i -> {
                    System.out.println(i);
                    return i > 10;
                })
                .sequential()
                .map(P -> {
                    System.out.println(P);
                    return P;
                })
                .limit(100)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(reduce);

    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> {
                    System.out.println(i);
                    return candidate % i == 0;
                });
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }


}

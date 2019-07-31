package com.sc.cd.jdk8.stream.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sc.cd.action.six.Dish;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class CollectorDemo {

    public static void main(String[] args) {

        List<Dish> menuStream = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        List<Dish> dishes = menuStream.stream().collect(
                ArrayList::new, List::add, List::addAll);

        dishes = menuStream.stream().collect(Collectors.toList());
    }

}

class ToListCollector<T> implements Collector<T, List<T>, List<T>>
{
    /**
     * 建立新的结果容器:supplier方法
     * supplier方法必须返回一个结果为空的Supplier，也就是一个无参数函数，在调用时，它会创建一个空的累加器实例，供数据收集过程使用。
     * 就个人通俗的理解来说，这个方法定义你如何收集数据，之所以提炼出来就是为了让你可以传lambda表达式来指定收集器。
     * 对于toList, 我们直接返回一个空list就好。
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 将元素添加到结果容器:accumulator方法
     * 当遍历到流中第n个元素时，这个函数就会执行。函数有两个参数，第一个参数是累计值，第二参数是第n个元素。
     * 累加值与元素n如何做运算就是accumulator做的事情了。比如toList, 累加值就是一个List，对于元素n，当然就是add。
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 合并两个结果容器 combiner
     *上面看起来似乎已经可以工作了，这是针对顺序执行的情况。我们知道Stream天然支持并行，但并行却不是毫无代价的。
     * 想要并行首先就必然要把任务分段，然后才能并行执行，最后还要合并。
     * 虽然Stream底层对我们透明的执行了并行，但如何并行还是需要取决于我们自己。这就是combiner要做的事情。
     * combiner方法会返回一个供归约操作使用的函数，它定义了对流的各个子部分并行处理时，各个字部分归约所得的累加器要如何合并。
     * 对于toList而言，Stream会把流自动的分成几个并行的部分，每个部分都执行上述的归约，汇集成一个List。当全部完成后再合并成一个List。
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 对结果容器应用最终转换:finisher方法
     * 遍历完流之后，我们需要对结果做一个处理，返回一个我们想要的结果。这就是finisher方法所定义的事情
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 最后一个方法characteristics会返回一个不可变的Characteristics集合，
     * 它定义了收集器的行为--尤其是关于流是否可以并行归约，以及可以使用哪些优化的提示。
     * Characteristics是一个包含三个项目的枚举：
     *
     * UNORDERED--归约结果不受流中项目的遍历和累积顺序的影响
     * CONCURRENT--accumulator函数可以从多个线程同时调用，且该收集器可以并行归约流。
     *             如果收集器没有标为UNORDERED, 那它仅在用于无序数据源时才可以并行归约。
     * IDENTITY_FINISH--这表明完成器方法返回的函数是一个恒等函数，可以跳过。
     *                  这种情况下，累加器对象将会直接用做归约过程的最终结果。这也意味着，将累加器A不加检查地转换为结果R是安全的。
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                IDENTITY_FINISH, CONCURRENT));
    }
}

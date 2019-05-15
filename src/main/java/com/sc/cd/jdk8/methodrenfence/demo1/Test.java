package com.sc.cd.jdk8.methodrenfence.demo1;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:41
 */
public class Test {

    public static void main(String[] args) {

        // 匿名内部类方式,创建对象
        PersonFactory factory = new PersonFactory() {
            @Override
            public Person createPerson(String firstName, String lastName) {
                return new Person(firstName, lastName);
            }
        };

        Person person = factory.createPerson("张", "三");
        System.out.println(person);


        // lambda表达式
        factory = (firstName, lastName) -> new Person(firstName, lastName);
        person = factory.createPerson("李", "三");
        System.out.println(person);

        // 构造方法引用
        factory = Person::new;
        person = factory.createPerson("王", "五");
        System.out.println(person);


    }
}

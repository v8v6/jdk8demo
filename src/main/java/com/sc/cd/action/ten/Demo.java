package com.sc.cd.action.ten;

import java.util.Optional;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-25 17:20
 */
public class Demo {

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();
        //System.out.println(optCar.get());

        optCar = Optional.ofNullable(null);
        //optCar.get();

        Optional<Insurance> optInsurance = Optional.ofNullable(null);
        Optional<String> name1 = optInsurance.map(Insurance::getName);
        System.out.println(name1);

        optInsurance.filter(i -> "a".equals(i.getName())).ifPresent(x->System.out.println("ok"));


        Person person = Person.builder().car(Optional.ofNullable(Car.builder().insurance(Optional.ofNullable(Insurance.builder().name("test").build())).build())).build();
        Optional<Person> optPerson = Optional.of(person);
        String name =
                optPerson.flatMap(Person::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getName).orElse("Unknown");
        System.out.println(name);

        /*name = optPerson.map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName);*/
        optPerson.filter(person1 -> person1.getCar().get() instanceof Car).get();




    }
}

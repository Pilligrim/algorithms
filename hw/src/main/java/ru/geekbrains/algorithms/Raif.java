package ru.geekbrains.algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Raif {
    public static void main(String[] args) {
        List<Person> persons =
                Stream.of(new Person("Ivan", 550),
                          new Person("Peter", 30),
                          new Person("Ivan", 40),
                          new Person("Ivan", 50)).toList();
        System.out.println(getTopAgeForName(persons));
        /*
        select name, max(age) from Person
        group by name;

        select name, age, count(name) from Person
        group by name, age
        having count(name) > 1;
         */


    }

    static List<Person> getTopAgeForName(List<Person> persons) {
//      return new ArrayList<>(persons.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)).values());

        Map<String, Person> map = new HashMap<>();
//        persons.stream().forEach(p-> {
//                    map.putIfAbsent(p.getName(), p);
//                    map.computeIfPresent(p.getName(), (curName, prev) -> new Person(curName, Math.max(p.getAge(), prev.getAge())));
//                }
//        );
//       persons.forEach(p -> map.compute(p.getName(), (curName, prev) -> prev != null ? new Person(curName, Math.max(p.getAge(), prev.getAge())) : p));
//
        persons.forEach(p -> map.merge(p.getName(), p, (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2));
        return new ArrayList<>(map.values());
    }

    static class Person {
        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

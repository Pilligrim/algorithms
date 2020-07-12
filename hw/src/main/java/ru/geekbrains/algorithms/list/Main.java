package ru.geekbrains.algorithms.list;

import ru.geekbrains.algorithms.Cat;

public class Main {
    public static void main(String[] args) {
        RelatedList<Cat> rl = new RelatedList<>();
        rl.push(new Cat(2, "cat1"));
        rl.push(new Cat(3, "cat2"));
        rl.push(new Cat(4, "cat3"));
        rl.push(new Cat(5, "cat4"));
        rl.push(new Cat(6, "cat5"));
        System.out.println(rl);
        System.out.println(rl.pop());
        System.out.println(rl);
    }
    //reset();
    //next();
    //getCurrent();
    //hasNext();
    //atEnd();
    //insertAfter();
    //*insertBefore();
    //deleteCurrent();
}

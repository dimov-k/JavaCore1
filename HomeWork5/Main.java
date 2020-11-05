

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);

        // Для фиксированой возможностей животных

/*        double distanceRun = 200;
        double distanceJump = 2;
        double distanceSwim = 0;
        Cat cat = new Cat(distanceRun, distanceJump, distanceSwim);

        distanceRun = 5;
        distanceJump = 0.2;
        distanceSwim = 0;
        Bird bird = new Bird(distanceRun, distanceJump, distanceSwim);

        distanceRun = 500 ;
        distanceJump = 0.5;
        distanceSwim = 10;
        Animals dog = new Dog(distanceRun, distanceJump, distanceSwim);

        distanceRun = 1500;
        distanceJump = 3;
        distanceSwim = 100;
        Horse horse = new Horse(distanceRun, distanceJump, distanceSwim);*/


    // Рэндомная сила всех животных, но не выше заданных параметров.

        double distanceRun = Math.random() * 400;
        double distanceJump = Math.random() * 5;
        double distanceSwim = Math.random() * 0;
        Cat cat = new Cat(distanceRun, distanceJump, distanceSwim);

        distanceRun = Math.random() * 5;
        distanceJump = Math.random() * 2;
        distanceSwim = Math.random() * 0;
        Bird bird = new Bird(distanceRun, distanceJump, distanceSwim);

        distanceRun = Math.random() * 800 ;
        distanceJump = Math.random() * 5;
        distanceSwim = Math.random() * 90;
        Animals dog = new Dog(distanceRun, distanceJump, distanceSwim);

        distanceRun = Math.random() * 3000;
        distanceJump = Math.random() * 30;
        distanceSwim = Math.random() * 500;
        Horse horse = new Horse(distanceRun, distanceJump, distanceSwim);


        System.out.println("Кошка может пробежать: " + cat.getAnimalDistanceRun() +
                " м. \nПтица может пробежать: " + bird.getAnimalDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getAnimalDistanceRun() +
                " м. \nЛошадь может пробежать: " + horse.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега животных:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка бежит(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Птица бежит(" + distance + "). Результат: " + bird.run(distance));
        System.out.println("Собака бежит(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("Лошадь бежит(" + distance + "). Результат: " + horse.run(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может прыгнуть: " + cat.getAnimalDistanceJump() +
                " м. \nПтица может прыгнуть: " + bird.getAnimalDistanceJump() +
                " м. \nСобака может прыгнуть: " + dog.getAnimalDistanceJump() +
                " м. \nЛошадь может прыгнуть: " + horse.getAnimalDistanceJump() + " м.");


        System.out.println("Введите высоту прыжка животных:");
        distance = scanner.nextDouble();

        System.out.println("Кошка прыгает(" + distance + "). Результат: " + cat.jump(distance));
        System.out.println("Птица прыгает(" + distance + "). Результат: " + bird.jump(distance));
        System.out.println("Собака прыгает(" + distance + "). Результат: " + dog.jump(distance));
        System.out.println("Лошадь прыгает(" + distance + "). Результат: " + horse.jump(distance));
        System.out.println("\n****************\n");


        System.out.println("Кошка может проплыть: " + cat.getAnimalDistanceSwim() +
                " м. \nПтица может проплыть: " + bird.getAnimalDistanceSwim() +
                " м. \nСобака может проплыть: " + dog.getAnimalDistanceSwim() +
                " м. \nЛошадь может проплыть: " + horse.getAnimalDistanceSwim() + " м.");


        System.out.println("Введите дистанцию для плавания животных:");
        distance = scanner.nextDouble();


        System.out.println("Кошка плывет, но испугалась(" + distance + "). Результат: " + cat.swim(distance));
        System.out.println("У птицы есть дела поважнее, чем плыть(" + distance + "). Результат: " + bird.swim(distance));
        System.out.println("Собака плывет(" + distance + "). Результат: " + dog.swim(distance));
        System.out.println("Лошадь плывет(" + distance + "). Результат: " + horse.swim(distance));
        System.out.println("\n****************\n");


    }
}

   /* Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
        Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
        У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
        При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
        * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.*/
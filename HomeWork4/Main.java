public class Main {

    public static void main(String[] args) {
        Users[] users = {
                new Users("Петров.И.О ", "Директор ", "+7(915)4568523 ", 500000, 56),
                new Users("Иванов.К.А ", "Аналитик", "+7(999)4568190", 50000, 45),
                new Users("Bender.I.I ", "Бог ИИ", "+7(916)4567393", 10100101, 15),
                new Users("Пивненко.Л.И ", "Бухгалтер", "+7(910)4535523", 70000, 39),
                new Users("Чижов Е.А ", "Инженер Программист", "+7(915)4568523", 80000, 78)
        };
        System.out.println("\n____Вывести при помощи методов  ФИО и должность.____");
        System.out.println(users[0].getFullName() + "| Должность: " + users[0].getPost());
        System.out.println(users[1].getFullName() + "| Должность: " + users[1].getPost());
        System.out.println(users[2].getFullName() + "| Должность: " + users[2].getPost());

        System.out.println("\n____Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;____");
        for (Users employees : users) {
            if (employees.getAge() > 40)
                employees.getFullUsersInfo();
        }
        System.out.println("\n____Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000____");
       salaryUp(users, 45, 5000);
        for (Users employees : users) employees.getFullUsersInfo();
    }
       public static void salaryUp(Users[] users, int age, int raise) {
            for (Users employees : users) {
                if (employees.getAge() >= age) employees.setSalary(employees.getSalary() + raise);
            }
    }

}

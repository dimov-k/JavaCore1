public class Users {


        private String fio;
        private String post;
        private String tel;
        private int salary;
        private int age;
        private int userID; //не додумал мыслю

        public Users(String fio, String post, String tel, int salary, int age) {
            this.fio = fio;
            this.post =post;
            this.tel = tel;
            this.salary = salary;
            this.age = age;
            this.userID = 0; 
        }
    //Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getFullName() {
        return fio;
    }

    public String getPost() {
        return post;
    }

    public String getTel() {
        return tel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getUserID(){
            return userID;
    }

    public void getFullUsersInfo(){
            System.out.println("ФИО: " + fio + " | Должность: " + post +
                    " | Телефон : " + tel + " | Зарплата: " + salary + " | Возраст: " + age);
        System.out.println();
        }

    }



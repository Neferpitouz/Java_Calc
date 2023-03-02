public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Teacher t1 = new Teacher();
        t1.age = 44;
        t1.name = "Harry";
        System.out.println(t1.retirement());
    }
}

class Teacher {
    int age;
    String name;
    int retirement(){
        int leftover = 70 - age;
        return leftover;
    }
}
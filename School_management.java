import java.util.*;
abstract class Person {
    private int id;
    private String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole();
}
class Teacher extends Person {
    public Teacher(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Teaching";
    }
}

class Student extends Person {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Studying";
    }
}
public class School_management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            System.out.println("\n===== SCHOOL MANAGEMENT =====");
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Student");
            System.out.println("3. List Teachers");
            System.out.println("4. List Students");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 5) {
                System.out.println("Exiting School Management System...");
                break;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter Teacher ID: ");
                    int tId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Teacher Name: ");
                    String tName = sc.nextLine();
                    people.add(new Teacher(tId, tName));
                    System.out.println("Teacher added.");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    people.add(new Student(sId, sName));
                    System.out.println("Student added.");
                    break;

                case 3:
                    System.out.println("\n--- Teachers ---");
                    for (Person p : people) {
                        if (p instanceof Teacher) {
                            System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Role: " + p.getRole());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Students ---");
                    for (Person p : people) {
                        if (p instanceof Student) {
                            System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Role: " + p.getRole());
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

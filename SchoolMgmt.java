import java.util.*;

// Abstraction + Encapsulation
abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.id = id;
        this.name = name.trim();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole(); // Polymorphism
}

// Inheritance
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

// Main driver
public class SchoolMgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n===== SCHOOL MANAGEMENT =====");
                System.out.println("1. Add Teacher");
                System.out.println("2. Add Student");
                System.out.println("3. List Teachers");
                System.out.println("4. List Students");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                if (!sc.hasNextInt()) {
                    throw new InputMismatchException("Menu choice must be a number.");
                }

                int ch = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (ch == 5) {
                    System.out.println("Exiting School Management System...");
                    break;
                }

                switch (ch) {
                    case 1:
                        try {
                            System.out.print("Enter Teacher ID: ");
                            int tId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Teacher Name: ");
                            String tName = sc.nextLine();
                            people.add(new Teacher(tId, tName));
                            System.out.println("Teacher added.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. ID must be a number.");
                            sc.nextLine(); // clear buffer
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Enter Student ID: ");
                            int sId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Student Name: ");
                            String sName = sc.nextLine();
                            people.add(new Student(sId, sName));
                            System.out.println("Student added.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. ID must be a number.");
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Teachers ---");
                        boolean tFound = false;
                        for (Person p : people) {
                            if (p instanceof Teacher) {
                                System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Role: " + p.getRole());
                                tFound = true;
                            }
                        }
                        if (!tFound) System.out.println("No teachers available.");
                        break;

                    case 4:
                        System.out.println("\n--- Students ---");
                        boolean sFound = false;
                        for (Person p : people) {
                            if (p instanceof Student) {
                                System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Role: " + p.getRole());
                                sFound = true;
                            }
                        }
                        if (!sFound) System.out.println("No students available.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        sc.close();
    }
}

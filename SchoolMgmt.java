import java.util.*;

public class SchoolMgmt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        while (true) {
            System.out.println("\n=== School Management System ===");
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Student");
            System.out.println("3. Show Teachers");
            System.out.println("4. Show Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }
            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher ID: ");
                    try {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Teacher Name: ");
                        String name = scanner.nextLine();
                        people.add(new Teacher(id, name));
                        System.out.println("Teacher added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input for ID.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    try {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        people.add(new Student(id, name));
                        System.out.println("Student added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input for ID.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Teachers ---");
                    boolean hasTeachers = false;
                    for (Person p : people) {
                        if (p instanceof Teacher) {
                            System.out
                                    .println("ID: " + p.getId() + ", Name: " + p.getName() + ", Role: " + p.getRole());
                            hasTeachers = true;
                        }
                    }
                    if (!hasTeachers) {
                        System.out.println("No teachers found.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Students ---");
                    boolean hasStudents = false;
                    for (Person p : people) {
                        if (p instanceof Student) {
                            System.out
                                    .println("ID: " + p.getId() + ", Name: " + p.getName() + ", Role: " + p.getRole());
                            hasStudents = true;
                        }
                    }
                    if (!hasStudents) {
                        System.out.println("No students found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }
        }
        scanner.close();
    }
}
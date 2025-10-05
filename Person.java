abstract class Person implements Role {
    private int id;
    private String name;

    public Person(int id, String name) {
        if (id <= 0) {
            System.out.println("Error: ID must be a positive number.");
            return;
        }
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }
        this.id = id;
        this.name = name.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
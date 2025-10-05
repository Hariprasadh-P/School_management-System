class Student extends Person {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
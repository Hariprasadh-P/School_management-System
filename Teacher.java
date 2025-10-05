class Teacher extends Person {
    public Teacher(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}
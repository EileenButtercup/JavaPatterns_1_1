public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("Введите корректный возраст (age).");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() {
        Person per = null;

        if (validateEmployee()) {
            per = new Person(this);
        } else {
            throw new IllegalStateException("Извините! Необходимо указать имя и фамилию.");
        }
        return per;
    }

    private boolean validateEmployee() {
        return (name != null && !name.trim().isEmpty() && surname != null && !surname.trim().isEmpty());
    }
}

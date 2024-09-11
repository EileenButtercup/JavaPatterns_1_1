import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;

    protected Integer age;
    protected String address;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge()) age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(getSurname());
        personBuilder.setAddress(getAddress());
        return personBuilder;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[name= ").append(name)
                .append(", surname= ").append(surname)
                .append(", age= ").append(age)
                .append(", address= ").append(address).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}

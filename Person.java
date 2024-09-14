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
        try {
            return age >= 0;
        } catch (NullPointerException except) {
            System.out.println("Введите возраст (age).");
            throw except;
        }
    }


    public boolean empty(OptionalInt q) {
        // Действия для ситуации, когда строка не является null и одновременно пуста.
        return String.valueOf(q) != null || String.valueOf(q).isEmpty();
    }

    public boolean equals() {

        return String.valueOf(age) != null;
    }

    public boolean equalsWithNulls(OptionalInt q) {
        return q.isPresent();
    }

    public String proverka() {
        if (equals()) {
            return "Возраст введен";
        }
        return "возраст не введен";
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        try {
            if (equalsWithNulls(OptionalInt.of(age))) {
                return OptionalInt.of(age);
            }
            if (empty(OptionalInt.of(age))) {
                return OptionalInt.of(age);
            }

            return OptionalInt.empty();
        } catch (NullPointerException except) {
            System.out.println("Введите возраст (age).");
            throw except;
        }
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

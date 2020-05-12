package ee.jpa;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id //Указатель первичного ключа Primary key, может быть над несколькими полями(составной первичный ключ)
    @GeneratedValue
    int id;
    String name;

    // !!! для классов @Entity всегда должен быть конструктор по уполчанию
    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }
}

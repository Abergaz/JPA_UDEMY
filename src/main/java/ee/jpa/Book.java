package ee.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    int id;
    String name;

    public Book(String name)
    {
        this.name =name;
    }
}

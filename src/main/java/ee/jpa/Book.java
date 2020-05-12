package ee.jpa;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue
    int id;
    /** FetchType.EAGER по умолчанию, загрузка сразу при считывании, FetchType.LAZY - при обращении*/
    @Basic(fetch = FetchType.EAGER)
    String name;

    @Basic(fetch = FetchType.LAZY) /** грузить картинку только при обращении*/
    @Lob /** BLOB - увеличенного размера*/
    byte[] img;

    @Basic(optional = false )/** По умолчанию false - значит атрибут Not Null, если true - то NULL */
    String desc;


    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }
}

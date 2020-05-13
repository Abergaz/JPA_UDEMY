package ee.jpa;

import javax.persistence.*;

@Entity
public class Student20 {
    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.ALL) //Вид отношения
    @JoinColumn(name="adressId") //имя коллонки в таблице студента в которой хоранится ключ на запись в таблице адресс
    Adress adress;

    public Student20() {
    }
    public Student20(String name) {
        this.name=name;
    }
}


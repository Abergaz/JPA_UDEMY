package ee.jpa;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Student19 {
    @Id
    @GeneratedValue
    int id;
    String name;
    /**  помечаем что используем встрроиваемый класс
     * его поля встроятся в туже таблицу*/
    @Embedded
    Adress adress;

    public Student19() {
    }
    public Student19(String name) {
        this.name=name;
        Adress a = new Adress();
        a.city="Moscow";
        a.street="Arbat";
        this.adress=a;
    }
}
/**  помечаем, что класс встраиваемый*/
@Embeddable
class Adress{
    String city;
    String street;
}
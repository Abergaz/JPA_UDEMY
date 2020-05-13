package ee.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student13 {
    @Id
    @GeneratedValue
    String name;
    @Transient /** Поля помечанные @Transient или transient в БД не сохраняются */
    int age;
    Date birth;
}

package ee.jpa;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Student15 {
    @Id
    @GeneratedValue
    String name;
    int age;
    /** numType.ORDINAL - по умолчнию ENUM'ы сохраняют числовой индекс в таблице
     * numType.STRING - хранит текстовое представление */
    @Enumerated(EnumType.STRING)
    Gender gender;

    public Student15(){}
    public Student15(String name){
        this.name=name;
    }
}
enum Gender{
    ALIEN,
    MALE,
    FEMALE
}

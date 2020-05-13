package ee.jpa;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
/**
 * AccessType.FIELD - доступ через поля
 * AccessType.PROPERTY - доступ через геттеры
@Access(AccessType.FIELD) /** на весь класс через поля */
public class Student16 {
    @Id
    @GeneratedValue
    int id;
    String name;

    public Student16() {
    }
    public Student16(String name) {
        this.name=name;
    }
    /** а к этому полю доступ будет через геттр
     В БД запишется "Mr."+name, т.к.для записи в БД значение из
     обьекта извлекается геттером то и анотацию пишем над геттером
     */
    @Access(AccessType.PROPERTY)
    public String getName() {
        return "Mr."+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

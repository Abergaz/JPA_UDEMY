package ee.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity //Помечаем класс как запись такблицы и все его свойства - это столбцы
public class Student {
    @Id//уникальный идентификатор
    @GeneratedValue // генериться автоматически уникальное значение
    int id;
    String name;
    int age;
    Date birth;
}

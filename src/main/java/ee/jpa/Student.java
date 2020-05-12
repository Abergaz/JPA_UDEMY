package ee.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity //Помечаем класс как запись такблицы и все его свойства - это столбцы
@Table(name = "Students")//Указываем как будет называться таблица для @Entity данного класс

@SecondaryTables({@SecondaryTable(name="Adresses"), @SecondaryTable(name="Countrys")})//Вынос даных в несколько таблиц
public class Student {
    //уникальный идентификатор @Id казатель первичного ключа Primary key, может быть над несколькими полями(составной первичный ключ)
    @Id
    /**  Можно не использовать @GeneratedValue, если в таблице настроить auto_increment для данного столбца*/
    int id;
    String name;
    int age;
    Date birth;
    @Column(table = "Adresses")//Доя выноса данных в другую таблицу
    String city;
    @Column(table = "Adresses")
    String street;
    @Column(table = "Countrys")
    String country;

    // !!! для классов @Entity всегда должен быть конструктор по уполчанию
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

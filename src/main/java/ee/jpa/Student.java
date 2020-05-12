package ee.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity //Помечаем класс как запись такблицы и все его свойства - это столбцы
@Table(name = "Students")//Указываем как будет называться таблица для @Entity данного класс

//@SecondaryTable("Adresses") Позволяет часть данных класса выносить в другую таблицу, используется совместно с @Column(table="")
@SecondaryTables({@SecondaryTable(name="Adresses"), @SecondaryTable(name="Countrys")})//Вынос даных в несколько таблиц

@SequenceGenerator(name = "mySeq", initialValue = 1, allocationSize = 100)
public class Student {
    //уникальный идентификатор @Id казатель первичного ключа Primary key, может быть над несколькими полями(составной первичный ключ)
    @Id
    /** генериться автоматически уникальное значение
     * @GeneratedValue, указывается стратегия и используемый генератор если нужен свой @TableGenerator или @SequenceGenerator
     * GenerationType.AUTO - работает автоматически учитывая специфику СУДБ, выбирает сппособ ниже, для MSSQL - TABLE
     * GenerationType.IDENTITY - не для всех СУБД
     * GenerationType.SEQUENCE - не для всех СУБД (например MySQL не поддерживает)
     * GenerationType.Table - создается отдельная табличка для генерации значений, например hibernate_sequence
     * generator="имя" - можно настоить отдельную табличку с помощью @TableGenerator
     */
    @TableGenerator(name = "myGen",table = "mySequence",initialValue = 10,allocationSize = 100)//Настраиваем табичку для генерации первичных ключей
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "myGen") //Для стратегии Table указываем имя @TableGenerator
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeq") //Для стратегии SEQUENCE указываем имя @SequenceGenerator
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

package ee.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student12 {
    @Id
    @GeneratedValue
    int id;
    /** name - имя столбца
     * length - размер значения
     * unique - уникальность значения uniq столбца(по умолчанию false)
     * nullable - по упольчанию true, false - добавляет not null к столюцу таблицы
     * insertable - по умолчанию true, если false то неудатся заинсертить значение столбца
     * updatable по умолчанию true, если false то неудатся засетить новое значение столбца
     * columnDefinition - можно задать на  SQL опрделение поля
     */
    @Column(name="MyName",length = 50, unique = true,nullable = false,updatable = false, insertable = false)
    String name;
    @Column(columnDefinition = "varchar(50) null")
    int age;
    Date birth;
}

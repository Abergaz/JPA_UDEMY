package ee.jpa;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Student13 {
    @Id
    @GeneratedValue
    String name;
    int age;
    /** TemporalType.DATE - сохраниться толька дата
     *  TemporalType.TIME - сохраниться толька время
     *  TemporalType.TIMESTAMP - и дата и время
     */
    @Temporal(TemporalType.TIME)
    Date time;
    @Temporal(TemporalType.DATE) /** Работает и с календарем*/
    Calendar date;
}

package ee.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity //Помечаем класс как запись такблицы и все его свойства - это столбцы
//@IdClass(StudId.class) можно использовать вместо @EmbeddedId, тогда класс не надо помечать @Embeddable, а поля надо указать в текущем классе и пометить их @Id
public class Student {
    @EmbeddedId //Поля указанного класс будуь сотавным первичым ключем
    StudId studId;
    int age;


    // !!! для классов @Entity всегда должен быть конструктор по уполчанию
    public Student() {
    }

    public Student(String name, String serName, int age) {
        this.studId = new StudId(name,serName);
        this.age = age;
    }
}
/** Класс должен обязательно быть помечен как @Embeddable
 * Должен имлементировать Serializable и => иметь пустой конструктор
 * переобределять equals и hashCode
 */
@Embeddable
class StudId implements Serializable {
    String name;
    String serName;

    public StudId() {
    }
    public StudId( String name, String serName) {
        this.name =name;
        this.serName = serName;

    }


    public String getName() {
        return name;
    }

    public String getSerName() {
        return serName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudId studId = (StudId) o;
        return Objects.equals(name, studId.name) &&
                Objects.equals(serName, studId.serName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serName);
    }
}

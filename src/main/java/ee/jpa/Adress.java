package ee.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
class Adress {
    @Id
    @GeneratedValue
    int id;
    String city;
    String street;
    /** для двунаправленной связи указываем
     * что данный клас мапиться в поле адрес класс student 20
     * т.е. в этом двунаправленном отношении класс Student главный,
     * тогда в таблице адрес не будет создаваться колонка с id студента
     * а вот в таблице студента будет колонка с id адреса
     * */
    @OneToOne(mappedBy = "adress")
    Student20 student20;

    public Adress() {
        city = "Moscow";
        street = "Arbat";
    }
}

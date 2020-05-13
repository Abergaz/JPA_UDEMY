package ee.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Student17 {
    @Id
    @GeneratedValue
    int id;
    String name;

    @ElementCollection(fetch = FetchType.LAZY)/**  @ElementCollection выносит элементы коллекции в отдельную таблицу */
    @CollectionTable(name="ListStudent") /** имя таблицы  */
    @Column(name="Column_name") /** задаем имя столбца */
    List<String> list = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)/**  @ElementCollection выносит элементы коллекции в отдельную таблицу */
    @CollectionTable(name="mapStudent") /** имя таблицы  */
    @Column(name="Column_name") /** задаем имя столбца для значений*/
    @MapKey(name = "Colunm_Key_name")/**  задаем имя столбца для ключей мапы*/
    Map<Integer,String> map = new HashMap<>();

    public Student17() {
    }
    public Student17(String name) {
        this.name=name;
        this.list.add("one");
        this.list.add("two");
        this.list.add("free");
        this.map.put(1,"one");
        this.map.put(2,"two");
        this.map.put(3,"free");
    }

}

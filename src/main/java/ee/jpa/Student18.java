package ee.jpa;

//все описание находиться в META-INF/StudentMap.xml
public class Student18 {
    int id;
    String name;

    public Student18() {
    }
    public Student18(String name) {
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package ee.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class MainExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Student20 student20 = new Student20("Max");
        Adress adress = new Adress();
        student20.adress = adress;

        //делаем двунаправленную связь, чтобы студент знал о адресе а адрес о студенте.
        adress.student20=student20;

        entityManager.persist(student20);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}

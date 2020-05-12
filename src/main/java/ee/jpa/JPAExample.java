package ee.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAExample {
    public static void main(String[] args) {
        //Создаем EntityManagerFactory для создания EntityManager из Persistence передав имя persistence-unit из persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        //создаём EntityManager из фабрики EntityManagerFactory, через него ведется работа с БД
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //получаем транзакцию из EntityManager
        EntityTransaction entityTransaction = entityManager.getTransaction();
        //начинаем транзакцию
        entityTransaction.begin();
        //Сохраняем обьект с помощью EntityManager
        entityManager.persist(new Book("Inferno"));
        //закрываем транзакцию коммитом
        entityTransaction.commit();
        //entityTransaction.rollback(); можно закрыть транзакцию откатом

        //закрываем EntityManager
        entityManager.close();
        //закрываем EntityManagerFactory
        entityManagerFactory.close();


    }
}

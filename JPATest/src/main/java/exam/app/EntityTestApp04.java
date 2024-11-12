package exam.app;

import java.time.LocalDateTime;
import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp04 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        EntityTest01 entityTest01;
        for(int i=1; i<=5; i++) {
            entityTest01 = new EntityTest01();
            entityTest01.setName("또치" + i);
            entityTest01.setAge((int)(Math.random()*26 + 25));
            entityTest01.setBirthday(LocalDateTime.now());

            manager.persist(entityTest01);
        }//for

        TypedQuery<EntityTest01> tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
        List<EntityTest01> list = tq.getResultList();
        list.stream().forEach(System.out::println);

        manager.flush();

        System.out.println("----------------");
        tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
        list = tq.getResultList();
        list.stream().forEach(System.out::println);

        manager.getTransaction().rollback();

        System.out.println("----------------");
        tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
        list = tq.getResultList();
        list.stream().forEach(System.out::println);

        manager.close();
        factory.close();
    }

}

/*
flush()
- 영속성 컨텍스트(persistence context)에 보관된 변경 사항을 즉시 데이터베이스에 반영하는 메서드이다.
- 커밋은 트랜잭션을 종료하고 DB에 영구적으로 반영하는 것이라면, flush()는 데이터를 DB에 반영하지만 트랜잭션은 계속 열려 있는 상태이다.

- flush()는 영속성 컨텍스트에 있는 변경 사항을 데이터베이스에 즉시 반영하지만, 트랜잭션을 커밋하지 않습니다.
  즉, 데이터를 DB에 반영하지만, 트랜잭션을 커밋(commit) 해야만 데이터가 영구적으로 저장된다.
 */










package exam.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class HelloJPA03 {

    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        Query query = em.createNativeQuery("select emp from Emp emp",Emp.class);
        List<Emp> emps = query.getResultList();
        for (Emp emp : emps) {
            System.out.println("직원명 : " + emp.getEname() );

            Thread.sleep(1000);

            if(emp.getDeptno() != null)
                System.out.println("부서명 : "+emp.getDeptno().getDname());
        }
    }
}

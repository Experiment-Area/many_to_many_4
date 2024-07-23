package lk.ijse.dep12.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.entity.Course;
import lk.ijse.dep12.jpa.entity.Enroll;
import lk.ijse.dep12.jpa.entity.Student;
import lk.ijse.dep12.jpa.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

//                Course c001 = new Course("C001", "CMJD", "Six Month");
//                Course c002 = new Course("C002", "GDSE", "Three Year");
//                Course c003 = new Course("C003", "DEP", "Six Month");
//
//                List.of(c001, c002,c003).forEach(em::persist);

                Course c001 = em.find(Course.class, "C001");
                Course c002 = em.find(Course.class, "C002");

                Student s001 = new Student("S001", "Kasun", "Galle", "011-9654427", Date.valueOf("2000-04-30"));

                Enroll e001 = new Enroll(s001, c002, "Hansi", Date.valueOf(LocalDate.now()));
                Enroll e002 = new Enroll(s001, c001, "Hansi", Date.valueOf(LocalDate.now()));

                em.persist(s001);
                em.persist(e001);
                em.persist(e002);

                tx.commit();

            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}

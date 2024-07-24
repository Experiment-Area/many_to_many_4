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

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Course c001 = em.find(Course.class, "C001");
                Course c002 = em.find(Course.class, "C002");
                Course c003 = em.find(Course.class, "C003");

                Student s005 = new Student("S005", "Buddika", "Kaduwela", "078-5554401", Date.valueOf("2000-07-10"), Student.Gender.MALE);
                Student s006= new Student("S006", "Methmi", "Malabe", "072-3254466", Date.valueOf("2000-07-10"), Student.Gender.FEMALE);

                Enroll e007 = new Enroll(s006, c002, "Chathurika", Date.valueOf(LocalDate.now()));
                Enroll e008 = new Enroll(s005, c001, "Sumudu", Date.valueOf(LocalDate.now()));
                Enroll e009 = new Enroll(s006, c003, "Risni", Date.valueOf(LocalDate.now()));

                List.of(c001, c002, c003, s005, s006, e007, e008, e009).forEach(em::persist);

                tx.commit();

            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}

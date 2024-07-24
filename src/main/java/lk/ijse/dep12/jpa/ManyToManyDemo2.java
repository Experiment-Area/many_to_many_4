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

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Course c001 = em.find(Course.class, "C001");
                Course c002 = em.find(Course.class, "C002");
                Course c003 = em.find(Course.class, "C003");

                Student s003 = new Student("S003", "Yasitha", "Moratuwa", "078-5554401", Date.valueOf("2000-07-10"), Student.Gender.MALE);
                Student s004= new Student("S004", "piyumi", "Kaluthara", "072-3254466", Date.valueOf("2000-07-10"), Student.Gender.FEMALE);

                Enroll e001 = new Enroll(s003, c002, "Banuka", Date.valueOf(LocalDate.now()));
                Enroll e002 = new Enroll(s004, c001, "Kaveesh", Date.valueOf(LocalDate.now()));
                Enroll e003 = new Enroll(s003, c003, "Risni", Date.valueOf(LocalDate.now()));

                List.of(c001, c002, c003, s003, s004, e001, e002, e003).forEach(em::persist);

                tx.commit();

            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}

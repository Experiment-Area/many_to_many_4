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

                Course c001 = new Course("C001", "CMJD", "Six Month");
                Course c002 = new Course("C002", "GDSE", "Three Year");
                Course c003 = new Course("C003", "DEP", "Six Month");

                Student s001 = new Student("S001", "Kasun", "Galle", "071-5854451", Date.valueOf("2000-07-10"), Student.Gender.MALE);
                Student s002 = new Student("S002", "Sahasra", "Panadura", "011-7854494", Date.valueOf("2000-07-10"), Student.Gender.FEMALE);

                Enroll e001 = new Enroll(s001, c002, "Hansi", Date.valueOf(LocalDate.now()));
                Enroll e002 = new Enroll(s002, c001, "Hansi", Date.valueOf(LocalDate.now()));
                Enroll e003 = new Enroll(s001, c003, "Yasitha", Date.valueOf(LocalDate.now()));

                List.of(c001, c002, c003, s001, s002, e001, e002, e003).forEach(em::persist);

                tx.commit();

            }catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}

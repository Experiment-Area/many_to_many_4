package lk.ijse.dep12.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enroll")
public class Enroll implements Serializable {
    @EmbeddedId
    private EnrollPK enrollPK;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Course course;

    public Enroll(Student student, Course course, String registeredBy, Date date) {
        this.enrollPK = new EnrollPK(student.getId(), course.getCode());
        this.student = student;
        this.course = course;
        this.date = date;
        this.registeredBy = registeredBy;
    }
}

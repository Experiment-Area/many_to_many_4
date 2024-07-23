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
    @JoinColumn(name = "studet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "code", insertable = false, updatable = false)
    private Course course;

    public Enroll(Student student, Course course, String registeredBy, Date date) {
        this.enrollPK = new EnrollPK(student.getId(), course.getCode());
        this.registeredBy = registeredBy;
        this.date = date;
    }
}

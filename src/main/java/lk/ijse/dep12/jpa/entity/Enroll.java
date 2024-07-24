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
@IdClass(EnrollPK.class)
public class Enroll implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "code")
    private Course course;

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    public Enroll(String registeredBy, Date date) {
        this.registeredBy = registeredBy;
        this.date = date;
    }
}

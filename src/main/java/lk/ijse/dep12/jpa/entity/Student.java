package lk.ijse.dep12.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public static enum Gender {
        MALE, FEMALE
    }
}

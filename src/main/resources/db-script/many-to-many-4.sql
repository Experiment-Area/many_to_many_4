CREATE TABLE student(
    id VARCHAR(10) PRIMARY KEY ,
    name VARCHAR(200) NOT NULL ,
    address VARCHAR(500) NOT NULL ,
    contact VARCHAR(15) NOT NULL ,
    dob DATE NOT NULL
);

CREATE TABLE course(
    code VARCHAR(10) PRIMARY KEY ,
    name VARCHAR(100) NOT NULL ,
    duration VARCHAR(20) NOT NULL
);

CREATE TABLE enroll(
    student_id VARCHAR(10) NOT NULL ,
    course_code VARCHAR(10) NOT NULL ,
    registered_by VARCHAR(30) NOT NULL ,
    date DATE NOT NULL ,
    CONSTRAINT pk_enroll PRIMARY KEY (student_id, course_code),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT fk_course FOREIGN KEY (course_code) REFERENCES course(code)
);


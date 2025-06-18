package cz.vsb.skainwebapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="grade")
@Getter
@Setter
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private StudentEntity student;
    @ManyToOne
    private SubjectEntity subject;
    private String topic;
    private int mark;
    private LocalDateTime date;
}

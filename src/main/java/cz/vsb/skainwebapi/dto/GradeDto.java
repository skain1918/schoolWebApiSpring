package cz.vsb.skainwebapi.dto;

import cz.vsb.skainwebapi.entity.StudentEntity;
import cz.vsb.skainwebapi.entity.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {
    private int id;
    private StudentDto student;
    private int studentId;
    private SubjectDto subject;
    private int subjectId;
    private String topic;
    private int mark;
    private LocalDateTime date;
}

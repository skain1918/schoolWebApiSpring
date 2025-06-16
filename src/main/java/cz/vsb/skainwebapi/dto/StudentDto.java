package cz.vsb.skainwebapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}

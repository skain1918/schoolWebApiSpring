package cz.vsb.skainwebapi.controller;

import cz.vsb.skainwebapi.dto.StudentDto;
import cz.vsb.skainwebapi.entity.StudentEntity;
import cz.vsb.skainwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //@RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping({"/students", "/students/"})
    public List<StudentDto> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping({"/students", "/students/"})
    public StudentDto addStudent(@RequestBody StudentDto studentToAdd){
        return studentService.addStudent(studentToAdd);
    }
    @PutMapping("students/{studentId}")
    public StudentDto editStudent(@RequestBody StudentDto editedStudent, @PathVariable int studentId){
        return studentService.editStudent(editedStudent, studentId);
    }
}

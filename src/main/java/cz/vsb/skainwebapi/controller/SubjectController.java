package cz.vsb.skainwebapi.controller;

import cz.vsb.skainwebapi.dto.SubjectDto;
import cz.vsb.skainwebapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }
    @GetMapping({"/subjects", "/subjects/"})
    public List<SubjectDto> getSubjects(){
        return subjectService.getSubjects();
    }
    @PostMapping({"/subjects", "/subjects/"})
    public SubjectDto addSubject(@RequestBody SubjectDto subjectToAdd){
        return subjectService.addSubject(subjectToAdd);
    }
    @PutMapping("subjects/{subjectId}")
    public SubjectDto editSubject(@RequestBody SubjectDto editedSubject, @PathVariable int subjectId){
        return subjectService.editSubject(editedSubject, subjectId);
    }
    @DeleteMapping("subject/{subjectId}")
        public SubjectDto deleteSubject(@PathVariable int subjectId){
        return subjectService.deleteSubject(subjectId);
    }
}

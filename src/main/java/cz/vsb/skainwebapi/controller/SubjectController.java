package cz.vsb.skainwebapi.controller;

import cz.vsb.skainwebapi.dto.SubjectDto;
import cz.vsb.skainwebapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

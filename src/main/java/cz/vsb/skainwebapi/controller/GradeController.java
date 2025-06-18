package cz.vsb.skainwebapi.controller;

import cz.vsb.skainwebapi.dto.GradeDto;
import cz.vsb.skainwebapi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    GradeService gradeService;
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @GetMapping({"/grades", "/grades/"})
    public List<GradeDto> getAllGrades(){
        return gradeService.getAllGrades();
    }
    @GetMapping("/grade/{gradeId}")
    public GradeDto getGradeById(@PathVariable int gradeId){
        return gradeService.getGradeById(gradeId);
    }
    @PostMapping({"/grades", "/grades/"})
    public GradeDto addGrade(@RequestBody GradeDto newGrade){
        return gradeService.addGrade(newGrade);
    }
    @PutMapping("/grades/{gradeId}")
    public GradeDto updateGrade(@PathVariable int gradeId, @RequestBody GradeDto updatedGrade){
        return gradeService.editGrade(gradeId, updatedGrade);
    }
    @DeleteMapping("/grades/{gradeId}")
    public GradeDto deleteGrade(@PathVariable int gradeId){
        return gradeService.deleteGrade(gradeId);
    }
}

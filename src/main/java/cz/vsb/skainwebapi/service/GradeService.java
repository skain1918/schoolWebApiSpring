package cz.vsb.skainwebapi.service;

import cz.vsb.skainwebapi.dto.GradeDto;
import cz.vsb.skainwebapi.entity.GradeEntity;
import cz.vsb.skainwebapi.mapper.GradeMapper;
import cz.vsb.skainwebapi.repository.GradeRepository;
import cz.vsb.skainwebapi.repository.StudentRepository;
import cz.vsb.skainwebapi.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    GradeMapper gradeMapper;
    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    SubjectRepository subjectRepository;
@Autowired
    public GradeService(GradeMapper gradeMapper, GradeRepository gradeRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.gradeMapper = gradeMapper;
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }
    public List<GradeDto> getAllGrades(){
        List<GradeEntity> allGrades = gradeRepository.findAll();
        List<GradeDto> allGradeDtos = new ArrayList<>();
        for (GradeEntity gradeEntity : allGrades) {
            allGradeDtos.add(gradeMapper.toDto(gradeEntity));
        }
        return allGradeDtos;
    }
    public GradeDto getGradeById(int gradeId){
    GradeEntity grade = gradeRepository.getReferenceById(gradeId);
    return gradeMapper.toDto(grade);
    }
    public GradeDto addGrade(GradeDto newGrade){
        GradeEntity gradeToAdd = gradeMapper.toEntity(newGrade);
        gradeToAdd.setStudent(studentRepository.getReferenceById(newGrade.getStudentId()));
        gradeToAdd.setSubject(subjectRepository.getReferenceById(newGrade.getSubjectId()));
        GradeEntity savedEntity = gradeRepository.save(gradeToAdd);
        return gradeMapper.toDto(savedEntity);
    }
    public GradeDto editGrade(int gradeId, GradeDto editedGradeDto){
        GradeEntity editedEntity = gradeRepository.getReferenceById(gradeId);
        //GradeEntity editedEntity = gradeRepository.findById(gradeId).orElseThrow(EntityNotFoundException::new);
        editedGradeDto.setId(gradeId);
        gradeMapper.updateEntity(editedGradeDto, editedEntity);
        editedEntity.setStudent(studentRepository.getReferenceById(editedGradeDto.getStudentId()));
        editedEntity.setSubject(subjectRepository.getReferenceById(editedGradeDto.getSubjectId()));
        return gradeMapper.toDto(gradeRepository.save(editedEntity));
    }
    public GradeDto deleteGrade(int gradeId){
    GradeEntity entityToDelete = gradeRepository.getReferenceById(gradeId);
    GradeDto gradeToReturn = gradeMapper.toDto(entityToDelete);
    gradeRepository.delete(entityToDelete);
    return gradeToReturn;
    }
}

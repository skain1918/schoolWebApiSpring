package cz.vsb.skainwebapi.service;

import cz.vsb.skainwebapi.dto.SubjectDto;
import cz.vsb.skainwebapi.entity.SubjectEntity;
import cz.vsb.skainwebapi.mapper.SubjectMapper;
import cz.vsb.skainwebapi.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    SubjectMapper subjectMapper;
    SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectMapper subjectMapper, SubjectRepository subjectRepository) {
        this.subjectMapper = subjectMapper;
        this.subjectRepository = subjectRepository;
    }


    public List<SubjectDto> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjectDtos.add(subjectMapper.toDto(subjectEntity));
        }
        return subjectDtos;
    }

    public SubjectDto addSubject(SubjectDto newSubjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(newSubjectDto);
        SubjectEntity savedSubject = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(savedSubject);
    }

    public SubjectDto editSubject(SubjectDto editedSubject, int subjectId) {
        if (!subjectRepository.existsById(subjectId)) {
            throw new EntityNotFoundException("Subject not found");
        }
        SubjectEntity entity = subjectMapper.toEntity(editedSubject);
        entity.setId(subjectId);
        SubjectEntity savedSubject = subjectRepository.save(entity);
        return subjectMapper.toDto(savedSubject);
    }
    public SubjectDto deleteSubject(int subjectId){
        if (!subjectRepository.existsById(subjectId)) {
            throw new EntityNotFoundException("Subject not found");
        }
        SubjectEntity entity = subjectRepository.findById(subjectId).orElseThrow(EntityNotFoundException::new);
        SubjectDto deletedSubjectToReturn = subjectMapper.toDto(entity);
        subjectRepository.delete(entity);
        return deletedSubjectToReturn;
    }
}

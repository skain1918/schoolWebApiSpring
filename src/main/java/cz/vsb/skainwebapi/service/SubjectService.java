package cz.vsb.skainwebapi.service;

import cz.vsb.skainwebapi.dto.SubjectDto;
import cz.vsb.skainwebapi.entity.SubjectEntity;
import cz.vsb.skainwebapi.mapper.StudentMapper;
import cz.vsb.skainwebapi.mapper.SubjectMapper;
import cz.vsb.skainwebapi.repository.StudentRepository;
import cz.vsb.skainwebapi.repository.SubjectRepository;
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
        subjectMapper = subjectMapper;
        this.subjectRepository = subjectRepository;
    }


    public List<SubjectDto> getSubjects(){
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjectDtos.add(subjectMapper.toDto(subjectEntity));
        }
        return subjectDtos;
    }


}

package cz.vsb.skainwebapi.mapper;

import cz.vsb.skainwebapi.dto.SubjectDto;
import cz.vsb.skainwebapi.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto subjectDto);
    SubjectDto toDto(SubjectEntity subjectEntity);
}

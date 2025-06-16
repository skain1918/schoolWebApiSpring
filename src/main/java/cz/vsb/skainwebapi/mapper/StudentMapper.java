package cz.vsb.skainwebapi.mapper;

import cz.vsb.skainwebapi.dto.StudentDto;
import cz.vsb.skainwebapi.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(StudentDto studentDto);
    StudentDto toDto(StudentEntity studentEntity);

}

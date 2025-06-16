package cz.vsb.skainwebapi.repository;

import cz.vsb.skainwebapi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}

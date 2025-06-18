package cz.vsb.skainwebapi.repository;

import cz.vsb.skainwebapi.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {

}

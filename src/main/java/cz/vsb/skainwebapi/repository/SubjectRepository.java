package cz.vsb.skainwebapi.repository;

import cz.vsb.skainwebapi.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
}

package com.gb.DanismanPortal.repository;

import com.gb.DanismanPortal.entity.Job;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}

package com.anhbq.sketch.repository;

import com.anhbq.sketch.model.Sketch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface SketchRepository extends JpaRepository<Sketch, Long> {
    List<Sketch> findByNameContaining(String name);
    Page<Sketch> findByNameContaining(String name, Pageable pageable);
}

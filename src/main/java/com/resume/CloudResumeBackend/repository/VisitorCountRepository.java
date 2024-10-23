package com.resume.CloudResumeBackend.repository;

import com.resume.CloudResumeBackend.entity.VisitorCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorCountRepository extends JpaRepository<VisitorCount, Long> {
    VisitorCount findFirstByOrderByIdDesc();
}

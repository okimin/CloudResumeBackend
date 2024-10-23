package com.resume.CloudResumeBackend.controller;

import com.resume.CloudResumeBackend.entity.VisitorCount;
import com.resume.CloudResumeBackend.repository.VisitorCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorCountController {
    @Autowired
    private VisitorCountRepository visitorCountRepository;

    @GetMapping("/visitor-count")
    public int getVisitorCount() {
        VisitorCount visitorCount = visitorCountRepository.findFirstByOrderByIdDesc();
        return visitorCount != null ? visitorCount.getCount() : 0;
    }

    @PostMapping("/visitor-count")
    public void incrementVisitorCount() {
        VisitorCount visitorCount = visitorCountRepository.findFirstByOrderByIdDesc();
        if (visitorCount == null) {
            visitorCount = new VisitorCount();
        }
        visitorCount.setCount(visitorCount.getCount() + 1);
        visitorCountRepository.save(visitorCount);
    }
}

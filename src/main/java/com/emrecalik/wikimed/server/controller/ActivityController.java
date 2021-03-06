package com.emrecalik.wikimed.server.controller;

import com.emrecalik.wikimed.server.model.response.activity.ActivityResponseDto;
import com.emrecalik.wikimed.server.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(ActivityController.BASE_URL)
public class ActivityController {

    public final static String BASE_URL = "/api/activities";

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<ActivityResponseDto>> getActivityStream(@PathVariable Long userId) {
        return ResponseEntity.ok(activityService.getActivityStream(userId));
    }
}

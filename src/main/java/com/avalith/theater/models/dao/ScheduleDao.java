package com.avalith.theater.models.dao;

import com.avalith.theater.models.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDao extends JpaRepository<Schedule,Long> {
    Schedule findByName(String name);
}

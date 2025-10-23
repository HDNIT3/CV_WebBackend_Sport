package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Room;

@Controller
public interface RoomRepository extends JpaRepository<Room,Long> {
}

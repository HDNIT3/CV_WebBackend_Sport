package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.RoomReq;
import com.example.demo.dto.response.data;
import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user/room")
public class RoomController {
	@Autowired
	private RoomService roomSer;
	
    @PostMapping("/")
    public ResponseEntity<data> getcreate(@RequestBody RoomReq room) {
        try {
			Room rooms = roomSer.createRoom(room);
			return ResponseEntity.ok().body(new data("Success","Room created successfully",rooms));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new data("Failure",e.getMessage(),null));
		}
    }
    
    @GetMapping("/")
    public ResponseEntity<data> getList(@RequestBody RoomReq room) {
        try {
			List<Room> ls = roomSer.getAllRoom();
			return ResponseEntity.ok().body(new data("Success","get list room successfully",ls));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new data("Failure",e.getMessage(),null));
		}
    }
}

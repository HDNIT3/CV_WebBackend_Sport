package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.RoomReq;
import com.example.demo.entity.Room;
import com.example.demo.entity.User;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomrep;

    @Autowired
    private UserRepository userrep;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public Room createRoom(RoomReq roomReq){
         String name = SecurityContextHolder.getContext().getAuthentication().getName();
         
         User finduser = userrep.findByUsername(name).orElse(null);
         
         if (finduser == null) {
        	 	throw new RuntimeException("User not found");
         }
         
         Room room = new Room();
         
         room.setName(roomReq.getNameroom());
         room.setPass(passwordEncoder.encode(roomReq.getPassroom()));
         room.setMax_quantity(roomReq.getMax_quantity());
         room.setQuantity(1);
         
         room.setUser_create(finduser);
         
         return roomrep.save(room);
    }
    
    public List<Room> getAllRoom(){
    		return roomrep.findAll();
    }
}

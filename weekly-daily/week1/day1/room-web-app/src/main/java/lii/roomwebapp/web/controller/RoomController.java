package lii.roomwebapp.web.controller;

import lii.roomwebapp.data.entity.RoomEntity;
import lii.roomwebapp.data.repository.RoomRepository;
import lii.roomwebapp.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String rooms(Model model) {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<Room>(roomEntities.size());
        roomEntities.forEach(roomEntity -> {
            rooms.add(new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo()));
        });
        model.addAttribute("rooms", rooms);
        return "rooms";
    }
}

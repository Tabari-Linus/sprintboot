package lii.roomwebapp.service;

import lii.roomwebapp.data.entity.RoomEntity;
import lii.roomwebapp.data.repository.RoomRepository;
import lii.roomwebapp.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        roomEntities.forEach(roomEntity -> {
            rooms.add(getRoomFromEntity(roomEntity));
        });
        return rooms;
    }

    public Room getRoomById(UUID id) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        return roomEntity.map(this::getRoomFromEntity).orElse(null);
    }

    public Room createRoom(Room room) {
        RoomEntity entity = getRoomEntityFromRoom(room);
        entity = roomRepository.save(entity);
        return getRoomFromEntity(entity);
    }

    public Room updateRoom(Room room) {
        RoomEntity entity = getRoomEntityFromRoom(room);
        entity = roomRepository.save(entity);
        return getRoomFromEntity(entity);
    }
    public void deleteRoomById(UUID id) {
        roomRepository.deleteById(id);
    }

    private Room getRoomFromEntity(RoomEntity entity) {
        return new Room( entity.getRoomId(), entity.getName(), entity.getNumber(), entity.getBedInfo());
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity( room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }
}

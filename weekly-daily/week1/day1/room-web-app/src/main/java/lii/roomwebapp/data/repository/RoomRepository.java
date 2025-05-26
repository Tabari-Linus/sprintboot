package lii.roomwebapp.data.repository;

import lii.roomwebapp.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

}

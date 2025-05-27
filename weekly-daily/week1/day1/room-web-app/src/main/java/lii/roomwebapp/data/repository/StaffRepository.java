package lii.roomwebapp.data.repository;

import lii.roomwebapp.data.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember, String> {
}

package lii.roomwebapp.web.controller;

import lii.roomwebapp.data.entity.StaffMember;
import lii.roomwebapp.data.repository.StaffRepository;
import lii.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/staffs")
public class StaffController {

    private final StaffRepository staffRepository;


    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping
    public String staffs(Model model) {
        List<StaffMember> staffMembers = staffRepository.findAll();
        List<Staff> staffs = new ArrayList<>();
        staffMembers.forEach(staffMember -> {
            staffs.add(new Staff(staffMember.getEmployeeId(), staffMember.getFirstName(), staffMember.getLastName(),staffMember.getPosition()));
        });
        model.addAttribute("staffs", staffs);
        return "staffs";
    }
}





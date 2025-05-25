package lii.learning.spring_boot;

import org.springframework.web.bind.annotation.*;

import lii.learning.spring_boot.SoftwareEngineer;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEnginerrService softwareEnginerrService;

    public SoftwareEngineerController(SoftwareEnginerrService softwareEnginerrService) {
        this.softwareEnginerrService = softwareEnginerrService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEnginerrService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id){
        return softwareEnginerrService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEnginerrService.insertSoftwareEngineer(softwareEngineer);
    }
}

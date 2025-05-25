package lii.learning.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEnginerrService {

    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEnginerrService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Software Engineer with id "+id+" not found"));
    }
}

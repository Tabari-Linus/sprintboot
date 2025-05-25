package lii.photozclone;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PhotozController {

    Map<String, Photos> db = new HashMap<>(){{
        new Photos("1", "Hello.jpg");
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photos> get() {
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photos getByid(@PathVariable String id) {
        return db.get(id);
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        db.remove(id);
    }

    @PostMapping("/photoz")
    public Photos Create(@RequestBody Photos photos) {
        String id = UUID.randomUUID().toString();
        photos.setId(id);
        db.put(photos.getId(), photos);
        return photos;
    }
}



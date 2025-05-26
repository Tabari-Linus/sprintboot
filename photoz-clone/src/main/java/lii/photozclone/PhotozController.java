package lii.photozclone;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    Map<String, Photo> db = new HashMap<>(){{
        new Photo("1", "Hello.jpg");
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo getByid(@PathVariable String id) {
        return db.get(id);
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        db.remove(id);
    }

    @PostMapping("/photoz")
    public Photo Create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }
}



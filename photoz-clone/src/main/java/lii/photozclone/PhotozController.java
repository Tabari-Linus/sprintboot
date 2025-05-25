package lii.photozclone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotozController {

    List<Photos> photos = List.of(new Photos(1, "Hello.jpg"));

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public List<Photos> photoz() {
        return
    }
}



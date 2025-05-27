package lii.roomwebapp.web.model;

import lii.roomwebapp.data.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    private String id;
    private String firstName;
    private String lastName;
    private Position position;

}

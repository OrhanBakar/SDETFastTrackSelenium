package FastTrack4Api.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Spartan {

    private int id;
    private String name;
    private String gender;
    private Long phone;

}

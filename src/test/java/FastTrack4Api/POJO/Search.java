package FastTrack4Api.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class Search {
    private List<Spartan> content;
    private int totalElement;


}

import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.models.Job;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class EmpleadoMuestra {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("birthdate")
    private Date birthdate;

    @JsonProperty("job")
    private Integer job;

    @JsonProperty("gender")
    private Integer gender;
}

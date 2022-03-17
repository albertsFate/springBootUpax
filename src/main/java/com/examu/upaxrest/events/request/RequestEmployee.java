package com.examu.upaxrest.events.request;

import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.models.Job;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("birthdate")
    private Date birthdate;

    @JsonProperty("job")
    private Job job;

    @JsonProperty("gender")
    private Gender gender;

}

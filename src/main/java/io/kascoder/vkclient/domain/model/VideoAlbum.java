package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.kascoder.vkclient.util.BooleanIntDeserializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoAlbum {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("updated_time")
    private Integer modificationDate; // UnitTime
    @JsonProperty("is_system")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean system;
}

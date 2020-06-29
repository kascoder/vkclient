package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("thumb_id")
    private Integer thumbId;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("description")
    private String description;
    @JsonProperty("thumb_src")
    private String coverUrl;
    @JsonProperty("created")
    private Integer creationDate; // UnitTime
    @JsonProperty("update")
    private Integer modificationDate; // UnitTime
    @JsonProperty("sizes")
    private List<PhotoSize> coverSizes;
}

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@ApiObjectDefinition(name = "photos_photo")
@JsonIgnoreProperties(ignoreUnknown = true) // post_id, long, lat, images
public class Photo {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("album_id")
    private Integer albumId;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("user_id")
    private Integer uploaderId;
    @JsonProperty("date")
    private Integer date; // UnitTime
    @JsonProperty("text")
    private String caption;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("width")
    private Integer originalWidth;
    @JsonProperty("height")
    private Integer originalHeight;
    @JsonProperty("sizes")
    private List<PhotoSize> sizeList;
}

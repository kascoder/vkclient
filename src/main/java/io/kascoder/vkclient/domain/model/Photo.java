// objects.json [photos_photo]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // album_id, date, user_id, post_id, owner_id, long, lat, images
public class Photo {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("date")
    private Integer dateUnixTime;
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

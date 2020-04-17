// objects.json [audio_audio]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // duration, album_id, genre_id, performer
public class Audio {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private Integer dateUnixTime;
    @JsonProperty("url")
    private String url;
    @JsonProperty("artist")
    private String artist;
}

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiObjectDefinition(name = "audio_audio")
@JsonIgnoreProperties(ignoreUnknown = true) // album_id, genre_id, performer
public class Audio {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("owner_id")
    private Integer owner_id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private Integer date; // UnixTime
    @JsonProperty("url")
    private String mp3Url;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("duration")
    private Integer duration; // seconds
}

// objects.json [video_video]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // adding_date, can_add, can_comment, can_edit, can_like, can_repost, comments, date, description, duration
public class Video {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("date")
    private Integer dateUnixTime;
    @JsonProperty("adding_date")
    private Integer addingDateUnixTime;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("player")
    private String playerUrl;
}

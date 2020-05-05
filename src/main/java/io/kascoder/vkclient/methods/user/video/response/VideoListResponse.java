package io.kascoder.vkclient.methods.user.video.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kascoder.vkclient.domain.model.Video;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Video> videoList;
}

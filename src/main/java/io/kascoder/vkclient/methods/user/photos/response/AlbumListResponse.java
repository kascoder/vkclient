package io.kascoder.vkclient.methods.user.photos.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kascoder.vkclient.domain.model.Album;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Album> albums;
}





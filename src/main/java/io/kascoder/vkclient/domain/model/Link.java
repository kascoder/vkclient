package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true) // button, product
public class Link {
    @JsonProperty("url")
    private String url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("description")
    private String description;
    @JsonProperty("photo")
    private Photo previewPhoto;
    @JsonProperty("preview_page")
    private String previewPage;
    @JsonProperty("preview_url")
    private String previewUrl;
}

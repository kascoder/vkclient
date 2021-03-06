package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiObjectDefinition(name = "photos_photo_sizes")
public class PhotoSize {
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;

    @Getter
    @AllArgsConstructor
    @ApiObjectDefinition(name = "photos_photo_sizes_type")
    public enum Type {
        k("k"),
        l("l"),
        m("m"),
        o("o"),
        p("p"),
        q("q"),
        r("r"),
        s("s"),
        w("w"),
        x("x"),
        y("y"),
        z("z");

        @JsonValue
        private final String value;
    }
}

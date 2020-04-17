// objects.json[photos_photo_sizes]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoSize {
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;

    // objects.json[photos_photo_sizes_type]
    @AllArgsConstructor
    @Getter
    public enum Type {
        s("s"),
        m("m"),
        x("x"),
        o("o"),
        p("p"),
        q("q"),
        r("r"),
        y("y"),
        z("z"),
        w("w");

        @JsonValue
        private final String value;
    }
}
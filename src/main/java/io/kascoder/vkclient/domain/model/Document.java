// objects.json [docs_doc]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // owner_id, preview
public class Document {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("date")
    private Integer dateUnixTime;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("ext")
    private String extension;

    @AllArgsConstructor
    public enum Type {
        TEXT(1),
        ARCHIVE(2),
        GIF(3),
        IMAGE(4),
        AUDIO(5),
        VIDEO(6),
        EBOOK(7),
        UNKNOWN(8);

        @JsonValue
        private final int value;

        @JsonCreator
        public static Type from(int value) {
            return Arrays.stream(values())
                    .filter(t -> t.value == value)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Unknown document type value: " + value));
        }
    }
}

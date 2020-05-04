package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
@ApiObjectDefinition(name = "docs_doc")
@JsonIgnoreProperties(ignoreUnknown = true) // preview
public class Document {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("date")
    private Integer date; // UnixTime
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("ext")
    private String extension;
    @JsonProperty("size")
    private Integer size; //bytes

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

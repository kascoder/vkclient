package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Peer {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("local_id ")
    private Integer localId;
    @JsonProperty("type")
    private Type type;

    @Getter
    @ToString
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {
        USER("user"),
        CHAT("chat"),
        GROUP("group"),
        EMAIL("email");

        @JsonValue
        private final String value;
    }
}

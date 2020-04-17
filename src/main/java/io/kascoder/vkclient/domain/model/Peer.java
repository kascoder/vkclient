package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Peer {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("local_id ")
    private Integer localId;
    @JsonProperty("type")
    private Type type;

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public enum Type {
        USER("user"),
        CHAT("chat"),
        GROUP("group"),
        EMAIL("email");

        @JsonValue
        private final String value;
    }
}

package io.kascoder.vkclient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestParameter {
    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
}

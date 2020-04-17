package io.kascoder.vkclient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestParameter {
    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
}

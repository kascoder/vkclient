package io.kascoder.vkclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VkApiResponse<T> {
    @JsonProperty("response")
    private T response;
    @JsonProperty("error")
    private VkApiError error;
}

package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.kascoder.vkclient.domain.model.Message;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryMessageListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Message> messages;
}

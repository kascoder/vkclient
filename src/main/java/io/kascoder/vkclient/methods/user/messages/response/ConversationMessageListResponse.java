package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.kascoder.vkclient.domain.model.Message;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationMessageListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Message> messages;
}

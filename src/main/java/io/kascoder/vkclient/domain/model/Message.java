package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("from_id")
    private Integer from;
    @JsonProperty("date")
    private Integer dateUnixTime;
    @JsonProperty("conversation_message_id")
    private Integer conversationMessageId;
    @JsonProperty("attachments")
    private List<Attachment> attachments;
}

package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.kascoder.vkclient.domain.model.Attachment;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryAttachmentListResponse {
    @JsonProperty("items")
    private List<Item> historyItems;
    @JsonProperty("next_from")
    private String nextFrom;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        @JsonProperty("message_id")
        private Integer messageId;
        @JsonProperty("attachment")
        private Attachment attachment;
    }
}

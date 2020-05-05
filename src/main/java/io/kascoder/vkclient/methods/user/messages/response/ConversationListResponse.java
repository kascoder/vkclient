package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.kascoder.vkclient.domain.model.Community;
import io.kascoder.vkclient.domain.model.Conversation;
import io.kascoder.vkclient.domain.model.Message;
import io.kascoder.vkclient.domain.model.User;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Item> historyItems;
    @JsonProperty("unread_count")
    private int unread;
    @JsonProperty("profiles")
    private List<User> profiles;
    @JsonProperty("groups")
    private List<Community> communities;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        @JsonProperty("conversation")
        private Conversation conversation;
        @JsonProperty("last_message")
        private Message lastMessage;
    }
}





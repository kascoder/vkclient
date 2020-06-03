package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.kascoder.vkclient.domain.model.Community;
import io.kascoder.vkclient.domain.model.Conversation;
import io.kascoder.vkclient.domain.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationInfoListResponse {
    @JsonProperty("count")
    private Integer total;
    @JsonProperty("items")
    private List<Conversation> conversations;
    @JsonProperty("profiles")
    private List<User> profiles;
    @JsonProperty("groups")
    private List<Community> communities;
}





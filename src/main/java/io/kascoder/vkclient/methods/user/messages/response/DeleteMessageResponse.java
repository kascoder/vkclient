package io.kascoder.vkclient.methods.user.messages.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class DeleteMessageResponse {
    private Map<Integer, Boolean> resultMap;

    public DeleteMessageResponse() {
        this.resultMap = new HashMap<>();
    }

    @JsonAnySetter
    public void setResultItem(String messageId, Integer messageDeleteIntResult) {
        resultMap.put(Integer.parseInt(messageId), messageDeleteIntResult != null && messageDeleteIntResult >= 1);
    }
}

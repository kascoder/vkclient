package io.kascoder.vkclient.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import io.kascoder.vkclient.domain.IValue;

@Getter
@AllArgsConstructor
public enum ConversationFilter implements IValue {
    ALL("all"),
    UNREAD("unread"),
    IMPORTANT("important"),
    UNANSWERED("unanswered");

    private final String value;
}

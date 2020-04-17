package io.kascoder.vkclient.methods.user.messages;

import lombok.AllArgsConstructor;
import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.methods.VkAPiMethod;
import io.kascoder.vkclient.methods.user.messages.query.*;
import io.kascoder.vkclient.methods.user.messages.response.*;

import java.util.Objects;

public class MessagesApi {
    public VkApiRequest<ConversationListResponse> getConversations(GetConversationsQuery query) {
        Objects.requireNonNull(query);

        return io.kascoder.vkclient.VkApiRequest.<ConversationListResponse>builder()
                .vkAPiMethod(Methods.getConversations)
                .query(query)
                .clazz(ConversationListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryAttachmentListResponse> getHistoryAttachments(GetHistoryAttachmentsQuery query) {
        Objects.requireNonNull(query);

        return io.kascoder.vkclient.VkApiRequest.<HistoryAttachmentListResponse>builder()
                .vkAPiMethod(Methods.getHistoryAttachments)
                .query(query)
                .clazz(HistoryAttachmentListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryMessageListResponse> getHistory(GetHistoryQuery query) {
        Objects.requireNonNull(query);

        return io.kascoder.vkclient.VkApiRequest.<HistoryMessageListResponse>builder()
                .vkAPiMethod(Methods.getHistory)
                .query(query)
                .clazz(HistoryMessageListResponse.class)
                .build();
    }

    public VkApiRequest<ConversationMessageListResponse> getByConversationMessageId(GetByConversationMessageIdQuery query) {
        Objects.requireNonNull(query);

        return io.kascoder.vkclient.VkApiRequest.<ConversationMessageListResponse>builder()
                .vkAPiMethod(Methods.getByConversationMessageId)
                .query(query)
                .clazz(ConversationMessageListResponse.class)
                .build();
    }

    public VkApiRequest<MessageListResponse> getById(GetByIdQuery query) {
        Objects.requireNonNull(query);

        return io.kascoder.vkclient.VkApiRequest.<MessageListResponse>builder()
                .vkAPiMethod(Methods.getById)
                .query(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements VkAPiMethod {
        getConversations("getConversations"),
        getHistoryAttachments("getHistoryAttachments"),
        getByConversationMessageId("getByConversationMessageId"),
        getHistory("getHistory"),
        getById("getById");

        private final String path;

        @Override
        public String path() {
            return "messages." + path;
        }
    }
}



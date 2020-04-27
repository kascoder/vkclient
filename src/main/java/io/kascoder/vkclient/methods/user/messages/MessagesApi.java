package io.kascoder.vkclient.methods.user.messages;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.methods.VkAPiMethod;
import io.kascoder.vkclient.methods.user.messages.query.*;
import io.kascoder.vkclient.methods.user.messages.response.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class MessagesApi {
    public VkApiRequest<ConversationListResponse> getConversations(@NonNull GetConversationsQuery query) {
        return VkApiRequest.<ConversationListResponse>builder()
                .vkAPiMethod(Methods.getConversations)
                .query(query)
                .clazz(ConversationListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryAttachmentListResponse> getHistoryAttachments(@NonNull GetHistoryAttachmentsQuery query) {
        return VkApiRequest.<HistoryAttachmentListResponse>builder()
                .vkAPiMethod(Methods.getHistoryAttachments)
                .query(query)
                .clazz(HistoryAttachmentListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryMessageListResponse> getHistory(@NonNull GetHistoryQuery query) {
        return VkApiRequest.<HistoryMessageListResponse>builder()
                .vkAPiMethod(Methods.getHistory)
                .query(query)
                .clazz(HistoryMessageListResponse.class)
                .build();
    }

    public VkApiRequest<ConversationMessageListResponse> getByConversationMessageId(@NonNull GetByConversationMessageIdQuery query) {
        return VkApiRequest.<ConversationMessageListResponse>builder()
                .vkAPiMethod(Methods.getByConversationMessageId)
                .query(query)
                .clazz(ConversationMessageListResponse.class)
                .build();
    }

    public VkApiRequest<MessageListResponse> getById(@NonNull GetByIdQuery query) {
        return VkApiRequest.<MessageListResponse>builder()
                .vkAPiMethod(Methods.getById)
                .query(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    public VkApiRequest<MessageListResponse> search(@NonNull SearchQuery query) {
        return VkApiRequest.<MessageListResponse>builder()
                .vkAPiMethod(Methods.search)
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
        getById("getById"),
        search("search");

        private final String path;

        @Override
        public String path() {
            return "messages." + path;
        }
    }
}



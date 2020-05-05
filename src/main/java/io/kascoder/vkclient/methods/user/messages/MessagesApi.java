package io.kascoder.vkclient.methods.user.messages;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.user.messages.query.*;
import io.kascoder.vkclient.methods.user.messages.response.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class MessagesApi {
    public VkApiRequest<ConversationListResponse> getConversations(@NonNull GetConversationsQuery query) {
        return VkApiRequest.<ConversationListResponse>builder()
                .method(Methods.getConversations)
                .vkApiQuery(query)
                .clazz(ConversationListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryAttachmentListResponse> getHistoryAttachments(@NonNull GetHistoryAttachmentsQuery query) {
        return VkApiRequest.<HistoryAttachmentListResponse>builder()
                .method(Methods.getHistoryAttachments)
                .vkApiQuery(query)
                .clazz(HistoryAttachmentListResponse.class)
                .build();
    }

    public VkApiRequest<HistoryMessageListResponse> getHistory(@NonNull GetHistoryQuery query) {
        return VkApiRequest.<HistoryMessageListResponse>builder()
                .method(Methods.getHistory)
                .vkApiQuery(query)
                .clazz(HistoryMessageListResponse.class)
                .build();
    }

    public VkApiRequest<ConversationMessageListResponse> getByConversationMessageId(@NonNull GetByConversationMessageIdQuery query) {
        return VkApiRequest.<ConversationMessageListResponse>builder()
                .method(Methods.getByConversationMessageId)
                .vkApiQuery(query)
                .clazz(ConversationMessageListResponse.class)
                .build();
    }

    public VkApiRequest<MessageListResponse> getById(@NonNull GetByIdQuery query) {
        return VkApiRequest.<MessageListResponse>builder()
                .method(Methods.getById)
                .vkApiQuery(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    public VkApiRequest<MessageListResponse> search(@NonNull SearchQuery query) {
        return VkApiRequest.<MessageListResponse>builder()
                .method(Methods.search)
                .vkApiQuery(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    public VkApiRequest<DeleteMessageResponse> delete(@NonNull DeleteQuery query) {
        return VkApiRequest.<DeleteMessageResponse>builder()
                .method(Methods.delete)
                .vkApiQuery(query)
                .clazz(DeleteMessageResponse.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements Method {
        getConversations("getConversations"),
        getHistoryAttachments("getHistoryAttachments"),
        getByConversationMessageId("getByConversationMessageId"),
        getHistory("getHistory"),
        getById("getById"),
        search("search"),
        delete("delete");

        private final String path;

        @Override
        public String path() {
            return "messages." + path;
        }
    }
}



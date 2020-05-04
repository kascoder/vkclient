package io.kascoder.vkclient.methods.user.messages;

import io.kascoder.vkclient.Request;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.user.messages.query.*;
import io.kascoder.vkclient.methods.user.messages.response.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class MessagesApi {
    public Request<ConversationListResponse> getConversations(@NonNull GetConversationsQuery query) {
        return Request.<ConversationListResponse>builder()
                .method(Methods.getConversations)
                .query(query)
                .clazz(ConversationListResponse.class)
                .build();
    }

    public Request<HistoryAttachmentListResponse> getHistoryAttachments(@NonNull GetHistoryAttachmentsQuery query) {
        return Request.<HistoryAttachmentListResponse>builder()
                .method(Methods.getHistoryAttachments)
                .query(query)
                .clazz(HistoryAttachmentListResponse.class)
                .build();
    }

    public Request<HistoryMessageListResponse> getHistory(@NonNull GetHistoryQuery query) {
        return Request.<HistoryMessageListResponse>builder()
                .method(Methods.getHistory)
                .query(query)
                .clazz(HistoryMessageListResponse.class)
                .build();
    }

    public Request<ConversationMessageListResponse> getByConversationMessageId(@NonNull GetByConversationMessageIdQuery query) {
        return Request.<ConversationMessageListResponse>builder()
                .method(Methods.getByConversationMessageId)
                .query(query)
                .clazz(ConversationMessageListResponse.class)
                .build();
    }

    public Request<MessageListResponse> getById(@NonNull GetByIdQuery query) {
        return Request.<MessageListResponse>builder()
                .method(Methods.getById)
                .query(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    public Request<MessageListResponse> search(@NonNull SearchQuery query) {
        return Request.<MessageListResponse>builder()
                .method(Methods.search)
                .query(query)
                .clazz(MessageListResponse.class)
                .build();
    }

    public Request<DeleteMessageResponse> delete(@NonNull DeleteQuery query) {
        return Request.<DeleteMessageResponse>builder()
                .method(Methods.delete)
                .query(query)
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



package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.util.annotation.Converter;
import lombok.*;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;

import java.util.List;

@Value
@Builder
public class GetHistoryQuery implements VkApiQuery {
    @RequestParameter(name = "peer_id")
    int peerId;
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 20; // can not be more than 200
    @RequestParameter
    boolean extended;
    @RequestParameter(name = "start_message_id")
    Integer startMessageId;
    @RequestParameter
    @Builder.Default Integer rev = 0;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
}


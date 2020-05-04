package io.kascoder.vkclient.methods.user.messages.query;

import lombok.*;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.Query;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;

@Value
@Builder
public class GetHistoryQuery implements Query {
    @Param(name = "peer_id")
    int peerId;
    @Param(name = "offset")
    private final int offset;
    @Param(name = "count")
    @Builder.Default private final int count = 20; // can not be more than 200
    @Param(name = "extended")
    boolean extended;
    @Param(name = "start_message_id")
    Integer startMessageId;
    @Param(name = "rev")
    @Builder.Default Integer rev = 0;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
}


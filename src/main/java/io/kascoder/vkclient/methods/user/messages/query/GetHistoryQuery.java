package io.kascoder.vkclient.methods.user.messages.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetHistoryQuery implements VkApiQuery {
    @Param(name = "peer_id")
    private final Integer peerId;
    @Param(name = "offset")
    private final int offset;
    @Param(name = "count")
    @Builder.Default private final int count = 20; // can not be more than 200
    @Param(name = "extended")
    private final boolean extended;
    @Param(name = "start_message_id")
    private final Integer startMessageId;
    @Param(name = "rev")
    @Builder.Default private final Integer rev = 0;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    private final List<ObjectField> fields;
}


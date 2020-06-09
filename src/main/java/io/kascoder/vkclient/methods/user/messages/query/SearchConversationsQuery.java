package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class SearchConversationsQuery implements VkApiQuery {
    @Param(name = "q")
    String q;
    @Param(name = "count")
    @Builder.Default int count = 20;
    @Param(name = "extended")
    boolean extended;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
}

package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.LocalDateDDMMYYYYConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class SearchQuery implements VkApiQuery {
    @Param(name = "q")
    String q;
    @NonNull
    @Param(name = "peer_id")
    Integer peerId;
    @NonNull
    @Param(name = "date", strategy = LocalDateDDMMYYYYConversionStrategy.class)
    LocalDate date;
    @Param(name = "offset")
    int offset;
    @Param(name = "count")
    @Builder.Default int count = 20; // can not be more than 100
    @Param(name = "extended")
    boolean extended;
    @Param(name = "preview_length")
    @Builder.Default Integer previewLength = 0;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
}

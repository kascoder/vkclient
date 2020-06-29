package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.LocalDateDDMMYYYYRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class SearchQuery implements VkApiQuery {
    @RequestParameter
    String q;
    @RequestParameter(name = "peer_id")
    int peerId;
    @NonNull
    @RequestParameter
    @Converter(LocalDateDDMMYYYYRequestParameterConverter.class)
    LocalDate date;
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 20; // can not be more than 100
    @RequestParameter
    boolean extended;
    @RequestParameter(name = "preview_length")
    @Builder.Default Integer previewLength = 0;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
}

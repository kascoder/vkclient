package io.kascoder.vkclient.util.conversion.custom;

import lombok.NonNull;
import io.kascoder.vkclient.domain.IValue;
import io.kascoder.vkclient.util.conversion.RequestParameterConverter;

public class IValueRequestParameterConverter implements RequestParameterConverter<IValue> {
    @Override
    public String convert(@NonNull IValue o) {
        return o.getValue();
    }
}

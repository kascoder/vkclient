package io.kascoder.vkclient.util.conversion.custom;

import lombok.NonNull;
import io.kascoder.vkclient.domain.IValue;
import io.kascoder.vkclient.util.conversion.ConversionStrategy;

public class IValueConversionStrategy implements ConversionStrategy<IValue> {
    @Override
    public String convert(@NonNull IValue o) {
        return o.getValue();
    }
}

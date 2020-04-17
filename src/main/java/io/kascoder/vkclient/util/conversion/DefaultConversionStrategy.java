package io.kascoder.vkclient.util.conversion;

import lombok.NonNull;

public class DefaultConversionStrategy implements ConversionStrategy<Object> {
    @Override
    public String convert(@NonNull Object o) {
        return o.toString();
    }
}

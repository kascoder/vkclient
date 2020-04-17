package io.kascoder.vkclient.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.ConversionStrategy;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParameterBuilder {
    @SuppressWarnings("unchecked")
    public static Map<String, Object> buildParamMap(IParam iParamObject) {
        var params = new HashMap<String, Object>();
        if (iParamObject == null) {
            return params;
        }

        var iParamObjectClass = iParamObject.getClass();
        for (var field : iParamObjectClass.getDeclaredFields()) {
            var paramAnnotation = field.getAnnotation(Param.class);
            if (paramAnnotation == null) {
                continue;
            }

            Object o;
            ConversionStrategy conversionStrategy;
            try {
                field.setAccessible(true);
                o = field.get(iParamObject);
                if (o == null) {
                    continue;
                }

                conversionStrategy = paramAnnotation.strategy().getConstructor().newInstance();
            } catch (Exception e) {
                continue;
            }

            params.put(paramAnnotation.name(), conversionStrategy.convert(o));
        }

        return params;
    }
}

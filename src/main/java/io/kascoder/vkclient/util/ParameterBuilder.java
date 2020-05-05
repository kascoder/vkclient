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
    public static Map<String, Object> buildParamMap(Parameterizable parameterizableObject) {
        var params = new HashMap<String, Object>();
        if (parameterizableObject == null) {
            return params;
        }

        var iParamObjectClass = parameterizableObject.getClass();
        for (var field : iParamObjectClass.getDeclaredFields()) {
            var paramAnnotation = field.getAnnotation(Param.class);
            if (paramAnnotation == null) {
                continue;
            }

            Object o;
            ConversionStrategy conversionStrategy;
            try {
                field.setAccessible(true);
                o = field.get(parameterizableObject);
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

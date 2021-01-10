package io.kascoder.vkclient.util;

import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.ObjectRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.RequestParameterConverter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
            var paramAnnotation = field.getAnnotation(RequestParameter.class);
            if (paramAnnotation == null) {
                continue;
            }

            var converterAnnotation = field.getAnnotation(Converter.class);
            RequestParameterConverter requestParameterConverter = new ObjectRequestParameterConverter();
            if (converterAnnotation != null) {
                try {
                    requestParameterConverter = converterAnnotation.value().getConstructor().newInstance();
                } catch (Exception e) {
                    continue;
                }
            }

            Object o;
            try {
                field.setAccessible(true);
                o = field.get(parameterizableObject);
                if (o == null) {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }

            var paramName = paramAnnotation.name().isEmpty() ? field.getName() : paramAnnotation.name();
            params.put(paramName, requestParameterConverter.convert(o));
        }

        return params;
    }
}

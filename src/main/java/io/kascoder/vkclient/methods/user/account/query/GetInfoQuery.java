package io.kascoder.vkclient.methods.user.account.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.methods.user.AccountInfoField;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GetInfoQuery implements VkApiQuery {
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<AccountInfoField> fields; // if empty or null - all fields will be retrieved
}

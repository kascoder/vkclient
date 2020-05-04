package io.kascoder.vkclient.methods.user.account.query;

import io.kascoder.vkclient.methods.Query;
import io.kascoder.vkclient.methods.user.AccountInfoField;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GetInfoQuery implements Query {
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<AccountInfoField> fields; // if empty or null - all fields will be retrieved
}

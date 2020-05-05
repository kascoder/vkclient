package io.kascoder.vkclient.methods.user.account;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.domain.model.AccountInfo;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.user.account.query.GetInfoQuery;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class AccountApi {
    public VkApiRequest<AccountInfo> getInfo(@NonNull GetInfoQuery query) {
        return VkApiRequest.<AccountInfo>builder()
                .method(Methods.getInfo)
                .vkApiQuery(query)
                .clazz(AccountInfo.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements Method {
        getInfo("getInfo");

        private final String path;

        @Override
        public String path() {
            return "account." + path;
        }
    }
}

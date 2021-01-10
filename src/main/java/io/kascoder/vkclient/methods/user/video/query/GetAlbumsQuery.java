package io.kascoder.vkclient.methods.user.video.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetAlbumsQuery implements VkApiQuery {
    @RequestParameter(name = "owner_id")
    Integer ownerId; // default value is current user id
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 50; // Max value is 100
    @RequestParameter(name = "need_system")
    boolean needSystem;
    @RequestParameter
    boolean extended;
}

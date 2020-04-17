package io.kascoder.vkclient.methods.user;

import lombok.AllArgsConstructor;
import io.kascoder.vkclient.methods.ObjectField;

@AllArgsConstructor
public enum UserBasicField implements ObjectField {
    ID("id"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    DEACTIVATED("deactivated"),
    IS_CLOSED("is_closed"),
    CAN_ACCESS_CLOSED("can_access_closed");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}

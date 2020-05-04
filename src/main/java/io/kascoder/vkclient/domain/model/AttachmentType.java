package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import io.kascoder.vkclient.domain.IValue;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiObjectDefinition(name = "messages_message_attachment_type")
public enum  AttachmentType implements IValue {
    PHOTO("photo"),
    VIDEO("video"),
    AUDIO("audio"),
    DOC("doc"),
    LINK("link"),
    NOTE("note"),
    POLL("poll"),
    PAGE("page"),
    ALBUM("album"),
    PHOTOS_LIST("photos_list"),
    MARKET("market"),
    MARKET_ALBUM("market_album"),
    WALL("wall"),
    WALL_REPLY("wall_reply"),
    STICKER("sticker"),
    GIFT("gift"),
    MONEY("money"),
    GRAFFITI("graffiti"),
    AUDIO_MESSAGE("audio_message"),
    PRETTY_CARDS("pretty_cards"),
    EVENT("event"),
    ARTICLE("article"),
    AUDIO_PLAYLIST("audio_playlist"),
    PODCAST("podcast"),
    CALL("call"),
    STORY("story");

    @JsonValue
    private final String value;
}

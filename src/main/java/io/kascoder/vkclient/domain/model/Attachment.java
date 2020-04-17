// objects.json [messages_message_attachment]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // market, link, graffiti, gift, market_market_album, sticker, wall, wall_reply
public class Attachment {
    @JsonProperty("type")
    private AttachmentType type;
    @JsonProperty("audio")
    private Audio audio;
    @JsonProperty("audio_message")
    private AudioMessage audioMessage;
    @JsonProperty("doc")
    private Document document;
    @JsonProperty("photo")
    private Photo photo;
    @JsonProperty("video")
    private Video video;
}

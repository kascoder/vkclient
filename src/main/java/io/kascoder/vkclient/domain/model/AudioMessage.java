// objects.json [messages_audio_message]

package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // duration, waveform
public class AudioMessage {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("link_mp3")
    private String mp3Url;
    @JsonProperty("link_ogg")
    private String oggUrl;
    @JsonProperty("owner_id")
    private Integer ownerId;
}
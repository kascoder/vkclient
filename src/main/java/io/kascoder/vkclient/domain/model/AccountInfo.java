package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.kascoder.vkclient.util.BooleanIntDeserializer;
import io.kascoder.vkclient.domain.Language;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountInfo {
    @JsonProperty("country")
    private String countryCode;
    @JsonProperty("https_required")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isHttpsRequired;
    @JsonProperty("2fa_required")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean is2faRequired;
    @JsonProperty("own_posts_default")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isOwnPostsDefault;
    @JsonProperty("no_wall_replies")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isNoWallReplies;
    @JsonProperty("intro")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isIntroPassed;
    @JsonProperty("lang")
    private Language language;
}

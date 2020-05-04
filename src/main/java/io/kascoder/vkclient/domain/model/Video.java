package io.kascoder.vkclient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.kascoder.vkclient.util.BooleanIntDeserializer;
import io.kascoder.vkclient.util.annotation.ApiObjectDefinition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiObjectDefinition(name = "video_video")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("duration")
    private Integer duration; // seconds
    @JsonProperty("date")
    private Integer date; // UnixTime
    @JsonProperty("adding_date")
    private Integer addingDate; // UnixTime
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("player")
    private String playerUrl;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("live")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isLive;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("upcoming")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isUpcoming;
    @JsonProperty("is_favorite")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isFavorite;
    @JsonProperty("processing")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isProcessing;
    @JsonProperty("comments")
    private Integer commentNumber;
    @JsonProperty("views")
    private Integer viewNumber;
    @JsonProperty("can_edit")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canEdit;
    @JsonProperty("can_add")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canAdd;
    @JsonProperty("is_private")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isPrivate;
    @JsonProperty("converting")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isConverting;
    @JsonProperty("repeat")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean isRepeat;
    @JsonProperty("can_comment")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canComment;
    @JsonProperty("can_like")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canLike;
    @JsonProperty("can_repost")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canRepost;
    @JsonProperty("can_subscribe")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canSubscribe;
    @JsonProperty("can_add_to_faves")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canAddToFaves;
    @JsonProperty("can_attach_link")
    @JsonDeserialize(using = BooleanIntDeserializer.class)
    private boolean canAttachLink;
    @JsonProperty("files")
    private File file;

    @Getter
    @Setter
    @ToString
    public static class File {
        @JsonProperty("external")
        private String externalUrl;
        @JsonProperty("mp4_240")
        private String mp240Url;
        @JsonProperty("mp4_360")
        private String mp360Url;
        @JsonProperty("mp4_480")
        private String mp480Url;
        @JsonProperty("mp4_720")
        private String mp720Url;
        @JsonProperty("mp4_1080")
        private String mp1080Url;
    }
}

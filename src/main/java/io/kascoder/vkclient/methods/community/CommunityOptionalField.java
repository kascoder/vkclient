package io.kascoder.vkclient.methods.community;

import lombok.AllArgsConstructor;
import io.kascoder.vkclient.methods.ObjectField;

@AllArgsConstructor
public enum CommunityOptionalField implements ObjectField {
    ACTIVITY("activity"), 
    AGE_LIMITS("age_limits"), 
    BAN_INFO("ban_info"), 
    CAN_CREATE_TOPIC("can_create_topic"), 
    CAN_MESSAGE("can_message"), 
    CAN_POST("can_post"), 
    CAN_SEE_ALL_POSTS("can_see_all_posts"), 
    CAN_UPLOAD_DOC("can_upload_doc"), 
    CAN_UPLOAD_VIDEO("can_upload_video"), 
    CITY("city"), 
    CONTACTS("contacts"), 
    COUNTERS("counters"), 
    COUNTRY("country"), 
    COVER("cover"), 
    CROP_PHOTO("crop_photo"), 
    DESCRIPTION("description"), 
    FIXED_POST("fixed_post"), 
    HAS_PHOTO("has_photo"), 
    IS_FAVORITE("is_favorite"), 
    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"), 
    IS_MESSAGES_BLOCKED("is_messages_blocked"), 
    LINKS("links"), 
    MAIN_ALBUM_ID("main_album_id"), 
    MAIN_SECTION("main_section"), 
    MARKET("market"), 
    MEMBER_STATUS("member_status"), 
    PLACE("place"), 
    PUBLIC_DATE_LABEL("public_date_label"), 
    SITE("site"), 
    START_DATE("start_date"),
    FINISH_DATE("finish_date"),
    STATUS("status"),
    TRENDING("trending"),
    VERIFIED("verified"),
    WALL("wall"),
    WIKI_PAGE("wiki_page");

    private String value;

    @Override
    public String toString() {
        return value;
    }
}

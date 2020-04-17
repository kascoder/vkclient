package io.kascoder.vkclient.methods.user;

import lombok.AllArgsConstructor;
import io.kascoder.vkclient.methods.ObjectField;

@AllArgsConstructor
public enum UserOptionalField implements ObjectField {
    ABOUT("about"), 
    ACTIVITIES("activities"), 
    BIRTH_DATE("bdate"), 
    BLACKLISTED("blacklisted"), 
    BLACKLISTED_BY_ME("blacklisted_by_me"), 
    BOOKS("books"), 
    CAN_POST("can_post"), 
    CAN_SEE_ALL_POSTS("can_see_all_posts"), 
    CAN_SEE_AUDIO("can_see_audio"), 
    CAN_SEND_FRIEND_REQUEST("can_send_friend_request"), 
    CAN_WRITE_PRIVATE_MESSAGE("can_write_private_message"), 
    CAREER("career"), 
    CITY("city"), 
    COMMON_COUNT("common_count"), 
    CONNECTIONS("connections"), 
    CONTACTS("contacts"), 
    COUNTERS("counters"), 
    COUNTRY("country"), 
    CROP_PHOTO("crop_photo"), 
    DOMAIN("domain"), 
    EDUCATION("education"), 
    EXPORTS("exports"), 
    FIRST_NAME_NOM("first_name_nom"), 
    FIRST_NAME_GEN("first_name_gen"), 
    FIRST_NAME_DAT("first_name_dat"), 
    FIRST_NAME_ACC("first_name_acc"), 
    FIRST_NAME_INS("first_name_ins"), 
    FIRST_NAME_ABL("first_name_abl"), 
    FOLLOWERS_COUNT("followers_count"), 
    FRIEND_STATUS("friend_status"), 
    GAMES("games"), 
    HAS_MOBILE("has_mobile"), 
    HAS_PHOTO("has_photo"), 
    HOME_TOWN("home_town"), 
    INTERESTS("interests"), 
    IS_FAVORITE("is_favorite"), 
    IS_FRIEND("is_friend"), 
    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"), 
    LAST_NAME_NOM("last_name_nom"), 
    LAST_NAME_GEN("last_name_gen"), 
    LAST_NAME_DAT("last_name_dat"), 
    LAST_NAME_ACC("last_name_acc"), 
    LAST_NAME_INS("last_name_ins"), 
    LAST_NAME_ABL("last_name_abl"), 
    LAST_SEEN("last_seen"), 
    LISTS("lists"), 
    MAIDEN_NAME("maiden_name"), 
    MILITARY("military"), 
    MUSIC("music"), 
    NICKNAME("nickname"), 
    OCCUPATION("occupation"), 
    ONLINE("online"), 
    PERSONAL("personal"), 
    PHOTO_50("photo_50"), 
    PHOTO_100("photo_100"), 
    PHOTO_200_ORIG("photo_200_orig"), 
    PHOTO_200("photo_200"), 
    PHOTO_400_ORIG("photo_400_orig"), 
    PHOTO_ID("photo_id"), 
    PHOTO_MAX("photo_max"), 
    PHOTO_MAX_ORIG("photo_max_orig"), 
    QUOTES("quotes"), 
    RELATIVES("relatives"), 
    RELATION("relation"), 
    SCHOOLS("schools"), 
    SCREEN_NAME("screen_name"), 
    SEX("sex"), 
    SITE("site"), 
    STATUS("status"), 
    TIMEZONE("timezone"), 
    TRENDING("trending"), 
    TV("tv"), 
    UNIVERSITIES("universities"), 
    VERIFIED("verified"); 

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
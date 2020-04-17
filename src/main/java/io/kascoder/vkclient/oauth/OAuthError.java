package io.kascoder.vkclient.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthError extends RuntimeException {
    @JsonProperty("error")
    private String error;
    @JsonProperty("error_type")
    private String errorType;
    @JsonProperty("error_description")
    private String errorDescription;
    @JsonProperty("validation_type")
    private String validationType;
    @JsonProperty("validation_sid")
    private String validationSid;
    @JsonProperty("phone_mask")
    private String phoneMask;
    @JsonProperty("redirect_uri")
    private String redirectUri;
    @JsonProperty("captcha_sid")
    private String captchaSid;
    @JsonProperty("captcha_img")
    private String captchaImg;
}

package io.kascoder.vkclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import io.kascoder.vkclient.domain.RequestParameter;

import java.util.List;

@Getter
@Setter
public class VkApiError extends RuntimeException {
    @JsonProperty("error_code")
    private int errorCode;
    @JsonProperty("error_msg")
    private String errorMessage;
    @JsonProperty("captcha_sid")
    private String captchaSid;
    @JsonProperty("captcha_img")
    private String captchaImg;
    @JsonProperty("redirect_uri")
    private String redirectUri;
    @JsonProperty("confirmation_text")
    private String confirmationText;
    @JsonProperty("request_params")
    private List<RequestParameter> requestParams;
}

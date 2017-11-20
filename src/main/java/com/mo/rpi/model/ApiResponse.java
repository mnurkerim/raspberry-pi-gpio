package com.mo.rpi.model;

import com.pi4j.io.gpio.PinState;

public class ApiResponse {

    private String message;
    private PinState pinState;

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    public PinState getPinState() {
        return pinState;
    }

    void setPinState(PinState pinState) {
        this.pinState = pinState;
    }

    public static final class ApiResponseBuilder {
        private String message;
        private PinState pinState;

        private ApiResponseBuilder() {
        }

        public static ApiResponseBuilder anApiResponse() {
            return new ApiResponseBuilder();
        }

        public ApiResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder withPinState(PinState pinState) {
            this.pinState = pinState;
            return this;
        }

        public ApiResponse build() {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage(message);
            apiResponse.setPinState(pinState);
            return apiResponse;
        }
    }
}

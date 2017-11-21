package com.mo.rpi.api;

import com.mo.rpi.gpio.GpioService;
import com.mo.rpi.model.ApiResponse;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mo.rpi.model.ApiResponse.ApiResponseBuilder.anApiResponse;

@RestController
@RequestMapping("api")
public class GpioApi {

    private final GpioService gpioService;

    @Autowired
    public GpioApi(GpioService gpioService) {
        this.gpioService = gpioService;
    }

    @RequestMapping("/led/toggle")
    public ApiResponse togglePin() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();
        ledPin.toggle();
        PinState state = ledPin.getState();

        return anApiResponse().withMessage("LED Toggled").withPinState(state).build();
    }

    @RequestMapping("/led/on")
    public ApiResponse setPinHigh() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();
        ledPin.high();

        return anApiResponse().withMessage("LED switched ON").withPinState(ledPin.getState()).build();
    }

    @RequestMapping("/led/off")
    public ApiResponse setPinLow() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();
        ledPin.low();

        return anApiResponse().withMessage("LED switched OFF").withPinState(ledPin.getState()).build();
    }

    @RequestMapping("/led/state")
    public ApiResponse getState() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();

        return anApiResponse().withMessage("No action performed").withPinState(ledPin.getState()).build();
    }
}

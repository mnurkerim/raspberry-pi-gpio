package com.mo.rpi.api;

import com.mo.rpi.gpio.GpioService;
import com.mo.rpi.model.ApiResponse;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return new ApiResponse("Switch toggled. Current state: " + state);
    }

    @RequestMapping("/led/on")
    public ApiResponse setPingHigh() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();
        ledPin.high();

        return new ApiResponse("LED switched on.");
    }

    @RequestMapping("/led/off")
    public ApiResponse setPingLow() {
        GpioPinDigitalOutput ledPin = gpioService.getLedPin();
        ledPin.low();

        return new ApiResponse("LED switched off");
    }

}

package com.mo.rpi.gpio;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Component;

@Component
public class GpioService {

    private GpioPinDigitalOutput ledPin;

    public GpioService() {
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        GpioController gpio = GpioFactory.getInstance();

        ledPin = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_16, "My LED", PinState.LOW);
    }

    public GpioPinDigitalOutput getLedPin() {
        return ledPin;
    }
}

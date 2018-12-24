package io.github.hanzhi713.sensing;

import com.pi4j.io.gpio.*;
/**
 * @author Hanzhi Zhou
 * */
public class BarrierDetector implements DisposableGpioDevice {
    private final GpioController gpio = GpioFactory.getInstance();
    private final GpioPinDigitalInput sensor;

    public BarrierDetector(Pin p){
        sensor = gpio.provisionDigitalInputPin(p, PinPullResistance.PULL_DOWN);
    }

    public boolean detected(){
        return sensor.isState(PinState.LOW);
    }

    @Override
    public void dispose() {
        gpio.unprovisionPin(sensor);
        gpio.shutdown();
    }
}

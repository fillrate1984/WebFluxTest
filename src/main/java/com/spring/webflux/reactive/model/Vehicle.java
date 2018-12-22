package com.spring.webflux.reactive.model;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private Integer speed;

    
    public Vehicle() {
    	
    }

    public Vehicle(Integer speed) {
        super();
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                '}';
    }
}

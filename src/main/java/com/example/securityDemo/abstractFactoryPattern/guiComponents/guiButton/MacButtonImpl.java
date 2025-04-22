package com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton;

public class MacButtonImpl implements Button {
    @Override
    public void render() {
        System.out.println("--------------------------");
        System.out.println("-        Mac Button      -");
        System.out.println("--------------------------");
    }
}

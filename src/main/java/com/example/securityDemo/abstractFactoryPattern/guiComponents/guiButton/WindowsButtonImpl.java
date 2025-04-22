package com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton;

public class WindowsButtonImpl implements Button {
    @Override
    public void render() {
        System.out.println("--------------------------");
        System.out.println("-     Windows Button     -");
        System.out.println("--------------------------");
    }
}

package com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox;

public class MacCheckBoxImpl implements CheckBox{
    @Override
    public void render() {
        System.out.println("------   |\\  /|");
        System.out.println("- _/ -   | \\/ |");
        System.out.println("------   |    |");
    }
}

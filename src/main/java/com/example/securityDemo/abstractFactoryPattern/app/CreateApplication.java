package com.example.securityDemo.abstractFactoryPattern.app;

import com.example.securityDemo.abstractFactoryPattern.factory.GUIFactory;
import com.example.securityDemo.abstractFactoryPattern.factory.MacGUIFactoryImpl;
import com.example.securityDemo.abstractFactoryPattern.factory.WindowsGUIFactoryImpl;

public class CreateApplication {
    public static void main(String[] args) {
        GUIFactory windowsGUIFactory = new WindowsGUIFactoryImpl();
        GUIFactory macGUIFactory = new MacGUIFactoryImpl();
        Application windowsApplication = new Application(windowsGUIFactory);
        Application macApplication = new Application(macGUIFactory);
        windowsApplication.create();
        macApplication.create();
    }
}

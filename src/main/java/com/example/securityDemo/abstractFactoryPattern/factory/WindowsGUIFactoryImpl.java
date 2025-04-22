package com.example.securityDemo.abstractFactoryPattern.factory;

import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.Button;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.WindowsButtonImpl;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.CheckBox;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.WindowsCheckBoxImpl;

public class WindowsGUIFactoryImpl implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButtonImpl();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBoxImpl();
    }
}

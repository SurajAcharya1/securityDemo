package com.example.securityDemo.abstractFactoryPattern.factory;

import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.Button;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.MacButtonImpl;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.CheckBox;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.MacCheckBoxImpl;

public class MacGUIFactoryImpl implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButtonImpl();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBoxImpl();
    }
}

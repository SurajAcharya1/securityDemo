package com.example.securityDemo.abstractFactoryPattern.factory;

import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.Button;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

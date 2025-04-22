package com.example.securityDemo.abstractFactoryPattern.app;

import com.example.securityDemo.abstractFactoryPattern.factory.GUIFactory;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiButton.Button;
import com.example.securityDemo.abstractFactoryPattern.guiComponents.guiCheckBox.CheckBox;

public class Application {
    private final Button button;
    private final CheckBox checkBox;
    Application(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.checkBox = guiFactory.createCheckBox();
    }

    public void create() {
        button.render();
        checkBox.render();
    }
}

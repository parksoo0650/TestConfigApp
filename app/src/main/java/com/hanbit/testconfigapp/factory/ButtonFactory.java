package com.hanbit.testconfigapp.factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import java.util.Map;

/**
 * Created by hanbit on 2017-03-15.
 */

public class ButtonFactory {
    public static Button createButton(Context context,Map<String,String>buttonMap) {
        Button button = new Button(context);
        String text = "", layoutParams = "", bgColor = "";
        switch (buttonMap.get("type")) {
            case "basic":
                button.setText(buttonMap.get("text"));
                button.setLayoutParams(LayoutParamsFactory.createLayoutParams(buttonMap.get("layoutParams")));
                button.setBackgroundColor(Color.parseColor(buttonMap.get("color")));
                break;
        }
        return button;
    }
}

package com.hanbit.testconfigapp.factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by hanbit on 2017-03-15.
 */

public class TextViewFactory {
    public static TextView createTextView(Context context,Map<String,String>map) {
        TextView textView = new TextView(context);
        String text = "", layoutParams = "", bgColor = "";
        switch (map.get("type")) {
            case "basic":
                textView.setText(map.get("text"));
                textView.setLayoutParams(LayoutParamsFactory.createLayoutParams(map.get("layoutParams")));
                textView.setBackgroundColor(Color.parseColor(map.get("color")));
                break;
        }
        return textView;
    }
}

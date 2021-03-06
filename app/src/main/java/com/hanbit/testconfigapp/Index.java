package com.hanbit.testconfigapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hanbit.testconfigapp.factory.Composite;
import com.hanbit.testconfigapp.member.MemberList;

import java.util.HashMap;

public class Index extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=Index.this;
        HashMap<?,?>components=init(context);
        setContentView((LinearLayout) components.get("llIndex"));
        ((Button) components.get("btnIndex")).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));
            }
        });
    }
    public HashMap<?,?>init(Context context){
        Composite compo=new Composite(context,"Index");
        compo.excute();
        setContentView(compo.getFrame());
        return  compo.getComponents();
    }
    /*public void init(Context context){
        Map<String,String>map=new HashMap<>();
        map.put("type","vertical");
        map.put("layoutParams","mm");
        LinearLayout frame = LiearLayoutFactory.createLinearLayout(context,map);
        map.clear();
        map.put("type","basic");
        map.put("text","HELLO");
        map.put("layoutParams","mw");
        map.put("color","white");
        TextView textView= TextViewFactory.createTextView(context,map);
        map.clear();
        map.put("type","basic");
        map.put("text","ENTER");
        map.put("layoutParams","mw");
        map.put("color","#00ff00");
        button= ButtonFactory.createButton(context,map);
        frame.addView(textView);
        frame.addView(button);
        setContentView(frame);
        ViewGroup.MarginLayoutParams tvMargin=new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
        tvMargin.setMargins(0,200,0,0);
        button.setLayoutParams(new LinearLayout.LayoutParams(tvMargin));
        ViewGroup.MarginLayoutParams btnMargin=new ViewGroup.MarginLayoutParams(button.getLayoutParams());
        btnMargin.setMargins(0,300,0,0);
        button.setLayoutParams(new LinearLayout.LayoutParams(btnMargin));

    }*/
}

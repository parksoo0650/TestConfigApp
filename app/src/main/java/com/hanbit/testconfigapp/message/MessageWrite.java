package com.hanbit.testconfigapp.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MessageWrite extends AppCompatActivity {
    String temp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=MessageWrite.this;
        Intent intent=this.getIntent();
        LinearLayout frame=new LinearLayout(context);
        LinearLayout.LayoutParams mm=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams mw=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        frame.setLayoutParams(mm);
        TextView tv=new TextView(context);
        tv.setLayoutParams(mw);
        ViewGroup.MarginLayoutParams top100=new ViewGroup.MarginLayoutParams(mw);
        top100.setMargins(0,200,0,0);
        tv.setLayoutParams(new LinearLayout.LayoutParams(top100));
        tv.setLayoutParams(top100);
        tv.setGravity(1);
        tv.setTextSize(30);
        String idAndPhone=intent.getExtras().getString("idAndphone").toString();
        Log.d("넘어온 ID ,전화번호, 이름",idAndPhone);
        tv.setText(idAndPhone);
        WebView wv=new WebView(context);
        wv.setLayoutParams(mm);
        WebSettings settings=wv.getSettings();
        settings.setUseWideViewPort(true); //http를 쓰겠다는 의미이다.
        settings.setJavaScriptEnabled(true); //javaScript를 가능하게한다.
        wv.setWebViewClient(new WebViewClient());

        wv.addJavascriptInterface(new JavascriptInterface() {
            @Override @android.webkit.JavascriptInterface
            public void showToast(String message){
                Toast.makeText(context,temp,Toast.LENGTH_LONG).show();
            }
            @Override
            public void sendMessage(String message) {
                temp=message;
            }
        },"Hybrid");

                wv.loadUrl("file:///android_asset/www/html/messageWrite");//외부의 DB값을 보는 것이다.
        frame.addView(wv);
        setContentView(frame);

        //마진탑 100
        //setText
    }
    public interface JavascriptInterface{
        public void showToast(String message);
        public void sendMessage(String message);
        }


}

package com.hanbit.testconfigapp.factory;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by hanbit on 2017-03-16.
 */

public class CompositeCompo {
    interface iComposite {
        public void excute();
    }

    final HashMap<String, Object> map = new HashMap<>();

    public LinearLayout getFrame() {
        return frame;
    }
    LinearLayout frame;
    String order;
    Context context;

    public CompositeCompo(Context context, String order) {
        this.context = context;
        this.order = order;
    }
    public HashMap<String, Object> getComponents(){
        return map;
    }

        public void excute() { //선언된 순서대로 실행한다.
            new ButtonCompo().service.excute();
            new TextViewCompo().service.excute();
            new LinearLayoutCompo().service.excute();
            new ListViewComp().service.excute();
            switch (order){
                case "Index" : frame = (LinearLayout) map.get(order);
                    frame.addView((android.widget.TextView) map.get("HelloTextView"));
                    frame.addView((android.widget.Button) map.get("EnterButton"));
                    break;
                case "MemberList" : frame = (LinearLayout) map.get(order);
                    frame.addView((android.widget.ListView) map.get("MemberListView")); //저쪽으로 ListView 전달
                case "MemberDetail" : frame = (LinearLayout) map.get(order);
                    frame.addView((LinearLayout) map.get("ll1"));
                    frame.addView((LinearLayout) map.get("ll2"));
                    frame.addView((LinearLayout) map.get("ll3"));
                    frame.addView((LinearLayout) map.get("ll4"));
                    frame.addView((LinearLayout) map.get("ll5"));
                    frame.addView((LinearLayout) map.get("ll6"));
                    frame.addView((LinearLayout) map.get("uiButton1"));
                    frame.addView((LinearLayout) map.get("uiButton2"));
                    frame.addView((LinearLayout) map.get("uiButton3"));
                    frame.addView((LinearLayout) map.get("uiButton4"));
                    frame.addView((LinearLayout) map.get("uiButton5"));

                    break;
            }
        }
        class ButtonCompo {
            iComposite service = new iComposite() {
                @Override
                public void excute() {
                    Button button = null;
                    String text = "", layoutParams = "", bgColor = "";
                    switch (order) {
                        case "Index":
                            button = new Button(context);
                            button.setText("ENTER");
                            button.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            button.setBackgroundColor(Color.parseColor("#00FF00"));
                            ViewGroup.MarginLayoutParams margin=new ViewGroup.MarginLayoutParams(button.getLayoutParams());
                            margin.setMargins(0,300,0,0);
                            button.setLayoutParams(new LinearLayout.LayoutParams(margin));
                            map.put("EnterButton", button);
                            break;
                        case "MemberDetail" :
                            LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
                              /* 구글맵 & 내 위치*/
                            LinearLayout uiButton1=new LinearLayout(context);
                            uiButton1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            Button btLocation=new Button(context);
                            btLocation.setLayoutParams(weight);
                            btLocation.setText("LOCATION");
                            btLocation.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btLocation",btLocation);
                            Button btGoogleMap=new Button(context);
                            btGoogleMap.setLayoutParams(weight);
                            btGoogleMap.setText("GOOGLE MAP");
                            btGoogleMap.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btGoogleMap",btGoogleMap);
                            uiButton1.addView(btLocation);
                            uiButton1.addView(btGoogleMap);
                            map.put("uiButton1",uiButton1);
        /* 앨범  &  음악*/
                            LinearLayout uiButton2=new LinearLayout(context);
                            uiButton2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            Button btGallery=new Button(context);
                            btGallery.setLayoutParams(weight);
                            btGallery.setText("GALLERY");
                            btGallery.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btGallery",btGallery);
                            Button btMusic=new Button(context);
                            btMusic.setLayoutParams(weight);
                            btMusic.setText("MUSIC");
                            btMusic.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btMusic",btMusic);
                            uiButton2.addView(btGallery);
                            uiButton2.addView(btMusic);
                            map.put("uiButton2",uiButton2);
        /* SMS & 메일 */
                            LinearLayout uiButton3=new LinearLayout(context);
                            uiButton3.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            Button btSMS=new Button(context);
                            btSMS.setLayoutParams(weight);
                            btSMS.setText("SMS");
                            btSMS.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btSMS",btSMS);
                            Button btMail=new Button(context);
                            btMail.setLayoutParams(weight);
                            btMail.setText("MAIL");
                            btMail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btMail",btMail);
                            uiButton3.addView(btSMS);
                            uiButton3.addView(btMail);
                            map.put("uiButton3",uiButton3);
        /* 다이얼 & 콜 */
                            LinearLayout uiButton4=new LinearLayout(context);
                            uiButton4.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            Button btDial=new Button(context);
                            btDial.setLayoutParams(weight);
                            btDial.setText("DIAL");
                            btDial.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btDial",btDial);
                            Button btCall=new Button(context);
                            btCall.setLayoutParams(weight);
                            btCall.setText("CALL");
                            btCall.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btCall",btCall);
                            uiButton4.addView(btDial);
                            uiButton4.addView(btCall);
                            map.put("uiButton4",uiButton4);
        /* 목록가기 & 수정하기 */
                            LinearLayout uiButton5=new LinearLayout(context);
                            uiButton5.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            Button btList=new Button(context);
                            btList.setLayoutParams(weight);
                            btList.setText("LIST");
                            btList.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btList",btList);
                            Button btUpdate=new Button(context);
                            btUpdate.setLayoutParams(weight);
                            btUpdate.setText("UPDATE");
                            btUpdate.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("btUpdate",btUpdate);
                            uiButton5.addView(btList);
                            uiButton5.addView(btUpdate);
                            map.put("uiButton5",uiButton5);
                            break;
                    }
                }
            };
        }

        class TextViewCompo {
            iComposite service = new iComposite() {
                @Override
                public void excute() {
                    TextView tv1= null,tv2=null,tv3=null,tv4=null,tv5=null,tv6=null;
                    TextView tv1_1= null,tv2_1=null,tv3_1=null,tv4_1=null,tv5_1=null,tv6_1=null;
                    LinearLayout ll1=null,ll2=null,ll3=null,ll4=null,ll5=null,ll6=null;
                    switch (order) {
                        case "Index":
                            tv1 = new TextView(context);
                            tv1.setText("HelloTextView");
                            tv1.setGravity(Gravity.CENTER);
                            tv1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv1.setBackgroundColor(Color.parseColor(("#FFFFFF")));
                            ViewGroup.MarginLayoutParams margin=new ViewGroup.MarginLayoutParams(tv1.getLayoutParams());
                            margin.setMargins(0,300,0,0);
                            tv1.setLayoutParams(new LinearLayout.LayoutParams(margin));
                            map.put("HelloTextView", tv1);
                            break;
                        case "MemberDetail" :
                             /* ID Row */
                            ll1=new LinearLayout(context);
                            ll1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv1=new TextView(context);
                            tv1.setText("ID: ");
                            tv1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv1_1 =new TextView(context);
                            tv1_1.setText("ID content");
                            tv1_1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv1_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvIdContent",tv1_1);
                            ll1.addView(tv1);
                            ll1.addView(tv1_1);
                            map.put("ll1",ll1);
        /* NAME Row */
                            ll2=new LinearLayout(context);
                            ll2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv2=new TextView(context);
                            tv2.setText("NAME: ");
                            tv2.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv2_1=new TextView(context);
                            tv2_1.setText("NAME content");
                            tv2_1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv2_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvNameContent",tv2_1);
                            ll2.addView(tv2);
                            ll2.addView(tv2_1);
                            map.put("ll2",ll2);
        /* PHONE Row */
                            ll3=new LinearLayout(context);
                            ll3.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv3=new TextView(context);
                            tv3.setText("PHONE: ");
                            tv3.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv3_1=new TextView(context);
                            tv3_1.setText("PHONE content");
                            tv3_1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv3_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvPhoneContent",tv3_1);
                            ll3.addView(tv3);
                            ll3.addView(tv3_1);
                            map.put("ll3",ll3);
        /* AGE Row */
                            ll4=new LinearLayout(context);
                            ll4.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv4=new TextView(context);
                            tv4.setText("AGE: ");
                            tv4.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv4_1=new TextView(context);
                            tv4_1.setText("AGE content");
                            tv4_1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv4_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvAgeContent",tv4_1);
                            ll4.addView(tv4);
                            ll4.addView(tv4_1);
                            map.put("ll4",ll4);
        /* 주소Row */
                            ll5=new LinearLayout(context);
                            ll5.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv5=new TextView(context);
                            tv5.setText("ADDRESS: ");
                            tv5.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv5_1=new TextView(context);
                            tv5_1.setText("ADDRESS content");
                            tv5_1.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv5_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvAddressContent",tv5_1);
                            ll5.addView(tv5);
                            ll5.addView(tv5_1);
                            map.put("ll5",ll5);
        /* 연봉 Row */
                            ll6=new LinearLayout(context);
                            ll6.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                            tv6=new TextView(context);
                            tv6.setText("SALARY: ");
                            tv6.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            tv6_1=new TextView(context);
                            tv6.setText("SALARY content");
                            tv6.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                            tv6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            map.put("tvSalaryContent",tv6);
                            ll6.addView(tv6_1);
                            ll6.addView(tv6);
                            map.put("ll6",ll6);
                            break;
                    }
                }
            };
        }

        class EditTextCompo {
            iComposite service = new iComposite() {
                @Override
                public void excute() {

                }
            };
        }
        class ListViewComp{
            iComposite service = new iComposite() {
                @Override
                public void excute() {
                    ListView listView=null;
                    switch (order){
                        case "MemberList":
                            listView = new ListView(context);
                            listView.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                            map.put("MemberListView", listView);
                            break;
                    }
                }
            };
        }
        class LinearLayoutCompo {
            iComposite service = new iComposite() {
                @Override
                public void excute() {
                    switch (order) {
                        case "Index": case "MemberList" : case "MemberDetail" :
                            frame = new LinearLayout(context);
                            frame.setOrientation(LinearLayout.VERTICAL);
                            frame.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                            map.put(order, frame);
                            break;
                    }
                }
            };
        }
    };







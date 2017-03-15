package com.hanbit.testconfigapp.member;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.testconfigapp.action.IDetail;
import com.hanbit.testconfigapp.factory.DetailQuery;
import com.hanbit.testconfigapp.factory.LayoutParamsFactory;

import java.util.HashMap;
import java.util.Map;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=this.getIntent();
        final String id=intent.getExtras().getString("id").toString();
        super.onCreate(savedInstanceState);
        final Context context=MemberDetail.this;
        LinearLayout ui=new LinearLayout(context);
        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
        LinearLayout uiId=new LinearLayout(context);
        uiId.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvId=new TextView(context);
        tvId.setText("ID: ");
        tvId.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvIdContent=new TextView(context);
        tvIdContent.setText("ID content");
        tvIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiId.addView(tvId);
        uiId.addView(tvIdContent);
        ui.addView(uiId);
        LinearLayout uiName=new LinearLayout(context);
        uiName.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvName=new TextView(context);
        tvName.setText("NAME: ");
        tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvNameContent=new TextView(context);
        tvNameContent.setText("NAME content");
        tvNameContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiName.addView(tvName);
        uiName.addView(tvNameContent);
        ui.addView(uiName);
        LinearLayout uiPhone=new LinearLayout(context);
        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvPhone=new TextView(context);
        tvPhone.setText("PHONE: ");
        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvPhoneContent=new TextView(context);
        tvPhoneContent.setText("PHONE content");
        tvPhoneContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiPhone.addView(tvPhone);
        uiPhone.addView(tvPhoneContent);
        ui.addView(uiPhone);
        LinearLayout uiAge=new LinearLayout(context);
        uiAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAge=new TextView(context);
        tvAge.setText("AGE: ");
        tvAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAgeContent=new TextView(context);
        tvAgeContent.setText("AGE content");
        tvAgeContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAge.addView(tvAge);
        uiAge.addView(tvAgeContent);
        ui.addView(uiAge);
        LinearLayout uiAddress=new LinearLayout(context);
        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAddress=new TextView(context);
        tvAddress.setText("ADDRESS: ");
        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAddressContent=new TextView(context);
        tvAddressContent.setText("ADDRESS content");
        tvAddressContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAddress.addView(tvAddress);
        uiAddress.addView(tvAddressContent);
        ui.addView(uiAddress);
        LinearLayout uiSalary=new LinearLayout(context);
        uiSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvSalary=new TextView(context);
        tvSalary.setText("SALARY: ");
        tvSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvSalaryContent=new TextView(context);
        tvSalaryContent.setText("SALARY content");
        tvSalaryContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiSalary.addView(tvSalary);
        uiSalary.addView(tvSalaryContent);
        ui.addView(uiSalary);
        LinearLayout uiButton1=new LinearLayout(context);
        uiButton1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btLocation=new Button(context);
        btLocation.setLayoutParams(weight);
        btLocation.setText("LOCATION");
        btLocation.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btGoogleMap=new Button(context);
        btGoogleMap.setLayoutParams(weight);
        btGoogleMap.setText("GOOGLE MAP");
        btGoogleMap.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton1.addView(btLocation);
        uiButton1.addView(btGoogleMap);
        ui.addView(uiButton1);
        LinearLayout uiButton2=new LinearLayout(context);
        uiButton2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btGallery=new Button(context);
        btGallery.setLayoutParams(weight);
        btGallery.setText("GALLERY");
        btGallery.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btMusic=new Button(context);
        btMusic.setLayoutParams(weight);
        btMusic.setText("MUSIC");
        btMusic.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton2.addView(btGallery);
        uiButton2.addView(btMusic);
        ui.addView(uiButton2);
        LinearLayout uiButton3=new LinearLayout(context);
        uiButton3.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btSMS=new Button(context);
        btSMS.setLayoutParams(weight);
        btSMS.setText("SMS");
        btSMS.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btMail=new Button(context);
        btMail.setLayoutParams(weight);
        btMail.setText("MAIL");
        btMail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton3.addView(btSMS);
        uiButton3.addView(btMail);
        ui.addView(uiButton3);
        LinearLayout uiButton4=new LinearLayout(context);
        uiButton4.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btDial=new Button(context);
        btDial.setLayoutParams(weight);
        btDial.setText("DIAL");
        btDial.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btCall=new Button(context);
        btCall.setLayoutParams(weight);
        btCall.setText("CALL");
        btCall.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton4.addView(btDial);
        uiButton4.addView(btCall);
        ui.addView(uiButton4);
        LinearLayout uiButton5=new LinearLayout(context);
        uiButton5.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btList=new Button(context);
        btList.setLayoutParams(weight);
        btList.setText("LIST");
        btList.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btUpdate=new Button(context);
        btUpdate.setLayoutParams(weight);
        btUpdate.setText("UPDATE");
        btUpdate.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton5.addView(btList);
        uiButton5.addView(btUpdate);
        ui.addView(uiButton5);

        final MemDetail memberDetail=new MemDetail(context);
        IDetail service=new IDetail() {
            @Override
            public Map<String,String> list(String params) {
                return memberDetail.detail("select _id AS id,name,phone,age,address,salary from member where _id='"+params+"';");
            }
        };
        Map<String,String> rsMap= (Map<String, String>) service.list(id);
        Toast.makeText(MemberDetail.this,"id값 확인"+id,Toast.LENGTH_LONG).show();
        tvIdContent.setText(rsMap.get("id"));
        tvNameContent.setText(rsMap.get("name"));
        tvPhoneContent.setText(rsMap.get("phone"));
        tvAgeContent.setText(rsMap.get("age"));
        tvAddressContent.setText(rsMap.get("address"));
        tvSalaryContent.setText(rsMap.get("salary"));
        setContentView(ui);
        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "));
                //intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + map.get("phoneNum")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MemberDetail.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
    class MemDetail extends DetailQuery {

        public MemDetail(Context context) {
            super(context);
        }

        @Override
        public Map<String,String> detail(String sql) {
            Map<String,String> map=new HashMap<>();
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            if(cursor!=null) {
                if (cursor.moveToNext()){
                    map=new HashMap<>();
                    map.put("id",cursor.getString(cursor.getColumnIndex("id")));
                    map.put("name",cursor.getString(cursor.getColumnIndex("name")));
                    map.put("age",cursor.getString(cursor.getColumnIndex("age")));
                    map.put("phone",cursor.getString(cursor.getColumnIndex("phone")));
                    map.put("address",cursor.getString(cursor.getColumnIndex("address")));
                    map.put("salary",cursor.getString(cursor.getColumnIndex("salary")));

                }
            }
            return map;
        }
    }

}

package com.hanbit.testconfigapp.member;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hanbit.testconfigapp.R;
import com.hanbit.testconfigapp.action.IDelete;
import com.hanbit.testconfigapp.action.IList;
import com.hanbit.testconfigapp.factory.Composite;
import com.hanbit.testconfigapp.factory.DeleteQuery;
import com.hanbit.testconfigapp.factory.LayoutParamsFactory;
import com.hanbit.testconfigapp.factory.ListQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* @Create: 2017-03-16
* @Auth: parkseoungsoo
* @Story: 친구목록을 보여준다
* @@Nested: Class ListDao, MemberAdapter, ViewHolder
* */
public class MemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=MemberList.this;
        HashMap<?,?>components=init(context);
        final ListView listview= (ListView) components.get("MemberListView");
        final HashMap<String,Object>map=new HashMap<>();
        final ListDao memberList=new ListDao(context);
        final IList service=new IList() {
            @Override
            public List<?> list() {
                return memberList.list("select _id AS id, name, phone, age, address, salary from member;");
            }
        };


        final ArrayList<Map<String,String>> memberMap= (ArrayList<Map<String, String>>) service.list();
        listview.setAdapter(new MemberAdapter(memberMap,context));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Intent intent=new Intent(context,MemberDetail.class);
                intent.putExtra("id",memberMap.get(i).get("id"));
                startActivity(intent);
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                HashMap<String,String>temp= (HashMap<String, String>) listview.getItemAtPosition(i); //내가 길게누른 아이템을 가져옴
                map.clear();
                map.put("id",temp.get("id"));
                new AlertDialog.Builder(context)
                .setTitle("삭제")
                .setMessage("정말 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            final DeleteDao deleteDao = new DeleteDao(context);
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                IDelete service = new IDelete() {
                                    @Override
                                    public void delete() {
                                        deleteDao.delete("DELETE FROM Member WHERE _id='"+map.get("id")+"';");
                                        startActivity(new Intent(context, MemberList.class));
                                    }
                                };
                                service.delete();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //no를 클릭하면 그냥 닫히므로 코딩 할필요 없음
                            }
                        })
                        .show();
                //하나를 선택해서 담고, alert를 띄움
                return true;
            }
        });
    }
    class ListDao extends ListQuery {
        public ListDao(Context context) {
            super(context);
        }

        @Override
        public List<?> list(String sql) {
            Map<String,String> map;
            ArrayList<Map<String,String>> members=new ArrayList<>();
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            if(cursor!=null) {
                if (cursor.moveToFirst()){
                    do{
                        map=new HashMap<>();
                        map.put("id",cursor.getString(cursor.getColumnIndex("id")));
                        map.put("name",cursor.getString(cursor.getColumnIndex("name")));
                        map.put("age",cursor.getString(cursor.getColumnIndex("age")));
                        map.put("phone",cursor.getString(cursor.getColumnIndex("phone")));
                        map.put("address",cursor.getString(cursor.getColumnIndex("address")));
                        map.put("salary",cursor.getString(cursor.getColumnIndex("salary")));
                        members.add(map);
                    }while(cursor.moveToNext());
                }
            }
            return members;
        }
    }
    class DeleteDao extends DeleteQuery {
        public DeleteDao(Context context) {
            super(context);
        }

        @Override
        public void delete(String sql) {
            super.getDatabase().execSQL(sql);
        }
    }

    class MemberAdapter extends BaseAdapter {
        ArrayList<Map<String,String>> list;
        LayoutInflater inflater;
        private int[] photos={R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecream,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.cupcake,R.drawable.donut};
        public MemberAdapter(ArrayList<?> list, Context context) {
            this.list = (ArrayList<Map<String, String>>) list;
            this.inflater= LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) { return list.get(i);}

        @Override
        public long getItemId(int i) { //index
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup g) {
            ViewHoler holder;
            if(v==null) {
                LinearLayout uiItem=new LinearLayout(MemberList.this);
                uiItem.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                uiItem.setPadding(8, 8, 8, 8);
                ImageView profileImg = new ImageView(MemberList.this);
                profileImg.setLayoutParams(new ViewGroup.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics()),(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics())));
                TextView tvName = new TextView(MemberList.this);
                tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                tvName.setText("Name");
                tvName.setTypeface(null, Typeface.BOLD);
                TextView tvPhone = new TextView(MemberList.this);
                tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                tvPhone.setText("Phone");
                uiItem.addView(profileImg);
                uiItem.addView(tvName);
                uiItem.addView(tvPhone);
                holder=new ViewHoler();
                holder.profileImg= profileImg;
                holder.tvName= tvName;
                holder.tvPhone= tvPhone;
                v=uiItem;
                v.setTag(holder);
            }else{
                holder= (ViewHoler) v.getTag();
            }
            holder.profileImg.setImageResource(photos[i]);
            holder.tvName.setText(list.get(i).get("name"));
            holder.tvPhone.setText(list.get(i).get("phone"));
            return v;
        }
    }
    static class ViewHoler{
        ImageView profileImg;
        TextView tvName,tvPhone;
    }

    public HashMap<?,?>init(Context context){
        Composite compo=new Composite(context,"MemberList");
        compo.excute();
        setContentView(compo.getFrame());
        return  compo.getComponents();
    }
}


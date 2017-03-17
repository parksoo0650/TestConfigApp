package com.hanbit.testconfigapp.member;

import android.support.v7.app.AppCompatActivity;

public class MemberUpdate extends AppCompatActivity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final Context context = MemberUpdate.this;
        HashMap<?, ?> compments = init(context);
        final ListView listView = (ListView) compments.get("MemberUpdate");
        final HashMap<String, Object> map = new HashMap<>();
        final IUpdate service = new IUpdate() {
            @Override
            public void update(Map<?, ?> map) {
                return
            }
        };

        class UpdateDao extends WriteQuery {

            public UpdateDao(Context context) {
                super(context);
            }

            @Override
            public Map<String, String> update(String sql) {
                Map<String, String> map = null;
                ArrayList<Map<String, String>> member = new ArrayList<>();
                SQLiteDatabase db = super.getDatabase();
                Cursor cursor = db.rawQuery(sql, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        map = new HashMap<>();
                        map.put("id", cursor.getString(cursor.getColumnIndex("id")));
                        map.put("name", cursor.getString(cursor.getColumnIndex("name")));
                        map.put("age", cursor.getString(cursor.getColumnIndex("age")));
                        map.put("phone", cursor.getString(cursor.getColumnIndex("phone")));
                        map.put("address", cursor.getString(cursor.getColumnIndex("address")));
                        map.put("salary", cursor.getString(cursor.getColumnIndex("salary")));
                    }
                }
                return map;
            }
        }
        public HashMap<?,?>init(Context context){
            Composite compo=new Composite(context,"MemberUpdate");
            compo.excute();
            setContentView(compo.getFrame());
            return  compo.getComponents();
        }*/
}

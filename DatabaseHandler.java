package com.example.usamasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String Database_Name="studentmanager";
    public DatabaseHandler(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create="create table student(rollno text primary key,name text,age text)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists student");
        onCreate(sqLiteDatabase);
    }
    public boolean addData(String rollno,String name,String age){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues add=new ContentValues();

        add.put("rollno",rollno);
        add.put("name",name);
        add.put("age",age);

        long r=db.insert("student",null,add);
        if (r==-1){
            return false;
        }else {
            return true;
        }
    }
    public boolean updateData(String rollno,String name,String age){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues add=new ContentValues();
        add.put("name",name);
        add.put("age",age);

        Cursor cursor=db.rawQuery("select * from student where rollno=?",new String[]{rollno});

        if (cursor.getCount()>0){
            long r=db.update("student",add,"rollno=?",new String[]{rollno});
            if (r==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
    public boolean deleteData(String rollno){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("select * from student where rollno=?",new String[] {rollno});
        if (cursor.getCount()>0){
            long r=db.delete("student","rollno=?",new String[] {rollno});
            if (r==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
    Details selectData(String rollno){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("student",new String[]{"rollno","name","age"},"rollno=?",new String[]{rollno},null,null,null,null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        Details details=new Details(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        return details;
    }
}

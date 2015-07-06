package com.example.mybffapp_;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter 

{
	static final String KEY_DNI="dni";
	static final String KEY_NAME="nombre";
	static final String KEY_LASTNAME="apellido";
	static final String KEY_EMAIL="email";
	static final String KEY_PASSWORD="password";
	static final String TAG="DBAdapter";

	static final String DATABASE_NAME="db_MyBffApp";
	static final String DATABASE_TABLE="usuarios";
	static final int DATABASE_VERSION=1;
	static final String DATABASE_CREATE=
			"create table usuarios (dni integer primary key,"
			+"nombre text not null,apellido text not null,email text not null,password text not null "
			+ ");";
	final Context context;
	DatabaseHelper DBHelper;
	SQLiteDatabase db;
	public DBAdapter(Context ctx)
	{
		this.context=ctx;
		DBHelper=new DatabaseHelper(context);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}
		
		public void onCreate(SQLiteDatabase db)
		{
			try
			{
				db.execSQL(DATABASE_CREATE);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		public void onUpgrade (SQLiteDatabase db, int oldVersion,int newVersion)
		{
			Log.w(TAG,"Upgrading database from version:"+oldVersion+"to"
					+newVersion+",which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS usuarios");
			onCreate (db);
		}
	}
	
	public DBAdapter open() throws SQLException
	{
		db=DBHelper.getWritableDatabase();
		return this;
		
	}
	public void close() 
	{
		DBHelper.close();
	}
	public long insertUsuario (int dni,String name, String apellido, String email, String password) 
	{
		ContentValues initialValues=new ContentValues();
		initialValues.put(KEY_DNI, dni);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_LASTNAME, apellido);
		initialValues.put(KEY_EMAIL, email);
		initialValues.put(KEY_PASSWORD, password);
		return db.insert(DATABASE_TABLE, null, initialValues);


		
	}

	public boolean deleteContact(long rowId)
	{
		return db.delete(DATABASE_TABLE,KEY_DNI+"="+rowId,null)>0;
	}
	
	public Cursor getAllContacts()
	{
			return db.query(DATABASE_TABLE,new String[]{KEY_DNI,
						KEY_NAME,KEY_EMAIL},null,
						null,null,null,null);
	}
	
	
	
	public Cursor getContact(long rowId) throws SQLException
	{
		Cursor mCursor=
				db.query(true, DATABASE_TABLE,new String[]{KEY_DNI,
						KEY_NAME,KEY_EMAIL},KEY_DNI+"="+rowId,null,
						null,null,null,null);
		if(mCursor!=null)
		{
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	public boolean ValidarUsuario (String user, String pass)
	{
		Cursor mCursor=
				db.rawQuery("SELECT COUNT (*)"+
					"FROM usuarios WHERE email=' "+ user+
					"' AND password='"+pass+"'",null);
		if(mCursor.getCount()<1)
		{
			return false;
		}
		mCursor.moveToFirst();
		if(mCursor.getInt(0)!=1)
		{
			return false;

		}
		return true;
		
	}
	public boolean updateContact(long rowId,String name, String email)
	{
		ContentValues args=new ContentValues();
		args.put(KEY_NAME,name);
		args.put(KEY_EMAIL,email);
		return db.update(DATABASE_TABLE, args, KEY_DNI+"="+rowId, null)>0;
	}
	




}

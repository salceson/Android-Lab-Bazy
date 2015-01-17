package pl.edu.agh.michalciolczyk;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SecureDataActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secure_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_logout){
            SharedPreferences sp = getSharedPreferences("mySP", Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("isAuthorized", false);
            e.commit();
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onOpenOrCreateDatabaseClicked(View view){
        MyFirstSQLiteDatabaseHelper databaseHelper = new MyFirstSQLiteDatabaseHelper(this);
    }

    public void onInsertDataClicked(View view){
        MyFirstSQLiteDatabaseHelper databaseHelper = new MyFirstSQLiteDatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyFirstSQLiteDatabaseHelper.USER_NAME, "John Q. Public");
        database.insert(MyFirstSQLiteDatabaseHelper.TABLE_NAME,
                MyFirstSQLiteDatabaseHelper.USER_NAME, contentValues);

        Cursor c = database.query(MyFirstSQLiteDatabaseHelper.TABLE_NAME,
                new String[]{MyFirstSQLiteDatabaseHelper.U_ID,
                        MyFirstSQLiteDatabaseHelper.USER_NAME},
                null, null, null, null, null, null);

        while(c.moveToNext()) {
            int i = c.getInt(c.getColumnIndex(MyFirstSQLiteDatabaseHelper.U_ID));
            String name = c.getString(c.getColumnIndex(MyFirstSQLiteDatabaseHelper.USER_NAME));

            Log.i("MichalCiolczyk", i + ": " + name);
        }

    }

    public void onRunSimpleAdapterClicked(View view){
        startActivity(new Intent(this, SimpleAdapterActivity.class));
    }

    public void onShowUserListClicked(View view){
        startActivity(new Intent(this, ListUserActivity.class));
    }
}

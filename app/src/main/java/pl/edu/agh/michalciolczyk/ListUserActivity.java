package pl.edu.agh.michalciolczyk;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import static android.R.id.text1;
import static android.R.layout.simple_list_item_1;

public class ListUserActivity extends ListActivity {
    private int[] VIEW_BINDING = new int[]{text1};
    private String[] COLUMN_BINDING = new String[]{MyFirstSQLiteDatabaseHelper.USER_NAME};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyFirstSQLiteDatabaseHelper helper = new MyFirstSQLiteDatabaseHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();

        Cursor c = database.query(MyFirstSQLiteDatabaseHelper.TABLE_NAME,
                new String[]{MyFirstSQLiteDatabaseHelper.U_ID,
                        MyFirstSQLiteDatabaseHelper.USER_NAME},
                null, null, null, null, null, null);

        ListAdapter adapter = new SimpleCursorAdapter(this, simple_list_item_1, c,
                COLUMN_BINDING, VIEW_BINDING);

        setListAdapter(adapter);
    }
}

package pl.edu.agh.michalciolczyk;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import static android.R.layout.simple_list_item_1;

public class SimpleAdapterActivity extends ListActivity {
    private static String[] tab = {"1", "2", "3", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1, tab);
        setListAdapter(adapter);
    }
}

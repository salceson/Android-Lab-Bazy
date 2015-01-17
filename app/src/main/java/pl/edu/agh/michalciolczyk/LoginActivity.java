package pl.edu.agh.michalciolczyk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void onLoginButtonClicked(View view){
        EditText editText = (EditText) findViewById(R.id.editText);

        if("mojehaslo".equals(editText.getText().toString())){
            SharedPreferences sp = getSharedPreferences("mySP", Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("isAuthorized", true);
            e.commit();
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        String msg = editText.getText().toString() + " is not good password!";

//        AlertDialog ad = new AlertDialog.Builder(LoginActivity.this)
//                .setTitle("Login")
//                .setMessage(editText.getText())
//                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .create();
//
//        ad.show();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.dmb.actividad6di;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,address;
    private TextView changeColor;
    boolean color = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        name = (EditText)findViewById(R.id.name);
        address = (EditText)findViewById(R.id.address);
        changeColor = (TextView)findViewById(R.id.changeColor);

        registerForContextMenu(name);
        registerForContextMenu(address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contex_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.conf:
                return true;
            case R.id.data:
                return true;
            case R.id.pref:
                Intent intent = new Intent(this,Main3Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.name:
                return true;
            case R.id.address:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void changeColor(View v){
        if(color==true){
            changeColor.setBackgroundColor(Color.BLACK);
            changeColor.setTextColor(Color.WHITE);
            color = false;
        }else if(color==false){
            changeColor.setBackgroundColor(Color.WHITE);
            changeColor.setTextColor(Color.BLACK);
            color = true;
        }
    }

    public void openFloridaOberta(View v){
        Uri uri = Uri.parse("https://www.floridaoberta.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openListView(View v){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}

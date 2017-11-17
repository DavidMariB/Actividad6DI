package com.dmb.actividad6di;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private CheckBox silenceMode;
    private TextView silenceModeText,ringTone,ringToneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        silenceMode = (CheckBox)findViewById(R.id.silenceMode);
        silenceModeText = (TextView)findViewById(R.id.silenceModeText);
        ringTone = (TextView)findViewById(R.id.ringTone);
        ringToneText = (TextView)findViewById(R.id.ringToneText);

        registerForContextMenu(ringTone);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tone_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.classic:
                ringToneText.setText("Clasico");
                return true;
            case R.id.mambo:
                ringToneText.setText("Mambo");
                return true;
            case R.id.piano:
                ringToneText.setText("Piano");
                return true;
            case R.id.pitbull:
                ringToneText.setText("Pitbull");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void silenceModeChecker(View v){
        if(silenceMode.isChecked()){
            silenceModeText.setText("Modo silencioso activado");
        }else {
            silenceModeText.setText("Modo silencioso desactivado");
        }
    }

    public void advancedOptions(View v){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}

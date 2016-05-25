package org.mqstack.mydemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.mqstack.airhockey.AirHockeyActivity;
import org.mqstack.gldemo.GlMainActivity;
import org.mqstack.particles.ParticlesActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btGLdemo;

    private Button btAirHockey;
    private Button btParticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGLdemo = (Button) findViewById(R.id.button_gldemo);
        btGLdemo.setOnClickListener(this);

        btAirHockey = (Button) findViewById(R.id.button_airhockey);
        btAirHockey.setOnClickListener(this);

        btParticle = (Button) findViewById(R.id.button_particle);
        btParticle.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_gldemo:
                Intent intent = new Intent(MainActivity.this, GlMainActivity.class);
                startActivity(intent);
                break;
            case R.id.button_airhockey:
                Intent intent1 = new Intent(MainActivity.this, AirHockeyActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_particle:
                Intent intent2 = new Intent(MainActivity.this, ParticlesActivity.class);
                startActivity(intent2);

                break;
            default:
                return;
        }
    }
}

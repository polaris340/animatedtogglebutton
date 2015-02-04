package me.jiho.animatedtogglebuttonexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import me.jiho.animatedtogglebutton.ListGridToggleButton;
import me.jiho.animatedtogglebutton.MenuAnimatedToggleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuAnimatedToggleButton btn1 = (MenuAnimatedToggleButton) findViewById(R.id.btn1);
        MenuAnimatedToggleButton btn2 = (MenuAnimatedToggleButton) findViewById(R.id.btn2);
        MenuAnimatedToggleButton btn3 = (MenuAnimatedToggleButton) findViewById(R.id.btn3);

        btn1.setRotateAngle(90f);
        btn2.setColor(Color.RED);
        btn3.setRotateAngle(180f);
        btn3.setColor(Color.BLUE);
        btn3.setInterpolator(new AccelerateInterpolator(), true);
        btn3.setInterpolator(new DecelerateInterpolator(), false);
        btn3.setDuration(1000);


        ListGridToggleButton btn4 = (ListGridToggleButton) findViewById(R.id.btn4);
        ListGridToggleButton btn5 = (ListGridToggleButton) findViewById(R.id.btn5);
        ListGridToggleButton btn6 = (ListGridToggleButton) findViewById(R.id.btn6);


        btn5.setColor(Color.RED);
        btn6.setColor(Color.BLUE);
        btn6.setInterpolator(new AccelerateInterpolator(2f), true);
        btn6.setInterpolator(new DecelerateInterpolator(2f), false);
        btn6.setDuration(1000);
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
}

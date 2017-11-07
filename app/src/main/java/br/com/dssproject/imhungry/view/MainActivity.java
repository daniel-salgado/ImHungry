package br.com.dssproject.imhungry.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import br.com.dssproject.imhungry.R;


//Animations --> http://awsrh.blogspot.co.nz/2017/10/welcome-screen-with-uptodown-animation.html
public class MainActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    LinearLayout linearTop;
    LinearLayout linearBottom;


    Animation uptodown;
    Animation downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearTop = (LinearLayout) findViewById(R.id.linearTop);
        linearBottom = (LinearLayout) findViewById(R.id.linearBottom);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        linearTop.setAnimation(uptodown);
        linearBottom.setAnimation(downtoup);


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(MainActivity.this,FoodListActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }


}

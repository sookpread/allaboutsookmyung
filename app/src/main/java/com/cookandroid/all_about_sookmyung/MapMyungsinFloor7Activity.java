package com.cookandroid.all_about_sookmyung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapMyungsinFloor7Activity extends AppCompatActivity {
    Animation fab_open, fab_close;
    Boolean isFabOpen = false, isVisible = false;
    FloatingActionButton fab, fab1, fab2;
    Context context;
    ImageView main, locker;

    Button movementSub1, movementSub2, movementSub3, movementSub4, movementSub5, movementSub6;
    ImageButton r701Btn, r702Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myungsin_floor7);

        movementSub1 = findViewById(R.id.button);
        movementSub2 = findViewById(R.id.button2);
        movementSub3 = findViewById(R.id.button3);
        movementSub4 = findViewById(R.id.button4);
        movementSub5 = findViewById(R.id.button5);
        movementSub6 = findViewById(R.id.button6);

        movementSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor1Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor3Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor4Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor5Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor7Activity.this, MapMyungsinFloor6Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        context = getApplicationContext();
        fab_open = AnimationUtils.loadAnimation(context, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(context, R.anim.fab_close);

        fab = (FloatingActionButton) findViewById(R.id.fab_main);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        main = (ImageView) findViewById(R.id.imageView4);
        locker = (ImageView) findViewById(R.id.floor7_locker);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isVisible){
                    locker.setVisibility(View.VISIBLE);
                    main.setVisibility(View.INVISIBLE);
                    isVisible = true;
                }
                else {
                    locker.setVisibility(View.INVISIBLE);
                    main.setVisibility(View.VISIBLE);
                    isVisible = false;
                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // 캠퍼스 지도로
            }
        });

        r701Btn = (ImageButton) findViewById(R.id.room701);
        r701Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassInfoDialogFragment classInfoDialogFragment = ClassInfoDialogFragment.getInstance("701", "뒷문만", true, 1);
                classInfoDialogFragment.show(getSupportFragmentManager(), "");
            }
        });

        r702Btn = (ImageButton) findViewById(R.id.room702);
        r702Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassInfoDialogFragment classInfoDialogFragment = ClassInfoDialogFragment.getInstance("702", "뒷문만", true, 1);
                classInfoDialogFragment.show(getSupportFragmentManager(), "");
            }
        });
    }

    public void anim() {
        if (isFabOpen) {
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }
}

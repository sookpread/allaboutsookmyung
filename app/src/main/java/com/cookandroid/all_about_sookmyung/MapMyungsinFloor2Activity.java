package com.cookandroid.all_about_sookmyung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MapMyungsinFloor2Activity extends AppCompatActivity{
    Animation fab_open, fab_close;
    Boolean isFabOpen = false;
    FloatingActionButton fab, fab1, fab2;
    Context context;

    Button movementSub1, movementSub3, movementSub4, movementSub5, movementSub6, movementSub7;
    ImageButton r202Btn, r203Btn, r204Btn, r218bBtn;

    // TODO: 2022-12-17 Image 버튼 구현 요망(선언부터), 파란 강의실은 ClassInfoDialogFragment, 회색은 편집 중
    //       강의실 201 207 209 210 211 213 214 215 217 221
    //       과방 208a 208b 218a 219 220a 220b
    //       회색 212 218b

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myungsin_floor2);

        movementSub1 = findViewById(R.id.button);
        movementSub3 = findViewById(R.id.button3);
        movementSub4 = findViewById(R.id.button4);
        movementSub5 = findViewById(R.id.button5);
        movementSub6 = findViewById(R.id.button6);
        movementSub7 = findViewById(R.id.button7);

        movementSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor1Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor3Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor4Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor5Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor6Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        movementSub7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapMyungsinFloor2Activity.this, MapMyungsinFloor7Activity.class);
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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2022-12-17 사물함
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // 캠퍼스 지도로
            }
        });

        r202Btn = (ImageButton) findViewById(R.id.room202);
        r202Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassInfoDialogFragment room203Dialog = ClassInfoDialogFragment.getInstance("202호", "앞문과 뒷문", true, 0);
                room203Dialog.show(getSupportFragmentManager(), "202");
            }
        });

        r203Btn = (ImageButton) findViewById(R.id.room203);
        r203Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassInfoDialogFragment room203Dialog = ClassInfoDialogFragment.getInstance("203호", "앞문과 뒷문", true, 0);
                room203Dialog.show(getSupportFragmentManager(), "203");
            }
        });

        r204Btn = (ImageButton) findViewById(R.id.room204);
        r204Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassInfoDialogFragment room204Dialog = ClassInfoDialogFragment.getInstance("204", "앞문과 뒷문", true, 0);
                room204Dialog.show(getSupportFragmentManager(), "204");
            }
        });

        r218bBtn = (ImageButton) findViewById(R.id.room218b);
        r218bBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElseInfoDialogFragment room218bDialog = ElseInfoDialogFragment.getInstance("218b", "분리수거 작업실");
                room218bDialog.show(getSupportFragmentManager(), "218b");
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

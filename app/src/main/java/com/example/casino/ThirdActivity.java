package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kotlin.random.Random;

public class ThirdActivity extends AppCompatActivity {

    private TextView msg;
    private ImageView img1, img2, img3, img4;
    private Wheel wheel1, wheel2, wheel3, wheel4;
    private Button btn;
    private boolean isStarted;

    public static final Random RANDOM = new Random() {
        @Override
        public int nextBits(int i) {
            return 0;
        }
    };

    public static long randomLong (long lower, long upper){
        return lower + (long) (RANDOM.nextDouble()*(upper-lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button mainbtn = findViewById(R.id.mainbtn);

        View.OnClickListener oclmainbtn = view -> {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            startActivity(intent);
        };

        mainbtn.setOnClickListener(oclmainbtn);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        btn = (Button) findViewById(R.id.btn);
        msg = (TextView) findViewById(R.id.msg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isStarted) {
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();
                    wheel4.stopWheel();

                    if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex && wheel3.currentIndex == wheel4.currentIndex) {
                        msg.setText("Вы выиграли большой приз!");
                    } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex || wheel3.currentIndex == wheel4.currentIndex || wheel1.currentIndex == wheel4.currentIndex) {
                        msg.setText("Молодец, вы выиграли небольшой приз");
                    } else {
                        msg.setText("Вы проиграли");
                    }

                    btn.setText("Начать");
                    isStarted = false;

                } else {
                    wheel1 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    wheel1.start();

                    wheel2 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel2.start();

                    wheel3 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel3.start();

                    wheel4 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img4.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel4.start();

                    btn.setText("Стоп");
                    msg.setText("");
                    isStarted = true;

                }
                ;}});}}
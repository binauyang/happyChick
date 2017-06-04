package cn.edu.tju.ouyangbin.helloworld;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button mHappyChickBtn;
    private Button mCatchChickBtn;

    private SoundPool soundPool;//声明一个SoundPool
    private int soundId;//创建某个声音对应的音频ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
    }

    private void initButton() {
        mHappyChickBtn = (Button) this.findViewById(R.id.happyChickbutton);
        mHappyChickBtn.setOnClickListener(this);
        mCatchChickBtn = (Button) this.findViewById(R.id.catchChickBtn);
        mCatchChickBtn.setOnClickListener(this);

        initSound();
    }

    private void initSound() {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(this, R.raw.btn, 1);
    }

    @Override
    public void onClick(View v) {
        playSound();
        switch (v.getId()) {
            case R.id.happyChickbutton:
                jump2HappyChickActivity();
                break;
            case R.id.catchChickBtn:
                jump2CatchChickActivity();
                break;
        }
    }

    private void playSound() {
        soundPool.play(soundId, 0.1f, 0.5f, 0, 1, 1);
    }

    private void jump2HappyChickActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, HappyChickActivity.class);
        startActivity(intent);
    }

    private void jump2CatchChickActivity() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CatchChickActivity.class);
        startActivity(intent);
    }
}
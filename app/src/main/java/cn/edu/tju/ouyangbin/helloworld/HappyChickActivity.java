package cn.edu.tju.ouyangbin.helloworld;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HappyChickActivity extends BaseActivity {

    private ImageView chickIV;
    private AnimationDrawable chickAnimation;

    private ImageView layEggIV;
    private AnimationDrawable layEggAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_chick);
        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        chickAnimation.start();
    }

    private void initView() {
        chickIV = (ImageView) findViewById(R.id.chickIV);
        chickIV.setBackgroundResource(R.drawable.chick_animation);
        chickAnimation = (AnimationDrawable) chickIV.getBackground();

        layEggIV = (ImageView) findViewById(R.id.lay_eggIV);
        Animation layAnimation = AnimationUtils.loadAnimation(this, R.anim.lay_egg);
        layEggIV.startAnimation(layAnimation);
    }
}

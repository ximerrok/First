package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.first.R;

import java.util.concurrent.Executor;

public class KaspiActivity extends AppCompatActivity {

    ImageView[] imageViews = new ImageView[4];
    Button[] buttons = new Button[10];
    ImageButton imageButton;
    String str = "";
    TextView forget;

    ImageButton finger;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaspi_main2);
        SharedPreferences password = getSharedPreferences("fastPass", MODE_PRIVATE);

        buttons[0] = findViewById(R.id.button0);
        buttons[1] = findViewById(R.id.button);
        buttons[2] = findViewById(R.id.button2);
        buttons[3] = findViewById(R.id.button3);
        buttons[4] = findViewById(R.id.button4);
        buttons[5] = findViewById(R.id.button5);
        buttons[6] = findViewById(R.id.button6);
        buttons[7] = findViewById(R.id.button7);
        buttons[8] = findViewById(R.id.button8);
        buttons[9] = findViewById(R.id.button9);
        forget = findViewById(R.id.Forget);
        finger = findViewById(R.id.buttonFinger);
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS: {
                finger.setVisibility(View.VISIBLE);
                break;
            }
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED: {
                finger.setVisibility(View.INVISIBLE);
                break;
            }
            case BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED:
            case BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED:
            case BiometricManager.BIOMETRIC_STATUS_UNKNOWN:
                break;
        }
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(KaspiActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                nextAcc();
                super.onAuthenticationSucceeded(result);
            }

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationFailed() {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(150);
                super.onAuthenticationFailed();
            }
        });
        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Вход по отпечатку пальца").setDescription("Приложите палец, чтобы войти в приложение").setNegativeButtonText("Использовать код доступа").build();

        imageViews[0] = findViewById(R.id.imageView);
        imageViews[1] = findViewById(R.id.imageView2);
        imageViews[2] = findViewById(R.id.imageView3);
        imageViews[3] = findViewById(R.id.imageView4);

        imageButton = findViewById(R.id.imageButton);


        View.OnTouchListener oclBtnOk = new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (v.getId()) {
                    case R.id.button: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(1);
                        }

                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(1, v, event);
                        }

                        break;
                    }
                    case R.id.button2: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(2);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(2, v, event);
                        }
                        break;
                    }
                    case R.id.button3: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(3);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(3, v, event);
                        }
                        break;
                    }
                    case R.id.button4: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(4);
                        }

                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(4, v, event);
                        }

                        break;
                    }
                    case R.id.button5: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(5);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(5, v, event);
                        }
                        break;
                    }
                    case R.id.button6: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(6);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(6, v, event);
                        }
                        break;
                    }
                    case R.id.button7: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(7);
                        }

                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(7, v, event);
                        }

                        break;
                    }
                    case R.id.button8: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(8);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(8, v, event);
                        }
                        break;
                    }
                    case R.id.button9: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(9);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(9, v, event);
                        }
                        break;
                    }
                    case R.id.button0: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            changeBackD(0);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            changeBackU(0, v, event);
                        }
                        break;
                    }

                    case R.id.imageButton: {

                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Drawable buttonDrawable = imageButton.getBackground();
                            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                            DrawableCompat.setTint(buttonDrawable, Color.rgb( 233,131,5));
                            imageButton.setBackground(buttonDrawable);
                            imageButton.setImageResource(R.drawable.ic_delete_white);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            Rect rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());

                            if (str.length() != 0 && rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                                str = str.substring(0, str.length() - 1);
                                imageViews[str.length()].setImageResource(R.drawable.ic_ellipse_13);
                            }
                            Drawable buttonDrawable = imageButton.getBackground();
                            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                            DrawableCompat.setTint(buttonDrawable, Color.rgb(239, 242, 245));
                            imageButton.setBackground(buttonDrawable);
                            imageButton.setImageResource(R.drawable.ic_delete);
                        }
                        break;
                    }
                    case R.id.buttonFinger: {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Drawable buttonDrawable = finger.getBackground();
                            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                            DrawableCompat.setTint(buttonDrawable, Color.rgb( 233,131,5));
                            finger.setBackground(buttonDrawable);
                            finger.setImageResource(R.drawable.ic_fingerprint_white);
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            Rect rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                            if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                                biometricPrompt.authenticate(promptInfo);
                            }
                            Drawable buttonDrawable = finger.getBackground();
                            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                            DrawableCompat.setTint(buttonDrawable, Color.rgb( 239, 242, 245));
                            finger.setBackground(buttonDrawable);
                            finger.setImageResource(R.drawable.ic_fingerprint);
                        }
                        break;
                    }

                }
                if (str.length() == 4) {
                    SharedPreferences password = getSharedPreferences("fastPass", MODE_PRIVATE);
                    String cur = password.getString("fastPassword", "null");
                    if (cur.equals("null")) {
                        SharedPreferences.Editor editor = password.edit();
                        editor.putString("fastPassword", str);
                        editor.apply();
                        str = "";
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                clearPass();
                            }
                        }, 300);
                    }
                    else {
                        if (str.equals(cur)) {
                            str = "";
                            nextAcc();
                        } else {
                            str = "";
                            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            vibe.vibrate(150);

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    clearPass();
                                }
                            }, 300);
                        }
                    }
                }
                return true;
            }
        };
        for (Button button : buttons) {
            button.setOnTouchListener(oclBtnOk);
        }
        imageButton.setOnTouchListener(oclBtnOk);
        finger.setOnTouchListener(oclBtnOk);
        biometricPrompt.authenticate(promptInfo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }



    public void nextAcc() {
        Intent intent = new Intent(this, com.example.first.LoginActiv.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("ResourceAsColor")
    public void changeBackD(int n) {
        Drawable buttonDrawable = buttons[n].getBackground();
        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
        DrawableCompat.setTint(buttonDrawable, Color.rgb( 233,131,5));
        buttons[n].setBackground(buttonDrawable);
        buttons[n].setTextColor(Color.WHITE);
    }
    public void changeBackU(int n, View v, MotionEvent event) {
        Rect rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
            imageViews[str.length()].setImageResource(R.drawable.ic_ellipse_12);
            str = str + n;
        }
        Drawable buttonDrawable = buttons[n].getBackground();
        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
        DrawableCompat.setTint(buttonDrawable, Color.rgb(239, 242, 245));
        buttons[n].setBackground(buttonDrawable);
        buttons[n].setTextColor(Color.BLACK);
    }
    public void clearPass() {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(150);
        str = "";
        for (ImageView i : imageViews) {
            i.setImageResource(R.drawable.ic_ellipse_13);
        }
    }
}
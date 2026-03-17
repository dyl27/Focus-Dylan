package com.example.focus;
/**
 * @author Dylan Enrique Juárez Martínez
 */

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Version modificada en main
// Comentario para crear el conflicto

public class MainActivity extends AppCompatActivity {

    // UI
    private TextView tvTimerDisplay;
    private Button btnStartStop;

    // Timer
    private CountDownTimer timer;

    // Estado
    private boolean isRunning = false;

    // Tiempos (en milisegundos)
    private long focusTime = 25 * 60 * 1000;
    private long breakTime = 5 * 60 * 1000;
    private long restTime = 15 * 60 * 1000;

    private long currentTime = focusTime;

    // Control de sesiones
    private int focusSessions = 0;
    private String currentMode = "FOCUS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Conectar UI
        tvTimerDisplay = findViewById(R.id.tvTimerDisplay);
        btnStartStop = findViewById(R.id.btnStartStop);

        // Botón Start / Stop
        btnStartStop.setOnClickListener(v -> {

            if(!isRunning){
                startTimer();
                btnStartStop.setText("Stop");
                isRunning = true;
            }else{
                if(timer != null){
                    timer.cancel();
                }
                btnStartStop.setText("Start");
                isRunning = false;
            }
        });

    }

    private void startTimer(){
        // Evitar múltiples timers
        if(timer != null){
            timer.cancel();
        }
        timer = new CountDownTimer(currentTime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                currentTime = millisUntilFinished;

                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;

                String time = String.format("%02d:%02d",minutes,seconds);

                tvTimerDisplay.setText(time);
            }

            @Override
            public void onFinish() {
                changeMode();
            }
        }.start();
    }


    private void changeMode(){
        if(currentMode.equals("FOCUS")){
            focusSessions++;
            if(focusSessions == 4){
                currentMode = "REST";
                currentTime = restTime;
                focusSessions = 0;
                Log.d("Pomodoro","Descanso largo");
            }else{
                currentMode = "BREAK";
                currentTime = breakTime;
                Log.d("Pomodoro","Descanso corto");
            }
        }
        else if(currentMode.equals("BREAK")){

            currentMode = "FOCUS";
            currentTime = focusTime;

            Log.d("Pomodoro","Modo enfoque");

        }
        else if(currentMode.equals("REST")){

            currentMode = "FOCUS";
            currentTime = focusTime;

            Log.d("Pomodoro","Reiniciando ciclo");

        }

        startTimer();

    }

}
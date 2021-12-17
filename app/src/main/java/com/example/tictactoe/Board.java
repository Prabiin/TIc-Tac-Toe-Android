package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Board extends AppCompatActivity {

    Button button;
    TextView update_panel;
    CardView okay, cancel;

    boolean player1_turn;


    int[] BUTTON_IDS = {
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_board);

        update_panel = findViewById(R.id.update_panel);

        okay = findViewById(R.id.btn_ok);
        cancel = findViewById(R.id.btn_cancel);

        okay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });

        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                backToSecond();
            }
        });

        Random random = new Random();
        if(random.nextInt(2) == 0) {
            player1_turn = true;
            update_panel.setText("Player X's turn");
        } else {
            player1_turn = false;
            update_panel.setText("Player O's turn");
        }

       for(int id : BUTTON_IDS){
            button = findViewById(id);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchPlayer(id);
                }
            });
        }
    }

    public void switchPlayer(int i){
        button = findViewById(i);
        if(player1_turn){
            button.setText("X");
            button.setTextColor(Color.parseColor("#FFFF4444"));
            update_panel.setText("Player O's turn");
            player1_turn = false;
        }else{
            button.setText("O");
            button.setTextColor(Color.parseColor("#23CF23"));
            update_panel.setText("Player X's turn");
            player1_turn = true;
        }
        button.setClickable(false);
        check();
    }

    public void check(){
        Button btn1 =  findViewById(R.id.btn1);
        Button btn2 =  findViewById(R.id.btn2);
        Button btn3 =  findViewById(R.id.btn3);
        Button btn4 =  findViewById(R.id.btn4);
        Button btn5 =  findViewById(R.id.btn5);
        Button btn6 =  findViewById(R.id.btn6);
        Button btn7 =  findViewById(R.id.btn7);
        Button btn8 =  findViewById(R.id.btn8);
        Button btn9 =  findViewById(R.id.btn9);
        if(btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")){
            xWin(btn1, btn2, btn3);
        }
        if(btn4.getText().equals("X") && btn5.getText().equals("X") && btn6.getText().equals("X")){
            xWin(btn4, btn5, btn6);
        }
        if(btn7.getText().equals("X") && btn8.getText().equals("X") && btn9.getText().equals("X")){
            xWin(btn7, btn8, btn9);
        }
        if(btn1.getText().equals("X") && btn4.getText().equals("X") && btn7.getText().equals("X")){
            xWin(btn1, btn4, btn7);
        }
        if(btn2.getText().equals("X") && btn5.getText().equals("X") && btn8.getText().equals("X")){
            xWin(btn2, btn5, btn8);
        }
        if(btn3.getText().equals("X") && btn6.getText().equals("X") && btn9.getText().equals("X")){
            xWin(btn3, btn6, btn9);
        }
        if(btn1.getText().equals("X") && btn5.getText().equals("X") && btn9.getText().equals("X")){
            xWin(btn1, btn5, btn9);
        }
        if(btn3.getText().equals("X") && btn5.getText().equals("X") && btn7.getText().equals("X")){
            xWin(btn3, btn5, btn7);
        }

        if(btn1.getText().equals("O") && btn2.getText().equals("O") && btn3.getText().equals("O")){
            oWin(btn1, btn2, btn3);
        }
        if(btn4.getText().equals("O") && btn5.getText().equals("O") && btn6.getText().equals("O")){
            oWin(btn4, btn5, btn6);
        }
        if(btn7.getText().equals("O") && btn8.getText().equals("O") && btn9.getText().equals("O")){
            oWin(btn7, btn8, btn9);
        }
        if(btn1.getText().equals("O") && btn4.getText().equals("O") && btn7.getText().equals("O")){
            oWin(btn1, btn4, btn7);
        }
        if(btn2.getText().equals("O") && btn5.getText().equals("O") && btn8.getText().equals("O")){
            oWin(btn2, btn5, btn8);
        }
        if(btn3.getText().equals("O") && btn6.getText().equals("O") && btn9.getText().equals("O")){
            oWin(btn3, btn6, btn9);
        }
        if(btn1.getText().equals("O") && btn5.getText().equals("O") && btn9.getText().equals("O")){
            oWin(btn1, btn5, btn9);
        }
        if(btn3.getText().equals("O") && btn5.getText().equals("O") && btn7.getText().equals("O")){
            oWin(btn3, btn5, btn7);
        }

        if (!btn1.getText().equals("") && !btn2.getText().equals("") && !btn3.getText().equals("") &&
            !btn4.getText().equals("") && !btn5.getText().equals("") && !btn6.getText().equals("") &&
            !btn7.getText().equals("") && !btn8.getText().equals("") && !btn9.getText().equals("")) {
            btn1.setBackgroundColor(Color.parseColor("#808080"));
            btn2.setBackgroundColor(Color.parseColor("#808080"));
            btn3.setBackgroundColor(Color.parseColor("#808080"));
            btn4.setBackgroundColor(Color.parseColor("#808080"));
            btn5.setBackgroundColor(Color.parseColor("#808080"));
            btn6.setBackgroundColor(Color.parseColor("#808080"));
            btn7.setBackgroundColor(Color.parseColor("#808080"));
            btn8.setBackgroundColor(Color.parseColor("#808080"));
            btn9.setBackgroundColor(Color.parseColor("#808080"));
            update_panel.setTextColor(Color.parseColor("#23CF23"));
            update_panel.setText("DRAW");

            CardView CV = findViewById(R.id.msg_container);
            LinearLayout LL = findViewById(R.id.btn_container);

            CV.setVisibility(View.VISIBLE);
            LL.setVisibility(View.VISIBLE);
        }
    }
    public void xWin(Button btna, Button btnb, Button btnc){
        btna.setBackgroundColor(Color.parseColor("#808080"));
        btnb.setBackgroundColor(Color.parseColor("#808080"));
        btnc.setBackgroundColor(Color.parseColor("#808080"));

        Button btn1 =  findViewById(R.id.btn1);
        Button btn2 =  findViewById(R.id.btn2);
        Button btn3 =  findViewById(R.id.btn3);
        Button btn4 =  findViewById(R.id.btn4);
        Button btn5 =  findViewById(R.id.btn5);
        Button btn6 =  findViewById(R.id.btn6);
        Button btn7 =  findViewById(R.id.btn7);
        Button btn8 =  findViewById(R.id.btn8);
        Button btn9 =  findViewById(R.id.btn9);

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

        update_panel.setTextColor(Color.parseColor("#FFFF4444"));
        update_panel.setText("Player X wins");

        CardView CV = findViewById(R.id.msg_container);
        LinearLayout LL = findViewById(R.id.btn_container);

        CV.setVisibility(View.VISIBLE);
        LL.setVisibility(View.VISIBLE);
    }
    public void oWin(Button btna, Button btnb, Button btnc){
        btna.setBackgroundColor(Color.parseColor("#808080"));
        btnb.setBackgroundColor(Color.parseColor("#808080"));
        btnc.setBackgroundColor(Color.parseColor("#808080"));

        Button btn1 =  findViewById(R.id.btn1);
        Button btn2 =  findViewById(R.id.btn2);
        Button btn3 =  findViewById(R.id.btn3);
        Button btn4 =  findViewById(R.id.btn4);
        Button btn5 =  findViewById(R.id.btn5);
        Button btn6 =  findViewById(R.id.btn6);
        Button btn7 =  findViewById(R.id.btn7);
        Button btn8 =  findViewById(R.id.btn8);
        Button btn9 =  findViewById(R.id.btn9);

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

        update_panel.setTextColor(Color.parseColor("#23CF23"));
        update_panel.setText("Player O wins");

        CardView CV = findViewById(R.id.msg_container);
        LinearLayout LL = findViewById(R.id.btn_container);

        CV.setVisibility(View.VISIBLE);
        LL.setVisibility(View.VISIBLE);
    }

    public void restartGame(){
        Intent intent = new Intent(this, Board.class);
        finish();
        startActivity(intent);
    }

    public void backToSecond(){
        Intent intent = new Intent(this, SecondActivity.class);
        finish();
        startActivity(intent);
    }
}
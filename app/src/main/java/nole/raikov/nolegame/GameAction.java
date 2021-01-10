package nole.raikov.nolegame;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameAction extends AppCompatActivity implements View.OnClickListener{


    Timer mTimer = new Timer();
    OccTimerTask mMyTimerTask = new OccTimerTask();
    ImageView[] array = new ImageView[4];
    Random random = new Random();
    int pos;
    int count = 0;
    int level = 1;
    int delay = 1000;
    int period = 1000;
    MediaPlayer slapSound;
    TextView scoreText;
    TextView levelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_action);
        slapSound = MediaPlayer.create(this, R.raw.slap);


        ImageView hole0 = (ImageView) findViewById(R.id.hole0);
        ImageView hole1 = (ImageView) findViewById(R.id.hole1);
        ImageView hole2 = (ImageView) findViewById(R.id.hole2);
        ImageView hole3 = (ImageView) findViewById(R.id.hole3);

        scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setText(ImArray.scores[0]);
        levelText = (TextView) findViewById(R.id.levelText);
        levelText.setText(ImArray.levels[0]);

        array[0] = hole0;
        array[1] = hole1;
        array[2] = hole2;
        array[3] = hole3;

        array[0].setImageResource(ImArray.holeImages[0]);
        array[1].setImageResource(ImArray.holeImages[1]);
        array[2].setImageResource(ImArray.holeImages[2]);
        array[3].setImageResource(ImArray.holeImages[3]);

        hole0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hole1.setEnabled(false);
                hole2.setEnabled(false);
                hole3.setEnabled(false);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(count == 5 && level == 5){
                        createInterAlertDialog(getResources().getString(ImArray.messages[level-1]));
                        mTimer.cancel();
                    }

                    if(count == 5){
                        createInterAlertDialog(getResources().getString(ImArray.messages[level-1]));
                        mTimer.cancel();
                    }
                    else if (pos == 0 && count < 5) {
                        mTimer.cancel();
                        playSound(slapSound);
                        count++;
                        scoreText.setText(ImArray.scores[count]);
                        pos = random.nextInt(ImArray.noleImages.length);
                        for (int i = 0; i < ImArray.noleImages.length; i++) {
                            array[i].setImageResource(ImArray.holeImages[i]);
                        }
                        mTimer = new Timer();
                        mMyTimerTask = new OccTimerTask();
                        mTimer.schedule(mMyTimerTask, 100, period);
                    }
                    else{

                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    hole1.setEnabled(true);
                    hole2.setEnabled(true);
                    hole3.setEnabled(true);
                }
                return true;
            }
        });

        hole1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hole0.setEnabled(false);
                hole2.setEnabled(false);
                hole3.setEnabled(false);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(count == 5){

                        createInterAlertDialog(getResources().getString(ImArray.messages[level-1]));
                        mTimer.cancel();
                    }
                    else if (pos == 1 && count < 5) {
                        mTimer.cancel();
                        playSound(slapSound);
                        count++;
                        scoreText.setText(ImArray.scores[count]);
                        pos = random.nextInt(ImArray.noleImages.length);
                        for (int i = 0; i < ImArray.noleImages.length; i++) {
                            array[i].setImageResource(ImArray.holeImages[i]);
                        }
                        mTimer = new Timer();
                        mMyTimerTask = new OccTimerTask();
                        mTimer.schedule(mMyTimerTask, 100, period);
                    }
                    else {}
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    hole0.setEnabled(true);
                    hole2.setEnabled(true);
                    hole3.setEnabled(true);
                }
                return true;
            }
        });

        hole2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hole1.setEnabled(false);
                hole0.setEnabled(false);
                hole3.setEnabled(false);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(count == 5){

                        createInterAlertDialog(getResources().getString(ImArray.messages[level-1]));
                        mTimer.cancel();
                    }
                    else if (pos == 2 && count < 5) {
                        mTimer.cancel();
                        playSound(slapSound);
                        count++;
                        scoreText.setText(ImArray.scores[count]);
                        pos = random.nextInt(ImArray.noleImages.length);
                        for (int i = 0; i < ImArray.noleImages.length; i++) {
                            array[i].setImageResource(ImArray.holeImages[i]);
                        }
                        mTimer = new Timer();
                        mMyTimerTask = new OccTimerTask();
                        mTimer.schedule(mMyTimerTask, 100, period);
                    }
                    else{}
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    hole1.setEnabled(true);
                    hole0.setEnabled(true);
                    hole3.setEnabled(true);
                }
                return true;
            }
        });

        hole3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hole1.setEnabled(false);
                hole2.setEnabled(false);
                hole0.setEnabled(false);

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(count == 5){

                        createInterAlertDialog(getResources().getString(ImArray.messages[level-1]));
                        mTimer.cancel();

                    }
                    else if (pos == 3 && count < 5) {
                        mTimer.cancel();
                        playSound(slapSound);
                        count++;
                        scoreText.setText(ImArray.scores[count]);
                        pos = random.nextInt(ImArray.noleImages.length);
                        for (int i = 0; i < ImArray.noleImages.length; i++) {
                            array[i].setImageResource(ImArray.holeImages[i]);
                        }
                        mTimer = new Timer();
                        mMyTimerTask = new OccTimerTask();
                        mTimer.schedule(mMyTimerTask, 100, period);
                    }
                    else{}
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    hole1.setEnabled(true);
                    hole2.setEnabled(true);
                    hole0.setEnabled(true);
                }
                return true;
            }
        });


        pos = random.nextInt(ImArray.noleImages.length);
        array[pos].setImageResource(ImArray.noleImages[pos]);
        mTimer.schedule(mMyTimerTask, delay, period);

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameAction.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception exception) {

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {

    }

    class OccTimerTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    array[pos].setImageResource(ImArray.holeImages[pos]);
                    Random random = new Random();
                    int old = pos;

                    pos = random.nextInt(ImArray.noleImages.length);
                    if (old == pos) {
                        pos = random.nextInt(ImArray.noleImages.length);
                    } else {
                        array[pos].setImageResource(ImArray.noleImages[pos]);
                    }

                }
            });
        }


    }

    void playSound(MediaPlayer sound) {

        sound.start();
    }

    private void createInterAlertDialog( String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(content);

        builder.setNegativeButton(R.string.finish,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                });
        builder.setPositiveButton(R.string.cont,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {


                        if(level == 1){
                            dialog.dismiss();
                            period = 800;
                            delay = 500;
                            level++;
                            count = 0;

                            levelText = (TextView) findViewById(R.id.levelText);
                            levelText.setText(ImArray.levels[level-1]);

                            scoreText.setText(ImArray.scores[count]);
                            pos = random.nextInt(ImArray.noleImages.length);
                            for (int i = 0; i < ImArray.noleImages.length; i++) {
                                array[i].setImageResource(ImArray.holeImages[i]);
                            }
                            mTimer = new Timer();
                            mMyTimerTask = new OccTimerTask();
                            mTimer.schedule(mMyTimerTask, delay, period);
                            return;

                        } else if (level == 2){
                            dialog.dismiss();
                            period = 600;
                            delay = 300;
                            level++;
                            count = 0;

                            levelText = (TextView) findViewById(R.id.levelText);
                            levelText.setText(ImArray.levels[level-1]);

                            scoreText.setText(ImArray.scores[count]);
                            pos = random.nextInt(ImArray.noleImages.length);
                            for (int i = 0; i < ImArray.noleImages.length; i++) {
                                array[i].setImageResource(ImArray.holeImages[i]);
                            }
                            mTimer = new Timer();
                            mMyTimerTask = new OccTimerTask();
                            mTimer.schedule(mMyTimerTask, delay, period);
                            return;

                        } else if (level == 3){
                            dialog.dismiss();
                            period = 500;
                            delay = 150;
                            level++;
                            count = 0;

                            levelText = (TextView) findViewById(R.id.levelText);
                            levelText.setText(ImArray.levels[level-1]);

                            scoreText.setText(ImArray.scores[count]);
                            pos = random.nextInt(ImArray.noleImages.length);
                            for (int i = 0; i < ImArray.noleImages.length; i++) {
                                array[i].setImageResource(ImArray.holeImages[i]);
                            }
                            mTimer = new Timer();
                            mMyTimerTask = new OccTimerTask();
                            mTimer.schedule(mMyTimerTask, delay, period);
                            return;

                        } else if (level == 4){
                            dialog.dismiss();
                            period = 400;
                            delay = 100;
                            count = 0;
                            level++;
                            levelText = (TextView) findViewById(R.id.levelText);
                            levelText.setText(ImArray.levels[level-1]);
                            level = 5;
                            scoreText.setText(ImArray.scores[count]);
                            pos = random.nextInt(ImArray.noleImages.length);
                            for (int i = 0; i < ImArray.noleImages.length; i++) {
                                array[i].setImageResource(ImArray.holeImages[i]);
                            }
                            mTimer = new Timer();
                            mMyTimerTask = new OccTimerTask();
                            mTimer.schedule(mMyTimerTask, delay, period);
                            return;
                        }
                        dialog.dismiss();
                        period = 1000;
                        delay = 1000;
                        level = 1;
                        count = 0;

                        levelText = (TextView) findViewById(R.id.levelText);
                        levelText.setText(ImArray.levels[0]);

                        scoreText.setText(ImArray.scores[count]);
                        pos = random.nextInt(ImArray.noleImages.length);
                        for (int i = 0; i < ImArray.noleImages.length; i++) {
                            array[i].setImageResource(ImArray.holeImages[i]);
                        }
                        mTimer = new Timer();
                        mMyTimerTask = new OccTimerTask();
                        mTimer.schedule(mMyTimerTask, delay, period);

                    }
                });
        builder.show();
    }


}
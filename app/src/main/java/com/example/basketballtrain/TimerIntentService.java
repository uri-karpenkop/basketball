package com.example.basketballtrain;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class TimerIntentService extends IntentService {


    public TimerIntentService() {
        super("TimerIntentService");
        Log.d("timer", "constructor Timer service called");

    }


    @Override

    protected void onHandleIntent(Intent intent) {
        Log.d("timer", "onHandleIntent Timer called");
        int counter = intent.getExtras().getInt("counter");
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Messenger messenger = (Messenger) bundle.get("messenger");
            while (counter > 0) {
                try {
                    counter--;
                    Message msg = Message.obtain();
                    bundle.putInt("timer", counter);
                    msg.setData(bundle); //put the data here
                    messenger.send(msg);
                    Thread.sleep(1000);
                    Log.d("timer", "counter=" + counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (RemoteException e) {
                    Log.i("error", "error");
                }
            }
        }
    }

    @Override

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destory service", Toast.LENGTH_LONG).show();
    }

}


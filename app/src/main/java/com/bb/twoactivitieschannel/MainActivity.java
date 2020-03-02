package com.bb.twoactivitieschannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_MAIN = "com.bb.twoactivitieschannel.MESSAGE_MAIN";
    private EditText messageToSend;
    private ImageView userIcon;
    public String conversation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageToSend = findViewById(R.id.message_edit_main);
        Intent intent = getIntent();
        String messages = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE_SECOND);
        TextView textView = findViewById(R.id.message_display_main);
        textView.setText(messages);
        conversation = messages;
        userIcon = findViewById(R.id.first_user_icon);
        String url = "https://www.flaticon.com/premium-icon/icons/svg/1207/1207995.svg";
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(this).load(url).apply(options).into(userIcon);
    }

    public void sendMessageToSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = messageToSend.getText().toString();
        conversation = conversation + message + "\n";
        intent.putExtra(EXTRA_MESSAGE_MAIN, conversation);
        startActivity(intent);
    }

}

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


public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_SECOND = "com.bb.twoactivitieschannel.MESSAGE_SECOND";
    private EditText messageToSend;
    private ImageView secondUserIcon;
    public String conversation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        messageToSend = findViewById(R.id.message_edit_second);
        Intent intent = getIntent();
        String messages = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_MAIN);
        TextView textView = findViewById(R.id.message_display_second);
        messages = messages.replace("null", "");
        textView.setText(messages);
        conversation = messages;
        secondUserIcon = findViewById(R.id.second_user_icon);
        String url = "https://www.flaticon.com/premium-icon/icons/svg/2588/2588812.svg";
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(this).load(url).apply(options).into(secondUserIcon);
    }

    public void sendMessageToFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = messageToSend.getText().toString();
        conversation = conversation + message + "\n";
        intent.putExtra(EXTRA_MESSAGE_SECOND, conversation);
        startActivity(intent);
    }
}

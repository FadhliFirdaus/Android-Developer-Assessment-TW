package com.example.interviewtesttrinitywizards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondScreenActivity extends AppCompatActivity {
    EditText firstName, lastName, email, phone;
    TextView cancel, save;
    Context mainActivityContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().hide();
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        email = findViewById(R.id.emailEditText);
        phone = findViewById(R.id.phoneNumberEditText);
        firstName.setText(extras.getString("firstName"));
        lastName.setText(extras.getString("lastName"));
        email.setText(extras.getString("email"));
        phone.setText(extras.getString("phone"));
        cancel = findViewById(R.id.cancelButton);
        save = findViewById(R.id.saveButton);
        cancel.setOnClickListener(view -> finish());
        save.setOnClickListener(view -> {
            MainActivity.getInstance().changeContactsData(extras.getInt("position"), firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), phone.getText().toString());
            finish();
        });
    }

    public Context getMainActivityContext() {
        return mainActivityContext;
    }

    public void setMainActivityContext(Context mainActivityContext) {
        this.mainActivityContext = mainActivityContext;
    }


}

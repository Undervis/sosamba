package com.example.sosamba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity {

    int token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        EditText edEmail = findViewById(R.id.edEmail);
        EditText edPassword = findViewById(R.id.edPassword);

        TextView tvSignUp = findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

        TextView tvSignIn = findViewById(R.id.tvSignIn);
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((edEmail.getText().toString().isEmpty()) || (edPassword.getText().toString().isEmpty())){
                    Toast.makeText(SignInActivity.this, "Поля пустые", Toast.LENGTH_LONG).show();
                }
                else if(!edEmail.getText().toString().contains("@")){
                    Toast.makeText(SignInActivity.this, "Неверный Email", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    intent.putExtra("token", token);
                    startActivity(intent);
                }
            }
        });

        getWindow().setStatusBarColor(getResources().getColor(R.color.bg_color));
    }

    private void auth(String email, String password){
        Uri url = Uri.parse("http://cinema.areas.su/auth/login").buildUpon()
                .appendQueryParameter("email", email)
                .appendQueryParameter("password", password).build();
        RequestQueue queue = Volley.newRequestQueue(SignInActivity.this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url.toString(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
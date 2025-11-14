package com.example.quizsierra1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextText, editTextTextPassword;
    ListaUsuarios lista1 = new ListaUsuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextText.getText().toString();
                String pass = editTextTextPassword.getText().toString();
                if (lista1.equalUser(user, pass)) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.putExtra("Username", user);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Usuario invalido!...", Toast.LENGTH_SHORT).show();
                }
                hideKeyboard();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextText.getText().toString();
                String pass = editTextTextPassword.getText().toString();
                if (lista1.equalUser(user, pass)){
                    Toast.makeText(MainActivity.this, "El usuario ya esta registrado!...", Toast.LENGTH_LONG).show();
                } else {
                    lista1.agregarAlFinal(user, pass);
                    Toast.makeText(MainActivity.this, "Usuario Agregado!", Toast.LENGTH_LONG).show();
                }
                hideKeyboard();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnLimpiar;
    TextView textRespuesta;
    EditText inputNumero1;
    EditText inputNumero2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar los elementos de la vista
        btnSumar = findViewById(R.id.sumar);
        btnRestar = findViewById(R.id.restar);
        btnMultiplicar = findViewById(R.id.multiplicar);
        btnDividir = findViewById(R.id.dividir);
        btnLimpiar = findViewById(R.id.limpiar);
        textRespuesta = findViewById(R.id.respuesta);
        inputNumero1 = findViewById(R.id.numero1);
        inputNumero2 = findViewById(R.id.numero2);

        //Configurar los metodos listener para los botones
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String input1 = inputNumero1.getText().toString();
        String input2 = inputNumero2.getText().toString();
        if (input1.equals("") || input2.equals("")){
            Toast.makeText(this, "Numeros vacios", Toast.LENGTH_LONG).show();
            return;
        }
        int numero1 = Integer.parseInt(input1);
        int numero2 = Integer.parseInt(input2);
        double resultado = 0;
        switch (view.getId()){
            case R.id.limpiar:
                limpiar();
                break;
            case R.id.sumar:
                resultado = sumar(numero1, numero2);
                break;
            case R.id.restar:
                resultado = restar(numero1, numero2);
                break;
            case R.id.multiplicar:
                resultado = multiplicar(numero1, numero2);
                break;
            case R.id.dividir:
                resultado = dividir(numero1, numero2);
                break;
            default:
                System.out.println("No existe");
        }
        textRespuesta.setText(String.valueOf(resultado));
    }

    private void limpiar() {
        inputNumero1.setText("");
        inputNumero2.setText("");
        textRespuesta.setText("0");
    }

    public int sumar(int numero1, int numero2){
        return numero1 + numero2;
    }

    public int restar(int numero1, int numero2){
        return numero1 - numero2;
    }

    public int multiplicar(int numero1, int numero2){
        return numero1 * numero2;
    }

    public Double dividir(int numero1, int numero2){
        if (numero2 == 0){
            Toast.makeText(this, "NO PUEDE DIVIDIR ENTRE 0", Toast.LENGTH_LONG).show();
            return null;
        }
        return (double) numero1 / numero2;
    }
}
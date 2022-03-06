package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        btnSumar.setOnClickListener(view -> sumar());
        btnRestar.setOnClickListener(view -> restar());
        btnMultiplicar.setOnClickListener(view -> multiplicar());
        btnDividir.setOnClickListener(view -> dividir());
        btnLimpiar.setOnClickListener(view -> limpiar());

    }

    private void limpiar() {
        inputNumero1.setText("");
        inputNumero2.setText("");
        textRespuesta.setText("0");
    }

    public void sumar(){
        int numero1 = Integer.parseInt(inputNumero1.getText().toString());
        int numero2 = Integer.parseInt(inputNumero2.getText().toString());
        int resultado = numero1 + numero2;
        textRespuesta.setText(String.valueOf(resultado));
    }

    public void restar(){
        int numero1 = Integer.parseInt(inputNumero1.getText().toString());
        int numero2 = Integer.parseInt(inputNumero2.getText().toString());
        int resultado = numero1 - numero2;
        textRespuesta.setText(String.valueOf(resultado));
    }

    public void multiplicar(){
        int numero1 = Integer.parseInt(inputNumero1.getText().toString());
        int numero2 = Integer.parseInt(inputNumero2.getText().toString());
        int resultado = numero1 * numero2;
        textRespuesta.setText(String.valueOf(resultado));
    }

    public void dividir(){
        double numero1 = Double.parseDouble(inputNumero1.getText().toString());
        double numero2 = Double.parseDouble(inputNumero2.getText().toString());
        if (numero2 == 0){
            textRespuesta.setText("NO PUEDE DIVIDIR ENTRE 0");
            return;
        }
        double resultado = numero1 / numero2;
        textRespuesta.setText(String.valueOf(resultado));
    }
}
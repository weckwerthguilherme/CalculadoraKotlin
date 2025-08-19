package com.example.calculadora.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.R
import com.example.calculadora.model.Operacao
import com.example.calculadora.service.Calculadora

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNum1 = findViewById<EditText>(R.id.edt_text_num1)
        val edtNum2 = findViewById<EditText>(R.id.edt_text_num2)
        val btnSoma = findViewById<Button>(R.id.btn_soma)
        val btnSubtracao = findViewById<Button>(R.id.btn_subtracao)
        val btnMultiplicacao = findViewById<Button>(R.id.btn_multiplicacao)
        val btnDivisao = findViewById<Button>(R.id.btn_divisao)
        val txtResultado = findViewById<TextView>(R.id.txv_resultado)

        btnSoma.setOnClickListener{
            val valor1 = edtNum1.text.toString().toIntOrNull()?:0
            val valor2 = edtNum2.text.toString().toIntOrNull()?:0
            val operacao = Operacao(valor1, valor2)
            val resultado = Calculadora().somar(operacao)
            txtResultado.text = "A soma é: $resultado"

        }

        btnSubtracao.setOnClickListener{
            val valor1 = edtNum1.text.toString().toIntOrNull()?:0
            val valor2 = edtNum2.text.toString().toIntOrNull()?:0
            val operacao = Operacao(valor1, valor2)
            val resultado = Calculadora().subtrair(operacao)
            txtResultado.text = "A subtracao é: $resultado"
        }

        btnMultiplicacao.setOnClickListener{
            val valor1 = edtNum1.text.toString().toIntOrNull()?:0
            val valor2 = edtNum2.text.toString().toIntOrNull()?:0
            val operacao = Operacao(valor1, valor2)
            val resultado = Calculadora().multiplicar(operacao)
            txtResultado.text = "A multiplicacao é: $resultado"
        }

        btnDivisao.setOnClickListener{
            val valor1 = edtNum1.text.toString().toIntOrNull()?:0
            val valor2 = edtNum2.text.toString().toIntOrNull()?:0
            val operacao = Operacao(valor1, valor2)
            try {
                val resultado = Calculadora().dividir(operacao)
                txtResultado.text = "A divisao é: $resultado"
            } catch (e: IllegalArgumentException){
                txtResultado.text = e.message  // mostra "Não é possível dividir por zero!"
            }


        }
    }
}
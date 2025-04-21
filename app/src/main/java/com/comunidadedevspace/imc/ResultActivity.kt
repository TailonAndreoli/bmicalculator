package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
           val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
           insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()
        val classificacao: String
        val corClassificacao: Int

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            corClassificacao = getColor(R.color.cor_magreza)
        } else if (result > 18.5f && result <= 25f) {
            classificacao = "NORMAL"
            corClassificacao = getColor(R.color.cor_normal)
        } else if (result > 25f && result <= 30f) {
            classificacao = "SOBREPESO"
            corClassificacao = getColor(R.color.cor_sobrepeso)
        } else if (result > 30f && result <= 40f) {
            classificacao = "OBESIDADE"
            corClassificacao = getColor(R.color.cor_obesidade)
        } else {
            classificacao = "OBESIDADE GRAVE"
            corClassificacao = getColor(R.color.cor_obesidade_grave)
        }


        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(corClassificacao)
    }
}
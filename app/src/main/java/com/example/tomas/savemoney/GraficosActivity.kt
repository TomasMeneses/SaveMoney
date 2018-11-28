package com.example.tomas.savemoney

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo

class GraficosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graficos)
        desenharGrafico()
    }
    fun desenharGrafico(){
        var graficoPizza: AnimatedPieView = findViewById(R.id.graficoPizza)
        var configuracao: AnimatedPieViewConfig
        configuracao = AnimatedPieViewConfig()
        configuracao.startAngle((-90.0).toFloat())

        configuracao.addData(SimplePieInfo(30.0, Color.parseColor("#ff0000"), "teste 1"))
        configuracao.addData(SimplePieInfo(18.0, Color.parseColor("#00ff00"), "teste 2")).drawText(true)
        configuracao.duration(2000).textSize(40.toFloat())

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        graficoPizza.applyConfig(configuracao);
        graficoPizza.start();
    }
}

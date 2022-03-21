package edu.itsco.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var tv: TextView
    lateinit var tv2: TextView

    var simbol: String = ""
    var v1: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)
        tv2 = findViewById(R.id.tv2)

        val btn_all_clear: Button = findViewById(R.id.btn_all_clear)
        val btnigual: Button = findViewById(R.id.btn_igual)


        //limpia la pantalla
        btn_all_clear.setOnClickListener {
            v1 = 0.0
            simbol = ""
            tv.setText("")
            tv2.setText("")

        }

        //da el resultado
        btnigual.setOnClickListener {
            var v2: Double = tv2.text.toString().toDouble()
            var resul: Double = 0.0

            when(simbol){
                "a" -> resul = v1 / v2
                "b" -> resul = v1 * v2
                "c" -> resul = v1 - v2
                "d" -> resul = v1 + v2
            }
            tv2.setText(resul.toString())
            tv.setText("")
        }

    }

    //agrega simbolo
    fun Operacion_simbol(view: View)
    {
        v1 = tv2.text.toString().toDouble()
        var num2_text: String = tv2.text.toString()
        tv2.setText("")
        when (view.id)
        {
            R.id.btn_div ->
            {
                tv.setText(num2_text + "/")
                simbol = "a"
            }
            R.id.btn_multi ->
            {
                tv.setText(num2_text + "*")
                simbol = "b"
            }
            R.id.btn_resta ->
            {
                tv.setText(num2_text + "-")
                simbol = "c"
            }
            R.id.btn_suma ->
            {
                tv.setText(num2_text + "+")
                simbol = "d"
            }
        }
    }


    //agrega digito
    fun press_num(view: View)
    {
        var num2: String = tv2.text.toString()

        when (view.id)
        {
            R.id.btn_uno -> tv2.setText(num2 + "1")
            R.id.btn_dos -> tv2.setText(num2 + "2")
            R.id.btn_tres -> tv2.setText(num2 + "3")
            R.id.btn_cuatro -> tv2.setText(num2 + "4")
            R.id.btn_cinco -> tv2.setText(num2 + "5")
            R.id.btn_seis -> tv2.setText(num2 + "6")
            R.id.btn_siete -> tv2.setText(num2 + "7")
            R.id.btn_ocho -> tv2.setText(num2 + "8")
            R.id.btn_nueve -> tv2.setText(num2 + "9")
            R.id.btn_cero -> tv2.setText(num2 + "0")
            R.id.btn_punto -> tv2.setText(num2 + ".")
        }

    }
}
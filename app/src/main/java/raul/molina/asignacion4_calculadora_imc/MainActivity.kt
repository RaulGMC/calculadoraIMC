package raul.molina.asignacion4_calculadora_imc

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Variables
    var peso = 0.0
    var altura = 0.0
    var imc = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calIMC: Button = findViewById(R.id.btnCalcular) as Button
        val totalIMC: TextView = findViewById(R.id.tvIMC) as TextView
        val colorIMC: TextView = findViewById(R.id.tvColor) as TextView

        //evento button click
        calIMC.setOnClickListener() {

            totalIMC.setText(calcularIMC().toString())
            when (imc) {
                in 0.0..18.5 -> {
                    colorIMC.setText("Bajo peso")
                    colorIMC.setBackgroundResource(R.color.colorBrown)
                }
                in 18.6..24.9 -> {
                    colorIMC.setText("Normal")
                    colorIMC.setBackgroundResource(R.color.colorGreen)
                }
                in 25.0..29.9 -> {
                    colorIMC.setText("Sobrepeso")
                    colorIMC.setBackgroundResource(R.color.colorGreenish)
                }
                in 30.0..34.9 -> {
                    colorIMC.setText("Obesidad grado 1")
                    colorIMC.setBackgroundResource(R.color.colorYellow)
                }
                in 35.0..39.9 -> {
                    colorIMC.setText("Obesidad grado 2")
                    colorIMC.setBackgroundResource(R.color.colorOrange)
                }
                in 40.0..100.0 -> {
                    colorIMC.setText("Obesidad grado 3")
                    colorIMC.setBackgroundResource(R.color.colorRed)
                }
            }

        }

    }

    //funcion
    fun calcularIMC(): String {

        altura = (this.etEstatura.text.toString()).toDouble()
        peso = (this.etPeso.text.toString()).toDouble()
        imc = (peso / (altura * altura))
        val formato = "%.2f".format(imc)
        val xd = formato.format(imc)
        return xd

    }

}

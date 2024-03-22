package rodrigo.hurtado.triangulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

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
        val txtBase = findViewById<EditText>(R.id.txtBase)
        val txtAltura = findViewById<EditText>(R.id.txtAltura)
        val lbRes = findViewById<TextView>(R.id.lbRes)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val objFigura = Figura()
        btnCalc.setOnClickListener {
            val area = objFigura.calc_area(txtBase.text.toString().toDouble(),txtAltura.text.toString().toDouble())
            lbRes.text = "El área es de $area cm²"
        }


    }
}
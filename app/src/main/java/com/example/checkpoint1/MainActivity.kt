import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.checkpoint1.R

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var alturaEditText: EditText
    private lateinit var calcularButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        alturaEditText = findViewById(R.id.alturaEditText)
        calcularButton = findViewById(R.id.calcularButton)

        calcularButton.setOnClickListener {
            calcularPesoIdeal()
        }
    }

    private fun calcularPesoIdeal() {
        val altura = alturaEditText.text.toString().toDoubleOrNull()

        if (altura == null || altura <= 0) {
            Toast.makeText(this, "Altura inválida", Toast.LENGTH_SHORT).show()
            return
        }

        val pesoIdeal = when (radioGroup.checkedRadioButtonId) {
            R.id.masculinoRadioButton -> (72.7 * altura) - 58
            R.id.femininoRadioButton -> (62.1 * altura) - 44.7
            else -> {
                Toast.makeText(this, "Selecione o sexo", Toast.LENGTH_SHORT).show()
                return
            }
        }

        Toast.makeText(this, "Peso ideal: $pesoIdeal kg", Toast.LENGTH_SHORT).show()
    }
}
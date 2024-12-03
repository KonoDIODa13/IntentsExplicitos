package com.example.intentsexplicitos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intentsexplicitos.databinding.ActivityActividadABinding

class ActividadA : AppCompatActivity() {
    lateinit var mibinding: ActivityActividadABinding
    var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { objeto: ActivityResult ->
            if (objeto.resultCode == Activity.RESULT_OK) {
                //obtengo datos de ActividadB
                mibinding.tvTextoDevuelto.text = objeto.data!!.extras!!.getString("texto")
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_actividad_a)

        inicializarComponentes()
    }

    private fun inicializarComponentes() {
        //Instancio el objeto mibinding
        mibinding = ActivityActividadABinding.inflate(layoutInflater)
        //establecemos el layout a mi actividad
        setContentView(mibinding.root)
        //realizamos la intencion al clickar al boton
        mibinding.btnChange.setOnClickListener {
            var intent = Intent(this, ActividadB::class.java)
            var bundle = Bundle()
            bundle.putString("texto", mibinding.etTexto.text.toString())
            bundle.putInt("entero", 69)
            intent.putExtras(bundle)
            //startActivity(intent)// si no queremos que devuelva algo
            launcher.launch(intent)// si queremos que devuelva algo
        }

    }
}
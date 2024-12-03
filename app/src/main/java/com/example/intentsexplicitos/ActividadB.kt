package com.example.intentsexplicitos


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intentsexplicitos.databinding.ActivityActividadBBinding

class ActividadB : AppCompatActivity() {
    lateinit var mibinding: ActivityActividadBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarcomponentes()
    }

    private fun inicializarcomponentes() {
        mibinding = ActivityActividadBBinding.inflate(layoutInflater)
        setContentView(mibinding.root)
        var intentB = intent // consigo el intent que lo inizializo
        var bundleB = intentB.extras!! // se que algo tiene
        mibinding.tvTexto.text = buildString {
            append(bundleB.getString("texto"))
            append(" ")
            append(bundleB.getInt("entero").toString())
        }


        mibinding.btnDestroy.setOnClickListener {
            var intentacion = Intent()
            var bundle = Bundle()
            bundle.putString("texto", mibinding.tvTexto.text.toString())
            intentacion.putExtras(bundle)
            setResult(Activity.RESULT_OK, intentacion)
            finish()
        }
    }
}
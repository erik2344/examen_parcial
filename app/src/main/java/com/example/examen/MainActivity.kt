package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityMainBinding

data class Persona(val nombre: String, val apellidos: String)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Valores fijos para la comparación
    private val miUser = "erik"
    private val miContra = "L@t@p@d3r@"

    // Lista de personas
    private val lista = arrayListOf(
        Persona("Erik Manuel", "Blanco Campos"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            val user = binding.etLogin.text.toString()
            val pass = binding.etPassword.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else if (user == miUser && pass == miContra) {
                val intent = Intent(this, MainActivityBienvenida::class.java)
                intent.putExtra("nombre", lista[0].nombre)
                intent.putExtra("apellidos", lista[0].apellidos)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
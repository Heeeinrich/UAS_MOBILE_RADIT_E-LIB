package com.example.uasmobileradite_lib

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uasmobileradite_lib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmailLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            if (validateInput(email, password)) {
                performLogin(email, password)
            }
        }

        // Link ke Register
        binding.tvRegisterLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            binding.tilEmailLogin.error = "Email is required"
            return false
        } else {
            binding.tilEmailLogin.error = null
        }

        if (password.isEmpty()) {
            binding.tilPasswordLogin.error = "Password is required"
            return false
        } else {
            binding.tilPasswordLogin.error = null
        }

        return true
    }

    private fun performLogin(email: String, password: String) {
        // Simulasi login berhasil
        if (email == "admin@example.com" && password == "admin123") {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java) // Start MainActivity
            intent.putExtra("loadHomeFragment", true) // Pass flag to load HomeFragment
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}

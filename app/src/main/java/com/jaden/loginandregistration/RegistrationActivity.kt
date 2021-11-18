package com.jaden.loginandregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user: $username pwd $password", Toast.LENGTH_SHORT).show()
    }
}
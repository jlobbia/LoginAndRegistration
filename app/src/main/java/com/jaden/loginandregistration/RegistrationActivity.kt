package com.jaden.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jaden.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_registration)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user: $username pwd $password", Toast.LENGTH_SHORT).show()

        binding.registerButton.setOnClickListener {
            //TODO: verify that info they entered is valid
            var returnToLoginIntent = Intent().apply {
                putExtra(LoginActivity.EXTRA_USERNAME,
                    binding.registrationUsername.text.toString())
                putExtra(LoginActivity.EXTRA_PASSWORD,
                    binding.registrationPassword.text.toString())
            }
            setResult(Activity.RESULT_OK, returnToLoginIntent)
            finish()
        }
    }
}
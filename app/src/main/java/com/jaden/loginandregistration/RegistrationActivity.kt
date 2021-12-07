package com.jaden.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jaden.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistrationBinding
    val TAG = "RegistrationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user: $username pwd $password", Toast.LENGTH_SHORT).show()

        binding.registerButton.setOnClickListener {
            //TODO: verify that info they entered is valid
            Log.d(TAG, "onCreate: ${binding.registrationName.text.toString()} ${RegistrationUtil.validateName(binding.registrationName.text.toString())}")


            if(!RegistrationUtil.validateName(binding.registrationName.text.toString())){
                Toast.makeText(this, "Invalid name", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onCreate: invalid name")
            }

            if(!RegistrationUtil.validateUsername(binding.registrationUsername.text.toString())) {
                Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show()
            }

            if(!RegistrationUtil.validatePassword(binding.registrationPassword.text.toString(), binding.registrationConfirmpass.text.toString())){
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
            }

            if(!RegistrationUtil.validateEmail(binding.registrationEmail.text.toString())){
                Toast.makeText(this, "Invalid EMail", Toast.LENGTH_SHORT).show()
            }

            else {
                var returnToLoginIntent = Intent().apply {
                    putExtra(
                        LoginActivity.EXTRA_USERNAME,
                        binding.registrationUsername.text.toString()
                    )
                    putExtra(
                        LoginActivity.EXTRA_PASSWORD,
                        binding.registrationPassword.text.toString()
                    )
                }
                setResult(Activity.RESULT_OK, returnToLoginIntent)
                finish()
            }
        }
    }
}
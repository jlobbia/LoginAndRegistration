package com.jaden.loginandregistration

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBar
import com.jaden.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var NewUser : TextView

    private lateinit var binding: ActivityLoginBinding

    companion object {
        var EXTRA_USERNAME = "username"
        var EXTRA_PASSWORD = "password"
    }

    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result : ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            binding.username.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.password.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        NewUser = findViewById(R.id.createaccount)


        NewUser.setOnClickListener {
            setContentView(R.layout.activity_registration)
            val username = binding.createaccount.text.toString()
            val password = binding.createaccount.text.toString()
            var registrationIntent = Intent(this, RegistrationActivity::class.java).apply{
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }
           // startActivity(registrationIntent)
            //alternate: could launch the activity for a result instead
            startRegistrationForResult.launch(registrationIntent)

        }
    }

}
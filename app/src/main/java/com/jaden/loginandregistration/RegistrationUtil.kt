package com.jaden.loginandregistration

import androidx.core.text.trimmedLength

object RegistrationUtil {

    var existingUsers = listOf("Libeee_kris", "kris_lovesranch", "email", "kris.microsoftceo", "kris_libber.supercellservice.com", "kris_libber.klashroale")


    fun validateUsername(username: String) : Boolean {
        if(username.length < 8 || existingUsers.contains(username)) {
            return false
        }

        return true
    }

    fun validatePassword(password: String, confirmPassword : String) : Boolean {
        if(password != confirmPassword || password.length < 8 || password == "") {
            return false
        }

        var cap = false
        var digit = false

        for (c in password) {
            if(c.isDigit()) {
                digit = true
            }
            if(c.isUpperCase()){
                cap = true
            }
        }

        if(!cap || !digit) {
            return false
        }

        return true
    }



    fun validateName(name: String) : Boolean {
        return true
    }

    fun validateEmail(email : String) : Boolean {
        return true
    }
}
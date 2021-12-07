package com.jaden.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.checkerframework.checker.units.qual.m

import org.junit.Test

class RegistrationUtilTest {
//base pwd = 123abcdE
    @Test
    fun validatePassword_emptyPassword_returnsFalse() {
        var result = RegistrationUtil.validatePassword("", "")

        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnsFalse() {
        var result = RegistrationUtil.validatePassword("123yeet", "123abcDEE")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_lengthUnder8_returnsFalse() {
        val result = RegistrationUtil.validatePassword("123abcD", "123abcD")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_noCapital_returnsFalse() {
        val result = RegistrationUtil.validatePassword("nocapital", "nocapital")
        assertThat(result).isFalse()
    }

    @Test
    fun validateName_empty_returnsFalse() {
        val result = RegistrationUtil.validateName("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateName_over20_returnsFalse() {
        val result = RegistrationUtil.validateName("aaaaaaaaaaaaaAAAAAAAAAAAAAAAAA")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_over40_returnsFalse(){
        val result = RegistrationUtil.validateEmail("jkcbvfdguc9rcbpyy9csbvbo8dcsrefcobcbftt7ber7rgcy9vcgrefo7gend8fcgoidrfotofoygdsyjgrdxsrrdr")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_isEmpty_returnsFalse(){
        val result = RegistrationUtil.validateEmail("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUsername_under8_returnsFalse(){
        val result = RegistrationUtil.validateUsername("whut")
        assertThat(result).isFalse()
    }

    @Test
    fun valdiateUsername_existingUser_returnsFalse(){
        val result = RegistrationUtil.validateUsername("kris_lovesranch")
        assertThat(result).isFalse()
    }



}
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
    }



}
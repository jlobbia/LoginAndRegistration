package com.jaden.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.checkerframework.checker.units.qual.m

import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun validatePassword_emptyPassword_returnsFalse() {
        var result = RegistrationUtil.validatePassword("", "")

        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnsFalse() {
        var result = RegistrationUtil.validatePassword("", "")
        assertThat(result).isFalse()
    }
}
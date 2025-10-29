package com.example.hellojenkins

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun hello_returnExpectedText() {
        assertEquals("Hello, Christopher!", MainActivity.SayHelloUtil.sayHello("Christopher"))
    }
}

package com.example.hellojenkins

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = SayHelloUtil.sayHello("Jenkins")
        setContentView(textView)
    }

    object SayHelloUtil {
        fun sayHello(name: String): String {
            return "Hello, $name!"
        }
    }
}
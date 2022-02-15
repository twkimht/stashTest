package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }


    class Book(var name : String, var price:Int) {
        fun discount() {
            price -= 2000
        }
    }
    fun Music() {

    }

    val i : Any = 3
    val q = when(i) {
        is Int -> 3
        !is String -> 1
        else -> {
            "else"
        }
    }
    val a : String ="aaaa"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //apply
        val kotlinBook = Book("코틀린안드로이드프로그래밍",10000).apply {
            name = "[세일]$name"
            discount()
            this@MainActivity.Music() //이건 메인액티비티에 Music이란 함수가있을 Eo
        }
        kotlinBook.name // [세일]코틀린안드로이드프로그래밍
        kotlinBook.price // 8000

        //let
        var hello = "Hello"
        val helloWorld = hello.let { hello ->
            "$hello World"
        }
        helloWorld // Hello World

        //with
        val book = Book("kotlin",10000)
        with(book){
            name
            price
            discount()
        }

        //also
        val kotlin = Book("코틀린",10000).also { book ->
            book.name = "코책"
            book.price = 8000
        }
        kotlin.name // 코책
        kotlin.price // 8000

        //run
        val run = Book("KotlinBook",10000).run {
            name = "kotlin"
            price = 99999
            this
        }
        run.name // "kotlin"
        run.price // 99999
    }
}
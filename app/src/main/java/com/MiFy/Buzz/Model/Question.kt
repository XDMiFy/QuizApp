package com.MiFy.Buzz.Model

class Question (
    val text: String
        ){
    val answers: MutableList<Answer> = mutableListOf()
}
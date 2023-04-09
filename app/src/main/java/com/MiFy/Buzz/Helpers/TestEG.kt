package com.MiFy.Buzz.Helpers

import com.MiFy.Buzz.Model.Answer
import com.MiFy.Buzz.Model.Question
import com.MiFy.Buzz.Model.Quiz

val q1 = Question("в каком году Елена Глинская провела денежную реформу?").apply {
    val ans1 = Answer(
        "1533",
        false
    )
    val ans2 = Answer(
        "1535",
        true
    )
    val ans3 = Answer(
        "1537",
        false
    )

    this.answers.add(ans1)
    this.answers.add(ans2)
    this.answers.add(ans3)
}
val q2 = Question("Кто из этих людей не был импрератором Китая?").apply {
    val ans1 = Answer(
        "У И",
        false
    )
    val ans2 = Answer(
        "Цзи Шао Хао",
        false
    )
    val ans3 = Answer(
        "Се Лянь",
        true
    )

    this.answers.add(ans1)
    this.answers.add(ans2)
    this.answers.add(ans3)
}
val q3 = Question("Сколько было названо непривзойденных демонов в 'Благословении Небожителей'?").apply {
    val ans1 = Answer(
        "3",
        true
    )
    val ans2 = Answer(
        "2",
        false
    )
    val ans3 = Answer(
        "4",
        false
    )

    this.answers.add(ans1)
    this.answers.add(ans2)
    this.answers.add(ans3)
}
val testEG = Quiz().apply{
    this.Questions.add(q1)
    this.Questions.add(q2)
    this.Questions.add(q3)

}
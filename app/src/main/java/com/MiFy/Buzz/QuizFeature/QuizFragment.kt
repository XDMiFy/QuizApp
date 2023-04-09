package com.MiFy.Buzz.QuizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.MiFy.Buzz.Helpers.DataManager
import com.MiFy.Buzz.Model.Question
import com.MiFy.Buzz.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var datamanager: DataManager
    private var currentQ = 0;
    private var ButtonGroup: RadioGroup? = null
    private var Button1: RadioButton? = null
    private var Button2: RadioButton? = null
    private var Button3: RadioButton? = null
    private var ansButton: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Button1 = view.findViewById(R.id.Ans1)
        Button1?.setOnClickListener {
            ansButton?.isEnabled = true
        }
        Button2 = view.findViewById(R.id.Ans2)
        Button2?.setOnClickListener {
            ansButton?.isEnabled = true
        }
        Button3 = view.findViewById(R.id.Ans3)
        Button3?.setOnClickListener {
            ansButton?.isEnabled = true
        }
        ButtonGroup = view.findViewById(R.id.radioGroup)
        val welcomeLabel = view.findViewById<TextView>(R.id.WelcomeSign)
        welcomeLabel.text = getString(R.string.WelcomeSign, datamanager.UserName)

        displayQ(datamanager.test.Questions[currentQ])

        ansButton = view.findViewById<Button>(R.id.AnsButton)
        ansButton?.isEnabled = false
        ansButton?.setOnClickListener {
            val currentQuestion = datamanager.test.Questions[currentQ]
            val IndexOfCorrect = currentQuestion.answers.indexOfFirst { currentAnswer ->
                currentAnswer.isCorrect
            }
            if (IndexOfCorrect == 0) {
                if (Button1?.isChecked == true) {
                    datamanager.test.score += 1
                }
            } else if (IndexOfCorrect == 1) {
                if (Button2?.isChecked == true) {
                    datamanager.test.score += 1
                }
            } else if (IndexOfCorrect == 2) {
                if (Button3?.isChecked == true) {
                    datamanager.test.score += 1
                }
            }

            currentQ += 1
            if (currentQ < datamanager.test.Questions.size){
                displayQ(datamanager.test.Questions[currentQ])
            } else {
                findNavController().navigate(R.id.resultsFragment)
            }
        }
    }
    private fun displayQ( currentQ: Question){
        val questionLabel: TextView? = view?.findViewById<TextView>(R.id.QLabel)
        questionLabel?.text = currentQ.text

        ansButton?.isEnabled = false
        ButtonGroup?.clearCheck()

        Button1?.text = currentQ.answers[0].text
        Button2?.text = currentQ.answers[1].text
        Button3?.text = currentQ.answers[2].text
    }
}
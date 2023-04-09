package com.MiFy.Buzz.ResultFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.MiFy.Buzz.Helpers.DataManager
import com.MiFy.Buzz.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultsFragment:Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fintext = view.findViewById<TextView>(R.id.ScoreTXT)
        val restartButton = view.findViewById< Button>(R.id.RestartButton)

        dataManager.test.score
        fintext.text = "${dataManager.test.score}/3"

        restartButton.setOnClickListener {
            dataManager.test.score = 0
            findNavController().popBackStack(R.id.loginFragment, inclusive = false)
        }

    }
}
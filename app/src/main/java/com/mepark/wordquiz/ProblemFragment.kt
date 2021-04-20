package com.mepark.wordquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mepark.wordquiz.databinding.FragmentProblemBinding
import com.mepark.wordquiz.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_problem.*

/**
 * A simple [Fragment] subclass.
 */
class ProblemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentProblemBinding>(inflater,
            R.layout.fragment_problem,container,false)

        binding.problemTextView.text = getString(R.string.celebrity_meaning)
        binding.submitButton.setOnClickListener{ view : View ->

            if(binding.radioButton1.isChecked)
                view.findNavController().navigate(R.id.action_problemFragmentId_to_resultFragmentId)
            else if(binding.radioButton2.isChecked)
                view.findNavController().navigate(R.id.action_problemFragmentId_to_finishFragment)

        }
        return binding.root
    }

}

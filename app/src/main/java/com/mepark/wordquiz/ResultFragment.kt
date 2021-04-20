package com.mepark.wordquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mepark.wordquiz.databinding.FragmentProblemBinding
import com.mepark.wordquiz.databinding.FragmentResultBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentResultBinding>(inflater,
            R.layout.fragment_result, container, false)

        binding.tryAgainButton.setOnClickListener { view : View ->

            view.findNavController().navigate(R.id.action_resultFragmentId_to_problemFragmentId)
        }
        return binding.root
    }

}

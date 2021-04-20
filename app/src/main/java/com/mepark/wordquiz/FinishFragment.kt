package com.mepark.wordquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mepark.wordquiz.databinding.FragmentFinishBinding

/**
 * A simple [Fragment] subclass.
 */
class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val databinding = DataBindingUtil.inflate<FragmentFinishBinding>(inflater,
            R.layout.fragment_finish, container, false)

        databinding.finishButton.setOnClickListener { view : View ->

            view.findNavController().navigate(R.id.action_finishFragment_to_titleFragmentId)
        }
        return databinding.root;
    }

}

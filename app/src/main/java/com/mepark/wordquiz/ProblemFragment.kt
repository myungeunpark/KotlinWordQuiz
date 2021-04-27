package com.mepark.wordquiz

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mepark.wordquiz.databinding.FragmentProblemBinding
import kotlinx.android.synthetic.main.fragment_problem.*

class ProblemFragment : Fragment() {

    private val TAG : String = ProblemFragment::class.java.simpleName
    private lateinit  var  viewModel : ProblemViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(TAG, "####v onAttached() is called.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "####v onCreate() is called.")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "####v onDestroy() is called.")
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "####v onStart() is called.")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "####v onStop() is called.")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "####v onPause() is called.")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "####v onResume() is called.")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "####v onViewCreated() is called.")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d(TAG, "####v onDestroyView() is called.")
    }

    override fun onDetach() {
        super.onDetach()

        Log.d(TAG, "####v onDetached() is called.")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentProblemBinding>(inflater,
            R.layout.fragment_problem,container,false)

        viewModel = ViewModelProvider(this).get(ProblemViewModel::class.java)
        binding.problemViewModel = viewModel

        binding.lifecycleOwner = this

        //binding.problemTextView.text = getString(R.string.celebrity_meaning)
        binding.submitButton.setOnClickListener{ view : View ->

            var result  = when(binding.AnsRadioGroupId.checkedRadioButtonId){

                R.id.radioButton1 ->
                    viewModel.MoveNextProblem(binding.radioButton1.text.toString())
                R.id.radioButton2 ->
                    viewModel.MoveNextProblem(binding.radioButton2.text.toString())
                R.id.radioButton3 ->
                    viewModel.MoveNextProblem(binding.radioButton3.text.toString())
                R.id.radioButton4 ->
                    viewModel.MoveNextProblem(binding.radioButton4.text.toString())

                else -> false
            }


            binding.AnsRadioGroupId.clearCheck()
            binding.lifecycleOwner = this
            if(result)
                view.findNavController().navigate(R.id.action_problemFragmentId_to_finishFragment)
        }

        viewModel.currentTime.observe(viewLifecycleOwner, Observer { timer -> Long

            if(timer == 0L){
                findNavController().navigate(R.id.action_problemFragmentId_to_resultFragmentId)
            }
        })


        return binding.root
    }

}

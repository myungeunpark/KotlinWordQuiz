package com.mepark.wordquiz

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mepark.wordquiz.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private val TAG : String = TitleFragment::class.java.simpleName
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
        // Inflate the layout for this fragment

        Log.d(TAG, "####v onCreateView() is called.")
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener{ view : View ->

          view.findNavController().navigate(R.id.action_titleFragmentId_to_problemFragmentId)

        }

        setHasOptionsMenu(true)
        return binding.root


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
            onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}

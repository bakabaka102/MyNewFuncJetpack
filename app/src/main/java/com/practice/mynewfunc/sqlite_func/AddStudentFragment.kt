package com.practice.mynewfunc.sqlite_func

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.practice.mynewfunc.databinding.FragmentAddStudentBinding

class AddStudentFragment : Fragment() {

    private lateinit var viewModel: AddStudentViewModel
    private val mViewModel: AddStudentViewModel by viewModels()
    private var _binding: FragmentAddStudentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = AddStudentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        initActions()
        return _binding?.root
    }

    private fun initActions() {
    }


    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddStudentViewModel::class.java]
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


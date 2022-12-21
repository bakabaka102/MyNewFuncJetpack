package com.practice.mynewfunc.sqlite_func

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.mynewfunc.basecontent.BaseFragment
import com.practice.mynewfunc.databinding.FragmentAddStudentBinding
import com.practice.mynewfunc.sqlite_func.databases_sqlite.DatabaseHandler
import com.practice.mynewfunc.sqlite_func.model.Student

class AddStudentFragment : BaseFragment(), View.OnClickListener {

//    private lateinit var mViewModel: AddStudentViewModel
    private val mViewModel: AddStudentViewModel by viewModels()

    private var _binding: FragmentAddStudentBinding? = null
    private var studentAdapter = StudentAdapter()
//    private val mViewModel: AddStudentViewModel by lazy {
//        ViewModelProvider(this).get(AddStudentViewModel::class.java)
//    }

    var _listStudent : List<Student>? = null
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
//        mViewModel = ViewModelProvider(this)[AddStudentViewModel::class.java]
//        mViewModel.getListStudent()
        /*mViewModel.listStudent.observe(viewLifecycleOwner) {
            binding.rcvStudent.adapter = studentAdapter
            studentAdapter.addDataToRecyclerView(it)
            val layoutManager = GridLayoutManager(requireActivity(), 1)
            binding.rcvStudent.layoutManager = layoutManager
        }*/
        binding.rcvStudent.adapter = studentAdapter
        getListStudent()?.let { studentAdapter.addDataToRecyclerView(it) }
        val layoutManager = GridLayoutManager(requireActivity(), 1)
        binding.rcvStudent.layoutManager = layoutManager
        return binding.root
    }

    private fun initActions() {
        binding.btnAdd.setOnClickListener(this)
    }

    fun getListStudent(): List<Student>? {
       return DatabaseHandler(requireActivity()).getAllStudents()
    }

/*    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this)[AddStudentViewModel::class.java]
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnAdd -> {
                val name = binding.edtName.text.toString()
                val address = binding.edtAddress.text.toString()
                val phone = binding.edtPhone.text.toString()
                val student = Student(0, name, address, phone)
                DatabaseHandler(requireActivity()).addStudent(student)
            }
        }
    }

}


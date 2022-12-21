package com.practice.mynewfunc.sqlite_func

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.mynewfunc.basecontent.SingleLiveEvent
import com.practice.mynewfunc.sqlite_func.databases_sqlite.DatabaseHandler
import com.practice.mynewfunc.sqlite_func.model.Student

class AddStudentViewModel() : ViewModel() {

    // Create a LiveData with a String
//    val _listStudent: MutableLiveData<Student> by lazy {
//        MutableLiveData<Student>()
//    }
    private val _listStudent: SingleLiveEvent<List<Student>> = SingleLiveEvent()

    val listStudent: MutableLiveData<List<Student>> get() = _listStudent

  /*  fun getListStudent() {
        _listStudent.postValue(DatabaseHandler(app).getAllStudents())
    }*/


}
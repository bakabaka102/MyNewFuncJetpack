package com.practice.mynewfunc.sqlite_func

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.mynewfunc.basecontent.SingleLiveEvent
import com.practice.mynewfunc.sqlite_func.databases_sqlite.DatabaseHandler
import com.practice.mynewfunc.sqlite_func.model.Student

class AddStudentViewModel(private val app: Application) : AndroidViewModel(app) {

    // Create a LiveData with a String
//    val _listStudent: MutableLiveData<Student> by lazy {
//        MutableLiveData<Student>()
//    }
    var valueDemo = "123"
    private val _listStudent: SingleLiveEvent<List<Student>?> = SingleLiveEvent()

    val listStudent: SingleLiveEvent<List<Student>?> get() = _listStudent

    fun getListStudent() {
        val allStudents = DatabaseHandler(app.baseContext).getAllStudents()
        _listStudent.postValue(allStudents)
    }


}
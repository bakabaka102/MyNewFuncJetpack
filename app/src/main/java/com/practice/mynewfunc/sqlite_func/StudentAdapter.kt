package com.practice.mynewfunc.sqlite_func

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.mynewfunc.databinding.ItemStudentBinding
import com.practice.mynewfunc.sqlite_func.model.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var listData = listOf<Student>()

    //@SuppressLint("NotifyDataSetChanged")
    fun addDataToRecyclerView(list: List<Student>) {
        listData = list
        notifyDataSetChanged()
    }

    inner class StudentViewHolder(private val itemBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindDataToView(position: Int) {
            itemBinding.textName.text = listData[position].name
            itemBinding.textAddress.text = listData[position].address
            itemBinding.textPhone.text = listData[position].phoneNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindDataToView(position)
    }

    override fun getItemCount(): Int = listData.size
}
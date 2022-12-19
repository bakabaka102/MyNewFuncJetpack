package com.practice.mynewfunc.sqlite_func.databases_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.practice.mynewfunc.Constant
import com.practice.mynewfunc.sqlite_func.model.Student


class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION) {

    override fun onCreate(database: SQLiteDatabase?) {
        val studentTable = String.format(
            "CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)",
            Constant.TABLE_NAME,
            Constant.KEY_ID,
            Constant.KEY_NAME,
            Constant.KEY_ADDRESS,
            Constant.KEY_PHONE_NUMBER
        )
        database?.execSQL(studentTable)
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropStudentTable = String.format("DROP TABLE IF EXISTS %s", Constant.TABLE_NAME)
        database?.execSQL(dropStudentTable)
        onCreate(database)
    }

    fun addStudent(student: Student) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Constant.KEY_NAME, student.name)
        values.put(Constant.KEY_ADDRESS, student.address)
        values.put(Constant.KEY_PHONE_NUMBER, student.phoneNumber)
        db.insert(Constant.TABLE_NAME, null, values)
        db.close()
    }

    fun getStudent(studentId: Int): Student? {
        val db = this.readableDatabase
        val cursor = db.query(
            Constant.TABLE_NAME,
            null,
            Constant.KEY_ID + " = ?",
            arrayOf(studentId.toString()),
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        val student = Student(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3)
        )
        db.close()
        cursor.close()
        return student
    }

    fun getAllStudents(): List<Student>? {
        val studentList: MutableList<Student> = ArrayList()
        val query = "SELECT * FROM ${Constant.TABLE_NAME}"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val student = Student(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
            )
            studentList.add(student)
            cursor.moveToNext()
        }
        db.close()
        cursor.close()
        return studentList
    }

    fun updateStudent(student: Student) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Constant.KEY_NAME, student.name)
        values.put(Constant.KEY_ADDRESS, student.address)
        values.put(Constant.KEY_PHONE_NUMBER, student.phoneNumber)
        db.update(
            Constant.TABLE_NAME,
            values,
            Constant.KEY_ID + " = ?",
            arrayOf(student.id.toString())
        )
        db.close()
    }

    fun deleteStudent(studentId: Int) {
        val db = this.writableDatabase
        db.delete(Constant.TABLE_NAME, Constant.KEY_ID + " = ?", arrayOf(studentId.toString()))
        db.close()
    }
}
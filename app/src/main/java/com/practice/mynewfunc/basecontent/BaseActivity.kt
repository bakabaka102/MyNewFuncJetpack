package com.practice.mynewfunc.basecontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getNavController(): NavController?
}
package com.practice.mynewfunc.basecontent

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.practice.mynewfunc.ultis.Logger


open class BaseFragment : Fragment() {

    open fun setTitleActionBar() {
        (activity as AppCompatActivity).supportActionBar?.title = this::class.java.simpleName
    }

    fun getNavController(): NavController? {
        return (activity as? BaseActivity)?.getNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Logger.d("${this::class.java.simpleName} - onDetach is called...")
//        return inflater.inflate(R.layout.fragment_base, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.d("${this::class.java.simpleName} - onAttach is called...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("${this::class.java.simpleName} - onCreate is called...")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Logger.d("${this::class.java.simpleName} - onActivityCreated is called...")
    }

    override fun onStart() {
        super.onStart()
        Logger.d("${this::class.java.simpleName} - onStart is called...")
    }

    override fun onResume() {
        super.onResume()
        Logger.d("${this::class.java.simpleName} - onResume is called...")
        setTitleActionBar()
    }

    override fun onPause() {
        super.onPause()
        Logger.d("${this::class.java.simpleName} - onPause is called...")
    }

    override fun onStop() {
        super.onStop()
        Logger.d("${this::class.java.simpleName} - onDetach is called...")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.d("${this::class.java.simpleName} - onDestroyView is called...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("${this::class.java.simpleName} - onDestroy is called...")
    }

    override fun onDetach() {
        super.onDetach()
        Logger.d("${this::class.java.simpleName} - onDetach is called...")
    }

    /*
    onAttach()
    onCreate()
    onCreateView()
    onActivityCreated()
    onStart()
    onResume()
    onPause()
    onStop()
    onDestroyView()
    onDestroy()
    onDetach()
     */

    companion object {
        @JvmStatic
        fun newInstance() = BaseFragment()
    }
}
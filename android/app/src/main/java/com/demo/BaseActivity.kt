package com.demo

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.app.urbanterrain.util.AppUtil
import com.facebook.react.ReactActivity
import java.util.*

abstract class BaseActivity : ReactActivity() {

    private var progressDialog: ProgressDialog? = null

    lateinit var binding: ViewBinding

    abstract fun layoutRes(): ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = layoutRes()
        setContentView(binding.root)
    }

    open fun setStatusBarColor(color: Int) {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = color
    }


    open fun showProgressBar() {
        showProgressBar(true)
    }

    open fun showProgressBar(isCancel: Boolean) {
        hideProgressBar()
        if (!isFinishing) {
            progressDialog = ProgressDialog.show(this@BaseActivity, "", "", true)
            if (progressDialog != null) {
                progressDialog?.setCanceledOnTouchOutside(isCancel)
                progressDialog?.setContentView(R.layout.progress_layout)
                Objects.requireNonNull(progressDialog?.window)
                    ?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
    }

    /**
     * Hide progress bar
     */
    open fun hideProgressBar() {
        if (!this@BaseActivity.isFinishing) {
            if (progressDialog != null) {
                progressDialog?.dismiss()
                progressDialog = null
            }
        }
    }

    /**
     * Launch activity with clear stack using class concept
     *
     * @param classType launching class
     */
    open fun launchActivityWithClearStack(classType: Class<out BaseActivity>) {
        val intent = Intent(this, classType)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

    }


    /**
     * Launch activity using class concept
     *
     * @param classType launching class
     */
    open fun launchActivity(classType: Class<out BaseActivity>) {
        startActivity(Intent(this, classType))
    }


    open fun launchActivity(
        classType: Class<out BaseActivity>,
        view: View
    ) {
        AppUtil.preventTwoClick(view)
        startActivity(Intent(this, classType))
    }


    open fun launchActivityForResult(
        classType: Class<out BaseActivity>,
        bundle: Bundle,
        requestCode: Int
    ) {
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    open fun launchActivityForResult(
        classType: Class<out BaseActivity>,
        requestCode: Int,
        view: View?
    ) {
        AppUtil.preventTwoClick(view)
        val intent = Intent(this, classType)
        startActivityForResult(intent, requestCode)
    }

    open fun launchActivityForResult(
        classType: Class<out BaseActivity>,
        requestCode: Int,
        bundle: Bundle,
        view: View?
    ) {
        AppUtil.preventTwoClick(view)
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * Launch activity using class concept and pass data using bundle
     *
     * @param classType launching class
     */
    open fun launchActivity(
        classType: Class<out BaseActivity>,
        bundle: Bundle
    ) {
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    open fun launchActivityForResult(
        classType: Class<out BaseActivity>,
        requestCode: Int
    ) {
        val intent = Intent(this, classType)
        startActivityForResult(intent, requestCode)
    }

    /**
     * Launch activity using class concept and pass data using bundle
     *
     * @param classType launching class
     */
    open fun launchActivity(
        bundle: Bundle,
        classType: Class<out BaseActivity>
    ) {
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * Launch activity using class concept and pass data using bundle
     *
     * @param classType launching class
     */
    open fun launchActivity(
        classType: Class<out BaseActivity>,
        bundle: Bundle,
        view: View
    ) {
        AppUtil.preventTwoClick(view)
        val intent = Intent(this, classType)
        if (bundle != null) {
            intent.putExtras(bundle)
        }

        startActivity(intent)
    }


    open fun hideSoftKeyBoard() {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (currentFocus != null) {
            imm.hideSoftInputFromWindow(
                currentFocus?.windowToken,
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
        }
    }

    open fun showSoftKeyBoard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (view.requestFocus()) {
            imm.showSoftInput(
                view,
                InputMethodManager.SHOW_IMPLICIT
            )
        }
    }

}
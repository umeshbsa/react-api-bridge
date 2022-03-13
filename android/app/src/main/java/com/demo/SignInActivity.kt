package com.demo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import android.content.ContentValues.TAG
import android.util.Log
import com.app.urbanterrain.util.AppUtil
import com.demo.databinding.ActivitySigninBinding
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.*


class SignInActivity : BaseActivity() {

    private lateinit var ui: ActivitySigninBinding
    private val viewModel: AuthViewModel by viewModels()


    override fun layoutRes(): ViewBinding {
        return ActivitySigninBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = binding as ActivitySigninBinding
        setListener()
        setObservables()
    }

    private fun setListener() {

        ui.etPassword.setOnEditorActionListener { v: TextView?, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                emailLogin()
                return@setOnEditorActionListener true
            }
            false
        }

        ui.btnSignIn.setOnClickListener {
            emailLogin()
        }
    }

    private fun emailLogin() {
        if (AppUtil.isConnection()) {
            val emailPhone = ui.etEmailPhone.text.toString()
            val password = ui.etPassword.text.toString()

            if (loginEmailAPI(emailPhone, password)) {
                hideSoftKeyBoard()
                showProgressBar()
                viewModel.loginAPI(emailPhone, password)
            }
        } else {
            AppUtil.showToast(getString(R.string.msg_network_connection))
        }
    }

    private fun setObservables() {
        viewModel.loginSuccess.observe(this) {

        }

        viewModel.error.observe(this) {
            hideProgressBar()
        }
    }

    private fun loginEmailAPI(email: String, password: String): Boolean {
        return isEmailMobileNumber(email) && isPassword(password)
    }

    private fun isEmailMobileNumber(emailPhone: String): Boolean {
        if (TextUtils.isEmpty(emailPhone)) {
            ui.tvEmailPhoneReq.text = getString(R.string.txt_email_phone_req)
            return false
        } else {
            ui.tvEmailPhoneReq.text = ""
        }
        return true
    }

    private fun isPassword(password: String): Boolean {
        if (TextUtils.isEmpty(password)) {
            ui.tvPasswordReq.text = getString(R.string.err_password_blank)
            return false
        } else {
            ui.tvPasswordReq.text = ""
        }
        return true
    }
}
package com.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.api.APICallHandler
import com.demo.api.APICallManager
import com.demo.api.APIType
import com.demo.model.api.UserProfileResponse
import com.demo.model.base.Errors

class AuthViewModel : ViewModel(), APICallHandler<Any> {

    var loginSuccess = MutableLiveData<UserProfileResponse>()
    var error = MutableLiveData<Errors>()

    fun loginAPI(
        email: String?,
        password: String?
    ) {
        val apiCallManager = APICallManager(APIType.LOGIN, this)
        apiCallManager.loginAPI(email, password)
    }

    override fun onSuccess(apiType: APIType, response: Any?) {
        when (apiType) {

            APIType.LOGIN -> {
                val userProfileResponse = response as UserProfileResponse
                loginSuccess.setValue(userProfileResponse)
            }

            else -> {
            }
        }
    }

    override fun onFailure(apiType: APIType, errors: Errors) {
        this.error.value = errors
    }
}
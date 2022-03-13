package com.demo.api

import android.content.Intent
import com.demo.model.api.UserProfileResponse
import com.demo.model.base.BaseResponse
import com.demo.model.base.Errors
import com.demo.utils.AppConstant
import com.app.urbanterrain.util.AppUtil
import com.demo.App
import com.demo.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class APICallManager<T>(
    private val mCallType: APIType,
    private val mAPICallHandler: APICallHandler<T>
) : Callback<BaseResponse<T>> {


    override fun onResponse(call: Call<BaseResponse<T>>?, response: Response<BaseResponse<T>>) {
        if (response.code() == APIStatusCode.OK || response.code() == APIStatusCode.CREATED || response.code() == APIStatusCode.NO_CONTENT) {
            val body = response.body()
            if (body != null) {
                if (body.statusCode == 1) {
                    mAPICallHandler.onSuccess(mCallType, body.responseData)
                } else {
                    if (body.error != null) {

                        if (body.error?.errorCode == 17) {


                        } else {
                            mAPICallHandler.onFailure(mCallType, body.error!!)
                        }
                    } else {
                        val errors = Errors()
                        val errorMessage =
                            App.INSTANCE.resources.getString(R.string.error_something_wrong)
                        errors.errorMessage = errorMessage
                        mAPICallHandler.onFailure(mCallType, errors)
                    }
                }
            }
        } else {
            val errors = Errors()
            val errorMessage =
                App.INSTANCE.resources.getString(R.string.error_something_wrong)
            errors.errorMessage = errorMessage
            mAPICallHandler.onFailure(mCallType, errors)
        }
    }

    override fun onFailure(call: Call<BaseResponse<T>>?, throwable: Throwable) {
        val errorCode = 0
        val message: String? =
            if (throwable is UnknownHostException || throwable is SocketException || throwable is SocketTimeoutException) {
                App.INSTANCE.resources.getString(R.string.error_something_wrong)
            } else {
                throwable.message
            }
        val errors = Errors()
        errors.errorMessage = message
        mAPICallHandler.onFailure(mCallType, errors)
    }


    fun loginAPI(email: String?, password: String?) {

        val deviceId = AppUtil.getDeviceId1()
        val fcmToken = ""
        val appType = AppConstant.APP_TYPE

        APIHandler.getApiInterface()
            .login(email, password, deviceId, fcmToken, AppConstant.PLATFORM, appType)
            .enqueue(this@APICallManager as Callback<BaseResponse<UserProfileResponse?>>)
    }
}

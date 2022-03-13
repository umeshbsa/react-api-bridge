package com.demo.api

import android.text.TextUtils
import android.util.Base64
import android.util.Log
import com.demo.BuildConfig
import com.demo.utils.AppConstant
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*

class APIInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String = ""
        Log.i("ACCESS", "TOKEN $token")
        val originalRequest: Request = chain.request()
        if (TextUtils.isEmpty(token)) {
            val builder = originalRequest.newBuilder()
            val oldReq: Request = builder
                .addHeader("Content-Type:application", "x-www-form-urlencoded")
                //   .addHeader("Authorization", BuildConfig.BASE_AUTH)
                // .addHeader("timezone", GsonUtils.getJsonString(timeZoneProperties))
                .addHeader("appVersion", BuildConfig.VERSION_NAME)
                .addHeader("Connection", "close")
                .addHeader("platform", AppConstant.PLATFORM.toString())
                .build()
            return chain.proceed(oldReq)
        }
        val builder = originalRequest.newBuilder()
        val oldReq: Request = builder
            .addHeader("accessToken", token)
            // .addHeader("Authorization", BuildConfig.BASE_AUTH)
            // .addHeader("timezone", GsonUtils.getJsonString(timeZoneProperties))
            .addHeader("appVersion", BuildConfig.VERSION_NAME)
            .addHeader("Connection", "close")
            .addHeader("platform", AppConstant.PLATFORM.toString())
            .build()
        return chain.proceed(oldReq)
    }

    /**
     * Method to get timeZone name,offset,timezoneId
     */
    private val timeZoneProperties: HeaderTimeZone
        private get() {
            val calendar = Calendar.getInstance()
            val displayName = calendar.timeZone.displayName.trim { it <= ' ' }.toByteArray()
            val timeZoneName = Base64.encodeToString(displayName, Base64.NO_WRAP)
            val timeZoneId = calendar.timeZone.id
            val timeZoneOffset =
                (calendar.timeZone.getOffset(calendar.timeInMillis) / 1000).toString()
            val zone = HeaderTimeZone()
            zone.abbreviation = timeZoneName
            zone.offset = timeZoneOffset
            zone.identifier = timeZoneId
            return zone
        }

    companion object {
        private val TAG = APIInterceptor::class.java.simpleName
    }
}
// osVersion, appVersion, deviceToken, deviceType and timeZone
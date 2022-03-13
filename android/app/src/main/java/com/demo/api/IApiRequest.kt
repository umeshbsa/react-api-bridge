package com.demo.api

import com.demo.model.api.UserProfileResponse
import com.demo.model.base.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface IApiRequest {

    @FormUrlEncoded
    @POST("api/v1/user/password/login")
    fun login(
        @Field("userName") username: String?,
        @Field("password") password: String?,
        @Field("deviceId") deviceId: String?,
        @Field("deviceToken") deviceToken: String?,
        @Field("platform") platform: Int,
        @Field("appType") appType: Int
    ): Call<BaseResponse<UserProfileResponse?>>

}
package com.demo.model.api

import java.io.Serializable


class UserProfile : Serializable {
    var userType = 0
    var gender = 0
    var firstName: String? = null
    var lastName: String? = null
    var profilePic: String? = null
    var fullMobileNo: String? = null
    var platform = 0
    var status = 0
    var _id: String? = null
    var email: String? = null
    var password: String? = null
    var dob = 0f
    var countryCode: String? = null
    var mobileNo: String? = null
    var deviceToken: String? = null
    var deviceId: String? = null

    var googleId: String? = null
    var facebookId: String? = null
    var socialToken: String? = null
}
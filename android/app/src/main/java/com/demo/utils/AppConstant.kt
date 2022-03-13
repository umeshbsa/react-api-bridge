package com.demo.utils

/**
 * Class is used to contain application constant.
 */
object AppConstant {

    val ACTIVITY_TYPE_CYCLING = 2
    val ACTIVITY_TYPE_WALKING = 3
    val ACTIVITY_TYPE_RUNNING = 1
    val LAT: Double = 28.644800
    val LNG: Double = 77.216721
    var ZOOM = 11.0f
    const val RESENT_OTP_TIME = 120
    const val COUNTRY_CODE = "91"
    const val APP_TYPE = 1
    const val PLATFORM = 2
    const val USER_TYPE_EMAIL = 1
    const val USER_TYPE_FB = 2
    const val USER_TYPE_GOOGLE = 3
    const val SPLASH_DELAY: Long = 2000
    var DEVICE_TYPE: Int = 1
    var FROM_GOOGLE: String? = "fromGoogle"
    var FROM_FB: String? = "fromFb"
    var FROM_REGISTER: String? = "fromRegister"
    const val GALLERY_VIDEO_LIMIT = 3
    val IMAGE = 1
    val VIDEO = 2

    interface PKN {
        companion object {
            const val FCM_TOKEN = "ic_login"
            const val ACCESS_TOKEN = "access_token"
            const val USER_DATA = "user_data"
            const val USER_LOGGED_IN = "user_logged_in"
            const val NOTI = "noti"
            const val ZOOM = "zoom"
            const val POI = "poi"
            const val TUTORIAL_ONE = "tutorial_one"
            const val PRIMARY_LM = "userType"
            const val MAP_LAYER = "map_layer"
            const val MAP_LAYER_FIRE = "map_layer_fire"
            const val ALL_DOWNLOAD = "all_download"
            const val TRAIL = "trail"
        }
    }

    interface MEDIA_TYPE {
        companion object {
            const val VIDEO = "VIDEO"
            const val IMAGE = "IMAGE"
        }
    }

    interface BK {
        companion object {
            const val OUTDOOR_TRACK_ID = "OUTDOOR_TRACK_ID"
            const val OUTDOOR_AVG_SPEED = "OUTDOOR_AVG_SPEED"
            const val OUTDOOR_ACTIVITY_TYPE = "OUTDOOR_ACTIVITY_TYPE"
            const val EMAIL = "EMAIL"
            const val PHONE_NUMBER = "PHONE_NUMBER"
            const val PHONE_CODE = "PHONE_CODE"
            const val FIRST_NAME = "FIRST_NAME"
            const val LAST_NAME = "LAST_NAME"
            const val HEIGHTUNIT = "HEIGHTUNIT"
            const val WEIGHTUNIT = "WEIGHTUNIT"
            const val HEIGHTVALUE = "HEIGHTVALUE"
            const val WEIGHTVALUE = "WEIGHTVALUE"
            const val PASSWORD = "PASSWORD"
            const val MSG_ID = "MSG_ID"
            const val MAP_DATA = "MAP_DATA"
            const val SOCIAL_FBDATA = "SOCIAL_FBDATA"
            const val SOCIAL_GOOGLEDATA = "SOCIAL_GOOGLEDATA"
            const val SOCIAL_TOKEN = "SOCIAL_TOKEN"
            const val USER_LOCATION = "USER_LOCATION"
            const val DOB = "DOB"
            const val GENDER = "GENDER"
            const val TRIM_VIDEO_COUNTER = "TRIM_VIDEO_COUNTER"
            const val TRIM_VIDEO_TYPE = "TRIM_VIDEO_TYPE"
            const val MEDIA_SINGLE_DATA = "single_data"
            const val MEDIA_POS = "MEDIA_POS"
            const val MEDIA_DATA = "media_data"
            const val OUTDOOR_DURATION = "OUTDOOR_DURATION"
            const val OUTDOOR_CAL = "OUTDOOR_CAL"
            const val OUTDOOR_DIS = "OUTDOOR_DIS"
            const val OUTDOOR_PACE = "OUTDOOR_PACE"
            const val OUTDOOR_ELEVATION = "OUTDOOR_ELEVATION"
            const val OUTDOOR_TITLE = "OUTDOOR_TITLE"
            const val OUTDOOR_ADDRESS = "OUTDOOR_ADDRESS"
            const val OUTDOOR_COORDINATEFILE = "OUTDOOR_COORDINATEFILE"
            const val OUTDOOR_TRACK_DATA = "OUTDOOR_TRACK_DATA"

        }
    }

    interface REQUEST_CODE {
        companion object {
            const val LOCATION_PERMISSION_REQ = 1000
        }
    }

    interface FT {
        companion object {
            const val DATA_PICKER = "date picker"
        }
    }

    interface DATE_FORMAT {
        companion object {
            const val API_DATE_1 = "yyyy-MM-dd HH:mm:ss"
            const val API_DATE_2 = "yyyy-MM-dd' 'HH:mm:ss"
            const val API_DATE_3 = "yyyy-MM-dd"
            const val API_DATE_4 = "yyyy-MM"
            const val OUTPUT_FORMAT_DATE = "MMM dd, yyyy"
            const val FEED_DATE = "EEEE MMM, dd yyyy"
            const val FEED_DATE_1 = "MMM, dd yyyy"
            const val ADD_TRACK = "EEE, dd MMMM yyyy, HH:mma"
            const val START_DATE = "MMM yyyy"
            /*  const val SOURCE = "yyyy-MM-dd' 'HH:mm:ss"
              const val EVENT_MAP_FILTER = "yyyy-MM-dd"
              const val ADD_TRACK = "EEE, dd MMMM yyyy, HH:mma"
              const val MY_ORDER_D = "MMM dd, yyyy"
              const val SOS_TIME = "MMM dd, yyyy, HH:mm a"
              const val MY_ORDER_TRANSACTION = "dd MMMM"
              const val TRIP_DATE_S = "yyyy-MM-dd"
              const val TRIP_DATE_O = "MM/dd/yyyy"
              const val MMM_DD = "MMM-dd"
              const val VIRTUAL_EVENT_DATE = "yyyy-MM-dd HH:mm:ss"
              const val MY_VE_DATE = "dd MMM"*/
        }
    }

    interface MT {
        companion object {
            const val UPLOAD_JSON = "json"
            const val UPLOAD_MEDIA = "lists[]"
            const val TEXT_PLAIN = "text/plain"
        }
    }

    interface USER_TYPE {
        companion object {
            const val SUPER_ADMIN = "1"
            const val SHIPPING_REPRESENTATIVE = "2"
            const val SALE = "3"
            const val NORMAL_USER = "4"
            const val LAND_MANAGER = "5" // admin
            const val SUB_ADMIN = "6"
        }
    }

    interface TYPE {
        companion object {
            const val CLICK_ON_VIDEO = 10
            const val CLICK_ON_CAMERA = 11
        }
    }

    interface ACTION {
        companion object {
            const val SERVICE_DATA_SPEED = "com.app.urbanterrain.service_data_speed"
        }
    }

    interface GOOGLE {
        companion object {
            internal const val GOOGLE_BASE_URL = "https://maps.googleapis.com/maps/api/"

            internal const val AUTO_COMPLETE = "place/autocomplete/json?"
            internal const val PLACE_DETAIL = "place/details/json?"
            internal const val SCOPE =
                "oauth2:https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/userinfo.profile"
        }
    }

    interface REQUEST_CODES {
        companion object {
            const val APP_SETTING = 1109
            const val CROP_VIDEO = 2200
            const val CROP_IMAGE_REQ_CODE = 1545
            const val MULTIPLE_IMAGE_VIDEOS_GALLERY_REQUEST_CODE = 7503
            const val LOCATION_REQ_CODE = 7504
            const val REQ_COUNTRY_CODE = 7505
            const val REQ_STATE_CODE = 7506
            const val REQ_ISSUE_CODE = 7507
            const val ADD_CARD = 7508
            const val REQ_BUY_NOW_CODE = 8000
            const val REQ_ADD_CARD_CODE = 8001
            const val RATING = 122
            const val REQ_WRITE_REVIEWS = 1001
            const val LOCATION_SETTINGS_REQ = 9000
            const val LOCATION_PERMISSION_REQ = 9001
            const val MAP_SETTINGS = 9002
            const val MAP_DETAIL_ANNOUNCEMNT_EVENT = 9003
            const val TRAILHEAD = 9004
            const val TRAILS = 9005

            const val CAMERA_IMAGE = 9008
            const val GALLERY_IMAGE = 9010
            const val CAMERA_VIDEO = 9009
            const val GALLERY_VIDEO = 9011


            const val Add_WAY_POINT = 9012


            const val PICK_VIDEO_FROM_GALLERY = 1003
            const val TRIM_VIDEO_ACTIVITY = 1006
            const val PREVIEW_VIDEO = 1007
            const val REQUEST_CODE_BACKGROUND = 9013

            const val DOCS_CAPTURE = 9015
            const val COMMENT_SCREEN = 9016
            const val LOCATION_REQ_CODE_1 = 9017


        }
    }
}
package com.app.urbanterrain.util

import android.Manifest
import android.app.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.RingtoneManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.demo.App
import com.demo.R
import io.nlopez.smartlocation.SmartLocation
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*
import java.util.regex.Pattern

object AppUtil {

    fun isConnection(): Boolean {
        return isConnection(true)
    }

    fun isConnection(notShowMsg: Boolean): Boolean {
        val connectivityManager = App.INSTANCE
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo =
            Objects.requireNonNull(connectivityManager)
                .activeNetworkInfo
        val isNetwork =
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        if (!isNetwork && !notShowMsg) {
            showToast(
                App.INSTANCE.resources
                    .getString(R.string.msg_network_connection)
            )
        }
        return isNetwork
    }


    fun getMimeType(url: String?): String {
        val path = Uri.fromFile(File(url))
        val type_map = MimeTypeMap.getSingleton()
        var extension = MimeTypeMap.getFileExtensionFromUrl(path.toString())
        extension = extension.toLowerCase(Locale.ROOT)
        if (extension.contains(".")) {
            extension = extension.substring(extension.lastIndexOf("."))
        }
        return type_map.getMimeTypeFromExtension(extension).toString()
    }

    fun getColor(color: Int): Int {
        return ContextCompat.getColor(App.INSTANCE, color)
    }

    fun getDrawable(color: Int): Drawable? {
        return ContextCompat.getDrawable(App.INSTANCE, color)
    }


    fun showToast(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(App.INSTANCE, msg, Toast.LENGTH_LONG)
                .show()
        }
    }

    val deviceId: String
        get() = Settings.Secure.getString(
            App.INSTANCE.contentResolver,
            Settings.Secure.ANDROID_ID
        )


    fun setBgView(layout: View, drawableId: Int) {
        layout.background = ContextCompat.getDrawable(
            App.INSTANCE,
            drawableId
        )
    }

    fun isValidEmail(email: String?): Boolean {
        val EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"
        val pattern = Pattern.compile(EMAIL_REGEX)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun preventTwoClick(view: View?) {
        if (view != null) {
            view.isEnabled = false
            view.postDelayed(Runnable { view.isEnabled = true }, 800)
        }
    }


    fun getFileType(url: String?): String {
        val path = Uri.fromFile(File(url))
        var extension =
            MimeTypeMap.getFileExtensionFromUrl(path.toString())
        extension = extension.toLowerCase()
        if (extension.contains(".")) {
            extension = extension.substring(extension.lastIndexOf("."))
        }
        return extension
    }


    fun getValue(month: Int): String {
        return if (month > 9) {
            month.toString()
        } else "0$month"
    }


    fun getFullName(firstName: String?, lastName: String?): String {
        var name1 = "NA"
        var name2: String? = ""
        if (!TextUtils.isEmpty(firstName)) {
            name1 = "$firstName "
        }
        if (!TextUtils.isEmpty(lastName)) {
            name2 = lastName
        }
        return name1 + "" + name2
    }


    fun getMediaMultiPart(
        profileImagePath: String,
        key: String
    ): MultipartBody.Part {
        val file = File(profileImagePath)
        val requestFileProfilePic =
            RequestBody.create(getMimeType(profileImagePath).toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData(key, file.name, requestFileProfilePic)
    }


    fun getDeviceOS(): String {
        var codeName = "UNKNOWN"
        try {
            val fields = Build.VERSION_CODES::class.java.fields

            fields.filter { it.getInt(Build.VERSION_CODES::class) == Build.VERSION.SDK_INT }
                .forEach { codeName = it.name }
        } catch (e: Exception) {

        }
        return codeName
    }


    const val CHANNEL_TWO_ID = "my_chanel"

    fun setBgTint(view: View?, color: Int) {
        view?.let {
            ViewCompat.setBackgroundTintList(
                it,
                ColorStateList.valueOf(color)
            )
        }
    }

    fun setTint(view: AppCompatImageView?, color: Int) {
        view?.setColorFilter(color)
    }

    fun getFileDir(): String? {
        return App.INSTANCE.getExternalFilesDir("image")?.absolutePath
    }

    fun getTimeZone(): String {
        return try {
            val tz = TimeZone.getDefault()
            if (tz != null && !TextUtils.isEmpty(tz.id)) {
                tz.id
            } else {
                ""
            }
        } catch (e: java.lang.Exception) {
            ""
        }
    }

    fun getProfile(id: String): String? {
        return "https://graph.facebook.com/$id/picture?type=large"
    }

    fun getDeviceId1(): String? {
        return Settings.Secure.getString(
            App.INSTANCE.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }


    fun getSecond(inSecond: Float): Int {
        return inSecond.toInt() % 60
    }

    fun getMinutes(inSecond: Float): Int {
        return (inSecond / 60 % 60).toInt()
    }

    fun getHour(inSecond: Float): Int {
        return (inSecond / (60 * 60) % 24).toInt()
    }


    fun twoDigitString(number: Long): String? {
        if (number == 0L) {
            return "00"
        }
        return if (number / 10 == 0L) {
            "0$number"
        } else number.toString()
    }

}
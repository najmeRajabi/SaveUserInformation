package com.example.saveuserinformation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String,val username: String,
                val email: String,val password: String,
                val gender: Gender):Parcelable {
}
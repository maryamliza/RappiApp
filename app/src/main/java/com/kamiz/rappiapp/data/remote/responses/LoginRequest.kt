package com.kamiz.rappiapp.data.remote.responses

import com.google.gson.annotations.SerializedName

class LoginRequest(
    @SerializedName("username") val email: String,
    val password: String,
)
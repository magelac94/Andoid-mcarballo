package com.example.listas.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Priority(val actionType: Int, val description: String) : Parcelable
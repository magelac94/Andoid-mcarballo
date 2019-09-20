package com.example.listas.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(val actionType: Int, val name: String, val color: String) : Parcelable
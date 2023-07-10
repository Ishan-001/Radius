package com.example.radius.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

data class Facility(
    val name: String,
    val options: List<Option>,
    @SerializedName("facility_id")
    val facilityId: String
)
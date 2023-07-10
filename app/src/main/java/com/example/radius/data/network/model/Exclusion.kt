package com.example.radius.data.model

import com.google.gson.annotations.SerializedName

data class Exclusion(
    @SerializedName("options_id")
    val optionsId: String,
    @SerializedName("facility_id")
    val facilityId: String
)
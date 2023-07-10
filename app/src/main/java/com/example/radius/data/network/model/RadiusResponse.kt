package com.example.radius.data.model

import io.realm.RealmList
import io.realm.RealmObject

data class RadiusResponse(
    val exclusions: List<List<Exclusion>>,
    val facilities: List<Facility>,
) {
    var updatedAt: Long? = null
}




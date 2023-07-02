package com.example.radius.data.model

import io.realm.RealmList
import io.realm.RealmObject

open class Facility(
    var name: String = "",
    var options: RealmList<Option>? = null,
    var facilityId: String = ""
): RealmObject()
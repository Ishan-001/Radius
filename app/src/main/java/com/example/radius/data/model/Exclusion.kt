package com.example.radius.data.model

import io.realm.RealmObject

open class Exclusion(
    var optionsId: String = "",
    var facilityId: String = ""
): RealmObject()
package com.example.radius.data.model

import io.realm.RealmObject

open class Option(
    var name: String = "",
    var icon: String = "",
    var id: String = ""
): RealmObject()

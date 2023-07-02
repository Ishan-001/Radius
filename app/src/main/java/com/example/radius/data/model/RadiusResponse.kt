package com.example.radius.data.model

import io.realm.RealmList
import io.realm.RealmObject

open class RadiusResponse(
    var exclusions: RealmList<ExclusionList>? = null,
    var facilities: RealmList<Facility>? = null,
    var updatedAt: Long? = null
): RealmObject()

open class ExclusionList(
    var exclusion: RealmList<Exclusion>? = null
): RealmObject()





package com.example.radius.data.repository

import com.example.radius.data.model.RadiusResponse
import com.example.radius.data.network.response.DataState
import com.example.radius.data.network.response.parse
import com.example.radius.data.network.service.RadiusService
import io.realm.Realm
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class Repository(
    private val service: RadiusService,
    private val realm: Realm,
    private val currentTimestamp: Long
) {
    internal fun getFacilities() = flow {
        val cache = realm.where(RadiusResponse::class.java).findFirst()

        cache?.updatedAt?.let {
            if (isApiCalledToday(it))
                emit(DataState.success(cache))
            else
                makeApiCall()
        } ?: run {
            makeApiCall()
        }
    }.catch {
        emit(DataState.error(it))
    }

    private fun makeApiCall() = flow {
        service.getFacilities().parse {
            emit(DataState.success(it))
            realm.executeTransaction { realm ->
                realm.insertOrUpdate(it)
            }
        }
    }

    private fun isApiCalledToday(timestamp: Long) = currentTimestamp - timestamp < 24 * 60 * 60 * 1000
}
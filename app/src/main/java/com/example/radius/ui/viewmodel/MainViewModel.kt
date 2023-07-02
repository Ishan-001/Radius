package com.example.radius.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radius.data.model.Exclusion
import com.example.radius.data.model.ExclusionList
import com.example.radius.data.model.Facility
import com.example.radius.data.repository.Repository
import com.example.radius.ui.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val screenState = mutableStateOf(ScreenState.Loading)

    val facilities = mutableStateListOf<Facility>()
    private val exclusions = mutableStateListOf<ExclusionList>()

    val excludedOptions = mutableStateListOf<String>()
    val selectedOptions = mutableMapOf<String, String>()

    init {
        getFacilities()
    }

    private fun getFacilities() {
        repository.getFacilities().onEach { dataState ->
            dataState.data?.let { response ->
                response.facilities?.let { facilities.addAll(it) }
                response.exclusions?.let { exclusions.addAll(it) }
                screenState.value = ScreenState.Success
            }
            dataState.error?.let {
                screenState.value = ScreenState.Error
            }
        }.launchIn(viewModelScope)
    }

    internal fun selectOption(optionId: String, facilityId: String) {
        selectedOptions[facilityId] = optionId

        excludedOptions.apply {
          clear()
          addAll(exclusions.filter {
              selectedOptions.values.contains(it.exclusion?.first()?.optionsId)
          }.map {
              it.exclusion?.last()?.optionsId!!
          }.toMutableStateList())
        }

        selectedOptions.forEach {
            if (it.value in excludedOptions){
                selectedOptions[it.key] = "0"
            }
        }
    }

}
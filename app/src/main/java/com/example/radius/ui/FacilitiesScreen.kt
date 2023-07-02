package com.example.radius.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.radius.ui.component.Facility
import com.example.radius.ui.model.ScreenState.*
import com.example.radius.ui.viewmodel.MainViewModel

@Composable
fun FacilitiesScreen(
    viewModel: MainViewModel
) {
    when (viewModel.screenState.value) {
        Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Radius Assignment",
                    fontSize = 36.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(20.dp))
                LazyColumn {
                    items(viewModel.facilities) {
                        Facility(
                            facility = it,
                            onClick = { optionId ->
                                viewModel.selectOption(optionId, it.facilityId)
                            },
                            selectedOptions = viewModel.selectedOptions.values.toList(),
                            excludedOptions = viewModel.excludedOptions
                        )
                    }
                }
            }
        }
        Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Error -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "An error occurred"
                )
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Radius Assignment",
            fontSize = 36.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(viewModel.facilities) {
                Facility(
                    facility = it,
                    onClick = { optionId ->
                        viewModel.selectOption(optionId, it.facilityId)
                    },
                    selectedOptions = viewModel.selectedOptions.values.toList(),
                    excludedOptions = viewModel.excludedOptions
                )
            }
        }
    }
}
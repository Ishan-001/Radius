package com.example.radius.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.radius.data.model.Facility
import com.example.radius.data.model.Option

@Composable
fun Facility(
    facility: Facility,
    excludedOptions: List<String> = listOf(),
    selectedOptions: List<String> = listOf(),
    onClick: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Text(
            text = facility.name,
            fontSize = 24.sp,
            color = Color.Black,
        )
        LazyHorizontalGrid(rows = GridCells.Adaptive(50.dp)) {
            items(facility.options as List<Option>) {
                Option(
                    option = it,
                    selected = selectedOptions.contains(it.id),
                    disabled = excludedOptions.contains(it.id),
                    onClick = {
                        onClick(it.id)
                    }
                )
            }
        }
    }
}
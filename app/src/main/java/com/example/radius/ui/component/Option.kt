package com.example.radius.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.radius.data.model.Option
import com.example.radius.ui.theme.getIconDrawable

@Composable
fun Option(
    option: Option,
    selected: Boolean,
    disabled: Boolean,
    onClick: () -> Unit
) {
    val iconId = getIconDrawable(option.icon)

    if (selected)
        BasicOption(
            iconId = iconId,
            text = option.name,
            backgroundColor = Color.Cyan,
            secondaryColor = Color.White
        )
    else if (disabled)
        BasicOption(
            iconId = iconId,
            text = option.name,
            backgroundColor = Color.Transparent,
            secondaryColor = Color.LightGray
        )
    else
        BasicOption(
            iconId = iconId,
            text = option.name,
            backgroundColor = Color.Transparent,
            secondaryColor = Color.Cyan,
            onClick = onClick
        )
}

@Composable
fun BasicOption(
    iconId: Int,
    text: String,
    backgroundColor: Color,
    secondaryColor: Color,
    onClick: () -> Unit = { }
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .background(backgroundColor)
            .clickable { onClick() }
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = secondaryColor
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = iconId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = text,
            color = secondaryColor
        )
    }
}
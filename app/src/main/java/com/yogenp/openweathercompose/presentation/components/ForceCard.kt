package com.yogenp.openweathercompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yogenp.openweathercompose.network.model.ForceListDTO

@Composable
fun ForceCard(
    force: ForceListDTO,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable(onClick = onClick),
        elevation = 5.dp
    ){
        Row{
            Text(
                text = force.name,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }

}
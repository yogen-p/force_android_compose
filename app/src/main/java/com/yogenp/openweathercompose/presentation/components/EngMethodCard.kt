package com.yogenp.openweathercompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yogenp.openweathercompose.network.model.EngMethods
import com.yogenp.openweathercompose.util.parseHtml


@Composable
fun EngMethodCard(
    method: EngMethods
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            method.description?.let {
                Text(
                    text = parseHtml(it),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
            method.url?.let {
                SelectionContainer {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onSurface,
                    )
                }
            }
        }
    }
}
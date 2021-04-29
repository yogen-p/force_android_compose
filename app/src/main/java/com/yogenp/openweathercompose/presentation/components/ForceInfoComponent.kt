package com.yogenp.openweathercompose.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.util.parseHtml

@Composable
fun ForceInfoComponent(
    force: ForceInfoDTO
) {
    Surface(
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {

            Text(
                text = force.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Divider(thickness = 2.dp)

            force.description?.let {
                Text(
                    text = parseHtml(it),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(8.dp)
                )
            }

            force.url?.let {
                SelectionContainer {
                    Text(
                        text = "URL: $it",
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            force.telephone?.let {
                Text(
                    text = "Telephone: $it",
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Divider(thickness = 1.dp)

            force.engagement_methods?.let {

                Text(
                    text = "Engagement Methods",
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                )

                for (method in it) {
                    EngMethodCard(method = method)
                }
            }

        }
    }
}
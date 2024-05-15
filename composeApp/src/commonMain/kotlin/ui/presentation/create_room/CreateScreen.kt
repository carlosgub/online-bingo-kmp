package ui.presentation.create_room

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.presentation.util.WindowInfo

@Composable
fun CreateScreen(
    component: CreateScreenComponent,
    windowInfo: WindowInfo
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Create Screen")
        Button(
            onClick = { component.popBack() }
        ) {
            Text("Back")
        }
    }

}
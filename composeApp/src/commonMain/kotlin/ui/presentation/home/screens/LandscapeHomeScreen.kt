package ui.presentation.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import themedbingo.composeapp.generated.resources.Res
import themedbingo.composeapp.generated.resources.join_room
import themedbingo.composeapp.generated.resources.new_room
import themedbingo.composeapp.generated.resources.profile
import ui.navigation.Configuration
import ui.presentation.home.HomeScreenComponent
import ui.presentation.home.event.HomeScreenEvent
import ui.presentation.home.screens.components.HomeScreenHeader

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LandscapeHomeScreen(
    event: (event: HomeScreenEvent) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val buttonModifier = Modifier
            .width(240.dp)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            HomeScreenHeader(maxPictureWidth = 200.dp)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Button(
                onClick = {
                    event(HomeScreenEvent.Navigate(Configuration.CreateScreen))
                },
                modifier = buttonModifier
            ) {
                Icon(
                    Icons.Filled.Create,
                    contentDescription = stringResource(resource = Res.string.new_room)
                )
                Spacer(Modifier.width(8.dp))
                Text(stringResource(resource = Res.string.new_room))
            }

            Button(
                onClick = {
                    event(HomeScreenEvent.Navigate(Configuration.JoinScreen))
                },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = stringResource(resource = Res.string.join_room)
                )
                Spacer(Modifier.width(8.dp))
                Text(stringResource(resource = Res.string.join_room))
            }

            Divider(
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .width(120.dp)
            )

            OutlinedButton(
                onClick = {
                    event(HomeScreenEvent.Navigate(Configuration.ProfileScreen))
                },
                modifier = buttonModifier
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = stringResource(resource = Res.string.profile)
                )
                Spacer(Modifier.width(8.dp))
                Text(stringResource(resource = Res.string.profile))
            }
        }
    }
}
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.navigation.Child
import ui.navigation.RootComponent
import ui.presentation.create_room.CreateRoomScreen
import ui.presentation.home.HomeScreen
import ui.presentation.host.HostScreen
import ui.presentation.join_room.JoinScreen
import ui.presentation.play.PlayScreen
import ui.presentation.profile.ProfileScreen
import ui.presentation.themes.ThemesScreen
import ui.presentation.util.getAsyncImageLoader
import ui.presentation.util.rememberWindowInfo

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {

        val childStack by rootComponent.childStack.subscribeAsState()

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            propagateMinConstraints = true
        ) {

            val boxWidth = this.maxWidth
            val boxHeight = this.maxHeight
            val windowInfo = rememberWindowInfo(screenHeight = boxHeight, screenWidth = boxWidth)

            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->

                when (val instance = child.instance) {
                    is Child.HomeScreen -> HomeScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.ThemesScreen -> ThemesScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.CreateScreen -> CreateRoomScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.HostScreen -> HostScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.JoinScreen -> JoinScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.PlayScreen -> PlayScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )

                    is Child.ProfileScreen -> ProfileScreen(
                        component = instance.component,
                        windowInfo = windowInfo
                    )
                }
            }
        }
    }
}
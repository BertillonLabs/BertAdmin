import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.events.Event
import presentation.App
import presentation.auth.LoginScreen
import presentation.dashboard.DashboardScreen
import theme.AdminTheme


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeJsTarget") {
            AdminTheme {
                LaunchedEffect(Unit){
                    val ele = document.getElementById("loading-indicator")
                    ele?.remove()
                }

                App()
            }
        }
    }

}
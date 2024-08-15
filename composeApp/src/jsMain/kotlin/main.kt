import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.wasm.onWasmReady
import presentation.App
import presentation.auth.LoginScreen
import presentation.dashboard.DashboardScreen
import theme.AdminTheme


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeJsTarget") {
            AdminTheme {
                App()
            }
        }
    }

}
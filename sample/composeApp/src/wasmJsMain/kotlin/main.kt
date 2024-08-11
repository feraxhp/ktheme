import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.feraxhp.sample.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("sample") {
        App()
    }
}

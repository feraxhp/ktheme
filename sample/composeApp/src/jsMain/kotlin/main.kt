import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasdthemedWindow
import com.feraxhp.sample.App
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasdthemedWindow("sample") {
            App()
        }
    }
}

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasdthemedWindow
import com.feraxhp.sample.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasdthemedWindow("sample") {
        App()
    }
}

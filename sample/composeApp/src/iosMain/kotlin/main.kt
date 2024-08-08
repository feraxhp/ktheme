import androidx.compose.ui.window.ComposeUIViewController
import com.feraxhp.sample.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }

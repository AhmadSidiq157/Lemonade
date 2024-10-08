package id.sidiqimawan.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.sidiqimawan.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                // Langkah 1: Pilih lemon
                LemonStep(
                    text = stringResource(R.string.lemon_select),
                    imageRes = R.drawable.lemon_tree,
                    contentDescription = stringResource(R.string.lemon_tree_content_description),
                    onImageClick = { currentStep = 2 }
                )
            }
            2 -> {
                // Langkah 2: Peras lemon
                LemonStep(
                    text = stringResource(R.string.lemon_squeeze),
                    imageRes = R.drawable.lemon_squeeze,
                    contentDescription = stringResource(R.string.lemon_content_description),
                    onImageClick = { currentStep = 3 }
                )
            }
            3 -> {
                // Langkah 3: Minum jus lemon
                LemonStep(
                    text = stringResource(R.string.lemon_drink),
                    imageRes = R.drawable.lemon_drink,
                    contentDescription = stringResource(R.string.lemon_drink_content_description),
                    onImageClick = { currentStep = 4 }
                )
            }
            4 -> {
                // Langkah 4: Reset
                LemonStep(
                    text = stringResource(R.string.lemon_restart),
                    imageRes = R.drawable.lemon_restart,
                    contentDescription = stringResource(R.string.lemon_restart_content_description),
                    onImageClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun LemonStep(
    text: String,
    imageRes: Int,
    contentDescription: String,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(imageRes),
            contentDescription = contentDescription,
            modifier = Modifier
                .wrapContentSize()
                .clickable { onImageClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}

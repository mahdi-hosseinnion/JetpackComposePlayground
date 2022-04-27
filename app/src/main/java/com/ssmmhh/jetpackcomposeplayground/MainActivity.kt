package com.ssmmhh.jetpackcomposeplayground

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ssmmhh.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MessageCard(Message.TEST_MESSAGE_1)
                }
            }
        }
    }
}

@Composable
fun MessageCard(mgs: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = stringResource(R.string.profile_picture)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(
                text = mgs.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    modifier = Modifier.padding(all = 4.dp),
                    text = mgs.text,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }

    }
}

@Preview(showBackground = true,name = "Light Mode")
@Composable
fun PreviewMessageCardInLightMode() {
    JetpackComposePlaygroundTheme {
        MessageCard(
            Message.TEST_MESSAGE_1
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun PreviewMessageCardInDarkMode() {
    JetpackComposePlaygroundTheme {
        MessageCard(
            Message.TEST_MESSAGE_1
        )
    }
}


package com.ssmmhh.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
                .clip(CircleShape),
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = stringResource(R.string.profile_picture)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(text = mgs.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = mgs.text)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePlaygroundTheme {
        MessageCard(
            Message.TEST_MESSAGE_1
        )
    }
}

data class Message(
    val author: String,
    val text: String
) {
    companion object {
        val TEST_MESSAGE_1 = Message(
            author = "Mahdi",
            text = "Hey are u up for tonight?"
        )
    }
}
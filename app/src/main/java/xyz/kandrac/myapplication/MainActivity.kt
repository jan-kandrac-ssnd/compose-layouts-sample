package xyz.kandrac.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Preview
@Composable
fun ContentPreview() {
    Content()
}

@Composable
fun Content() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) { ColumnSample() }
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) { RowSample() }
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) { BoxSample() }
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) { CombinationSample() }
    }
}

@Composable
fun ColumnSample() {
    Column(
        modifier = Modifier.shadow(12.dp).background(Color(0xFFFAFAFA), RoundedCornerShape(8.dp)).padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "Alfred Sisley", color = Color(0xFF1C1C1C), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Text(text = "3 minutes ago", color = Color(0xFF7B7B7B), fontSize = 12.sp, fontWeight = FontWeight.Light)
    }
}

@Composable
fun RowSample() {
    Row(
        modifier = Modifier.padding(12.dp).shadow(12.dp).fillMaxWidth().background(Color(0xFFFAFAFA), RoundedCornerShape(8.dp)).padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painterResource(R.drawable.cart_outline), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
        Image(painterResource(R.drawable.cog_outline), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
        Image(painterResource(R.drawable.home_outline), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
        Image(painterResource(R.drawable.music_note), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
    }
}

@Composable
fun BoxSample() {
    Box(
        modifier = Modifier.padding(12.dp).shadow(12.dp).background(Color(0xFFFAFAFA), RoundedCornerShape(8.dp)).padding(8.dp),
    ) {
        Image(painterResource(R.drawable.cart_outline), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
        Text("12", Modifier.background(Color(0xFFE53935), CircleShape).align(Alignment.TopEnd).padding(4.dp, 2.dp), color = Color.White, fontSize = 10.sp)
    }
}

@Composable
fun CombinationSample() {
    Row(
        modifier = Modifier.padding(12.dp).shadow(12.dp).fillMaxWidth().background(Color(0xFFFAFAFA), RoundedCornerShape(8.dp)).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
        ) {
            Image(painterResource(R.drawable.cart_outline), null, modifier = Modifier.clip(CircleShape).clickable {  }.padding(8.dp))
            Text("12", Modifier.background(Color(0xFFE53935), CircleShape).align(Alignment.TopEnd).padding(4.dp, 2.dp), color = Color.White, fontSize = 10.sp)
        }
        Column(
            modifier = Modifier.padding(8.dp).weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Alfred Sisley", color = Color(0xFF1C1C1C), fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = "3 minutes ago", color = Color(0xFF7B7B7B), fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
    }
}
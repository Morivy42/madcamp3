package io.madcamp.treasurehunterar

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import io.madcamp.treasurehunterar.auth.UserUiState

@Preview
@Composable
fun HomeScreen() {
    val ctx = LocalContext.current.applicationContext
//    Column {
//        Text(text = "Home Screen")
//        val userViewModel: UserViewModel = viewModel()
//        UsersList(userUiState = userViewModel.userUiState)
//    }
    Column {
        ProfileCard()
        Row {
            RegionCard()
            RegionCard()
            RegionCard()
            RegionCard()
        }
//        Button(
//            onClick = {
//                val intent = Intent(ctx, CloudAnchorActivity::class.java)
//                ctx.startActivity(intent)
//            }
//        ) {
//            Text(text = "Test")
//        }
    }
//    MapScreen()
}

@Preview
@Composable
fun RegionCard() {
    Card(
        modifier = Modifier.background(Color.Transparent)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Blue)
        )
        Text(text = "region")
    }
}

@Preview
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20f),

    ) {
        Text(text = "Welcome")
        Text(text = "name")
        Text(text = "collected / total")
        CustomLinearProgressIndicator(0.3f)
    }

}

@Composable
fun CustomLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
    indicatorHeight: Dp = 4.dp,
    indicatorPadding: Dp = 0.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .height(indicatorHeight)
                .fillMaxWidth()
                .background(backgroundColor)
        )
        Box(
            modifier = Modifier
                .height(indicatorHeight)
                .fillMaxWidth(progress)
                .background(color)
                .padding(start = indicatorPadding, end = indicatorPadding)
        )
    }
}



@Composable
fun UsersList(
    userUiState: UserUiState,
    modifier: Modifier = Modifier
) {
//    val userViewModel: UserViewModel = viewModel()
    when (userUiState) {
        is UserUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is UserUiState.Success -> ResultScreen(
            userUiState.Users
        )
        is UserUiState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.app_name)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = ""
        )
        Text(text = "Error", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ResultScreen(User: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = User)
    }
}

@Composable
fun GoogleMapExample() {
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            properties = properties,
            uiSettings = uiSettings
        )
        Switch(
            checked = uiSettings.zoomControlsEnabled,
            onCheckedChange = {
                uiSettings = uiSettings.copy(zoomControlsEnabled = it)
            }
        )
    }
}
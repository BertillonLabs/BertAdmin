package presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import design.AdminDialog
import design.Container
import presentation.auth.LoginScreen
import presentation.auth.LoginViewModel
import theme.*
import kotlin.random.Random

@Composable
fun DashboardScreen(){
    val scope = rememberCoroutineScope()
    val viewModel = remember(scope){ DashboardViewModel(scope) }
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.loadAgents()
    }

    DashboardContent(state){
        if (it == Content.AGENTS){
            viewModel.loadAgents()
        }else{
            viewModel.loadEnrolles()
        }
    }

    state.error?.let {
        AdminDialog(
            title = "Error",
            message = it,
            onClose = { viewModel.resetError() }
        )
    }
}

@Composable
private fun DashboardContent(
    state: DashboardState,
    onTab: (Content) -> Unit
){
    var currentTab by remember { mutableStateOf(Content.AGENTS) }

    SplitPanel(
        firstItem = {
            DrawerTab{ currentTab = it; onTab(it) }
        },
        lastItem = {
            ContentTab(currentTab, state)
        }
    )
}




@Composable
private fun SplitPanel(
    firstItem: @Composable RowScope.() -> Unit,
    lastItem: @Composable RowScope.() -> Unit
){
    Container{
        Row(modifier = Modifier.fillMaxSize()){
            firstItem()
            lastItem()
        }

    }
}
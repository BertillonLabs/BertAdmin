package presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Agent
import data.Enrolle
import design.Container
import design.Loading
import presentation.dashboard.agent.AgentTable
import presentation.dashboard.enrolle.EnrolleDetails
import presentation.dashboard.enrolle.EnrolleTable
import theme.*


enum class Content(name: String){
    AGENTS("Agents"), ENROLLED("Enrollees"), ENROLLED_DETAILS("Enrolled Details")
}

@Composable
fun RowScope.ContentTab(
    tab: Content,
    state: DashboardState
){

    var localTab by remember(tab){ mutableStateOf(tab) }
    var enrolle by remember { mutableStateOf<Enrolle?>(null) }
    val count = remember(tab, state){
        if (tab == Content.AGENTS) state.agents.size.toString() else state.enrolles.size.toString()
    }

    Box(modifier = Modifier
        .weight(4f)
        .fillMaxHeight()
        .background(white, RoundedCornerShape(4.dp))
    ){
        Container {
            if (listOf(Content.AGENTS, Content.ENROLLED).contains(localTab)){
                HeaderText(text = tab.name, "View and manage ${tab.name}")
                Spacer(modifier = Modifier.height(20.dp))
                TopTab("All ${tab.name}", count)
            }

            if (state.isLoading){
                Loading(modifier = Modifier.weight(1f).fillMaxWidth())
            }else {
                when(localTab){
                    Content.AGENTS -> AgentTable(state.agents)
                    Content.ENROLLED -> EnrolleTable(state.enrolles){
                        localTab = Content.ENROLLED_DETAILS
                        enrolle = it
                    }
                    Content.ENROLLED_DETAILS -> {
                        enrolle?.let {
                            EnrolleDetails(it)
                        }
                    }
                }

            }
        }
    }
}



@Composable
fun TopTab(title: String, count: String){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = black
            )
        )
        Text(
            text = count,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = primary
            )
        )
    }
}

@Composable
fun HeaderText(text: String, desc: String){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = charcoal
            )
        )
        Text(
            text = desc,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                color = charcoal.copy(0.4f)
            )
        )
    }

}
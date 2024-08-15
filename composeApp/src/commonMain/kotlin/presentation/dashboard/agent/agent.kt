package presentation.dashboard.agent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Agent
import theme.charcoal
import theme.grey400
import theme.primary

@Composable
fun AgentTable(agents: List<Agent>){

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            AgentTableTop()
        }
        items(agents){
            AgentItem(it)
        }
    }
}

@Composable
fun AgentItem(agent: Agent){
    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 10.dp)
        ) {
            Text(
                text = agent.name,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = agent.email,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(2f)
            )
            Text(
                text = agent.address,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(4f)
            )
            Text(
                text = agent.login,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Box(modifier = Modifier.height(1.dp).fillMaxWidth().background(grey400.copy(0.1f)))
    }

}

@Composable
fun AgentTableTop(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(grey400.copy(0.1f), RoundedCornerShape(4.dp))
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(
            text = "Name",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Email",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(2f)
        )
        Text(
            text = "Location",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(4f)
        )
        Text(
            text = "Last Login",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(1f)
        )
    }
}
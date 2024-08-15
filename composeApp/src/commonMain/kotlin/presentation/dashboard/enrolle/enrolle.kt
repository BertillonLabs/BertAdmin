package presentation.dashboard.enrolle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import data.Enrolle
import design.AsyncImage
import theme.charcoal
import theme.grey400
import theme.primary

@Composable
fun EnrolleTable(
    enrolles: List<Enrolle>,
    onItemClick: (Enrolle) -> Unit
){

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            EnrolleTableTop()
        }
        items(enrolles){
            EnrolleItem(it){ onItemClick(it) }
        }
    }
}

@Composable
fun EnrolleItem(enrolle: Enrolle, onItemClick: () -> Unit){
    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 10.dp)
                .clickable { onItemClick() },
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            AsyncImage(
                modifier = Modifier.weight(1f).height(40.dp),
                imageLink = enrolle.passport
            )
            Text(
                text = enrolle.fullName,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(2f)
            )
            Text(
                text = enrolle.location,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(4f)
            )
            Text(
                text = enrolle.gender,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = charcoal
                ),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = enrolle.dob,
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
fun EnrolleTableTop(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(grey400.copy(0.1f), RoundedCornerShape(4.dp))
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(
            text = "Passport",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Full name",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(2f)
        )
        Text(
            text = "Address",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(4f)
        )
        Text(
            text = "Gender",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "D.O.B",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = primary
            ),
            modifier = Modifier.weight(1f)
        )
    }
}
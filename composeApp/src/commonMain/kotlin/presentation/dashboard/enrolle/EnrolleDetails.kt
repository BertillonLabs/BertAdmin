package presentation.dashboard.enrolle

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Enrolle
import design.AsyncImage
import org.jetbrains.compose.resources.imageResource
import theme.charcoal
import theme.grey400

@Composable
fun EnrolleDetails(enrolle: Enrolle){

    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item(span = { GridItemSpan(5) }) {
            Column(
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Text(
                    text = enrolle.id,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 22.sp,
                        color = charcoal
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                DataDivider("Basic")
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageAndName(modifier = Modifier.weight(1f), name = enrolle.fullName, image = enrolle.passport)
                    BioData(modifier = Modifier.weight(2f), name = "Gender", icon = Icons.Outlined.Female, value = enrolle.gender)
                    BioData(modifier = Modifier.weight(1f), name = "Date of birth", icon = Icons.Outlined.Today, value = enrolle.dob)
                }
                DataDivider("Contact")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    BioData(modifier = Modifier.weight(1f), name = "Phone", icon = Icons.Outlined.Person, value =  enrolle.phone)
                    BioData(
                        modifier = Modifier.weight(2f),
                        name = "Location",
                        icon = Icons.Outlined.Place,
                        value = enrolle.location
                    )
                    BioData(modifier = Modifier.weight(1f), name = "Email", icon = Icons.Outlined.Mail, value =  enrolle.email)
                }
                DataDivider("Identity number")
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    BioData(modifier = Modifier.weight(1f), name = "ID", icon = Icons.Outlined.Person, value = enrolle.id)
                    BioData(modifier = Modifier.weight(1f), name = "Type", icon = Icons.Outlined.Person, value =  enrolle.idType)
                }
                DataDivider("Enrolled by")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    BioData(modifier = Modifier.weight(1f), name = "Name", icon = Icons.Outlined.Badge, value = enrolle.agentData?.name.orEmpty())
                    BioData(modifier = Modifier.weight(1f), name = "Email", icon = Icons.Outlined.Badge, value = enrolle.agentData?.email.orEmpty())

                }
                DataDivider("Next of kin")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    BioData(modifier = Modifier.weight(1f), name = "Name", icon = Icons.Outlined.Badge, value = enrolle.nextOfKin)

                }
                DataDivider("Bio-metrics")
            }
        }

        items(enrolle.fingerprints) {
            AsyncImage(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(0.dp),
                imageLink = it.path
            )
        }

    }

}

@Composable
private fun ImageAndName(
    modifier: Modifier = Modifier,
    image: String,
    name: String
){
    Row(
        modifier = modifier.height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(50.dp),
            shape = RoundedCornerShape(5.dp),
            imageLink = image
        )
        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
            Text(
                text = "Enrolled",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = charcoal.copy(alpha = 0.6f)
                )
            )
            Text(
                text = name,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = charcoal
                )
            )
        }
    }
}


@Composable
private fun BioData(
    name: String,
    icon: ImageVector,
    value: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(50.dp).border(width = (1.5).dp, charcoal.copy(alpha = 0.7f), RoundedCornerShape(5.dp)).padding(10.dp),
            imageVector = icon,
            contentDescription = null,
            tint = charcoal.copy(alpha = 0.7f)
        )
        Column(verticalArrangement = Arrangement.Top)  {
            Text(
                text = name,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = charcoal.copy(alpha = 0.6f)
                )
            )
            Text(
                text = value,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = charcoal
                )
            )
        }
    }
}

@Composable
private fun DataDivider(
    title: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(grey400.copy(0.1f), RoundedCornerShape(4.dp))
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = charcoal.copy(alpha = 0.6f)
            )
        )
    }
}

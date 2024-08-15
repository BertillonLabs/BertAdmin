package presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Groups2
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Enrolle
import theme.charcoal
import theme.grey
import theme.grey400
import kotlin.random.Random

@Composable
fun RowScope.DrawerTab(
    onTabClick: (Content) -> Unit
){
    var currentTab by remember { mutableStateOf(Content.AGENTS) }

    Column(
        modifier = Modifier.weight(1f)
    ) {
        Text(
            text = "GENERAL",
            style = MaterialTheme.typography.body1.copy(
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = grey
            )
        )

        DrawerItem(
            title = "Agents",
            icon = Icons.Outlined.Person2,
            isSelected = currentTab == Content.AGENTS,
            onClick = { currentTab = Content.AGENTS; onTabClick(Content.AGENTS) }
        )

        DrawerItem(
            title = "Enrollees",
            icon = Icons.Outlined.Groups2,
            isSelected = currentTab == Content.ENROLLED,
            onClick = { currentTab = Content.ENROLLED; onTabClick(Content.ENROLLED) }
        )

    }

}

@Composable
private fun DrawerItem(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
){
    val selectedColor = if (isSelected) grey400.copy(0.1f) else Color.Transparent
    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth()
            .background(selectedColor, RoundedCornerShape(4.dp)).padding(4.dp)
            .clickable(role = Role.Tab) { onClick() }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = charcoal.copy(alpha = 0.6f),
            modifier = Modifier.size(20.dp).padding(top = 3.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = charcoal.copy(alpha = 0.6f)
            )
        )
    }

}
package design

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import theme.*

@Composable
fun AdminDialog(
    title: String,
    message: String,
    onClose: () -> Unit
){

    BoxWithConstraints {
        val isCompact = maxWidth <= 600.dp

        Dialog(onDismissRequest = onClose) {
            Column(
                modifier = Modifier.let {
                    if (isCompact) it.fillMaxWidth() else it.widthIn(min = 280.dp, max = 520.dp)
                }.background(white, RoundedCornerShape(16.dp))
                    .padding(20.dp)
                ,
                horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start
            ) {
                BasicText(
                    text = title,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Medium,
                        color = black,
                        textAlign = if (isCompact) TextAlign.Center else TextAlign.Start
                    )
                )
                Spacer(Modifier.height(16.dp))
                BasicText(
                    text = message,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Normal,
                        color = grey400,
                        textAlign = if (isCompact) TextAlign.Center else TextAlign.Start
                    )
                )
                Spacer(Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.End),
                    modifier = Modifier.fillMaxWidth()
                ) {
//                    Box(Modifier.clip(RoundedCornerShape(12.dp))
//                        .clickable{  }
//                        .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(12.dp))
//                        .padding(horizontal = 14.dp, vertical = 10.dp)
//                        .let { if (isCompact) it.weight(1f) else it },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        BasicText(
//                            text = "Cancel", style = MaterialTheme.typography.body1.copy(
//                                color = Color(0xFF424242), fontWeight = FontWeight.Medium
//                            )
//                        )
//                    }
                    Box(
                        Modifier.clip(RoundedCornerShape(12.dp))
                            .clickable{ onClose() }
                            .background(primary)
                            .padding(horizontal = 14.dp, vertical = 10.dp)
                            .let { if (isCompact) it.weight(1f) else it }
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        BasicText(
                            text = "Close", style = MaterialTheme.typography.body1.copy(
                                color = Color.White, fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }
        }
    }
}
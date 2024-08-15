@file:OptIn(ExperimentalResourceApi::class)
package theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import codex.composeapp.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Inter(): FontFamily{
    return FontFamily(
        Font(Res.font.regular, weight = FontWeight.Normal),
        Font(Res.font.semibold, weight = FontWeight.SemiBold),
        Font(Res.font.bold, weight = FontWeight.Bold),
        Font(Res.font.medium, weight = FontWeight.Medium)
    )
}

val HubTypography = @Composable {
    Typography(
        defaultFontFamily = Inter()
    )
}
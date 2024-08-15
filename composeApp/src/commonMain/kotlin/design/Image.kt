package design

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import theme.grey400
import theme.greyLight

@Composable
fun AsyncImage(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    imageLink: String
){
    val resource = asyncPainterResource(imageLink)
    KamelImage(
        resource = resource,
        modifier = modifier.clip(shape),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        onLoading = { _ -> CircularProgressIndicator() },
        onFailure = { exception ->
            Box(modifier = modifier.background(grey400.copy(0.5f), shape))
        },
        animationSpec = tween()
    )
}
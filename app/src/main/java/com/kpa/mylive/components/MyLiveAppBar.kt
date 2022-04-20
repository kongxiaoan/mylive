package com.kpa.mylive.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kpa.mylive.R
import com.kpa.mylive.theme.elevatedSurface

/**
 * @author      kongpingan
 * @date        2022/4/20 16:00
 * @package     com.kpa.mylive.components
 * @description
 **/
@Composable
fun MyLiveAppBar(
    modifier: Modifier = Modifier,
    onNavIconPressed: () -> Unit,
    title: @Composable RowScope.() -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val backgroundColor = MaterialTheme.colors.elevatedSurface(3.dp)
    Column(
        Modifier.background(backgroundColor.copy(alpha = 0.95F))
    ) {
        TopAppBar(
            modifier = modifier,
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = MaterialTheme.colors.onSurface,
            actions = actions,
            title = { Row { title() } },
            navigationIcon = {
                Image(
                    painter = painterResource(R.mipmap.ic_launcher),
                    contentDescription = "导航",
                    modifier = Modifier
                        .clickable(onClick = onNavIconPressed)
                        .padding(horizontal = 16.dp)
                )
            }
        )
        Divider()
    }
}
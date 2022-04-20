package com.kpa.mylive.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsPadding
import com.kpa.mylive.R
import com.kpa.mylive.components.MyLiveAppBar
import com.kpa.mylive.data.exampleUiState
import com.kpa.mylive.theme.MyLiveTheme

/**
 * @author      kongpingan
 * @date        2022/4/19 19:10
 * @package     com.kpa.mylive.main
 * @description 主页面布局
 **/

@Composable
fun MainContent(
    uiState: MainUiState,
    modifier: Modifier = Modifier,
    navigateToDrawer: () -> Unit = {}
) {
    Surface(modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize()) {
                Text(
                    text = "ceshi",
                    color = colorResource(R.color.blue400),
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = 40.sp
                )
            }
            MyLiveBar(
                "MyLive",
                modifier = Modifier.statusBarsPadding(),
                onNavIconPressed = navigateToDrawer
            )
        }
    }

}

@Composable
fun MyLiveBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavIconPressed: () -> Unit
) {

    MyLiveAppBar(
        modifier = modifier,
        onNavIconPressed = onNavIconPressed,
        title = {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Channel name
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewMainContent() {
    MyLiveTheme {
        MainContent(
            uiState = exampleUiState,
            navigateToDrawer = {}
        )
    }
}
package com.kpa.mylive.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import com.google.accompanist.insets.navigationBarsPadding
import com.kpa.mylive.MainViewModel
import com.kpa.mylive.data.exampleUiState
import com.kpa.mylive.theme.MyLiveTheme

/**
 * @author      kongpingan
 * @date        2022/4/19 19:05
 * @package     com.kpa.mylive.main
 * @description
 **/
class MainFragment : Fragment() {
    private val activityViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)

        val viewWindowInset = ViewWindowInsetObserver(this)
            .start(windowInsetsAnimationsEnabled = true)
        setContent {
            CompositionLocalProvider(
                LocalBackPressedDispatcher provides requireActivity().onBackPressedDispatcher,
                LocalWindowInsets provides viewWindowInset
            ) {
                MyLiveTheme {
                    MainContent(
                        uiState = exampleUiState,
                        onNavIconPressed = {
                            activityViewModel.openDrawer()
                        },
                        modifier = Modifier.navigationBarsPadding(bottom = false)
                    )
                }
            }
        }
    }
}
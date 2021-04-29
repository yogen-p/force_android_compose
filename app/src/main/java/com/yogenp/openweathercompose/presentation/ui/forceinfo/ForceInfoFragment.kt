package com.yogenp.openweathercompose.presentation.ui.forceinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.yogenp.openweathercompose.R
import com.yogenp.openweathercompose.presentation.components.ForceInfoComponent
import com.yogenp.openweathercompose.presentation.components.TopAppBar
import com.yogenp.openweathercompose.presentation.theme.AppTheme
import com.yogenp.openweathercompose.presentation.ui.MainSharedViewModel

class ForceInfoFragment : Fragment() {

    private val viewModel: MainSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.getForce()
                val forceInfo = viewModel.forceInfo.value

                val isDarkTheme = isSystemInDarkTheme()
                AppTheme(darkTheme = isDarkTheme) {

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        TopAppBar(text = forceInfo?.name ?: getString(R.string.app_name))

                        forceInfo?.let {
                            ForceInfoComponent(forceInfo)
                        }

                        if (viewModel.showToast) {
                            Toast.makeText(requireContext(), viewModel.toastMessage, Toast.LENGTH_SHORT).show()
                            viewModel.updateToast()
                            Button(
                                onClick = { viewModel.getForce() },
                                modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp)
                            ) {
                                Text(text = "Try Again")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.clear()
    }

}
package com.yogenp.openweathercompose.presentation.ui.forcelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.yogenp.openweathercompose.R
import com.yogenp.openweathercompose.presentation.components.ForceCard
import com.yogenp.openweathercompose.presentation.components.TopAppBar
import com.yogenp.openweathercompose.presentation.theme.AppTheme
import com.yogenp.openweathercompose.presentation.ui.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForceListFragment : Fragment() {

    private val viewModel: MainSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val forces = viewModel.forces.value

                val isDarkTheme = isSystemInDarkTheme()
                AppTheme(darkTheme = isDarkTheme) {

                    Column {

                        TopAppBar(text = getString(R.string.app_name))

                        Box(modifier = Modifier.fillMaxSize()) {
                            LazyColumn {
                                itemsIndexed(
                                    items = forces
                                ) { _, force ->
                                    ForceCard(force = force) {
                                        viewModel.selectForce(force.id)
                                        findNavController().navigate(R.id.goToForceInfoFragment)
                                    }
                                }
                            }
                        }

                        if (viewModel.showToast) {
                            Toast.makeText(requireContext(), viewModel.toastMessage, Toast.LENGTH_SHORT).show()
                            viewModel.updateToast()
                            Button(
                                onClick = { viewModel.newSearch() },
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
}
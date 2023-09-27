package com.example.fetchproject.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchproject.model.DataResult
import com.example.fetchproject.viewmodel.MainViewModel

@Composable
fun MainComposeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val state: DataResult by viewModel.itemDataStateFlow.collectAsState()

    when (state) {
        is DataResult.Success -> {
            Surface(modifier = modifier.fillMaxSize()) {
                LazyColumn {
                    items(items = (state as DataResult.Success).dataList) { itemData ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = itemData.id.toString(), modifier = Modifier.weight(1f))
                            Text(text = itemData.name.toString(), modifier = Modifier.weight(1f))
                            Text(text = itemData.listId.toString(), modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
        is DataResult.Error -> {
            // Show error screen
        }
        is DataResult.Empty -> {
            // Do nothing
        }
    }
}

@Preview
@Composable
fun MainComposeScreenPreview() {
    MainComposeScreen()
}
package com.example.countermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.viewModels
import com.example.countermvvm.ui.theme.CounterMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val viewModel: CounterViewModel by viewModels()
                CounterMVVMTheme {
                    CounterApp(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = viewModel.count.value.toString(),
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = { viewModel.increment() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Increment")
        }
        Button(
            onClick = { viewModel.decrement() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Decrement")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    CounterMVVMTheme {
        val viewModel = CounterViewModel()
        CounterApp(viewModel = viewModel)
    }
}

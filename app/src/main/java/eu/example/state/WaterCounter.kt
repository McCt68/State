package eu.example.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function is stateless, as it don't hold the state of count it self
@Composable
fun StateLessWaterCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
	Column(modifier = Modifier.padding(16.dp)) {

		if (count > 0) {
			Text(text = "You've had $count glasses")
		}
		Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 5) {
			Text(text = "Add one")
		}
	}
}

// This function is statefull, as it holds the state of count it self
@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
	var waterCount by rememberSaveable { mutableStateOf(0) }
	var juiceCount by rememberSaveable { mutableStateOf(0) }
	StateLessWaterCounter(waterCount, { waterCount++ }, modifier)
	StateLessWaterCounter(juiceCount, { juiceCount++ }, modifier)
}
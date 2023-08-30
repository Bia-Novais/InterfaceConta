package com.example.interfaceconta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfaceconta.ui.theme.InterfaceContaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceContaTheme {

            }
        }
    }
    @Preview(showBackground = true, widthDp =  350, heightDp = 800)
    @Composable
    fun App(){
        InterfaceContaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    //SimpleTopAppBar()
                    //ClickableElevatedCardSample()
                    TwoLineListItem()
                }
            }

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar() {
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Magenta),
                title = {
                    Text(
                        text = "Seu Saldo",
                        color = Color.White
                    )
                },
                navigationIcon =  {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Filled.Menu,
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {


            }
        }

    )
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ClickableElevatedCardSample() {
        ElevatedCard(
            onClick = { /* Do something */ },
            modifier = Modifier.size(width = 50.dp, height = 50.dp)
        ) {
        }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Saldo Disponível:",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "R$ 200,00",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "+13%",
            color = Color.Blue,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth()
        )

        var checked by remember { mutableStateOf(false) }
        FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
            if (checked) {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = "Localized description")
            } else {
                Icon(Icons.Outlined.ArrowDropDown, contentDescription = "Localized description")
            }
        }


    }
}

@Preview(showBackground = true, widthDp =  350, heightDp = 600)
@Composable
fun ClickableElevatedCardSamplePreview(){
    ClickableElevatedCardSample()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoLineListItem() {
    Column {
        ListItem(
            headlineText = { Text("Rendimento") },
            supportingText  = { Text("+R$ 0¹²",color = Color.Blue) },
            trailingContent = { Text("Hoje \n 03:46") },
            leadingContent = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Localized description",
                )
            }
        )

        ListItem(
            headlineText = { Text("Rendimento") },
            supportingText  = { Text("+R$ 0²³",color = Color.Blue) },
            trailingContent = { Text("Ontem \n 17:36") },
            leadingContent = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Localized description",
                )
            }
        )

        ListItem(
            headlineText = { Text("Pagamento") },
            supportingText  = { Text("-15,³³", color = Color.Red) },
            trailingContent = { Text("Ontem \n 11:36") },
            leadingContent = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Localized description",
                )
            }
        )

    }
}

@Preview(showBackground = true, widthDp =  350, heightDp = 300)
@Composable
fun TwoLineListItemPreview(){
    TwoLineListItem()

}


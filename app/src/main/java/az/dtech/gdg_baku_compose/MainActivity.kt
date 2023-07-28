@file:OptIn(ExperimentalMaterial3Api::class)

package az.dtech.gdg_baku_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.dtech.gdg_baku_compose.ui.theme.Gdg_baku_composeTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gdg_baku_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier, color = MaterialTheme.colorScheme.background
                ) {
                    MyEditText()
                }
            }
        }
    }
}

@Composable
fun ListScreen(list: ImmutableList<Contact>) {
    ContactListScreenContent(contacts = list, comparator = ContactComparator(compareBy { it.name }))
}


@Composable
fun ContactListScreenContent(
    contacts: ImmutableList<Contact>,
    comparator: ContactComparator,
    modifier: Modifier = Modifier
) {
    val sortedContacts = remember(contacts, ContactComparator(comparator.comparator)) {
        contacts.sortedWith(comparator.comparator)
    }
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(sortedContacts) { contact ->
            ItemCard(contact)
        }
    }
}

@Composable
fun ItemCard(contact: Contact) {
    Text(
        text = contact.name,
        modifier = Modifier
            .background(
                Color.Blue,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                vertical = 20.dp,
                horizontal = 16.dp
            )
            .fillMaxWidth()
            .clickable {
            }, color = Color.White
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview
@Composable
fun PreviewListScreen() {
    Gdg_baku_composeTheme {
        ListScreen(list = list.toImmutableList())
    }
}

@Preview
@Composable
fun PreviewItemCard() {
    Gdg_baku_composeTheme {
        ItemCard(Contact("John Doe", false))
    }
}

@Immutable // or @Stable
data class ContactComparator(
    val comparator: Comparator<Contact>,
)

data class Contact(val name: String, val isFavorite: Boolean)

@Composable
fun MyEditText() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val focusRequester = FocusRequester()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            textStyle = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .padding(8.dp),
            singleLine = true,
            label = { Text("Enter your text here") }
        )

        Button(onClick = { println("") }) {
            Text(text = "Button")
        }
    }
}
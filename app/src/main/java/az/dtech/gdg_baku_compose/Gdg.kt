package az.dtech.gdg_baku_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Card() {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painterResource(R.drawable.image),
            contentDescription = "Image",
            modifier = Modifier.size(80.dp)
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Hello World!", modifier = Modifier
            )
            Text(
                text = "Hello GDG Baku!",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun TextWithBackground() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.Green,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = "Hello World!", modifier = Modifier
        )
    }
}

@Composable
fun ShowList() {
    val list = listOf<Contact>(
        Contact("John", true),
        Contact("Emma", true),
        Contact("Michael", true),
        Contact("Olivia", true),
        Contact("William", false),
        Contact("Sophia", true),
        Contact("James", true),
        Contact("Ava", false),
        Contact("Benjamin", true),
        Contact("Isabella", true),
        Contact("Jacob", false),
        Contact("Mia", true),
        Contact("Elijah", false),
        Contact("Charlotte", true),
        Contact("Alexander", true),
        Contact("Amelia", true),
        Contact("Daniel", false),
        Contact("Harper", true),
        Contact("Matthew", false),
        Contact("Evelyn", false),
        Contact("Liam", true),
        Contact("Abigail", false),
        Contact("Henry", true),
        Contact("Emily", true),
        Contact("Daniel", false),
        Contact("Scarlett", true),
        Contact("Owen", false),
        Contact("Grace", true),
        Contact("Logan", true),
        Contact("Chloe", true)
    )
    ContactList(contacts = list, comparator = compareBy { it.name })
}

@Composable
fun ContactList(
    contacts: List<Contact>,
    comparator: Comparator<Contact>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        // DON’T DO THIS
        items(contacts.sortedWith(comparator)) { contact ->
            Text(
                text = contact.name,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 16.dp
                    ), color = Color.White
            )
        }
    }
}

@Composable
fun CalculationScreenContent() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: $count",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = { count++ }) {
            Text(text = "Increment Count")
        }
    }
}

val list = listOf(
    Contact("John", true),
    Contact("Emma", true),
    Contact("Michael", true),
    Contact("Olivia", true),
    Contact("William", false),
    Contact("Sophia", true),
    Contact("James", true),
    Contact("Ava", false),
    Contact("Benjamin", true),
    Contact("Isabella", true),
    Contact("Jacob", false),
    Contact("Mia", true),
    Contact("Elijah", false),
    Contact("Charlotte", true),
    Contact("Alexander", true),
    Contact("Amelia", true),
    Contact("Daniel", false),
    Contact("Harper", true),
    Contact("Matthew", false),
    Contact("Evelyn", false),
    Contact("Liam", true),
    Contact("Abigail", false),
    Contact("Henry", true),
    Contact("Emily", true),
    Contact("Daniel", false),
    Contact("Scarlett", true),
    Contact("Owen", false),
    Contact("Grace", true),
    Contact("Logan", true),
    Contact("Chloe", true)
)
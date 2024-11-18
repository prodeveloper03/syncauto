package com.example.syncauto.ui.home
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.syncauto.ui.note.UserNote
import com.example.syncauto.ui.post.SyncButton
import com.example.syncauto.utils.getCurrentDate
import com.example.syncauto.utils.getCurrentTime
import kotlinx.coroutines.delay


@Composable
@Preview
fun HomeScreen() {
    // Global State
    var currentTime by remember { mutableStateOf(getCurrentTime()) }
    var currentDate by remember { mutableStateOf(getCurrentDate()) }
    var expenseType by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedCurrency by remember { mutableStateOf("INR") }
    var selectedPaymentMethod by remember { mutableStateOf("") }
    var userNoteText by remember { mutableStateOf("") }
    val context = LocalContext.current


    // List of expense type
    val expenseTypes = listOf("Food", "Transport", "Utilities", "Entertainment", "Rent", "Others")
    // List of Currencies
    val currencies = listOf("USD", "EUR", "INR", "JPY", "GBP")
    // List of Payment methods
    val paymentMethods = listOf("UPI","Cash","Debit Card","Credit Card")

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getCurrentTime()
            delay(1000L)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the current date and time at the toptrat
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = currentTime,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = currentDate,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown for expense type
        ExpenseTypeDropdown(
            selectedType = expenseType,
            onTypeSelected = { expenseType = it },
            expenseTypes = expenseTypes,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AmountInput(
            amount = amount,
            onAmountChange = { amount = it },
            selectedCurrency = selectedCurrency,
            onCurrencySelected = { selectedCurrency = it },
            currencies = currencies,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            paymentMethods.forEach { paymentMethod ->
                Chip(
                    text = paymentMethod,
                    isSelected = paymentMethod == selectedPaymentMethod,
                    onSelectedChanged = { selectedPaymentMethod = it },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

        ){
            UserNote(
                text = userNoteText,
                onTextChange = {userNoteText = it},
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(26.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
           SyncButton(
               text = "Sync Data",
               onClick = {
                   Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show()},
               modifier = Modifier.padding(16.dp)
           )
        }

    }
}
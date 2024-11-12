package com.example.syncauto.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountInput(
    amount: String,
    onAmountChange: (String) -> Unit,
    selectedCurrency: String,
    onCurrencySelected: (String) -> Unit,
    currencies: List<String>,
    modifier: Modifier = Modifier
) {
    var currencyDropdownExpanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue(amount)) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Text field for entering the amount
        TextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onAmountChange(it.text)
            },
            label = { Text("Amount") },
            modifier = Modifier
                .weight(1f)
                .height(56.dp) // Ensuring consistent height with the dropdown
        )



        // Currency dropdown menu
        ExposedDropdownMenuBox(
            expanded = currencyDropdownExpanded,
            onExpandedChange = { currencyDropdownExpanded = !currencyDropdownExpanded }
        ) {
            TextField(
                value = selectedCurrency,
                onValueChange = { onCurrencySelected(it) },
                readOnly = true,
                label = { Text("Currency") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = currencyDropdownExpanded)
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(56.dp) // Matching height with the amount input
            )

            ExposedDropdownMenu(
                expanded = currencyDropdownExpanded,
                onDismissRequest = { currencyDropdownExpanded = false }
            ) {
                currencies.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            onCurrencySelected(currency)
                            currencyDropdownExpanded = false
                        }
                    )
                }
            }
        }
    }
}

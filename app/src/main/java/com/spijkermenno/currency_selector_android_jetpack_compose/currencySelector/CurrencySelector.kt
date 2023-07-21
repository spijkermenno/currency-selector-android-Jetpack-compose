package com.spijkermenno.currency_selector_android_jetpack_compose.currencySelector

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyModalSelector(
    showModal: Boolean = false,
    modalTitle: String? = null,
    closeModal: (Currency) -> Unit
) {
    if (showModal) {
        Box(
            modifier = Modifier
                .zIndex(2f)
                .fillMaxSize()
                .background(Color(0x55000000))
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            ModalDrawerSheet(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(16.dp),
                drawerContainerColor = Color.White,
            ) {
                if (!modalTitle.isNullOrBlank()) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        text = "Choose your currency",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xff444444)
                        )
                    )

                    Divider()
                }
                LazyColumn(modifier = Modifier.padding(8.dp)) {
                    items(currencies) {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    Color(0x11666666),
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    closeModal.invoke(it)
                                }
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = "${it.symbol} - ${it.name}",
                                    color = Color.DarkGray
                                )

                                Icon(
                                    painter = painterResource(id = it.iconResourceId),
                                    contentDescription = it.name,
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ModalWithTitle() {
    MaterialTheme {
        Box(modifier = Modifier.background(Color.White)) {
            CurrencyModalSelector(true, "Choose your currency") {}
        }
    }
}

@Preview
@Composable
fun Modal() {
    MaterialTheme {
        Box(modifier = Modifier.background(Color.White)) {
            CurrencyModalSelector(true) {}
        }
    }
}
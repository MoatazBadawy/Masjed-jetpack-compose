package com.moataz.masjed.ui.view.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.masjed.ui.view.theme.Background
import com.moataz.masjed.ui.view.theme.ButtonColor
import com.moataz.masjed.ui.view.theme.TextColor
import com.moataz.masjed.ui.view.theme.Transparent
import com.moataz.masjed.ui.viewmodel.models.MasjedUI

@Composable
fun MasjedItem(
    masjed: MasjedUI,
    onButtonClick: () -> Unit
) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        backgroundColor = Transparent,
    ) {
        Card(
            modifier = Modifier
                .padding(top = 24.dp),
            backgroundColor = Background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 12.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = masjed.masjedName,
                    modifier = Modifier.padding(top = 16.dp),
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = masjed.masjedDescription,
                    modifier = Modifier.padding(top = 8.dp),
                    color = TextColor,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .width(85.dp)
                        .height(40.dp)
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(23.dp),
                    border = BorderStroke(3.dp, ButtonColor),
                    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
                ) {
                    Text(
                        text = "BROWSE",
                        fontSize = 10.sp,
                        color = Color.White,
                    )
                }
            }
        }

        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ImageLoading(url = masjed.masjedImg)
                }
            }
        }
    }
}

@Preview
@Composable
fun MasjedItemPreview() {
    MasjedItem(
        masjed = MasjedUI(
            masjedName = "Al-Masjid an-Nabawi",
            masjedDescription = "The Prophet's Masjed",
        ),
        onButtonClick = {}
    )
}
package com.codestarterr.shopkart.shopping.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codestarterr.shopkart.R
import com.codestarterr.shopkart.shopping.presentation.utils.CustomTextField
import java.nio.file.WatchEvent

@Composable
fun LoginScreen(modifier: Modifier = Modifier)  {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign In",
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp,
            modifier = modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)

        )

        CustomTextField(
            value = email,
            onValueChange = {
                email = it
            },
            leadingIcon = Icons.Default.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            label = "Email",
            singleLine = true
        )

        CustomTextField(
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            label = "Password",
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
        )

        Text("Forgot password ?", fontSize = 12.sp, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())

        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
                    context.printToast("SignUp successful")
                } else {
                    context.printToast("please fill all the fields")
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp
                ), shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.button_container)
            )
        ) {
            Text("Sign In")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account ?")
            TextButton(
                onClick = {}
            ) {
                Text("Sign up", color = colorResource(R.color.button_container))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(text = "Or", modifier = Modifier.padding(horizontal = 8.dp))
            HorizontalDivider(modifier = Modifier.weight(1f))
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),

            ) {
            Image(
                painter = painterResource(R.drawable.logo_google),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text("Login with google", color = colorResource(R.color.black))
        }
    }
}
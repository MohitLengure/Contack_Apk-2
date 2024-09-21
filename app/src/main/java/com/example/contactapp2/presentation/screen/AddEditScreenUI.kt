package com.example.contactapp2.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.contactapp2.ContactAppViewModel
import com.example.contactapp2.database.tables.Contact

@Composable
fun AddEditScreenUI(navController: NavHostController, viewModel: ContactAppViewModel){

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var context= LocalContext.current

    Column(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text ="Add Contact", textAlign = TextAlign.Center, color = Color.Blue, fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif , fontSize = 30.sp)
        OutlinedTextField(value = name, maxLines = 1, onValueChange ={
            name=it
        }, placeholder = {
            Text(text = "Enter Name", textAlign = TextAlign.Center)
        } )
        OutlinedTextField(maxLines = 1,value = email, onValueChange ={
            email=it
        }, placeholder = {
            Text(text = "Enter Email", textAlign = TextAlign.Center)
        } )
        OutlinedTextField(maxLines = 1, value = phone, onValueChange ={
            phone=it
        } , placeholder = {
            Text(text = "Enter Phone Number", textAlign = TextAlign.Center)
        })
        Button(onClick = {
            val contact= Contact(name=name,email=email,number=phone)
        viewModel.addUpdateContact(contact)
            navController.navigateUp()
        })
        {
            Text(text = "Save Contact")
        }
    }


}
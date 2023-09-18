package pe.edu.ulima.pm20232.aulavirtual.screens
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.components.ButtonWithIcon
import pe.edu.ulima.pm20232.aulavirtual.components.TextFieldWithLeadingIcon
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.*
import androidx.compose.material.Text as Text1
@Composable
fun IconoScreen(){
   Column(modifier =Modifier.fillMaxSize()) {

      Box(
         modifier = Modifier
            .fillMaxWidth()
            .background(if (isSystemInDarkTheme()) Color.Black else Gray1200)
            .weight(3f)
            .padding(8.dp),
         contentAlignment = Alignment.TopCenter
      ) {
         val paddingPercentage = 80;
         val paddingValue = with(LocalDensity.current) {
            (paddingPercentage * 0.02f * 16.dp.toPx()).dp
         }
         TopAppBar(
            title = {  "Mi Aplicación"},
            elevation = 0.dp,
            navigationIcon = {
               IconButton(onClick = { /* Aquí puedes agregar la funcionalidad de retroceso si es necesario */ }) {
                  Icon(
                     Icons.Default.ArrowBack,
                     contentDescription = "Back",
                     tint = if(isSystemInDarkTheme()) Color.White else Color.Black // Cambia el color del icono aquí (por ejemplo, a rojo)
                  )
               }
            },
            backgroundColor = if (isSystemInDarkTheme()) Color.Black else Gray1200 // Cambia el color de la barra superior según tus preferencias
         )
         Column(
            modifier = Modifier.padding(top = paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
         ) {


            Image(
               painter = painterResource(id = R.drawable.ic_ulima), // Replace with your SVG resource ID
               contentDescription = "Universidad de Lima",
               modifier = Modifier.size(120.dp),
               colorFilter = ColorFilter.tint(if (isSystemInDarkTheme()) White400 else Orange400),
            )
            Text1(
               text = "Gimnasio ULima",
               textAlign = TextAlign.Center,
               color = if (isSystemInDarkTheme()) White400 else Color.Black ,
               //fontSize = 40.sp,
               modifier =  Modifier.padding(top = 1.dp, bottom = 20.dp),
               style = MaterialTheme.typography.h4.copy(
                  fontSize = 20.sp,

                  color = if (isSystemInDarkTheme()) White400 else Color.Black // Apply the custom text color here
               )
            )
         }
      }
   }
}
@Composable
fun ResetForm(
   screenWidthDp: Int,
   screenHeightDp: Int,
) {
   var termsDisabled = true
   var temp =""

   Box(
      // caja gris (light)
      modifier = Modifier
         .fillMaxSize()
         .padding(top = (screenHeightDp * 0.30).dp,)
         .background(
            if (isSystemInDarkTheme()) Color(0xFF666666) else White400
         ),
   ) {
      Box(
         modifier = Modifier.padding(
            start = (screenWidthDp * 0.125).dp,
            top = (40.dp)
         ),
      ) {
         Box(
            modifier = Modifier
               .size(
                  (screenWidthDp * 0.75).dp,
                  (screenHeightDp * 0.45).dp
               ) // Adjust the size as needed
               //.border(1.dp, Gray800)
               .background(if (isSystemInDarkTheme()) Color(0xFF999999) else White400)
               .shadow(
                  elevation = 5.dp,
                  shape = MaterialTheme.shapes.medium,
                  //color = Color.Gray
               )
               .padding(start = 20.dp, top = 30.dp, bottom = 20.dp, end = 20.dp),
         ) {
            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text1(text = "SOLICITE CAMBIO DE CONTRASEÑA", fontWeight = FontWeight.Bold, fontSize = 12.sp, textAlign = TextAlign.Center,
                  color = if(isSystemInDarkTheme())Color.Black else White400)
               TextFieldWithLeadingIcon(
                  leadingIcon = Icons.Default.AccountBox, // Replace with your desired icon
                  placeholder = "DNI",
                  text = temp,
                  onTextChanged = {
                     temp = it
                  }
               )
               TextFieldWithLeadingIcon(
                  leadingIcon = Icons.Default.Email, // Replace with your desired icon
                  text = temp,
                  placeholder = "Correo",
                  onTextChanged = {
                     temp = it
                  },
                  isPassword = true,
               )
               Row(
                  modifier = Modifier
                     .fillMaxWidth()
                     .padding(top = 25.dp),
                  horizontalArrangement = Arrangement.Center,
               ) {
                  ButtonWithIcon("ENVIAR CORREO", Icons.Default.Send, {
                  })
               }
            }
         }
      }
      @Composable
      fun BottomSheet(screenWidthDp: Int, screenHeightDp: Int) {
         ResetForm(
            screenWidthDp,
            screenHeightDp
         )
      }
   }
}

@Composable
fun ResetPasswordScreen() {
   val configuration = LocalConfiguration.current
   val screenWidthDp = configuration.screenWidthDp
   val screenHeightDp = configuration.screenHeightDp
   IconoScreen()
   ResetForm(screenWidthDp, screenHeightDp)
}
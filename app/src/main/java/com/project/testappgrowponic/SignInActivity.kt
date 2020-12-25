package com.project.testappgrowponic

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.iid.FirebaseInstanceId
import com.project.testappgrowponic.service.MyFirebaseInstanceIDService
import com.project.testappgrowponic.util.FirestoreUtil
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private  val RC_SIGN_IN = 1

    private val signInProviders =
        listOf(AuthUI.IdpConfig.EmailBuilder()
            .setAllowNewAccounts(true)
            .setRequireName(true)
            .build())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        account_sign_in.setOnClickListener {
            val intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(signInProviders)
                .setLogo(R.mipmap.ic_launcher_growponic)
                .setIsSmartLockEnabled(true)
                .setTheme(R.style.SignInTheme)
                .build()
            startActivityForResult(intent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN){
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK){

                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Menyiapkan akun anda")
                progressDialog.setCancelable(false)
                progressDialog.show()

                FirestoreUtil.initCurrentUserIfFirstTime {
                    val intent =Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

                    FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
                        val registrationToken = it.token
                        MyFirebaseInstanceIDService.addTokenToFirestore(registrationToken)
                    }

                    startActivity(intent)
                    progressDialog.dismiss()
                }
            }
            else if (resultCode == Activity.RESULT_CANCELED){
                if (response == null) return

                when (response.error?.errorCode){
                    ErrorCodes.NO_NETWORK ->
                        Toast.makeText(this, "Periksa Koneksi Internet Anda", Toast.LENGTH_SHORT).show()
                    ErrorCodes.UNKNOWN_ERROR ->
                        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

package com.example.firstdemoproject

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.storage.StorageManager
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile
import com.anggrayudi.storage.SimpleStorageHelper
import com.anggrayudi.storage.callback.FolderPickerCallback
import com.anggrayudi.storage.file.DocumentFileCompat
import com.anggrayudi.storage.file.DocumentFileType
import com.anggrayudi.storage.file.FileFullPath
import com.anggrayudi.storage.file.StorageType
import com.anggrayudi.storage.file.child
import com.anggrayudi.storage.file.findFolder
import com.example.firstdemoproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.io.File
import kotlin.concurrent.thread

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getActivityView()=ActivityMainBinding.inflate(layoutInflater)

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun initViews(savedInstanceState: Bundle?) {
         val storageHelper = SimpleStorageHelper(this)
        val file= FileFullPath(this,"/storage/emulated/0/Android/media")
        binding.accessPermission.setOnClickListener {
//            askPermission("Android%2Fmedia",1001)
            storageHelper.openFolderPicker(1001,initialPath = file)
        }
        binding.isWhatsappFoundPermission.setOnClickListener {
            val grantedPaths = DocumentFileCompat.getAccessibleAbsolutePaths(this)
            val path = grantedPaths.values.firstOrNull()?.firstOrNull() ?: return@setOnClickListener
            val folder = DocumentFileCompat.fromFullPath(this, path, requiresWriteAccess = true)
            var b =DocumentFileCompat.fromFile(this, File(path+"/com.whatsapp/WhatsApp/Media/WhatsApp Images"), requiresWriteAccess = false)
           var a= DocumentFileCompat.fromFullPath(this,path+"/com.whatsapp/WhatsApp/Media/", documentType = DocumentFileType.ANY, requiresWriteAccess = false)
            var accessedPath=SharePerferenceClass.getAndroidMedia(this)
            Log.d("de_file", "initViews: accessed path $accessedPath+%2Fcom.whatsapp%2FWhatsApp%2FMedia")
            Log.d("de_file", "initViews: uri of a is ${a?.uri}")
            val uriParse = Uri.parse("$accessedPath%2Fcom.whatsapp%2FWhatsApp%2FMedia")
            val documentFile = DocumentFile.fromTreeUri(this, uriParse)
//            val documentFile = uriParse?.let { it1 -> DocumentFile.fromTreeUri(this, it1) }
            val statusFolder = documentFile?.findFolder(".Statuses")
            Log.d("de_file", "initViews: ${statusFolder?.listFiles()?.size}")
            Toast.makeText(this, "toast 1", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "toast 2 in bug fixing branch",Toast.LENGTH_SHORT).show()

            ExternalMethods.showToast(this,"master toast")
            ExternalMethods.showToast(this,"new tech toast")
            ExternalMethods.showToast(this,"alpha toast")
            ExternalMethods.showToast(this,"pull code")

        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("check_dir", "onResume: run requestPermission Result $requestCode" )
        try {
            if (resultCode == AppCompatActivity.RESULT_OK) {
//                statusMethods.run++
                Toast.makeText(this, "Grant", Toast.LENGTH_SHORT).show()
                val dataUri = data?.data
//                logD("dataUri is: "+dataUri.toString())
                SharePerferenceClass.setAndroidMedia(this, dataUri.toString())
                if (dataUri.toString() == "content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fmedia") {
                    contentResolver.takePersistableUriPermission(
                        dataUri!!,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    )
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
//                    startActivity(Intent(this,ScopePermissionDeniedActivity::class.java))
//                    finish()
                }
            }
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

}
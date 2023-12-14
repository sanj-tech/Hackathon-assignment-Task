package com.example.digitalflakedemo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmationDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       return activity.let {
           val alertDialog=AlertDialog.Builder(it)
           alertDialog.setView(requireActivity().layoutInflater.inflate(R.layout.confirmation_dialog,null))
           alertDialog.setPositiveButton("",DialogInterface.OnClickListener({dialog,id->

           }))
           alertDialog.create()
       }?:throw java.lang.IllegalStateException("Activity is null")

    }
    }


package com.progressdialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ProgressDialog : Dialog {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, theme: Int) : super(context!!, theme) {}

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val imageView =
            findViewById<View>(R.id.spinnerImageView) as ImageView
        val spinner = imageView.background as AnimationDrawable
        spinner.start()
    }

    fun setMessage(message: CharSequence?) {
        if (message != null && message.length > 0) {
            findViewById<View>(R.id.message).visibility = View.VISIBLE
            val txt = findViewById<View>(R.id.message) as TextView
            txt.text = message
            txt.invalidate()
        }
    }

    companion object {
        fun show(
            context: Context?,
            message: CharSequence?,
            indeterminate: Boolean,
            cancelable: Boolean,
            cancelListener: DialogInterface.OnCancelListener?
        ): ProgressDialog {
            val dialog = ProgressDialog(
                context,
                R.style.ProgressDialog
            )
            dialog.setTitle("")
            dialog.setContentView(R.layout.progress_dialog)
            if (message == null || message.length == 0) {
                dialog.findViewById<View>(R.id.message).visibility = View.GONE
            } else {
                val txt = dialog.findViewById<View>(R.id.message) as TextView
                txt.text = message
            }
            dialog.setCancelable(cancelable)
            dialog.setOnCancelListener(cancelListener)
            dialog.window!!.attributes.gravity = Gravity.CENTER
            val lp = dialog.window!!.attributes
            lp.dimAmount = 0.2f
            dialog.window!!.attributes = lp
            //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            dialog.show()
            return dialog
        }

        fun show(
            context: Context?,
            message: CharSequence?,
            cancelable: Boolean
        ): ProgressDialog {
            val dialog = ProgressDialog(
                context,
                R.style.ProgressDialog
            )
            dialog.setTitle("")
            dialog.setContentView(R.layout.progress_dialog)
            if (message == null || message.length == 0) {
                dialog.findViewById<View>(R.id.message).visibility = View.GONE
            } else {
                val txt = dialog.findViewById<View>(R.id.message) as TextView
                txt.text = message
            }
            dialog.setCancelable(cancelable)
            dialog.window!!.attributes.gravity = Gravity.CENTER
            val lp = dialog.window!!.attributes
            lp.dimAmount = 0.2f
            dialog.window!!.attributes = lp
            //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
            dialog.show()
            return dialog
        }
    }
}
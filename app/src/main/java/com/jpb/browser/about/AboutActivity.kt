package com.jpb.browser.about

import com.jpb.browser.R
import android.widget.ImageView
import android.widget.TextView
import com.drakeet.about.*
import com.jpb.browser.BuildConfig


class AboutActivity : AbsAboutActivity() {
    override fun onCreateHeader(icon: ImageView, slogan: TextView, version: TextView) {
        icon.setImageResource(R.mipmap.ic_launcher)
        slogan.text = getString(R.string.app_name)
        version.text = BuildConfig.VERSION_NAME
    }

    override fun onItemsCreated(items: MutableList<Any>) {
        items.add(Category("About App"))
        items.add(Card("A simple web browser for Android, based on the Jelly browser from LineageOS\n" +
                "Jelly Browser source: https://github.com/LineageOS/android_packages_apps_Jelly/tree/lineage-19.0"))
        items.add(Category("Developers"))
        items.add(
            Contributor(
                R.drawable.jpb,
                "jpb",
                "Developer",
                "https://occoam.com/jpb"
            )
        )
        items.add(Contributor(R.drawable.lineage, "The LineageOS Project", "Original app's developers", "https://lineageos.org/"))
    }
}
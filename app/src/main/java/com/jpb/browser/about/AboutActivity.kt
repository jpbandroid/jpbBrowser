package com.jpb.browser.about

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.jpb.browser.R
import android.widget.ImageView
import android.widget.TextView
import com.drakeet.about.*
import com.jpb.browser.BuildConfig
import com.jpb.browser.oss.license.OSSLicense


class AboutActivity : AbsAboutActivity() {
    override fun onCreateHeader(icon: ImageView, slogan: TextView, version: TextView) {
        icon.setImageResource(R.mipmap.ic_launcher)
        setHeaderBackground(R.color.colorAccent)
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.osslicense) {
            val intent = Intent(applicationContext, OSSLicense::class.java)
            startActivity(intent)
            return true
        }
        return false
    }
}
/*
 * Copyright (C) 2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jpb.browser.favorite

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jpb.browser.MainActivity
import com.jpb.browser.R
import com.jpb.browser.utils.UiUtils

class FavoriteHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mCard: CardView = view.findViewById(R.id.row_favorite_card)
    private val mTitle: TextView = view.findViewById(R.id.row_favorite_title)
    fun bind(context: Context, id: Long, title: String?, url: String, color: Int) {
        val adjustedTitle = if (title.isNullOrEmpty()) {
            url.split("/").toTypedArray()[2]
        } else {
            title
        }
        mTitle.text = adjustedTitle
        mTitle.setTextColor(if (UiUtils.isColorLight(color)) Color.BLACK else Color.WHITE)
        mCard.setCardBackgroundColor(color)
        mCard.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }
        mCard.setOnLongClickListener {
            (context as FavoriteActivity).editItem(id, adjustedTitle, url)
            true
        }
    }

}
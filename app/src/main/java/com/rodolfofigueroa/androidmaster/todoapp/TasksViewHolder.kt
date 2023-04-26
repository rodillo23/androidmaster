package com.rodolfofigueroa.androidmaster.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rodolfofigueroa.androidmaster.R

class TasksViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val cbTask:CheckBox = view.findViewById(R.id.cbTask)
    private val tvTask:TextView = view.findViewById(R.id.tvTask)

    fun render(task:Task){

        tvTask.text = task.name
        cbTask.isChecked = task.isSelected

        val color = when(task.category){
            TaskCategory.Business -> R.color.todoAppbusiness_category
            TaskCategory.Other -> R.color.todoAppOther_category
            TaskCategory.Personal -> R.color.todoAppPersonal_category
            TaskCategory.Technology -> R.color.todoAppTechnology_category
        }

        cbTask.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbTask.context, color))

        if (task.isSelected){
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }


    }
}
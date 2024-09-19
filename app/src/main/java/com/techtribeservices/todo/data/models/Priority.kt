package com.techtribeservices.todo.data.models

import androidx.compose.ui.graphics.Color
import com.techtribeservices.todo.ui.theme.HighPriorityColor
import com.techtribeservices.todo.ui.theme.LowPriorityColor
import com.techtribeservices.todo.ui.theme.MediumPriorityColor
import com.techtribeservices.todo.ui.theme.NonePriorityColor

enum class Priority(val color:Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
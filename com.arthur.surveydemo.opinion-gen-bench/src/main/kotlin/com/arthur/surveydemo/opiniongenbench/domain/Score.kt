package com.arthur.surveydemo.opiniongenbench.domain

enum class Score {
    BAD, NOTSOBAD, OK, GREAT;

    companion object {
        private val values = values();
        fun getByValue(value: Int) = values.firstOrNull { it.ordinal == value }
    }
}
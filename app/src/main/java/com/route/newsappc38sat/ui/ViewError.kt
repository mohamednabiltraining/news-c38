package com.route.newsappc38sat.ui


data class ViewError(
    val message: String? = null,
    val throwable: Throwable? = null,
    val onTryAgainClickListener: OnTryAgainClickListener? = null
)

fun interface OnTryAgainClickListener {
    fun onTryAgainClick()
}
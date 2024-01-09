package com.example.youpage_api

data class MoreItems(
    var img:String ?=null,
    var title :String ?=null,
    var guest_user_title :String?=null,
    var actionPage :String ?=null,
    var actionUrl :String ?=null,
    var dialogTabs :List<MoreDialogues>?=null
)

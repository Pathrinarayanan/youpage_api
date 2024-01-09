package com.example.youpage_api

data class Items(
    var img:String ?=null,
    var title :String?=null,
    var type:String ?=null,
    var contentType :String ?=null,
    var items:List<MoreItems>?=null
)

package com.prasant.assignment

data class LiveMatch(
    var firstTeam:String? = null,
    var firstLogo:Int = -1,
    var firstScore:Int = 0,
    var secondTeam:String? = null,
    var secondLogo:Int = -1,
    var secondScore:Int = 0,
    var time:String? = null
)

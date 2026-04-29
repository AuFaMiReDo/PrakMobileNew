package com.example.hunternotesmodul3

import androidx.lifecycle.ViewModel

class MonsterViewModel : ViewModel() {
    val monsterList = listOf(
        Monster(1, "Nargacuga", "Flying Wyvern", "Beradaptasi di area hutan lebat, bergerak seperti macan kumbang, dan menyerang dengan sayap setajam pisau.", R.drawable.nargacuga, "https://monsterhunter.fandom.com/wiki/Nargacuga"),
        Monster(2, "Tigrex", "Flying Wyvern", "Wyvern prasejarah yang sangat agresif. Terkenal dengan serudukan beruntunnya yang cepat dan raungan yang mematikan.", R.drawable.tigrex, "https://monsterhunter.fandom.com/wiki/Tigrex"),
        Monster(3, "Rathalos", "Flying Wyvern", "Dikenal sebagai 'Raja Langit'. Rathalos adalah predator yang menyerang dengan cakar beracun dan semburan api.", R.drawable.rathalos, "https://monsterhunter.fandom.com/wiki/Rathalos"),
        Monster(4, "Rajang", "Fanged Beast", "Monster berlengan besar yang brutal. Rajang bisa menembakkan sinar petir dan berubah menjadi mode keemasan.", R.drawable.rajang, "https://monsterhunter.fandom.com/wiki/Rajang"),
        Monster(5, "Fatalis", "Elder Dragon", "Naga Hitam legendaris yang menghancurkan kerajaan kuno dalam semalam. Keberadaannya dianggap mitos.", R.drawable.fatalis, "https://monsterhunter.fandom.com/wiki/Fatalis")
    )
}
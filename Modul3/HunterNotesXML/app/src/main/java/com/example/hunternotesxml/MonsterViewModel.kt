package com.example.hunternotesxml

import androidx.lifecycle.ViewModel

class MonsterViewModel : ViewModel() {
    val monsterList = listOf(
        Monster(
            id = 1,
            name = "Nargacuga",
            species = "Flying Wyvern",
            description = "Beradaptasi di area hutan lebat, bergerak seperti macan kumbang, dan menyerang dengan sayap setajam pisau.",
            imageResId = R.drawable.nargacuga,
            wikiUrl = "https://monsterhunter.fandom.com/wiki/Nargacuga"
        ),
        Monster(
            id = 2,
            name = "Tigrex",
            species = "Flying Wyvern",
            description = "Wyvern prasejarah yang sangat agresif. Terkenal dengan serudukan beruntunnya yang cepat dan raungan yang mematikan.",
            imageResId = R.drawable.tigrex,
            wikiUrl = "https://monsterhunter.fandom.com/wiki/Tigrex"
        ),
        Monster(
            id = 3,
            name = "Rathalos",
            species = "Flying Wyvern",
            description = "Dikenal sebagai 'Raja Langit'. Rathalos adalah predator yang menyerang dengan cakar beracun dan semburan api.",
            imageResId = R.drawable.rathalos,
            wikiUrl = "https://monsterhunter.fandom.com/wiki/Rathalos"
        ),
        Monster(
            id = 4,
            name = "Rajang",
            species = "Fanged Beast",
            description = "Monster berlengan besar yang brutal. Rajang bisa menembakkan sinar petir dan berubah menjadi mode keemasan.",
            imageResId = R.drawable.rajang,
            wikiUrl = "https://monsterhunter.fandom.com/wiki/Rajang"
        ),
        Monster(
            id = 5,
            name = "Fatalis",
            species = "Elder Dragon",
            description = "Naga Hitam legendaris yang menghancurkan kerajaan kuno dalam semalam. Keberadaannya dianggap mitos.",
            imageResId = R.drawable.fatalis,
            wikiUrl = "https://monsterhunter.fandom.com/wiki/Fatalis"
        )
    )
}
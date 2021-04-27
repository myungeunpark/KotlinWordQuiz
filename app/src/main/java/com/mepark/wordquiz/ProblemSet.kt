package com.mepark.wordquiz

import android.databinding.tool.Context.init

class ProblemSet {

    private var list = ArrayList<Problem>()
    private var inx = 0
    init {

        val ans1 = ArrayList<String>()
        ans1.add("Singer")
        ans1.add("Celebrity")
        ans1.add("Artist")
        ans1.add("Audience")
        val problem1 = Problem("Celebrity",
                        "a famous person, the state of being well known.", R.drawable.celebrity, ans1)
        list.add(problem1)


        val ans2 = ArrayList<String>()
        ans2.add("Estimate")
        ans2.add("Observe")
        ans2.add("Instruct")
        ans2.add("Measure")
        val problem2 = Problem("Measure",
            "ascertain the size, amount by using an instrument.", R.drawable.measure, ans2)
        list.add(problem2)

        val ans3 = ArrayList<String>()
        ans3.add("Fat")
        ans3.add("Curious")
        ans3.add("Adorable")
        ans3.add("Kind")
        val problem3 = Problem("Adorable",
            "inspiring great affection; delightful; charming.", R.drawable.adorable, ans3)
        list.add(problem3)

        val ans4 = ArrayList<String>()
        ans4.add("Identical")
        ans4.add("Different")
        ans4.add("Various")
        ans4.add("Special")
        val problem4 = Problem("Identical",
            "similar in every detail; exactly alike.", R.drawable.identical, ans4)
        list.add(problem4)

        val ans5 = ArrayList<String>()
        ans5.add("Interesting")
        ans5.add("Boring")
        ans5.add("Special")
        ans5.add("Marvelous")
        val problem5 = Problem("Marvelous",
            "causing great wonder; extraordinary.", R.drawable.marvelous, ans5)
        list.add(problem5)

        val ans6 = ArrayList<String>()
        ans6.add("Daybreak")
        ans6.add("Evening")
        ans6.add("Afternoon")
        ans6.add("Noon")
        val problem6 = Problem("Daybreak",
            "the time in the morning when daylight first appears", R.drawable.daybreak, ans6)
        list.add(problem6)

    }

    fun getNext() : Problem {

        inx += 1
        return list.get(inx)
    }

    fun getSize() : Int {

        return list.size
    }
    fun isNext() : Boolean {
        return (inx <= 5) && (inx >= 0)
    }

    fun getIndex() : Int {
        return inx
    }

    fun getFirst() : Problem {

        inx = 0
        return list.get(inx)
    }
}
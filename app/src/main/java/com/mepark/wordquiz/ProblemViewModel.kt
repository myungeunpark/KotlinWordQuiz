package com.mepark.wordquiz

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ProblemViewModel : ViewModel() {

    private val problemSet = ProblemSet()
    private val TAG : String  = ProblemViewModel::class.java.simpleName

    var currentScore : MutableLiveData<Int> = MutableLiveData()
    var currentProblem : MutableLiveData<Problem> = MutableLiveData()
    var currentIndex : MutableLiveData<Int> = MutableLiveData()

    // Countdown time
    val currentTime = MutableLiveData<Long>()
    private val timer: CountDownTimer

    companion object{

        // Time when the game is over
        private const val DONE = 0L
        // Countdown time interval
        private const val ONE_SECOND = 1000L
        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L
    }

    init{

        Log.i(TAG, "init construction of WordQuizViewModel is called")

        currentScore.value = 0
        currentIndex.value = problemSet.getIndex() + 1
        currentProblem.value = problemSet.getFirst()
        currentTime.value = COUNTDOWN_TIME/ONE_SECOND

        // Creates a timer which triggers the end of the game when it finishes
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                currentTime.value = millisUntilFinished/ONE_SECOND
            }

            override fun onFinish() {
                currentTime.value = DONE

                // game finished
            }
        }
        timer.start()

    }



    // The String version of the current time
    val countDownString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    override fun onCleared() {
        super.onCleared()

        // timer clear
        timer.cancel()
        Log.i(TAG, "onCleared() is called")
    }

    fun MoveNextProblem(ans : String) : Boolean {

        if(ans == currentProblem.value?.word){
            currentScore.value =  currentScore.value?.plus(1)
        }

        currentIndex.value = problemSet.getIndex() + 1
        if(currentIndex.value == problemSet.getSize())
            return true

        currentProblem.value = problemSet.getNext()
        currentIndex.value = problemSet.getIndex()
        return false;
    }

}
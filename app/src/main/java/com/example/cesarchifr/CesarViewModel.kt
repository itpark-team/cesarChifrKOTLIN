package com.example.cesarchifr

import android.view.View
import androidx.databinding.ObservableField
import java.lang.StringBuilder

class CesarViewModel {
    private var alphabet: CharRange = 'a'..'z'

    var fieldText: ObservableField<String> = ObservableField("")
    var fieldKey: ObservableField<String> = ObservableField("0")
    var fieldResult: ObservableField<String> = ObservableField("")

    fun encrypt() {
        var inputText = fieldText.get().toString()
        var key = fieldKey.get().toString().toInt()
        var stringBuilder = StringBuilder()

        for (i in inputText.indices) {
            var currentSymbol = inputText[i]
            var indexCurrentSymbol = alphabet.indexOf(currentSymbol)

            if (indexCurrentSymbol != -1) {
                var newIndex = (indexCurrentSymbol + key) % alphabet.count()
                //a - 0
                //key - 27
                //z - 25
                //0 - 52 % 26
                //0%26 = 0
                //25%26 = 25
                //26%26 = 0
                //27%26 = 1
                //50%26 = 24
                //51%26 = 25
                //52%26 = 0
                //0..25

                //abz
                //01 25
                //12 0
                //bca


                stringBuilder.append(alphabet.elementAt(newIndex))
            } else {
                stringBuilder.append(currentSymbol)
            }
        }

        fieldResult.set(stringBuilder.toString())
    }

    fun decrypt() {
        var inputText = fieldText.get().toString()
        var key = fieldKey.get().toString().toInt()
        var stringBuilder = StringBuilder()

        for (i in inputText.indices) {
            var currentSymbol = inputText[i]
            var indexCurrentSymbol = alphabet.indexOf(currentSymbol)

            if (indexCurrentSymbol != -1) {
                var newIndex =
                    ((indexCurrentSymbol - key) % alphabet.count() + alphabet.count()) % alphabet.count()

                //var newIndex = Math.floorMod(indexCurrentSymbol - key, alphabet.count())

                //acd
                //023
                //-112
                //+ 26
                //25 27 28
                //%26
                //25 1 2
                //zbc

                stringBuilder.append(alphabet.elementAt(newIndex))
            } else {
                stringBuilder.append(currentSymbol)
            }
        }

        fieldResult.set(stringBuilder.toString())
    }

}
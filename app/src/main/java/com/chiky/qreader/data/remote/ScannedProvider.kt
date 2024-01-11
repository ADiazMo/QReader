package com.chiky.qreader.data.remote

import com.chiky.qreader.data.model.Scanned

class ScannedProvider {
    companion object{
        val scannedList = listOf<Scanned>(
            Scanned(1,"titulo 1","data 1"),
            Scanned(2,"titulo 2","data 2")
        )
    }
}
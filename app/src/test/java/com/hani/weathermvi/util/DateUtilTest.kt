package com.hani.weathermvi.util

import com.hani.weathermvi.TestMockData
import org.junit.Assert
import org.junit.Test
import java.util.*

class DateUtilTest {

    @Test
    fun ` Current Data - formatDate - not Null `() {

        // arrange
        val currentTime = Date()

        //Arrange
        val newFormattedDate = DateUtil.formatDate(currentTime)

        //Assert
        Assert.assertNotNull(newFormattedDate)
    }


    @Test
    fun ` CurrentDate- newDataFormat - returnCorrectFormat `() {

        // arrange
        val currentFormattedDate = DateUtil.formatDate(Date())

        //Arrange
        val newFormattedDate = DateUtil.getCurrentDate()

        //Assert
        Assert.assertEquals(currentFormattedDate, newFormattedDate)
    }


    @Test(expected = Exception::class)
    fun ` testDayName - WrongDate - throwException `() {

        // arrange
        val stringDate = ""

        //Arrange
        DateUtil.getDayName(stringDate)

        //Assert
        //ThrowException
    }

    @Test
    fun ` convertTimestamp - DateFormat - returnNewDate `() {

        // arrange
        val timeStamp = TestMockData.TIMESTAMP_1

        //Arrange
        val convertedDate = DateUtil.getDateStringFormat(timeStamp)

        //Assert
        Assert.assertEquals(convertedDate, TestMockData.CONVERTED_TIMESTAMP)
    }
}
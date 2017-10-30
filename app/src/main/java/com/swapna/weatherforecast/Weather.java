package com.swapna.weatherforecast;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by swapna on 30/10/2017.
 */

public class Weather  {
        public final String dayOfWeek;
        public final String minTemp;
        public final String maxTemp;
        public final String humidity;
        public final String description;
        public final String iconURL;

        // constructor
        public Weather(long timeStamp, double minTemp, double maxTemp,
                       double humidity, String description, String iconName) {
            // NumberFormat to format double temperatures rounded to integers
            // ADD YOUR CODE HERE
            this.dayOfWeek = convertTimeStampToDay(timeStamp);
            this.minTemp = NumberFormat.getIntegerInstance().format(minTemp);
            this.maxTemp = NumberFormat.getIntegerInstance().format(maxTemp);
            this.humidity = NumberFormat.getPercentInstance().format(humidity/100);
            this.description = description;
            this.iconURL = "http://api.openweathermap.org/img/w/"+iconName;
            // END YOUR CODE HERE
        }

        // convert timestamp to a day's name (e.g., Monday, Tuesday, ...)
        private static String convertTimeStampToDay(long timeStamp) {
            Calendar calendar = Calendar.getInstance(); // create Calendar
            calendar.setTimeInMillis(timeStamp * 1000); // set time
            TimeZone tz = TimeZone.getDefault(); // get device's time zone
            calendar.add(Calendar.MILLISECOND,
                    tz.getOffset(calendar.getTimeInMillis()));

            // SimpleDateFormat that returns the day's name
            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
            return dateFormatter.format(calendar.getTime());
        }
}

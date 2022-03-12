package utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtil {

    public static LocalDate generateValidDate(LocalDate start, long agePassVal) {
        long startEpochDay = start.toEpochDay();
        long endEpochDay = LocalDate.now().minusYears(agePassVal).toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

}

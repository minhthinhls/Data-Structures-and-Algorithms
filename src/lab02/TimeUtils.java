/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Minh Thinh
 */
public class TimeUtils {

    public static long now() {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        return currentDate.getTime();
    }
}

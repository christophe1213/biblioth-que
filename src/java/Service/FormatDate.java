/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author Thierry Christophe
 */
public class FormatDate {
    public  static String formatDMMMyyy(LocalDateTime d){
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("d MMMM yyyy",Locale.FRENCH);
        return d.format(formater);
    }
    
    public static String formatDDMMyyyy(LocalDateTime d){
         DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return d.format(formater);
    }
    public static String formatDDMMyyyy(LocalDate d){
       DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return d.format(formater);
    }
    public static String formatDMMMyyy(LocalDate d){
        LocalDateTime dt= d.atStartOfDay();
        return formatDMMMyyy(dt);
    }
    
    public static String differrenceDay(LocalDate d){
        return ChronoUnit.DAYS.between(d,LocalDate.now())+" jours";
    }
    
    
}

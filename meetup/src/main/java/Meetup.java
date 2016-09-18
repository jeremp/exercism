
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;


/**
 *
 * @author jeremp
 */
public class Meetup {

    private int year ;
    private int month ;

    public Meetup(int month, int year) {
        this.year = year;
        this.month = month;
    }
    
    public DateTime day(int dateTimeConstants, MeetupSchedule ms){
        DateTime dateTime = new DateTime(year, month, 1, 0, 0);
        dateTime = dateTime.dayOfWeek().setCopy(dateTimeConstants);
        for (int i = 1; i < 10; i++) {
            dateTime = dateTime.weekOfWeekyear().addToCopy(i);
            if (MeetupSchedule.TEENTH.equals(ms) && isTeenth(dateTime)) {
                break;
            }else if(MeetupSchedule.FIRST.equals(ms) && isFirst(dateTime)){
                break;
            }
        }
        return dateTime;


    }
    
    private boolean isTeenth(DateTime dateTime){
        return dateTime!=null && dateTime.dayOfMonth().get() >= 10 && dateTime.dayOfMonth().get() <20 ;
    }
    
    private boolean isFirst(DateTime dateTime/*, int dateTimeConstants*/){
        if(dateTime!=null){
            return dateTime.dayOfYear().addToCopy(-7).getMonthOfYear() != dateTime.getMonthOfYear();
        }else{
            return false ; 
        }
    }
    
}

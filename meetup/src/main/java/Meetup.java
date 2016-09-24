
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
        if(dateTime.getMonthOfYear() < month){
            dateTime = dateTime.weekOfWeekyear().addToCopy(1);
        }else if(dateTime.getMonthOfYear() > month){
            dateTime = dateTime.weekOfWeekyear().addToCopy(-1);
        }
        for (int i = 1; i < 5; i++) {            
            if (MeetupSchedule.TEENTH.equals(ms) && isTeenth(dateTime)) {
                break;
            }else if(MeetupSchedule.FIRST.equals(ms) && isFirst(dateTime)){
                break;
            }else if(MeetupSchedule.LAST.equals(ms) && isLast(dateTime)){
                break;
            }else if(MeetupSchedule.SECOND.equals(ms) && isSecond(dateTime)){
                break;
            }else if(MeetupSchedule.THIRD.equals(ms) && isThird(dateTime)){
                break;
            }else if(MeetupSchedule.FOURTH.equals(ms) && isFourth(dateTime)){
                break;
            }
            dateTime = dateTime.weekOfWeekyear().addToCopy(1);
        }
        return dateTime;


    }
    
    private boolean isTeenth(DateTime dateTime){
        return dateTime!=null && dateTime.dayOfMonth().get() >= 13 && dateTime.dayOfMonth().get() <20 ;
    }
    
    private boolean isFirst(DateTime dateTime/*, int dateTimeConstants*/){
        if(dateTime!=null){
            return dateTime.dayOfYear().addToCopy(-7).getMonthOfYear() != dateTime.getMonthOfYear();
        }else{
            return false ; 
        }
    }
    
    private boolean isSecond(DateTime dateTime/*, int dateTimeConstants*/){
        if(dateTime!=null){
            return (dateTime.dayOfYear().addToCopy(-7).getMonthOfYear() == dateTime.getMonthOfYear())
                    &&((dateTime.dayOfYear().addToCopy(-14).getMonthOfYear() != dateTime.getMonthOfYear()));
        }else{
            return false ; 
        }
    }
    
    private boolean isThird(DateTime dateTime/*, int dateTimeConstants*/){
        if(dateTime!=null){
            return (dateTime.dayOfYear().addToCopy(-14).getMonthOfYear() == dateTime.getMonthOfYear())
                    &&((dateTime.dayOfYear().addToCopy(-21).getMonthOfYear() != dateTime.getMonthOfYear()));
        }else{
            return false ; 
        }
    }
    
    private boolean isFourth(DateTime dateTime/*, int dateTimeConstants*/){
        if(dateTime!=null){
            return (dateTime.dayOfYear().addToCopy(-21).getMonthOfYear() == dateTime.getMonthOfYear())
                    &&((dateTime.dayOfYear().addToCopy(-28).getMonthOfYear() != dateTime.getMonthOfYear()));
        }else{
            return false ; 
        }
    }

    private boolean isLast(DateTime dateTime){
        if(dateTime!=null){
            return dateTime.dayOfYear().addToCopy(7).getMonthOfYear() != dateTime.getMonthOfYear();
        }else{
            return false ; 
        }
    }
    
}

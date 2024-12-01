public class HistoricalEvent {
    /****CONSTANTS***/
    public static final String DEFAULT_DESCRIPTION = "Historial event descritpion default";
    public static final Date DEFAULT_EVENT_DAY = new Date();

    /****INSTANCE VARIABLES***/
    private String description;
    private Date eventDay;

    /****SETTERS / MUTATORS***/
    //Sets description instance variables
    //No error checking except for null
    public boolean setDescription(String description) {
        if (description != null) {
            this.description = description;
            return true;
        } else {
            return false;
        }
    }

    public boolean setEventDay(Date eventDay) {
        if(eventDay != null) {
            this.eventDay = new Date(eventDay); //Dont forget to deep copy!!
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(String description, Date eventDay) {
        return this.setDescription(description) && this.setEventDay(eventDay);
    }

/*****Constructors*****/
    //Full constructor
    //Sets object to parameter values if valid, otherwise outputs error and exists program
    public HistoricalEvent(String description, Date eventDay) {
        if(!this.setAll(description, eventDay)) {
            System.out.println("ERROR: bad data given to full constructor");
            System.exit(0);
        }
    }
    //DEFAULT CONSTUCTOR
    //Sets HistoricalEvent object to default values
    public HistoricalEvent() {
        this(DEFAULT_DESCRIPTION, DEFAULT_EVENT_DAY);
    }

    //COPY CONSTRUCTOR
    //If object null outputs error message and ends program
    //Original vaild HistoricalEvent object to deep copy
    public HistoricalEvent(HistoricalEvent original) {
        if(original != null) {
            System.out.println("ERROR: null data given to copy constructor");
            System.exit(0);
        }
    }

    /***** GETTERS / ACCESSORS *****/
    public String getDescription() {
        return this.description;
    }

    public Date getEventDay() {
        return new Date(this.eventDay);
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        } else if(!(other instanceof HistoricalEvent)) {
            return false;
        } else {
            HistoricalEvent otherEvent = (HistoricalEvent) other;
            return this.description.equals(otherEvent.description) && this.eventDay.equals(otherEvent.eventDay);
        }
    }

    /****OTHER REQUIRED METHODS***/
    @Override
    public String toString() {
        return "On " + this.eventDay + ": " + this.description;
    }
}

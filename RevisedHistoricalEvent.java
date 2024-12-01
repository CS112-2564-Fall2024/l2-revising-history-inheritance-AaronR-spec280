public class RevisedHistoricalEvent extends HistoricalEvent {
    /****CONSTANTS***/
    public static final String DEFAULT_REVISED_DESCRIPTION = "Revised historial event descritpion default";
    public static final String DEFAULT_CITATION = "Academic resource.citation.";

    /****INSTANCE VARIABLES***/
    private String revisedDescription;
    private String citation;

    /***** CONSTRUCTORS *****/
    //Full Constructor
    public RevisedHistoricalEvent(String description, Date eventDay, String revisedDescription, String citation) {
        super(description, eventDay);
        this.setRevisedDescription(revisedDescription);
        this.setCitation(citation);
    }

    //Default Constructor
    public RevisedHistoricalEvent() {
        this(HistoricalEvent.DEFAULT_DESCRIPTION, HistoricalEvent.DEFAULT_EVENT_DAY, DEFAULT_REVISED_DESCRIPTION, DEFAULT_CITATION);
    }

    /***** SETTERS / MUTATORS *****/
    public void setRevisedDescription(String revisedDescription) {
        this.revisedDescription = revisedDescription;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public boolean setAll(String description, Date eventDay, String revisedDescription, String citation) {
        if(super.setAll(description, eventDay)) {
            this.setRevisedDescription(revisedDescription);
            this.setCitation(citation);
            return true;
        } else {
            return false;
        }
    }

    /***** GETTERS / ACCESSORS *****/

    public String getRevisedDescription() {
        return this.revisedDescription;
    }

    public String getCitation() {
            return this.citation;
        }

    /****OTHER REQUIRED METHODS***/
    @Override
    public String toString() {
        //return super.toString() + "\nRevised Historical Event: " + this.revisedDescription + "\nCitation/Resource: " + this.citation;
        return "the following \"history\" was told for many years:\n\n" + super.toString() + "\n\nBy correcting history, not just rewriting it, we are revising it to embark on the process of righting a wrong.\nHere is the revised history:\n" + this.revisedDescription + "\n\nSource: " + this.citation;

    }

    @Override
            public boolean equals(Object other) {
        if(other == null) {
            return false;
        } else if(this.getClass() != other.getClass()) {
            return false;
        } else {
            RevisedHistoricalEvent otherEvent = (RevisedHistoricalEvent) other;
            return super.equals(other) &&
                    this.revisedDescription.equals(otherEvent.revisedDescription) && this.citation.equals(otherEvent.citation);
        }
    }

    public void teach() {
        System.out.println(this.toString());

        /*System.out.println("The following \"history\" was told for many years: \n\n" + super.toString());
        System.out.println("\n\nBy correcting history, not just rewriting it, we are revisiting it to embark on the process of righting a wrong. \nHere is te revised history: \n" + this.revisedDescription);
        System.out.println("\nSource: " + this.citation);*/
    }
}
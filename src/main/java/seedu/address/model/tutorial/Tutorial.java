package seedu.address.model.tutorial;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Tutorial in the ModQuik.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Tutorial {

    // Identity fields
    private final TutorialName name;
    private final TutorialModule module;
    private final TutorialVenue venue;
    private final TutorialDay day;

    //Data fields
    private final TutorialTimeslot timeslot;

    /**
     * Every field must be present and not null.
     */
    public Tutorial(TutorialName name, TutorialModule module, TutorialVenue venue,
                    TutorialTimeslot timeslot, TutorialDay day) {
        requireAllNonNull(name, module, venue, timeslot);
        this.name = name;
        this.module = module;
        this.venue = venue;
        this.timeslot = timeslot;
        this.day = day;
    }

    public TutorialName getName() {
        return name;
    }

    public TutorialModule getModule() {
        return module;
    }

    public TutorialVenue getVenue() {
        return venue;
    }

    public TutorialTimeslot getTimeslot() {
        return timeslot;
    }

    public TutorialDay getDay() {
        return day;
    }

    /**
     * Returns true if both tutorials have the same name.
     * This defines a weaker notion of equality between two tutorials.
     */
    public boolean isSameTutorial(Tutorial otherTutorial) {
        if (otherTutorial == this) {
            return true;
        }

        return otherTutorial != null
                && otherTutorial.getName().equals(getName());
    }

    /**
     * Returns true if both tutorials have the same venue and timeslot.
     */
    public boolean isClashTutorial(Tutorial otherTutorial) {
        if (otherTutorial == this) {
            return true;
        }

        return otherTutorial != null
                && otherTutorial.getVenue().equals(getVenue())
                && otherTutorial.getTimeslot().equals(getTimeslot());
    }

    /**
     * Returns true if both tutorials have the same identity and data fields.
     * This defines a stronger notion of equality between two tutorials.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return otherTutorial.getName().equals(getName())
                && otherTutorial.getModule().equals(getModule())
                && otherTutorial.getVenue().equals(getVenue())
                && otherTutorial.getTimeslot().equals(getTimeslot())
                && otherTutorial.getDay().equals(getDay());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, module, venue, timeslot, day);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Module: ")
                .append(getModule())
                .append("; Venue: ")
                .append(getVenue())
                .append("; Timeslot: ")
                .append(getTimeslot())
                .append("; Day: ")
                .append(getDay());

        return builder.toString();
    }

}

package com.example.tacochallenge;

public class FormattedDate {
    private final long id;
    private final String dateString;
    private final String pattern;

    public FormattedDate(final long id, final String pattern, final String dateString) {
        this.id = id;
        this.pattern = pattern;
        this.dateString = dateString;
    }

}

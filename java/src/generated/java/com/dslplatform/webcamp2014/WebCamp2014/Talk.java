package com.dslplatform.webcamp2014.WebCamp2014;

public class Talk implements java.io.Serializable {
    public Talk() {
        URI = java.util.UUID.randomUUID().toString();
        this.speakerID = "";
        this.title = "";
        this.track = com.dslplatform.webcamp2014.WebCamp2014.Track.Bitovi;
        this.description = "";
        this.startAt = org.joda.time.DateTime.now();
        this.endAt = org.joda.time.DateTime.now();
        this.DayScheduledate = org.joda.time.LocalDate.now();
        this.Index = 0;
    }

    private transient com.dslplatform.patterns.ServiceLocator _serviceLocator;

    private String URI;

    @com.fasterxml.jackson.annotation.JsonProperty("URI")
    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final Talk other = (Talk) obj;

        return URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return "Talk(" + URI + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    @com.fasterxml.jackson.annotation.JsonCreator
    private Talk(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("speakerURI") final String speakerURI,
            @com.fasterxml.jackson.annotation.JsonProperty("speakerID") final String speakerID,
            @com.fasterxml.jackson.annotation.JsonProperty("title") final String title,
            @com.fasterxml.jackson.annotation.JsonProperty("track") final com.dslplatform.webcamp2014.WebCamp2014.Track track,
            @com.fasterxml.jackson.annotation.JsonProperty("description") final String description,
            @com.fasterxml.jackson.annotation.JsonProperty("startAt") final org.joda.time.DateTime startAt,
            @com.fasterxml.jackson.annotation.JsonProperty("endAt") final org.joda.time.DateTime endAt,
            @com.fasterxml.jackson.annotation.JsonProperty("DayScheduledate") final org.joda.time.LocalDate DayScheduledate,
            @com.fasterxml.jackson.annotation.JsonProperty("Index") final int Index) {
        this._serviceLocator = _serviceLocator;
        this.URI = URI != null ? URI : new java.util.UUID(0L, 0L).toString();
        this.speakerURI = speakerURI;
        this.speakerID = speakerID == null ? "" : speakerID;
        this.title = title == null ? "" : title;
        this.track = track == null
                ? com.dslplatform.webcamp2014.WebCamp2014.Track.Bitovi
                : track;
        this.description = description == null ? "" : description;
        this.startAt = startAt == null ? new org.joda.time.DateTime(1, 1, 1, 0,
                0) : startAt;
        this.endAt = endAt == null
                ? new org.joda.time.DateTime(1, 1, 1, 0, 0)
                : endAt;
        this.DayScheduledate = DayScheduledate == null
                ? new org.joda.time.LocalDate(1, 1, 1)
                : DayScheduledate;
        this.Index = Index;
    }

    private com.dslplatform.webcamp2014.WebCamp2014.Speaker speaker;

    @com.fasterxml.jackson.annotation.JsonIgnore
    public com.dslplatform.webcamp2014.WebCamp2014.Speaker getSpeaker()
            throws java.io.IOException {
        if (speaker != null && !speaker.getURI().equals(speakerURI)
                || speaker == null && speakerURI != null)
            try {
                com.dslplatform.client.CrudProxy proxy = _serviceLocator
                        .resolve(com.dslplatform.client.CrudProxy.class);
                speaker = proxy.read(
                        com.dslplatform.webcamp2014.WebCamp2014.Speaker.class,
                        speakerURI).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return speaker;
    }

    public Talk setSpeaker(
            final com.dslplatform.webcamp2014.WebCamp2014.Speaker value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"speaker\" cannot be null!");

        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"WebCamp2014.Speaker\" for property \"speaker\" must be persisted before it's assigned");
        this.speaker = value;

        this.speakerID = value.getName();
        this.speakerURI = value.getURI();
        return this;
    }

    private String speakerURI;

    @com.fasterxml.jackson.annotation.JsonProperty("speakerURI")
    public String getSpeakerURI() {
        return this.speakerURI;
    }

    private String speakerID;

    @com.fasterxml.jackson.annotation.JsonProperty("speakerID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getSpeakerID() {
        return speakerID;
    }

    private Talk setSpeakerID(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"speakerID\" cannot be null!");
        this.speakerID = value;

        return this;
    }

    private String title;

    @com.fasterxml.jackson.annotation.JsonProperty("title")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getTitle() {
        return title;
    }

    public Talk setTitle(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"title\" cannot be null!");
        com.dslplatform.webcamp2014.Guards.checkLength(value, 80);
        this.title = value;

        return this;
    }

    private com.dslplatform.webcamp2014.WebCamp2014.Track track;

    @com.fasterxml.jackson.annotation.JsonProperty("track")
    public com.dslplatform.webcamp2014.WebCamp2014.Track getTrack() {
        return track;
    }

    public Talk setTrack(
            final com.dslplatform.webcamp2014.WebCamp2014.Track value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"track\" cannot be null!");
        this.track = value;

        return this;
    }

    private String description;

    @com.fasterxml.jackson.annotation.JsonProperty("description")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getDescription() {
        return description;
    }

    public Talk setDescription(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"description\" cannot be null!");
        this.description = value;

        return this;
    }

    private org.joda.time.DateTime startAt;

    @com.fasterxml.jackson.annotation.JsonProperty("startAt")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.DateTime getStartAt() {
        return startAt;
    }

    public Talk setStartAt(final org.joda.time.DateTime value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"startAt\" cannot be null!");
        this.startAt = value;

        return this;
    }

    private org.joda.time.DateTime endAt;

    @com.fasterxml.jackson.annotation.JsonProperty("endAt")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.DateTime getEndAt() {
        return endAt;
    }

    public Talk setEndAt(final org.joda.time.DateTime value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"endAt\" cannot be null!");
        this.endAt = value;

        return this;
    }

    private org.joda.time.LocalDate DayScheduledate;

    @com.fasterxml.jackson.annotation.JsonProperty("DayScheduledate")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.LocalDate getDayScheduledate() {
        return DayScheduledate;
    }

    public Talk setDayScheduledate(final org.joda.time.LocalDate value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"DayScheduledate\" cannot be null!");
        this.DayScheduledate = value;

        return this;
    }

    private int Index;

    @com.fasterxml.jackson.annotation.JsonProperty("Index")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getIndex() {
        return Index;
    }

    public Talk setIndex(final int value) {
        this.Index = value;

        return this;
    }

    public Talk(
            final com.dslplatform.webcamp2014.WebCamp2014.Speaker speaker,
            final String title,
            final com.dslplatform.webcamp2014.WebCamp2014.Track track,
            final String description,
            final org.joda.time.DateTime startAt,
            final org.joda.time.DateTime endAt) {
        setSpeaker(speaker);
        setTitle(title);
        setTrack(track);
        setDescription(description);
        setStartAt(startAt);
        setEndAt(endAt);
    }

}

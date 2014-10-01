package com.dslplatform.webcamp2014.WebCamp2014;

public class DaySchedule implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public DaySchedule() {
        URI = java.util.UUID.randomUUID().toString();
        this.date = org.joda.time.LocalDate.now();
        this.talks = new com.dslplatform.webcamp2014.WebCamp2014.Talk[] {};
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
        final DaySchedule other = (DaySchedule) obj;

        return URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return "DaySchedule(" + URI + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    @com.fasterxml.jackson.annotation.JsonCreator
    private DaySchedule(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("date") final org.joda.time.LocalDate date,
            @com.fasterxml.jackson.annotation.JsonProperty("talks") final com.dslplatform.webcamp2014.WebCamp2014.Talk[] talks) {
        this._serviceLocator = _serviceLocator;
        this.URI = URI != null ? URI : new java.util.UUID(0L, 0L).toString();
        this.date = date == null ? new org.joda.time.LocalDate(1, 1, 1) : date;
        this.talks = talks == null
                ? new com.dslplatform.webcamp2014.WebCamp2014.Talk[] {}
                : talks;
    }

    public boolean isNewAggregate() {
        return _serviceLocator == null;
    }

    public static DaySchedule find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static DaySchedule find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(DaySchedule.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<DaySchedule> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<DaySchedule> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(DaySchedule.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<DaySchedule> search()
            throws java.io.IOException {
        return search(null, null, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<DaySchedule> search(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(null, null, locator);
    }

    public static java.util.List<DaySchedule> search(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<DaySchedule> search(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .search(DaySchedule.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<DaySchedule> search(
            final com.dslplatform.patterns.Specification<DaySchedule> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<DaySchedule> search(
            final com.dslplatform.patterns.Specification<DaySchedule> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<DaySchedule> search(
            final com.dslplatform.patterns.Specification<DaySchedule> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<DaySchedule> search(
            final com.dslplatform.patterns.Specification<DaySchedule> specification,
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .search(specification, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count() throws java.io.IOException {
        return count(com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .count(DaySchedule.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<DaySchedule> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<DaySchedule> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .count(specification).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private org.joda.time.LocalDate date;

    @com.fasterxml.jackson.annotation.JsonProperty("date")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.LocalDate getDate() {
        return date;
    }

    public DaySchedule setDate(final org.joda.time.LocalDate value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"date\" cannot be null!");
        this.date = value;

        return this;
    }

    private com.dslplatform.webcamp2014.WebCamp2014.Talk[] talks;

    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    @com.fasterxml.jackson.annotation.JsonProperty("talks")
    public com.dslplatform.webcamp2014.WebCamp2014.Talk[] getTalks() {
        return talks;
    }

    public DaySchedule setTalks(
            final com.dslplatform.webcamp2014.WebCamp2014.Talk[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"talks\" cannot be null!");
        com.dslplatform.webcamp2014.Guards.checkNulls(value);
        this.talks = value;

        return this;
    }

    public DaySchedule(
            final org.joda.time.LocalDate date,
            final com.dslplatform.webcamp2014.WebCamp2014.Talk[] talks) {
        setDate(date);
        setTalks(talks);
    }

}

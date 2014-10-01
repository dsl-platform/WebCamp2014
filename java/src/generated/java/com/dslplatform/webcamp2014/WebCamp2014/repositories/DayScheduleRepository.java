package com.dslplatform.webcamp2014.WebCamp2014.repositories;

public class DayScheduleRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<com.dslplatform.webcamp2014.WebCamp2014.DaySchedule> {
    public DayScheduleRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(com.dslplatform.webcamp2014.WebCamp2014.DaySchedule.class,
                locator);
    }
}

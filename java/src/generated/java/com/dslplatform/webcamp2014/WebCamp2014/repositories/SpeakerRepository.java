package com.dslplatform.webcamp2014.WebCamp2014.repositories;

public class SpeakerRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<com.dslplatform.webcamp2014.WebCamp2014.Speaker> {
    public SpeakerRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(com.dslplatform.webcamp2014.WebCamp2014.Speaker.class, locator);
    }
}

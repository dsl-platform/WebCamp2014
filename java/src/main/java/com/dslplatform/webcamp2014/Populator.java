package com.dslplatform.webcamp2014;

import com.dslplatform.patterns.ServiceLocator;
import com.dslplatform.webcamp2014.WebCamp2014.*;
import com.dslplatform.webcamp2014.WebCamp2014.repositories.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public final class Populator {
  private Populator() { }

  public static final void populate(final ServiceLocator locator) throws Exception {
    final SpeakerRepository     speakerRep  = locator.resolve(SpeakerRepository.class);
    final DayScheduleRepository scheduleRep = locator.resolve(DayScheduleRepository.class);

    speakerRep.insert(new Speaker[] {
        new Speaker(
            "Nikola Plejić",
            "@nikolaplejic",
            "Currently running a small development shop in Zagreb called Neutrino..."),
        new Speaker(
            "Krešimir Antolić",
            "@Kantolic",
            "The main reason why Kresimir entered the mystical world of web development is the fact he had no Internet access while growing up..."),
        new Speaker(
            "Marko Elezović",
            "@melezov",
            "Marko Elezović is the tech lead of Instantor AB..."),
        new Speaker(
            "Deni Bertović",
            "@denibertovic",
            "Deni is a Software Engineer from Zagreb/Croatia...")
    }).get();

    scheduleRep.insert(new DaySchedule[] {
        new DaySchedule(
            new LocalDate(2014, 10, 4),
            new Talk[] {
                new Talk(
                    Speaker.find("Deni Bertović"),
                    "Supercharge your development environment using Docker",
                    Track.Hitlist_Code4Hire,
                    "The idea of this talk is to convey how important it is that we have our development environment as close to production as possible...",
                    new DateTime(2014, 10, 4, 17, 0), new DateTime(2014, 10, 4, 17, 30))
            }
        ),
        new DaySchedule(
            new LocalDate(2014, 10, 5),
            new Talk[] {
                new Talk(
                    Speaker.find("Nikola Plejić"),
                    "How, When, and Why Clojure?",
                    Track.Hitlist_Code4Hire,
                    "Clojure is a modern Lisp targeting JVM, CLR, and JavaScript. Is waking up mid-night screaming due to unmatched parentheses worth it...",
                    new DateTime(2014, 10, 5, 12, 15),
                    new DateTime(2014, 10, 5, 12, 45)),
                new Talk(
                    Speaker.find("Marko Elezović"),
                    "Man in the middle attack on banks",
                    Track.Hitlist_Code4Hire,
                    "Selenium scraping of other people's fun and profit...",
                    new DateTime(2014, 10, 5, 15, 30),
                    new DateTime(2014, 10, 5, 16,  0)),
                new Talk(
                    Speaker.find("Krešimir Antolić"),
                    "Building applications with a hammer",
                    Track.Bitovi,
                    "This talk will cover the goods and the bads of choosing javascript as a solution for everything...",
                    new DateTime(2014, 10, 5, 16,  0),
                    new DateTime(2014, 10, 5, 16, 30))
            }
        )
    }).get();
  }

  public static void neronize(ServiceLocator locator) throws Exception {
    final SpeakerRepository     speakerRep  = locator.resolve(SpeakerRepository.class);
    final DayScheduleRepository scheduleRep = locator.resolve(DayScheduleRepository.class);

    scheduleRep.delete(DaySchedule.search());
    speakerRep.delete(Speaker.search());
  }
}

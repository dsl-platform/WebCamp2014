package com.dslplatform.webcamp2014

import com.dslplatform.api.patterns.PersistableRepository
import com.dslplatform.webcamp2014.WebCamp2014._
import org.joda.time.{ DateTime, LocalDate }
import scala.concurrent.{ Await, Awaitable }
import scala.concurrent.duration._

object Populator {
  private def wait[T](a: Awaitable[T]): T = Await.result(a, 30 seconds)

  def populate() {
    val speakerRep  = locator.resolve[PersistableRepository[Speaker]]
    val scheduleRep = locator.resolve[PersistableRepository[DaySchedule]]

    wait(speakerRep.insert(Seq(
      Speaker(
        "Nikola Plejić ",
        Some("@nikolaplejic"),
        "Currently running a small development shop in Zagreb called Neutrino..."),
      Speaker(
        "Krešimir Antolić",
        Some("@Kantolic"),
        "The main reason why Kresimir entered the mystical world of web development is the fact he had no Internet access while growing up..."),
      Speaker(
        "Marko Elezović",
        Some("@melezov"),
        "Marko Elezović is the tech lead of Instantor AB..."),
      Speaker(
        "Deni Bertović",
        Some("@denibertovic"),
        "Deni is a Software Engineer from Zagreb/Croatia...")
    )))

    wait(scheduleRep.insert(Seq(
      DaySchedule(
        new LocalDate(2014, 10, 4),
          Array(
            Talk(
              Speaker.find("Deni Bertović"),
              "Supercharge your development environment using Docker",
              Track.Hitlist_Code4Hire,
              "The idea of this talk is to convey how important it is that we have our development environment as close to production as possible...",
              new DateTime(2014, 10, 4, 17, 0), new DateTime(2014, 10, 4, 17, 30))
          )
      ),
      DaySchedule(
        new LocalDate(2014, 10, 5),
          Array(
            Talk(
              Speaker.find("Nikola Plejić"),
              "How, When, and Why Clojure?",
              Track.Hitlist_Code4Hire,
              "Clojure is a modern Lisp targeting JVM, CLR, and JavaScript. Is waking up mid-night screaming due to unmatched parentheses worth it...",
              new DateTime(2014, 10, 5, 12, 15),
              new DateTime(2014, 10, 5, 12, 45)),
            Talk(
              Speaker.find("Marko Elezović"),
              "Man in the middle attack on banks",
              Track.Hitlist_Code4Hire,
              "Selenium scraping of other people's fun and profit...",
              new DateTime(2014, 10, 5, 15, 30),
              new DateTime(2014, 10, 5, 16,  0)),
            Talk(
              Speaker.find("Krešimir Antolić"),
              "Building applications with a hammer",
              Track.Bitovi,
              "This talk will cover the goods and the bads of choosing javascript as a solution for everything...",
              new DateTime(2014, 10, 5, 16,  0),
              new DateTime(2014, 10, 5, 16, 30))
          )
      )
    )))
  }

  def neronize() {
    val speakerRep  = locator.resolve[PersistableRepository[Speaker]]
    val scheduleRep = locator.resolve[PersistableRepository[DaySchedule]]

    scheduleRep.delete(wait(scheduleRep.search(None)))
    speakerRep.delete(wait(speakerRep.search(None)))
  }
}

package com.dslplatform.webcamp2014

import com.dslplatform.api.patterns.PersistableRepository
import com.dslplatform.webcamp2014.WebCamp2014._
import org.joda.time.DateTime
import org.joda.time.LocalDate
import scala.concurrent.{ Await, Awaitable }
import scala.concurrent.duration._

object Populator {
  private def wait[T](a: Awaitable[T]): T = Await.result(a, 30 seconds)

  def populate() {
    val speakerRep  = locator.resolve[PersistableRepository[Speaker]]
    val scheduleRep = locator.resolve[PersistableRepository[DaySchedule]]

    wait(speakerRep.insert(Seq(
        Speaker("Krešimir Antolić", Some("@Kantolic"), "The main reason why Kresimir entered the mystical world of web development is the fact he had no Internet access while growing up. Once he was introduced to its magic he instantly fell in love with it and all the possibilities this platform provides. Now he’s passionate about the Web and having the possibility to work on it and hopes to do so for many years to come.\n\nHe spends his days as a JavaScript Team Dictator at Infinum. He loves his job and the Web."),
        Speaker("Deni Bertović", Some("@denibertovic"), "Deni is a Software Engineer from Zagreb/Croatia, currently focusing mainly on Python, but enjoys learning about Clojure, Haskell and FP languages in general. Deni likes to do Sysadmin stuff with special interest in virtualization, continuous deployment and automating everything he can. When he's not hacking on open source, he spends most of his time happily coding away at GoodCode.io.\n\nInterested in continuous #deployment, #debian, #django, #docker, #functional programming, #haskell, #lxc, #python, #testing, #virtualization, #web."),
        Speaker("Michał Budzyński", Some("@michalbe"), "Michal is former Karate (1 kyu) & MMA fighter and Star Alliance Gold Senator. He loves subway systems & TV shows and collect ancient roman coins. Time to time he codes , tweets <@michalbe> and blogs . As a former mercenary in Mozilla FirefoxOS army & now volunteer, he is a front line soldier in war for the best mobile operating system."),
        Speaker("Ross Tuck", Some("@rosstuck"), "I’m an independent consultant and engineer, originally from the US and now living in the Netherlands. I started coding in 2000 and now specialize in building web apps, primarily with PHP and Javascript. I also speak at conferences and write articles. My hobbies are reading and hats.")
    )))

    wait(scheduleRep.insert(Seq(
        DaySchedule(
            new LocalDate(2014, 10, 4),
            Array(
              Talk(Speaker.find("Ross Tuck"), "Things I Believe Now That I'm Old", Track.Shared, "A talk with advice about using actual advice I've received\n\nDespite all the advice that's given to us, we seem intent on ignoring it. For better or worse, we rarely follow it until years later we understand what the person was trying to tell us.\n\nIn this talk, I'll share the most helpful, humiliating and hilarious pieces of advice I ever got and how they shaped my career (whether I listened or not). We'll also discuss why giving and receiving advice is important, how to handle it gracefully and why it can be so powerful. As Dijkstra said: \"We must be very careful when we give advice to younger people: sometimes they follow it!\"", new DateTime(2014, 10, 4, 10, 0), new DateTime(2014, 10, 5, 10, 45)),
              Talk(Speaker.find("Deni Bertović"), "Supercharge your development environment using Docker", Track.Hitlist_Code4Hire, "The idea of this talk is to convey how important it is that we have our development environment as close to production as possible.\n\nThese days applications are getting more and more complex. It's becoming quite difficult to keep track of all the different components an application needs to function (a database, an AMQP, a web server, a document store...). It keeps getting harder and harder to setup new development environments and to bring new developers into the team. Stuff works on one dev machine but doesn't on others? Code breaks often when deployed to production even though all tests were passing and it worked on the dev machine?\n\nIn this talk I am going to show how to utilize light weight lxc containers using docker, and make your development process much more straightforward. How to share container images among your development team and be sure that everyone is running the exact same stack. Do all this without hogging too many resources, without the need for complex provisioning scripts and management systems. And above all else, how to do it fast!", new DateTime(2014, 10, 4, 17, 0), new DateTime(2014, 10, 4, 17, 30))
            )
        ),
        DaySchedule(
            new LocalDate(2014, 10, 5),
            Array(
              Talk(Speaker.find("Krešimir Antolić"), "Building applications with a hammer", Track.Bitovi, "This talk will cover the goods and the bads of choosing javascript as a solution for everything.\n\nLet us start by quoting Atwood's Law: “any application that can be written in JavaScript, will eventually be written in JavaScript”. And so it came to be - you either love it or hate it but JavaScript became the “all solving hammer”. It has come to the point that you can write anything in it - including your very own desktop and mobile application, using only web frontend technologies ruled by the almighty JavaScript. The secret ingredient for this recipe is to “just add JavaScript”. In this talk some alternatives to native desktop and mobile development will be presented. There will be alternatives such as phonegap, node-webit and even something promising as NativeScript. But it won’t just sing praises to the mighty JavaScript king it will also cover the dark side of developing this type of software.", new DateTime(2014, 10, 5, 16, 0), new DateTime(2014, 10, 5, 16, 30)),
              Talk(Speaker.find("Michał Budzyński"), "JS, JS, are you mad?", Track.Bitovi, "Is it possible that JS - as a first class citizen of Software Development - went mad and want to conquer our planet and kill all the humans?", new DateTime(2014, 10, 5, 14, 15), new DateTime(2014, 10, 5, 15, 15))
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

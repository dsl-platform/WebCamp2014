<?php
use NGS\Client\StandardProxy;
use WebCamp2014\DaySchedule;
use WebCamp2014\Talk;
use WebCamp2014\Speaker;
use WebCamp2014\Track;

define('NGS_DSL_PATH',  __DIR__.'/../../dsl');
require_once __DIR__.'/../platform/Bootstrap.php';

$proxy = new StandardProxy();

$proxy->delete(DaySchedule::findAll());
$proxy->delete(Speaker::findAll());

$proxy->insert(array(
  new Speaker(array(
    'name'          => 'Nikola Plejić',
    'twitterHandle' => '@nikolaplejic',
    'shortBio'      => 'Currently running a small development shop in Zagreb called Neutrino...'
  )),
  new Speaker(array(
    'name'          => 'Krešimir Antolić',
    'twitterHandle' => '@Kantolic',
    'shortBio'      => 'The main reason why Kresimir entered the mystical world of web development is the fact he had no Internet access while growing up...'
  )),
  new Speaker(array(
    'name'          => 'Marko Elezović',
    'twitterHandle' => '@melezov',
    'shortBio'      => 'Marko Elezović is the tech lead of Instantor AB...'
  )),
  new Speaker(array(
    'name'          => 'Deni Bertović',
    'twitterHandle' => '@denibertovic',
    'shortBio'      => 'Deni is a Software Engineer from Zagreb/Croatia...'
  ))
));

$proxy->insert(array(
  new DaySchedule(array(
    'date'  => new DateTime('2014-10-4'),
    'talks' => array(
      new Talk(array(
        'speaker'     => Speaker::find('Deni Bertović'),
        'title'       => 'Supercharge your development environment using Docker',
        'track'       => Track::Hitlist_Code4Hire,
        'description' => 'The idea of this talk is to convey how important it is that we have our development environment as close to production as possible...',
        'startAt'     => new DateTime('2014-10-4 17:00'),
        'endAt'       => new DateTime('2014-10-4 17:30')
    ))
  )
  )),
  new DaySchedule(array(
    'date'  => new DateTime('2014-10-5'),
    'talks' => array(
      new Talk(array(
        'speaker'     => Speaker::find('Nikola Plejić'),
        'title'       => 'How, When, and Why Clojure?',
        'track'       => Track::Hitlist_Code4Hire,
        'description' => 'Clojure is a modern Lisp targeting JVM, CLR, and JavaScript. Is waking up mid-night screaming due to unmatched parentheses worth it...',
        'startAt'     => new DateTime('2014-10-5 12:15'),
        'endAt'       => new DateTime('2014-10-5 12:45')
      )),
      new Talk(array(
        'speaker'     => Speaker::find('Marko Elezović'),
        'title'       => 'Man in the middle attack on banks',
        'track'       => Track::Hitlist_Code4Hire,
        'description' => 'Selenium scraping of other people\'s fun and profit...',
        'startAt'     => new DateTime('2014-10-5 15:30'),
        'endAt'       => new DateTime('2014-10-5 16:00')
      )),
      new Talk(array(
        'speaker'     => Speaker::find('Krešimir Antolić'),
        'title'       => 'Building applications with a hammer',
        'track'       => Track::Bitovi,
        'description' => 'This talk will cover the goods and the bads of choosing javascript as a solution for everything...',
        'startAt'     => new DateTime('2014-10-5 16:00'),
        'endAt'       => new DateTime('2014-10-5 16:30')
      ))
    )
  ))
));

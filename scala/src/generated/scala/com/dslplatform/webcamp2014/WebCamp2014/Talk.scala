package com.dslplatform.webcamp2014.WebCamp2014

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class Talk @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    @transient private var _speaker: com.dslplatform.webcamp2014.WebCamp2014.Speaker,
    private var _speakerURI: String,
    private var _speakerID: String,
    private var _title: String,
    private var _track: com.dslplatform.webcamp2014.WebCamp2014.Track,
    private var _description: String,
    private var _startAt: org.joda.time.DateTime,
    private var _endAt: org.joda.time.DateTime,
    private var _DayScheduledate: org.joda.time.LocalDate,
    private var _Index: Int
  ) extends Serializable {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {
    _URI
  }

  private [webcamp2014] def URI_= (value: String) {
    _URI = value

  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: Talk => c.URI == URI
    case _ => false
  }

  override def toString = "Talk("+ URI +")"

   def copy(speaker: com.dslplatform.webcamp2014.WebCamp2014.Speaker = null, title: String = this._title, track: com.dslplatform.webcamp2014.WebCamp2014.Track = this._track, description: String = this._description, startAt: org.joda.time.DateTime = this._startAt, endAt: org.joda.time.DateTime = this._endAt, DayScheduledate: org.joda.time.LocalDate = this._DayScheduledate, Index: Int = this._Index): Talk = {

  require(title ne null, "Null value was provided for property \"title\"")
  com.dslplatform.api.Guards.checkLength(title, 80)
  require(track ne null, "Null value was provided for property \"track\"")
  require(description ne null, "Null value was provided for property \"description\"")
  require(startAt ne null, "Null value was provided for property \"startAt\"")
  require(endAt ne null, "Null value was provided for property \"endAt\"")
    new Talk(_URI = this.URI, __locator = this.__locator, _speaker = if(speaker != null) speaker else _speaker, _speakerURI = if (speaker != null) speaker.URI else this._speakerURI, _speakerID = speakerID, _title = title, _track = track, _description = description, _startAt = startAt, _endAt = endAt, _DayScheduledate = DayScheduledate, _Index = Index)
  }

  def speaker(implicit ec: ExecutionContext, duration: Duration) = {
  if(__locator.isDefined) {
      if (__locator.isDefined && (_speaker == null || _speaker.URI != speakerURI))
        _speaker = Await.result(__locator.get.resolve(classOf[CrudProxy]).read[com.dslplatform.webcamp2014.WebCamp2014.Speaker](speakerURI), duration)
    }
    _speaker
  }

  def speaker_= (value: com.dslplatform.webcamp2014.WebCamp2014.Speaker) {
    _speaker = value

    if(speakerID != value.name)
      speakerID = value.name
    _speakerURI = value.URI
  }

  @com.fasterxml.jackson.annotation.JsonProperty("speakerURI")
  def speakerURI = {

    _speakerURI
  }

  @com.fasterxml.jackson.annotation.JsonProperty("speakerID")
   def speakerID = {
    _speakerID
  }

  private [webcamp2014] def speakerID_= (value: String) {
    _speakerID = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("title")
  def title = {
    _title
  }

  def title_= (value: String) {
    com.dslplatform.api.Guards.checkLength(value, 80)
    _title = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("track")
  def track = {
    _track
  }

  def track_= (value: com.dslplatform.webcamp2014.WebCamp2014.Track) {
    _track = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("description")
  def description = {
    _description
  }

  def description_= (value: String) {
    _description = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("startAt")
  def startAt = {
    _startAt
  }

  def startAt_= (value: org.joda.time.DateTime) {
    _startAt = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("endAt")
  def endAt = {
    _endAt
  }

  def endAt_= (value: org.joda.time.DateTime) {
    _endAt = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("DayScheduledate")
  def DayScheduledate = {
    _DayScheduledate
  }

  def DayScheduledate_= (value: org.joda.time.LocalDate) {
    _DayScheduledate = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("Index")
  def Index = {
    _Index
  }

  def Index_= (value: Int) {
    _Index = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("speakerURI") speakerURI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("speakerID") speakerID: String
  , @com.fasterxml.jackson.annotation.JsonProperty("title") title: String
  , @com.fasterxml.jackson.annotation.JsonProperty("track") track: com.dslplatform.webcamp2014.WebCamp2014.Track
  , @com.fasterxml.jackson.annotation.JsonProperty("description") description: String
  , @com.fasterxml.jackson.annotation.JsonProperty("startAt") startAt: org.joda.time.DateTime
  , @com.fasterxml.jackson.annotation.JsonProperty("endAt") endAt: org.joda.time.DateTime
  , @com.fasterxml.jackson.annotation.JsonProperty("DayScheduledate") DayScheduledate: org.joda.time.LocalDate
  , @com.fasterxml.jackson.annotation.JsonProperty("Index") Index: Int
  ) =
    this(__locator = Some(__locator), _URI = URI, _speakerURI = if (speakerURI == null) "" else speakerURI, _speaker = null, _speakerID = if (speakerID == null) "" else speakerID, _title = if (title == null) "" else title, _track = if (track == null) com.dslplatform.webcamp2014.WebCamp2014.Track.Bitovi else track, _description = if (description == null) "" else description, _startAt = if (startAt == null) org.joda.time.DateTime.now else startAt, _endAt = if (endAt == null) org.joda.time.DateTime.now else endAt, _DayScheduledate = if (DayScheduledate == null) org.joda.time.LocalDate.now else DayScheduledate, _Index = Index)

}

object Talk{

  def apply(
    speaker: com.dslplatform.webcamp2014.WebCamp2014.Speaker
  , title: String = ""
  , track: com.dslplatform.webcamp2014.WebCamp2014.Track = com.dslplatform.webcamp2014.WebCamp2014.Track.Bitovi
  , description: String = ""
  , startAt: org.joda.time.DateTime = org.joda.time.DateTime.now
  , endAt: org.joda.time.DateTime = org.joda.time.DateTime.now
  , DayScheduledate: org.joda.time.LocalDate = org.joda.time.LocalDate.now
  , Index: Int = 0
  ) = {
    require(speaker ne null, "Null value was provided for property \"speaker\"")
    require(title ne null, "Null value was provided for property \"title\"")
    com.dslplatform.api.Guards.checkLength(title, 80)
    require(track ne null, "Null value was provided for property \"track\"")
    require(description ne null, "Null value was provided for property \"description\"")
    require(startAt ne null, "Null value was provided for property \"startAt\"")
    require(endAt ne null, "Null value was provided for property \"endAt\"")
    require(DayScheduledate ne null, "Null value was provided for property \"DayScheduledate\"")
    new Talk(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _speaker = speaker
    , _speakerURI = speaker.URI
    , _speakerID = ""
    , _title = title
    , _track = track
    , _description = description
    , _startAt = startAt
    , _endAt = endAt
    , _DayScheduledate = DayScheduledate
    , _Index = Index)
  }

}

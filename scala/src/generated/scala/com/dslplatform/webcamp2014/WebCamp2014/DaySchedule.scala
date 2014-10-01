package com.dslplatform.webcamp2014.WebCamp2014

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class DaySchedule @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _date: org.joda.time.LocalDate,
    private var _talks: Array[com.dslplatform.webcamp2014.WebCamp2014.Talk]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {
    _URI
  }

  private [webcamp2014] def URI_= (value: String) {
    _URI = value

  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: DaySchedule => c.URI == URI
    case _ => false
  }

  override def toString = "DaySchedule("+ URI +")"

   def copy(date: org.joda.time.LocalDate = this._date, talks: Array[com.dslplatform.webcamp2014.WebCamp2014.Talk] = this._talks): DaySchedule = {

  require(date ne null, "Null value was provided for property \"date\"")
  require(talks ne null, "Null value was provided for property \"talks\"")
  com.dslplatform.api.Guards.checkArrayNulls(talks)
    new DaySchedule(_URI = this.URI, __locator = this.__locator, _date = date, _talks = talks)
  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None || _URI == null

  private def updateWithAnother(result: com.dslplatform.webcamp2014.WebCamp2014.DaySchedule): this.type = {
    this._URI = result._URI
    this._date = result._date
    this._talks = result._talks
    this
  }

  private def create()(implicit locator: ServiceLocator, ec: ExecutionContext, duration: Duration): this.type = {

     if(this.talks != null) {
      for (thistalks: com.dslplatform.webcamp2014.WebCamp2014.Talk <- this.talks) {
        if (thistalks.speakerURI == null) {
          throw new IllegalArgumentException("Cannot persist instance of 'com.dslplatform.webcamp2014.WebCamp2014.DaySchedule' because reference 'speaker' (in 'com.dslplatform.webcamp2014.WebCamp2014.Talk') was not assigned");
        }
      }
    }
    __locator = Some(if (locator ne null) locator else Bootstrap.getLocator)
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).create(this), duration)
    updateWithAnother(toUpdateWith)

  }

  private def update()(implicit ec: ExecutionContext, duration: Duration): this.type = {

     if(this.talks != null) {
      for (thistalks: com.dslplatform.webcamp2014.WebCamp2014.Talk <- this.talks) {
        if (thistalks.speakerURI == null) {
          throw new IllegalArgumentException("Cannot persist instance of 'com.dslplatform.webcamp2014.WebCamp2014.DaySchedule' because reference 'speaker' (in 'com.dslplatform.webcamp2014.WebCamp2014.Talk') was not assigned");
        }
      }
    }
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).update(this), duration)
    updateWithAnother(toUpdateWith)

  }

  private def delete()(implicit ec: ExecutionContext, duration: Duration) = {
    if (__locator.isEmpty) throw new IllegalArgumentException("Can't delete an aggregate before it's been saved")
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.webcamp2014.WebCamp2014.DaySchedule](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("date")
  def date = {
    _date
  }

  def date_= (value: org.joda.time.LocalDate) {
    _date = value

    _talks foreach { child => child.DayScheduledate = _date }
  }

  @com.fasterxml.jackson.annotation.JsonProperty("talks")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def talks = {
    _talks
  }

  def talks_= (value: Array[com.dslplatform.webcamp2014.WebCamp2014.Talk]) {
    com.dslplatform.api.Guards.checkArrayNulls(value)
    _talks = value

    _talks.zipWithIndex foreach { case(child, i) =>
      child.Index = i
      child.DayScheduledate = _date
    }

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("date") date: org.joda.time.LocalDate
  , @com.fasterxml.jackson.annotation.JsonProperty("talks") talks: Array[com.dslplatform.webcamp2014.WebCamp2014.Talk]
  ) =
    this(__locator = Some(__locator), _URI = URI, _date = if (date == null) org.joda.time.LocalDate.now else date, _talks = if (talks == null) Array.empty else talks)

}

object DaySchedule extends AggregateRootCompanion[DaySchedule]{

  def apply(
    date: org.joda.time.LocalDate = org.joda.time.LocalDate.now
  , talks: Array[com.dslplatform.webcamp2014.WebCamp2014.Talk] = Array.empty
  ) = {
    require(date ne null, "Null value was provided for property \"date\"")
    com.dslplatform.api.Guards.checkArrayNulls(talks)
    require(talks ne null, "Null value was provided for property \"talks\"")
    new DaySchedule(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _date = date
    , _talks = talks)
  }

}

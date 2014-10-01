package com.dslplatform.webcamp2014.WebCamp2014

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class Speaker @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _name: String,
    private var _twitterHandle: Option[String],
    private var _shortBio: String
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
    case c: Speaker => c.URI == URI
    case _ => false
  }

  override def toString = "Speaker("+ URI +")"

   def copy(name: String = this._name, twitterHandle: Option[String] = this._twitterHandle, shortBio: String = this._shortBio): Speaker = {

  require(name ne null, "Null value was provided for property \"name\"")
  require(twitterHandle ne null, "Null value was provided for property \"twitterHandle\"")
  if(twitterHandle.isDefined) require(twitterHandle.get ne null, "Null value was provided for property \"twitterHandle\"")
  require(shortBio ne null, "Null value was provided for property \"shortBio\"")
    new Speaker(_URI = this.URI, __locator = this.__locator, _name = name, _twitterHandle = twitterHandle, _shortBio = shortBio)
  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None || _URI == null

  private def updateWithAnother(result: com.dslplatform.webcamp2014.WebCamp2014.Speaker): this.type = {
    this._URI = result._URI
    this._name = result._name
    this._twitterHandle = result._twitterHandle
    this._shortBio = result._shortBio
    this
  }

  private def create()(implicit locator: ServiceLocator, ec: ExecutionContext, duration: Duration): this.type = {
    __locator = Some(if (locator ne null) locator else Bootstrap.getLocator)
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).create(this), duration)
    updateWithAnother(toUpdateWith)

  }

  private def update()(implicit ec: ExecutionContext, duration: Duration): this.type = {
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).update(this), duration)
    updateWithAnother(toUpdateWith)

  }

  private def delete()(implicit ec: ExecutionContext, duration: Duration) = {
    if (__locator.isEmpty) throw new IllegalArgumentException("Can't delete an aggregate before it's been saved")
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.webcamp2014.WebCamp2014.Speaker](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("name")
  def name = {
    _name
  }

  def name_= (value: String) {
    _name = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("twitterHandle")
  def twitterHandle = {
    _twitterHandle
  }

  def twitterHandle_= (value: Option[String]) {
    _twitterHandle = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("shortBio")
  def shortBio = {
    _shortBio
  }

  def shortBio_= (value: String) {
    _shortBio = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("name") name: String
  , @com.fasterxml.jackson.annotation.JsonProperty("twitterHandle") twitterHandle: Option[String]
  , @com.fasterxml.jackson.annotation.JsonProperty("shortBio") shortBio: String
  ) =
    this(__locator = Some(__locator), _URI = URI, _name = if (name == null) "" else name, _twitterHandle = twitterHandle, _shortBio = if (shortBio == null) "" else shortBio)

}

object Speaker extends AggregateRootCompanion[Speaker]{

  def apply(
    name: String = ""
  , twitterHandle: Option[String] = None
  , shortBio: String = ""
  ) = {
    require(name ne null, "Null value was provided for property \"name\"")
    require(twitterHandle ne null, "Null value was provided for property \"twitterHandle\"")
    if (twitterHandle.isDefined) require(twitterHandle.get ne null, "Null value was provided for property \"twitterHandle\"")
    require(shortBio ne null, "Null value was provided for property \"shortBio\"")
    new Speaker(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _name = name
    , _twitterHandle = twitterHandle
    , _shortBio = shortBio)
  }

}

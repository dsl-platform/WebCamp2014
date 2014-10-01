package com.dslplatform.webcamp2014.WebCamp2014

@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using=classOf[_TrackDeserializer])
@com.fasterxml.jackson.databind.annotation.JsonSerialize(using=classOf[_TrackSerializer])
sealed trait Track
object Track {
case object Bitovi extends Track
case object Hitlist_Code4Hire extends Track
case object Shared extends Track
  val values = IndexedSeq[Track](Bitovi, Hitlist_Code4Hire, Shared)
}
private class _TrackSerializer extends com.fasterxml.jackson.databind.JsonSerializer[Track] {
  def serialize(value: Track, jgen: com.fasterxml.jackson.core.JsonGenerator, provider: com.fasterxml.jackson.databind.SerializerProvider) {
    value match {
      case Track.Bitovi => jgen.writeString("Bitovi")
      case Track.Hitlist_Code4Hire => jgen.writeString("Hitlist_Code4Hire")
      case Track.Shared => jgen.writeString("Shared")
      case _ =>
    }
  }
}

private class _TrackDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer[Track] {
  def deserialize(parser: com.fasterxml.jackson.core.JsonParser, context: com.fasterxml.jackson.databind.DeserializationContext):Track = {
    parser.getText() match {
      case "Bitovi" => Track.Bitovi
      case "Hitlist_Code4Hire" => Track.Hitlist_Code4Hire
      case "Shared" => Track.Shared
      case _ => Track.Bitovi
    }
  }
}

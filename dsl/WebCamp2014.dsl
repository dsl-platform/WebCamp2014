module WebCamp2014
{
  aggregate DaySchedule(date) {
    Date       date;
    Talk[]     talks;
  }

  entity Talk {
    Speaker    *speaker;
    String(80) title;
    Track      track;
    String     description;
    Timestamp  startAt;   
    Timestamp  endAt;
  }
  
  aggregate Speaker(name) {
    String     name;
    String?    twitterHandle;
    String     shortBio;
  }

  enum Track {
    Bitovi;
    Hitlist_Code4Hire;
    Shared;
  }
}

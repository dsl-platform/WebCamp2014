<?php
namespace WebCamp2014;

require_once __DIR__.'/TalkJsonConverter.php';
require_once __DIR__.'/TalkArrayConverter.php';
require_once __DIR__.'/Speaker.php';
require_once __DIR__.'/Track.php';
require_once __DIR__.'/DaySchedule.php';

/**
 * Generated from NGS DSL
 *
 * @property string $URI a unique object identifier (read-only)
 * @property string $speakerURI reference to an object of class "WebCamp2014\Speaker" (read-only)
 * @property \WebCamp2014\Speaker $speaker an object of class "WebCamp2014\Speaker"
 * @property string $speakerID used by reference $speaker (read-only)
 * @property string $title a string of length 80
 * @property string $track an enum (string) of class "WebCamp2014\Track"
 * @property string $description a string
 * @property \NGS\Timestamp $startAt a timestamp with time zone
 * @property \NGS\Timestamp $endAt a timestamp with time zone
 * @property \NGS\LocalDate $DayScheduledate a date
 * @property int $Index an integer number
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
class Talk implements \IteratorAggregate
{
    protected $URI;
    protected $speakerURI;
    protected $speaker;
    protected $speakerID;
    protected $title;
    protected $track;
    protected $description;
    protected $startAt;
    protected $endAt;
    protected $DayScheduledate;
    protected $Index;

    /**
     * Constructs object using a key-property array or instance of class "WebCamp2014\Talk"
     *
     * @param array|void $data key-property array or instance of class "WebCamp2014\Talk" or pass void to provide all fields with defaults
     */
    public function __construct($data = array(), $construction_type = '')
    {
        if(is_array($data) && $construction_type !== 'build_internal') {
            foreach($data as $key => $val) {
                if(in_array($key, self::$_read_only_properties, true))
                    throw new \LogicException($key.' is a read only property and can\'t be set through the constructor.');
            }
        }
        if (is_array($data)) {
            $this->fromArray($data);
        } else {
            throw new \InvalidArgumentException('Constructor parameter must be an array! Type was: '.\NGS\Utils::getType($data));
        }
    }

    /**
     * Supply default values for uninitialized properties
     *
     * @param array $data key-property array which will be filled in-place
     */
    private static function provideDefaults(array &$data)
    {
        if(!array_key_exists('URI', $data))
            $data['URI'] = null; //a string representing a unique object identifier
        //if(!array_key_exists('speakerID', $data))
        //    $data['speakerID'] = ''; // a string
        if(!array_key_exists('title', $data))
            $data['title'] = ''; // a string of length 80
        if(!array_key_exists('track', $data))
            $data['track'] = \WebCamp2014\Track::Bitovi; // an enum (string) of class "WebCamp2014\Track"
        if(!array_key_exists('description', $data))
            $data['description'] = ''; // a string
        if(!array_key_exists('startAt', $data))
            $data['startAt'] = new \NGS\Timestamp(); // a timestamp with time zone
        if(!array_key_exists('endAt', $data))
            $data['endAt'] = new \NGS\Timestamp(); // a timestamp with time zone
        if(!array_key_exists('DayScheduledate', $data))
            $data['DayScheduledate'] = new \NGS\LocalDate(); // a date
        if(!array_key_exists('Index', $data))
            $data['Index'] = 0; // an integer number
    }

    /**
     * Constructs object from a key-property array
     *
     * @param array $data key-property array
     */
    private function fromArray(array $data)
    {
        $this->provideDefaults($data);
        if(isset($data['URI']))
            $this->URI = \NGS\Converter\PrimitiveConverter::toString($data['URI']);
        unset($data['URI']);
        if (array_key_exists('speaker', $data))
            $this->setSpeaker($data['speaker']);
        unset($data['speaker']);
        if(array_key_exists('speakerURI', $data))
            $this->speakerURI = \NGS\Converter\PrimitiveConverter::toString($data['speakerURI']);
        unset($data['speakerURI']);
        if (array_key_exists('speakerID', $data))
            $this->setSpeakerID($data['speakerID']);
        unset($data['speakerID']);
        if (array_key_exists('title', $data))
            $this->setTitle($data['title']);
        unset($data['title']);
        if (array_key_exists('track', $data))
            $this->setTrack($data['track']);
        unset($data['track']);
        if (array_key_exists('description', $data))
            $this->setDescription($data['description']);
        unset($data['description']);
        if (array_key_exists('startAt', $data))
            $this->setStartAt($data['startAt']);
        unset($data['startAt']);
        if (array_key_exists('endAt', $data))
            $this->setEndAt($data['endAt']);
        unset($data['endAt']);
        if (array_key_exists('DayScheduledate', $data))
            $this->setDayScheduledate($data['DayScheduledate']);
        unset($data['DayScheduledate']);
        if (array_key_exists('Index', $data))
            $this->setIndex($data['Index']);
        unset($data['Index']);

        if (count($data) !== 0 && \NGS\Utils::WarningsAsErrors())
            throw new \InvalidArgumentException('Superflous array keys found in "WebCamp2014\Talk" constructor: '.implode(', ', array_keys($data)));
    }

// ============================================================================

    /**
     * Helper getter function, body for magic method $this->__get('URI')
     * URI is a string representation of the primary key.
     *
     * @return string unique resource identifier representing this object
     */
    public function getURI()
    {
        return $this->URI;
    }

    /**
     * @return a reference to an object of class "WebCamp2014\Speaker"
     */
    public function getSpeakerURI()
    {
        return $this->speakerURI;
    }

    /**
     * @return an object of class "WebCamp2014\Speaker"
     */
    public function getSpeaker()
    {
        if ($this->speakerURI !== null && $this->speaker === null)
            $this->speaker = \NGS\Patterns\Repository::instance()->find('WebCamp2014\\Speaker', $this->speakerURI);
        return $this->speaker;
    }

    /**
     * @return a string
     */
    public function getSpeakerID()
    {
        return $this->speakerID;
    }

    /**
     * @return a string of length 80
     */
    public function getTitle()
    {
        return $this->title;
    }

    /**
     * @return an enum (string) of class "WebCamp2014\Track"
     */
    public function getTrack()
    {
        return $this->track;
    }

    /**
     * @return a string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @return a timestamp with time zone
     */
    public function getStartAt()
    {
        return $this->startAt;
    }

    /**
     * @return a timestamp with time zone
     */
    public function getEndAt()
    {
        return $this->endAt;
    }

    /**
     * @return a date
     */
    public function getDayScheduledate()
    {
        return $this->DayScheduledate;
    }

    /**
     * @return an integer number
     */
    public function getIndex()
    {
        return $this->Index;
    }

    /**
     * Property getter which throws Exceptions on invalid access
     *
     * @param string $name Property name
     *
     * @return mixed
     */
    public function __get($name)
    {
        if ($name === 'URI')
            return $this->getURI(); // a string representing a unique object identifier
        if ($name === 'speakerURI')
            return $this->getSpeakerURI(); // a reference to an object of class "WebCamp2014\Speaker"
        if ($name === 'speaker')
            return $this->getSpeaker(); // an object of class "WebCamp2014\Speaker"
        if ($name === 'speakerID')
            return $this->getSpeakerID(); // a string
        if ($name === 'title')
            return $this->getTitle(); // a string of length 80
        if ($name === 'track')
            return $this->getTrack(); // an enum (string) of class "WebCamp2014\Track"
        if ($name === 'description')
            return $this->getDescription(); // a string
        if ($name === 'startAt')
            return $this->getStartAt(); // a timestamp with time zone
        if ($name === 'endAt')
            return $this->getEndAt(); // a timestamp with time zone
        if ($name === 'DayScheduledate')
            return $this->getDayScheduledate(); // a date
        if ($name === 'Index')
            return $this->getIndex(); // an integer number

        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\Talk" does not exist and could not be retrieved!');
    }

// ============================================================================

    /**
     * Property existence checker
     *
     * @param string $name Property name to check for existence
     *
     * @return bool will return true if and only if the property exist and is not null
     */
    public function __isset($name)
    {
        if ($name === 'URI')
            return $this->URI !== null;
        if ($name === 'speaker')
            return true; // an object of class "WebCamp2014\Speaker" (always set)
        if ($name === 'title')
            return true; // a string of length 80 (always set)
        if ($name === 'track')
            return true; // an enum (string) of class "WebCamp2014\Track" (always set)
        if ($name === 'description')
            return true; // a string (always set)
        if ($name === 'startAt')
            return true; // a timestamp with time zone (always set)
        if ($name === 'endAt')
            return true; // a timestamp with time zone (always set)
        if ($name === 'DayScheduledate')
            return true; // a date (always set)
        if ($name === 'Index')
            return true; // an integer number (always set)

        return false;
    }

    private static $_read_only_properties = array('URI', 'speakerURI', 'speakerID');

    /**
     * @param \WebCamp2014\Speaker $value an object of class "WebCamp2014\Speaker"
     *
     * @return \WebCamp2014\Speaker
     */
    public function setSpeaker($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "speaker" cannot be set to null because it is non-nullable!');
        $value = \WebCamp2014\SpeakerArrayConverter::fromArray($value);
        if ($value->URI === null)
            throw new \InvalidArgumentException('Value of property "speaker" cannot have URI set to null because it\'s a reference! Reference values must have non-null URIs!');
        $this->speaker = $value;
        $this->speakerURI = $value->URI;
        $this->speakerID = $value->name;
        return $value;
    }

    /**
     * @param string $value a string
     *
     * @return string
     */
    private function setSpeakerID($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "speakerID" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toString($value);
        $this->speakerID = $value;
        return $value;
    }

    /**
     * @param string $value a string of length 80
     *
     * @return string
     */
    public function setTitle($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "title" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toFixedString($value, 80);
        $this->title = $value;
        return $value;
    }

    /**
     * @param \WebCamp2014\Track $value an enum (string) of class "WebCamp2014\Track"
     *
     * @return \WebCamp2014\Track
     */
    public function setTrack($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "track" cannot be set to null because it is non-nullable!');
        $value = \WebCamp2014\Track::from($value);
        $this->track = $value;
        return $value;
    }

    /**
     * @param string $value a string
     *
     * @return string
     */
    public function setDescription($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "description" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toString($value);
        $this->description = $value;
        return $value;
    }

    /**
     * @param \NGS\Timestamp $value a timestamp with time zone
     *
     * @return \NGS\Timestamp
     */
    public function setStartAt($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "startAt" cannot be set to null because it is non-nullable!');
        $value = new \NGS\Timestamp($value);
        $this->startAt = $value;
        return $value;
    }

    /**
     * @param \NGS\Timestamp $value a timestamp with time zone
     *
     * @return \NGS\Timestamp
     */
    public function setEndAt($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "endAt" cannot be set to null because it is non-nullable!');
        $value = new \NGS\Timestamp($value);
        $this->endAt = $value;
        return $value;
    }

    /**
     * @param \NGS\LocalDate $value a date
     *
     * @return \NGS\LocalDate
     */
    public function setDayScheduledate($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "DayScheduledate" cannot be set to null because it is non-nullable!');
        $value = new \NGS\LocalDate($value);
        $this->DayScheduledate = $value;
        return $value;
    }

    /**
     * @param int $value an integer number
     *
     * @return int
     */
    public function setIndex($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "Index" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toInteger($value);
        $this->Index = $value;
        return $value;
    }

    /**
     * Property setter which checks for invalid access to entity properties and enforces proper type checks
     *
     * @param string $name Property name
     * @param mixed $value Property value
     */
    public function __set($name, $value)
    {
        if(in_array($name, self::$_read_only_properties, true))
            throw new \LogicException('Property "'.$name.'" in "WebCamp2014\Talk" cannot be set, because it is read-only!');
        if ($name === 'speaker')
            return $this->setSpeaker($value); // an object of class "WebCamp2014\Speaker"
        if ($name === 'title')
            return $this->setTitle($value); // a string of length 80
        if ($name === 'track')
            return $this->setTrack($value); // an enum (string) of class "WebCamp2014\Track"
        if ($name === 'description')
            return $this->setDescription($value); // a string
        if ($name === 'startAt')
            return $this->setStartAt($value); // a timestamp with time zone
        if ($name === 'endAt')
            return $this->setEndAt($value); // a timestamp with time zone
        if ($name === 'DayScheduledate')
            return $this->setDayScheduledate($value); // a date
        if ($name === 'Index')
            return $this->setIndex($value); // an integer number
        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\Talk" does not exist and could not be set!');
    }

    /**
     * Will unset a property if it exists, but throw an exception if it is not nullable
     *
     * @param string $name Property name to unset (set to null)
     */
    public function __unset($name)
    {
        if(in_array($name, self::$_read_only_properties, true))
            throw new \LogicException('Property "'.$name.'" cannot be unset, because it is read-only!');
        if ($name === 'speaker')
            throw new \LogicException('The property "speaker" cannot be unset because it is non-nullable!'); // an object of class "WebCamp2014\Speaker" (cannot be unset)
        if ($name === 'title')
            throw new \LogicException('The property "title" cannot be unset because it is non-nullable!'); // a string of length 80 (cannot be unset)
        if ($name === 'track')
            throw new \LogicException('The property "track" cannot be unset because it is non-nullable!'); // an enum (string) of class "WebCamp2014\Track" (cannot be unset)
        if ($name === 'description')
            throw new \LogicException('The property "description" cannot be unset because it is non-nullable!'); // a string (cannot be unset)
        if ($name === 'startAt')
            throw new \LogicException('The property "startAt" cannot be unset because it is non-nullable!'); // a timestamp with time zone (cannot be unset)
        if ($name === 'endAt')
            throw new \LogicException('The property "endAt" cannot be unset because it is non-nullable!'); // a timestamp with time zone (cannot be unset)
        if ($name === 'DayScheduledate')
            throw new \LogicException('The property "DayScheduledate" cannot be unset because it is non-nullable!'); // a date (cannot be unset)
        if ($name === 'Index')
            throw new \LogicException('The property "Index" cannot be unset because it is non-nullable!'); // an integer number (cannot be unset)
    }

    /** internal function */
    public function __setInternaltalks($parent)
    {
        $this->DayScheduledate = $parent->date;
    }

    public function toJson()
    {
        return \WebCamp2014\TalkJsonConverter::toJson($this);
    }

    public static function fromJson($item)
    {
        return \WebCamp2014\TalkJsonConverter::fromJson($item);
    }

    public function __toString()
    {
        return 'WebCamp2014\Talk'.$this->toJson();
    }

    public function __clone()
    {
        return \WebCamp2014\TalkArrayConverter::fromArray(\WebCamp2014\TalkArrayConverter::toArray($this));
    }

    public function toArray()
    {
        return \WebCamp2014\TalkArrayConverter::toArray($this);
    }

    /**
     * Implementation of the IteratorAggregate interface via \ArrayIterator
     *
     * @return Traversable a new iterator specially created for this iteratation
     */
    public function getIterator()
    {
        return new \ArrayIterator(\WebCamp2014\TalkArrayConverter::toArray($this));
    }
}
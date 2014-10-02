<?php
namespace WebCamp2014;

require_once __DIR__.'/DayScheduleJsonConverter.php';
require_once __DIR__.'/DayScheduleArrayConverter.php';
require_once __DIR__.'/Talk.php';

/**
 * Generated from NGS DSL
 *
 * @property string $URI a unique object identifier (read-only)
 * @property \NGS\LocalDate $date a date
 * @property array $talks an array of objects of class "WebCamp2014\Talk"
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
class DaySchedule extends \NGS\Patterns\AggregateRoot implements \IteratorAggregate
{
    protected $URI;
    protected $date;
    protected $talks;

    /**
     * Constructs object using a key-property array or instance of class "WebCamp2014\DaySchedule"
     *
     * @param array|void $data key-property array or instance of class "WebCamp2014\DaySchedule" or pass void to provide all fields with defaults
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
        if(!array_key_exists('date', $data))
            $data['date'] = new \NGS\LocalDate(); // a date
        if(!array_key_exists('talks', $data))
            $data['talks'] = array(); // an array of objects of class "WebCamp2014\Talk"
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
        if (array_key_exists('date', $data))
            $this->setDate($data['date']);
        unset($data['date']);
        if (array_key_exists('talks', $data))
            $this->setTalks($data['talks']);
        unset($data['talks']);

        if (count($data) !== 0 && \NGS\Utils::WarningsAsErrors())
            throw new \InvalidArgumentException('Superflous array keys found in "WebCamp2014\DaySchedule" constructor: '.implode(', ', array_keys($data)));
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
     * @return a date
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @return an array of objects of class "WebCamp2014\Talk"
     */
    public function getTalks()
    {
        return $this->talks;
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
        if ($name === 'date')
            return $this->getDate(); // a date
        if ($name === 'talks')
            return $this->getTalks(); // an array of objects of class "WebCamp2014\Talk"

        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\DaySchedule" does not exist and could not be retrieved!');
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
        if ($name === 'date')
            return true; // a date (always set)
        if ($name === 'talks')
            return true; // an array of objects of class "WebCamp2014\Talk" (always set)

        return false;
    }

    private static $_read_only_properties = array('URI');

    /**
     * @param \NGS\LocalDate $value a date
     *
     * @return \NGS\LocalDate
     */
    public function setDate($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "date" cannot be set to null because it is non-nullable!');
        $value = new \NGS\LocalDate($value);
        $this->date = $value;
        if($this->talks !== null) {
            foreach($this->talks as $child) {
                if($child->DayScheduledate !== $value)
                    $child->__setInternaltalks($this);
            }
        }
        return $value;
    }

    /**
     * @param array $value an array of objects of class "WebCamp2014\Talk"
     *
     * @return array
     */
    public function setTalks($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "talks" cannot be set to null because it is non-nullable!');
        $value = \WebCamp2014\TalkArrayConverter::fromArrayList($value, false);
        $this->talks = $value;
        if($this->talks !== null) {
            foreach($this->talks as $i => $child) {
                $child->Index = $i;
                $child->__setInternaltalks($this);
            }
        }
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
            throw new \LogicException('Property "'.$name.'" in "WebCamp2014\DaySchedule" cannot be set, because it is read-only!');
        if ($name === 'date')
            return $this->setDate($value); // a date
        if ($name === 'talks')
            return $this->setTalks($value); // an array of objects of class "WebCamp2014\Talk"
        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\DaySchedule" does not exist and could not be set!');
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
        if ($name === 'date')
            throw new \LogicException('The property "date" cannot be unset because it is non-nullable!'); // a date (cannot be unset)
        if ($name === 'talks')
            throw new \LogicException('The property "talks" cannot be unset because it is non-nullable!'); // references to an array of objects of class "WebCamp2014\Talk" (cannot be unset)
    }

    /**
     * Create or update WebCamp2014\DaySchedule instance (server call)
     *
     * @return modified instance object
     */
    public function persist()
    {

        if ($this->talks !== null) {
            foreach ($this->talks as $this_talks) {
                if ($this_talks->speakerURI === null && $this_talks->speakerID !== null) {
                    throw new \LogicException('Cannot persist instance of "WebCamp2014\DaySchedule" because reference "speaker" (in "WebCamp2014\Talk") was not assigned');
                }
            }
        }
        $newObject = parent::persist();
        $this->updateWithAnother($newObject);

        return $this;
    }

    private function updateWithAnother(\WebCamp2014\DaySchedule $result)
    {
        $this->URI = $result->URI;

        $this->date = $result->date;
        $this->talks = $result->talks;
    }
    public function addTalks($item)
    {
        if(is_array($item)) {
            $item = \WebCamp2014\Talk($item);
        } elseif(!$item instanceof \WebCamp2014\Talk) {
            throw new \InvalidArgumentException('Can\'t add $item. It must be an instance or array of "WebCamp2014\Talk"');
        }
        $list = $this->talks;
        if($list === null)
            $list = array();
        $item->__setInternaltalks($this);
        $list[] = $item;
        $item->Index = count($list) - 1;
        $this->talks = $list;
    }

    public function removeTalks($item)
    {
        if(is_array($item)) {
            $item = \WebCamp2014\Talk($item);
        } elseif(!$item instanceof \WebCamp2014\Talk) {
            throw new \InvalidArgumentException('Can\'t remove $item. It must be an instance or array of "WebCamp2014\Talk"');
        }
        $list = $this->talks;
        if($list === null)
            $list = array();
        $itemIndex = array_search($item, $list);
        if($itemIndex !== false) {
            array_splice($list, $itemIndex, 1);

            $count = count($list);
            for($i = $itemIndex; $i < $count; $i++) {
                $list[$i]->Index = $i;
            }
            $this->talks = $list;
        }
    }

    public function toJson()
    {
        return \WebCamp2014\DayScheduleJsonConverter::toJson($this);
    }

    public static function fromJson($item)
    {
        return \WebCamp2014\DayScheduleJsonConverter::fromJson($item);
    }

    public function __toString()
    {
        return 'WebCamp2014\DaySchedule'.$this->toJson();
    }

    public function __clone()
    {
        return \WebCamp2014\DayScheduleArrayConverter::fromArray(\WebCamp2014\DayScheduleArrayConverter::toArray($this));
    }

    public function toArray()
    {
        return \WebCamp2014\DayScheduleArrayConverter::toArray($this);
    }

    /**
     * Implementation of the IteratorAggregate interface via \ArrayIterator
     *
     * @return Traversable a new iterator specially created for this iteratation
     */
    public function getIterator()
    {
        return new \ArrayIterator(\WebCamp2014\DayScheduleArrayConverter::toArray($this));
    }
}
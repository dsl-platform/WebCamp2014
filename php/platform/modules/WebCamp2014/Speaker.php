<?php
namespace WebCamp2014;

require_once __DIR__.'/SpeakerJsonConverter.php';
require_once __DIR__.'/SpeakerArrayConverter.php';

/**
 * Generated from NGS DSL
 *
 * @property string $URI a unique object identifier (read-only)
 * @property string $name a string
 * @property string $twitterHandle a string, can be null
 * @property string $shortBio a string
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
class Speaker extends \NGS\Patterns\AggregateRoot implements \IteratorAggregate
{
    protected $URI;
    protected $name;
    protected $twitterHandle;
    protected $shortBio;

    /**
     * Constructs object using a key-property array or instance of class "WebCamp2014\Speaker"
     *
     * @param array|void $data key-property array or instance of class "WebCamp2014\Speaker" or pass void to provide all fields with defaults
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
        if(!array_key_exists('name', $data))
            $data['name'] = ''; // a string
        if(!array_key_exists('shortBio', $data))
            $data['shortBio'] = ''; // a string
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
        if (array_key_exists('name', $data))
            $this->setName($data['name']);
        unset($data['name']);
        if (array_key_exists('twitterHandle', $data))
            $this->setTwitterHandle($data['twitterHandle']);
        unset($data['twitterHandle']);
        if (array_key_exists('shortBio', $data))
            $this->setShortBio($data['shortBio']);
        unset($data['shortBio']);

        if (count($data) !== 0 && \NGS\Utils::WarningsAsErrors())
            throw new \InvalidArgumentException('Superflous array keys found in "WebCamp2014\Speaker" constructor: '.implode(', ', array_keys($data)));
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
     * @return a string
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * @return a string, can be null
     */
    public function getTwitterHandle()
    {
        return $this->twitterHandle;
    }

    /**
     * @return a string
     */
    public function getShortBio()
    {
        return $this->shortBio;
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
        if ($name === 'name')
            return $this->getName(); // a string
        if ($name === 'twitterHandle')
            return $this->getTwitterHandle(); // a string, can be null
        if ($name === 'shortBio')
            return $this->getShortBio(); // a string

        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\Speaker" does not exist and could not be retrieved!');
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
        if ($name === 'name')
            return true; // a string (always set)
        if ($name === 'twitterHandle')
            return $this->getTwitterHandle() !== null; // a string, can be null
        if ($name === 'shortBio')
            return true; // a string (always set)

        return false;
    }

    private static $_read_only_properties = array('URI');

    /**
     * @param string $value a string
     *
     * @return string
     */
    public function setName($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "name" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toString($value);
        $this->name = $value;
        return $value;
    }

    /**
     * @param string $value a string, can be null
     *
     * @return string
     */
    public function setTwitterHandle($value)
    {
        $value = $value !== null ? \NGS\Converter\PrimitiveConverter::toString($value) : null;
        $this->twitterHandle = $value;
        return $value;
    }

    /**
     * @param string $value a string
     *
     * @return string
     */
    public function setShortBio($value)
    {
        if ($value === null)
            throw new \InvalidArgumentException('Property "shortBio" cannot be set to null because it is non-nullable!');
        $value = \NGS\Converter\PrimitiveConverter::toString($value);
        $this->shortBio = $value;
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
            throw new \LogicException('Property "'.$name.'" in "WebCamp2014\Speaker" cannot be set, because it is read-only!');
        if ($name === 'name')
            return $this->setName($value); // a string
        if ($name === 'twitterHandle')
            return $this->setTwitterHandle($value); // a string, can be null
        if ($name === 'shortBio')
            return $this->setShortBio($value); // a string
        throw new \InvalidArgumentException('Property "'.$name.'" in class "WebCamp2014\Speaker" does not exist and could not be set!');
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
        if ($name === 'name')
            throw new \LogicException('The property "name" cannot be unset because it is non-nullable!'); // a string (cannot be unset)
        if ($name === 'twitterHandle')
            $this->setTwitterHandle(null);; // a string, can be null
        if ($name === 'shortBio')
            throw new \LogicException('The property "shortBio" cannot be unset because it is non-nullable!'); // a string (cannot be unset)
    }

    /**
     * Create or update WebCamp2014\Speaker instance (server call)
     *
     * @return modified instance object
     */
    public function persist()
    {

        $newObject = parent::persist();
        $this->updateWithAnother($newObject);

        return $this;
    }

    private function updateWithAnother(\WebCamp2014\Speaker $result)
    {
        $this->URI = $result->URI;

        $this->name = $result->name;
        $this->twitterHandle = $result->twitterHandle;
        $this->shortBio = $result->shortBio;
    }

    public function toJson()
    {
        return \WebCamp2014\SpeakerJsonConverter::toJson($this);
    }

    public static function fromJson($item)
    {
        return \WebCamp2014\SpeakerJsonConverter::fromJson($item);
    }

    public function __toString()
    {
        return 'WebCamp2014\Speaker'.$this->toJson();
    }

    public function __clone()
    {
        return \WebCamp2014\SpeakerArrayConverter::fromArray(\WebCamp2014\SpeakerArrayConverter::toArray($this));
    }

    public function toArray()
    {
        return \WebCamp2014\SpeakerArrayConverter::toArray($this);
    }

    /**
     * Implementation of the IteratorAggregate interface via \ArrayIterator
     *
     * @return Traversable a new iterator specially created for this iteratation
     */
    public function getIterator()
    {
        return new \ArrayIterator(\WebCamp2014\SpeakerArrayConverter::toArray($this));
    }
}
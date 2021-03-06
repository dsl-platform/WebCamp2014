<?php
namespace WebCamp2014;

require_once __DIR__.'/Speaker.php';

/**
 * Generated from NGS DSL
 *
 * Converts an object of class WebCamp2014\Speaker into a simple array and backwards.
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
abstract class SpeakerArrayConverter
{/**
     * @param array|\WebCamp2014\Speaker An object or an array of objects of type "WebCamp2014\Speaker"
     *
     * @return array A simple array representation
     */
    public static function toArray($item, $allowNullValues=false)
    {
        if ($item instanceof \WebCamp2014\Speaker)
            return self::toArrayObject($item);
        if (is_array($item))
            return self::toArrayList($item, $allowNullValues);

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\Speaker" nor an array of said instances!');
    }

    private static function toArrayObject($item)
    {
        $ret = array();
        $ret['URI'] = $item->URI;
        $ret['name'] = $item->name;
        $ret['twitterHandle'] = $item->twitterHandle;
        $ret['shortBio'] = $item->shortBio;
        return $ret;
    }

    private static function toArrayList(array $items, $allowNullValues=false)
    {
        $ret = array();

        foreach($items as $key => $val) {
            if ($allowNullValues && $val===null) {
                $ret[] = null;
            }
            else {
                if (!$val instanceof \WebCamp2014\Speaker)
                    throw new \InvalidArgumentException('Element with index "'.$key.'" was not an object of class "WebCamp2014\Speaker"! Type was: '.\NGS\Utils::getType($val));

                $ret[] = $val->toArray();
            }
        }

        return $ret;
    }

    public static function fromArray($item)
    {
        if ($item instanceof \WebCamp2014\Speaker)
            return $item;
        if (is_array($item))
            return new \WebCamp2014\Speaker($item, 'build_internal');

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\Speaker" nor an array of said instances!');
    }

    public static function fromArrayList(array $items, $allowNullValues=false)
    {
        try {
            foreach($items as $key => &$val) {
                if($allowNullValues && $val===null)
                    continue;
                if($val === null)
                    throw new \InvalidArgumentException('Null value found in provided array');
                if(!$val instanceof \WebCamp2014\Speaker)
                    $val = new \WebCamp2014\Speaker($val, 'build_internal');
            }
        }
        catch (\Exception $e) {
            throw new \InvalidArgumentException('Element at index '.$key.' could not be converted to object "WebCamp2014\Speaker"!', 42, $e);
        }

        return $items;
    }
}
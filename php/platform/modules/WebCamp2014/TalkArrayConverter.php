<?php
namespace WebCamp2014;

require_once __DIR__.'/Talk.php';

/**
 * Generated from NGS DSL
 *
 * Converts an object of class WebCamp2014\Talk into a simple array and backwards.
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
abstract class TalkArrayConverter
{/**
     * @param array|\WebCamp2014\Talk An object or an array of objects of type "WebCamp2014\Talk"
     *
     * @return array A simple array representation
     */
    public static function toArray($item, $allowNullValues=false)
    {
        if ($item instanceof \WebCamp2014\Talk)
            return self::toArrayObject($item);
        if (is_array($item))
            return self::toArrayList($item, $allowNullValues);

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\Talk" nor an array of said instances!');
    }

    private static function toArrayObject($item)
    {
        $ret = array();
        $ret['URI'] = $item->URI;
        if($item->speakerURI !== null)
            $ret['speakerURI'] = $item->speakerURI;
        $ret['speakerID'] = $item->speakerID;
        $ret['title'] = $item->title;
        if($item->track !== null)
            $ret['track'] = $item->track;
        $ret['description'] = $item->description;
        $ret['startAt'] = $item->startAt->__toString();
        $ret['endAt'] = $item->endAt->__toString();
        $ret['DayScheduledate'] = $item->DayScheduledate->__toString();
        $ret['Index'] = $item->Index;
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
                if (!$val instanceof \WebCamp2014\Talk)
                    throw new \InvalidArgumentException('Element with index "'.$key.'" was not an object of class "WebCamp2014\Talk"! Type was: '.\NGS\Utils::getType($val));

                $ret[] = $val->toArray();
            }
        }

        return $ret;
    }

    public static function fromArray($item)
    {
        if ($item instanceof \WebCamp2014\Talk)
            return $item;
        if (is_array($item))
            return new \WebCamp2014\Talk($item, 'build_internal');

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\Talk" nor an array of said instances!');
    }

    public static function fromArrayList(array $items, $allowNullValues=false)
    {
        try {
            foreach($items as $key => &$val) {
                if($allowNullValues && $val===null)
                    continue;
                if($val === null)
                    throw new \InvalidArgumentException('Null value found in provided array');
                if(!$val instanceof \WebCamp2014\Talk)
                    $val = new \WebCamp2014\Talk($val, 'build_internal');
            }
        }
        catch (\Exception $e) {
            throw new \InvalidArgumentException('Element at index '.$key.' could not be converted to object "WebCamp2014\Talk"!', 42, $e);
        }

        return $items;
    }
}
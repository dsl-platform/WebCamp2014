<?php
namespace WebCamp2014;

require_once __DIR__.'/DaySchedule.php';

/**
 * Generated from NGS DSL
 *
 * Converts an object of class WebCamp2014\DaySchedule into a simple array and backwards.
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
abstract class DayScheduleArrayConverter
{/**
     * @param array|\WebCamp2014\DaySchedule An object or an array of objects of type "WebCamp2014\DaySchedule"
     *
     * @return array A simple array representation
     */
    public static function toArray($item, $allowNullValues=false)
    {
        if ($item instanceof \WebCamp2014\DaySchedule)
            return self::toArrayObject($item);
        if (is_array($item))
            return self::toArrayList($item, $allowNullValues);

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\DaySchedule" nor an array of said instances!');
    }

    private static function toArrayObject($item)
    {
        $ret = array();
        $ret['URI'] = $item->URI;
        $ret['date'] = $item->date->__toString();
        $ret['talks'] = \WebCamp2014\TalkArrayConverter::toArray($item->talks, false);
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
                if (!$val instanceof \WebCamp2014\DaySchedule)
                    throw new \InvalidArgumentException('Element with index "'.$key.'" was not an object of class "WebCamp2014\DaySchedule"! Type was: '.\NGS\Utils::getType($val));

                $ret[] = $val->toArray();
            }
        }

        return $ret;
    }

    public static function fromArray($item)
    {
        if ($item instanceof \WebCamp2014\DaySchedule)
            return $item;
        if (is_array($item))
            return new \WebCamp2014\DaySchedule($item, 'build_internal');

        throw new \InvalidArgumentException('Argument was not an instance of class "WebCamp2014\DaySchedule" nor an array of said instances!');
    }

    public static function fromArrayList(array $items, $allowNullValues=false)
    {
        try {
            foreach($items as $key => &$val) {
                if($allowNullValues && $val===null)
                    continue;
                if($val === null)
                    throw new \InvalidArgumentException('Null value found in provided array');
                if(!$val instanceof \WebCamp2014\DaySchedule)
                    $val = new \WebCamp2014\DaySchedule($val, 'build_internal');
            }
        }
        catch (\Exception $e) {
            throw new \InvalidArgumentException('Element at index '.$key.' could not be converted to object "WebCamp2014\DaySchedule"!', 42, $e);
        }

        return $items;
    }
}
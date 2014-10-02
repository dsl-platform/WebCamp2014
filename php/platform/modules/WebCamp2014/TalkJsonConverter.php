<?php
namespace WebCamp2014;

require_once __DIR__.'/TalkArrayConverter.php';

/**
 * Generated from NGS DSL
 *
 * Converts an object of class WebCamp2014\Talk into a JSON string and backwards via an array converter.
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
abstract class TalkJsonConverter
{/**
     * @param string Json representation of the object(s)
     *
     * @return array|\WebCamp2014\Talk An object or an array of objects of type "WebCamp2014\Talk"
     */
    public static function fromJson($item, $allowNullValues=false)
    {
        $obj = json_decode($item, true);

        return \NGS\Utils::isJsonArray($item)
            ? \WebCamp2014\TalkArrayConverter::fromArrayList($obj, $allowNullValues)
            : \WebCamp2014\TalkArrayConverter::fromArray($obj);
    }

    /**
     * @param array|\WebCamp2014\Talk An object or an array of objects of type "WebCamp2014\Talk"
     *
     * @return string Json representation of the object(s)
     */
    public static function toJson($item)
    {
        $arr = \WebCamp2014\TalkArrayConverter::toArray($item);
        if(is_array($item))
            return json_encode($arr);
        if(empty($arr))
            return '{}';
        return json_encode($arr);
    }
}
<?php
namespace WebCamp2014;

require_once __DIR__.'/SpeakerArrayConverter.php';

/**
 * Generated from NGS DSL
 *
 * Converts an object of class WebCamp2014\Speaker into a JSON string and backwards via an array converter.
 *
 * @package WebCamp2014
 * @version 1.0.0.21551
 */
abstract class SpeakerJsonConverter
{/**
     * @param string Json representation of the object(s)
     *
     * @return array|\WebCamp2014\Speaker An object or an array of objects of type "WebCamp2014\Speaker"
     */
    public static function fromJson($item, $allowNullValues=false)
    {
        $obj = json_decode($item, true);

        return \NGS\Utils::isJsonArray($item)
            ? \WebCamp2014\SpeakerArrayConverter::fromArrayList($obj, $allowNullValues)
            : \WebCamp2014\SpeakerArrayConverter::fromArray($obj);
    }

    /**
     * @param array|\WebCamp2014\Speaker An object or an array of objects of type "WebCamp2014\Speaker"
     *
     * @return string Json representation of the object(s)
     */
    public static function toJson($item)
    {
        $arr = \WebCamp2014\SpeakerArrayConverter::toArray($item);
        if(is_array($item))
            return json_encode($arr);
        if(empty($arr))
            return '{}';
        return json_encode($arr);
    }
}
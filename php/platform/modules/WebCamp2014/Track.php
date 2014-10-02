<?php
namespace WebCamp2014;

abstract class Track extends \NGS\Enum
{
    protected static function getClass()
    {
        return __CLASS__;
    }

    public static function getValues()
    {
        return array(
            'Bitovi',
            'Hitlist_Code4Hire',
            'Shared',
        );
    }

    const Bitovi = 'Bitovi';
    const Hitlist_Code4Hire = 'Hitlist_Code4Hire';
    const Shared = 'Shared';
}
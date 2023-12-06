package com.solvd.zoo.enums;

public enum Month {
    JANUARY(31, Season.WINTER),
    FEBRUARY(28, Season.WINTER),
    MARCH(31, Season.SPRING),
    APRIL(30, Season.SPRING),
    MAY(31, Season.SPRING),
    JUNE(30, Season.SUMMER),
    JULY(31, Season.SUMMER),
    AUGUST(31, Season.SUMMER),
    SEPTEMBER(30, Season.FALL),
    OCTOBER(31, Season.FALL),
    NOVEMBER(30, Season.FALL),
    DECEMBER(31, Season.WINTER);

    private final int days;
    private final Season season;

    Month(int days, Season season) {
        this.days = days;
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public int getDays(boolean isLeapYear) {
        if (this == FEBRUARY && isLeapYear) {
            return 29;
        }
        return days;
    }
}
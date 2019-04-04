package com.dimakaplin143.margins;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int sTheme;

    public final static int THEME_FIRST = 0;
    public final static int THEME_SECOND = 1;
    public final static int THEME_THIRD = 2;
    private static int lang = 0;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_FIRST:
                activity.setTheme(R.style.FirstTheme);
                break;
            case THEME_SECOND:
                activity.setTheme(R.style.SecondTheme);
                break;
            case THEME_THIRD:
                activity.setTheme(R.style.ThirdTheme);
                break;
        }
    }

    public static void changeLang(int newLang) {
        lang = newLang;
    }

    public static int getLang() {
        return lang;
    }
    public static int getTheme() {
        return sTheme;
    }
}
package com.example.romanm.githubclient.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Roma on 26.09.2017.
 */

public class ActivityUtils {
    public static void setFragment(FragmentManager fragmentManager, Fragment fragment, int idContainer) {
        fragmentManager
                .beginTransaction()
                .replace(idContainer, fragment)
                .commit();
    }

    public static void setFragmentWithBackStack(FragmentManager fragmentManager, Fragment fragment, int idContainer) {
        fragmentManager
                .beginTransaction()
                .replace(idContainer, fragment)
                .addToBackStack("add")
                .commit();
    }
}

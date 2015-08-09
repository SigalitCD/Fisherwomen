package com.fisherwomen.fisherwomen;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class SettingsActivityFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

    private CheckBoxPreference mCheckBoxPreference;
    private ListPreference      mListPreference;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

/*
        mCheckBoxPreference = (CheckBoxPreference) getPreferenceManager().findPreference("checkbox_preference");
        if (mCheckBoxPreference != null )
        {
            mCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    // insert custom code
                    return true;
                }
            });
        }
*/




        mListPreference = (ListPreference)  getPreferenceManager().findPreference("key_notifications_vibrate_preference");
        if (mListPreference != null )
        {
            mListPreference.setOnPreferenceChangeListener(this);
        }

        mListPreference = (ListPreference)  getPreferenceManager().findPreference("key_notifications_popup_preference");
        if (mListPreference != null )
        {
            mListPreference.setOnPreferenceChangeListener(this);
        }



        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        return v;
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        // insert custom code
        return true;
    }

}

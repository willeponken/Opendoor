/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.willeponken.opendoor;

import android.Manifest;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        askForPermissions(new String[]{android.Manifest.permission.RECEIVE_SMS, android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.CALL_PHONE, android.Manifest.permission.READ_CONTACTS}, 2);
        addSlide(SampleSlide.newInstance(R.layout.fragment_initial));
        addSlide(SampleSlide.newInstance(R.layout.fragment_initial1));
        addSlide(SampleSlide.newInstance(R.layout.fragment_initial2));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(false);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        EditText editText_default = (EditText)findViewById(R.id.defaultNumber);
        Database.setDialNumber(getApplicationContext(), editText_default.getText().toString());
        Intent continueToMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        IntroActivity.this.startActivity(continueToMainActivity);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
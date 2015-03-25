// Copyright 2015 The Project Buendia Authors
//
// Licensed under the Apache License, Version 2.0 (the "License"); you may not
// use this file except in compliance with the License.  You may obtain a copy
// of the License at: http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software distrib-
// uted under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
// OR CONDITIONS OF ANY KIND, either express or implied.  See the License for
// specific language governing permissions and limitations under the License.

package org.msf.records.updater;

import android.app.Application;
import android.content.SharedPreferences;

import org.msf.records.inject.Qualifiers;
import org.msf.records.net.VolleySingleton;
import org.msf.records.prefs.StringPreference;
import org.msf.records.ui.patientlist.PatientSearchActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * A Dagger module that provides bindings for update-related classes.
 */
@Module(
        injects = {
                PatientSearchActivity.class
        },
        complete = false,
        library = true)
public class UpdateModule {

    @Provides
    @Singleton
    UpdateServer providePackageServer(
            Application application,
            @Qualifiers.PackageServerRootUrl StringPreference rootUrl) {
        return new UpdateServer(VolleySingleton.getInstance(application), rootUrl);
    }

    @Provides
    @Singleton
    UpdateManager provideUpdateManager(Application application, UpdateServer updateServer,
                                       SharedPreferences sharedPreferences) {
        return new UpdateManager(application, updateServer, sharedPreferences);
    }
}

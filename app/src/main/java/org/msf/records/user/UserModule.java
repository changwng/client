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

package org.msf.records.user;

import org.msf.records.utils.AsyncTaskRunner;
import org.msf.records.utils.EventBusInterface;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * A Dagger module that provides bindings for user-related classes.
 */
@Module(
        complete = false,
        library = true)
public class UserModule {

    @Provides
    @Singleton
    UserStore provideUserStore() {
        return new UserStore();
    }

    @Provides
    @Singleton
    UserManager provideUserManage(
            UserStore userStore,
            EventBusInterface eventBus,
            AsyncTaskRunner asyncTaskRunner) {
        return new UserManager(userStore, eventBus, asyncTaskRunner);
    }
}

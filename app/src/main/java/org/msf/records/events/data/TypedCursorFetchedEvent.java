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

package org.msf.records.events.data;

import org.msf.records.data.app.TypedCursor;
import org.msf.records.events.DefaultCrudEventBus;

/**
 * An abstract event bus event indicating that a {@link TypedCursor} has been fetched from the data
 * store.
 *
 * <p>Subclasses of this event should only be posted on a {@link DefaultCrudEventBus}.
 */
public abstract class TypedCursorFetchedEvent<T> {

    public final TypedCursor<T> cursor;

    TypedCursorFetchedEvent(TypedCursor<T> cursor) {
        this.cursor = cursor;
    }
}

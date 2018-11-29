/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

package com.htlhl.tourismus_hl.injection.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.htlhl.tourismus_hl.injection.qualifier.ChildFragmentManager
import com.htlhl.tourismus_hl.injection.qualifier.FragmentDisposable
import com.htlhl.tourismus_hl.injection.scopes.PerFragment
import com.htlhl.tourismus_hl.ui.base.navigator.ChildFragmentNavigator
import com.htlhl.tourismus_hl.ui.base.navigator.FragmentNavigator

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    @ChildFragmentManager
    internal fun provideChildFragmentManager(): FragmentManager {
        return fragment.childFragmentManager
    }

    @Provides
    @PerFragment
    internal fun provideFragmentNavigator(): FragmentNavigator {
        return ChildFragmentNavigator(fragment)
    }

    @Provides
    @PerFragment
    @FragmentDisposable
    internal fun provideFragmentCompositeDisposable(): CompositeDisposable = CompositeDisposable()

}

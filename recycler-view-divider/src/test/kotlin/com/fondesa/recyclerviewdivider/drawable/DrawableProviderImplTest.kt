/*
 * Copyright (c) 2020 Giorgio Antonioli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.recyclerviewdivider.drawable

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fondesa.recyclerviewdivider.test.allDividers
import com.fondesa.recyclerviewdivider.test.assertEqualDrawables
import com.fondesa.recyclerviewdivider.test.dummyGrid
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests of [DrawableProviderImpl].
 */
@RunWith(AndroidJUnit4::class)
class DrawableProviderImplTest {

    @Test
    fun `getDividerDrawable - returns same drawable for each divider`() {
        val grid = dummyGrid(cellsInLines = intArrayOf(3, 4, 2))
        val expectedDrawable = ColorDrawable(Color.RED)
        val provider = DrawableProviderImpl(drawable = expectedDrawable)

        grid.allDividers.forEach { divider ->
            val actualDrawable = provider.getDividerDrawable(grid = grid, divider = divider)

            assertEqualDrawables(expectedDrawable, actualDrawable)
        }
    }
}

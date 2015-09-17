/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.cities.bldg;

import org.terasology.commonworld.Orientation;
import org.terasology.math.geom.BaseVector2i;
import org.terasology.math.geom.ImmutableVector2i;

/**
 * A rectangular window in a wall
 */
public class SimpleWindow implements Window {

    private final Orientation orientation;
    private final ImmutableVector2i pos;
    private final int height;

    /**
     * @param orientation the orientation
     * @param pos the window position
     * @param height the height at the bottom
     */
    public SimpleWindow(Orientation orientation, BaseVector2i pos, int height) {
        this.orientation = orientation;
        this.pos = ImmutableVector2i.createOrUse(pos);
        this.height = height;
    }

    /**
     * @return the orientation
     */
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * @return the window position
     */
    public ImmutableVector2i getPos() {
        return this.pos;
    }

    /**
     * @return the baseHeight
     */
    public int getHeight() {
        return this.height;
    }
}

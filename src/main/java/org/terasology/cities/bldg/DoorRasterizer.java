/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.cities.bldg;

import org.terasology.cities.BlockTheme;
import org.terasology.cities.raster.RasterTarget;
import org.terasology.commonworld.heightmap.HeightMap;

/**
 * @param <T> the target class
 */
public abstract class DoorRasterizer<T extends Door> extends AbstractBuildingRasterizer<T> {

    /**
     * @param theme the block theme that is used to map type to blocks
     * @param targetClass the target class that is rasterized
     */
    protected DoorRasterizer(BlockTheme theme, Class<T> targetClass) {
        super(theme, targetClass);
    }

    @Override
    public void raster(RasterTarget brush, Building bldg, HeightMap hm) {
        for (BuildingPart part : bldg.getParts()) {
            for (Door door : part.getDoors()) {
                if (targetClass.isInstance(door)) {
                    raster(brush, targetClass.cast(door), hm);
                }
            }
        }
    }

    protected abstract void raster(RasterTarget brush, T part, HeightMap heightMap);
}


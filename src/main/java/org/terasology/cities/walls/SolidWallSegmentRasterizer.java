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

package org.terasology.cities.walls;

import org.terasology.cities.BlockTypes;
import org.terasology.cities.raster.RasterTarget;
import org.terasology.cities.raster.Rasterizer;
import org.terasology.cities.raster.TerrainInfo;
import org.terasology.commonworld.heightmap.HeightMap;
import org.terasology.commonworld.heightmap.HeightMaps;

/**
 * Converts a {@link SolidWallSegment} into blocks
 */
public class SolidWallSegmentRasterizer implements Rasterizer<SolidWallSegment> {

    @Override
    public void raster(RasterTarget brush, TerrainInfo ti, SolidWallSegment element) {

        HeightMap bottomHm = ti.getHeightMap();
        HeightMap topHm = HeightMaps.offset(bottomHm, element.getWallHeight());

        int x1 = element.getStart().getX();
        int z1 = element.getStart().getY();
        int x2 = element.getEnd().getX();
        int z2 = element.getEnd().getY();

        brush.draw(bottomHm, topHm, x1, z1, x2, z2, BlockTypes.TOWER_WALL);
    }

}
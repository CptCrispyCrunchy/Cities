/*
 * Copyright 2013 MovingBlocks
 *
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

package org.terasology.cities.model;

import java.util.Collections;
import java.util.Set;

import javax.vecmath.Point2d;

import com.google.common.collect.Sets;

/**
 * A site where two or more roads meet
 * @author "Martin Steiger"
 */
public class Junction {
    private final Set<Road> roads = Sets.newHashSet();
    
    private final Point2d coords;
    
    /**
     * @param coords the position coordinates in sectors
     */
    public Junction(Point2d coords) {
        this.coords = new Point2d(coords);
    }
    
    /**
     * @return the position coordinates in sectors
     */
    public Point2d getCoords() {
        return coords;
    }

    /**
     * @param road the road to add to this junction
     */
    public void addRoad(Road road) {
        roads.add(road);
    }
    
    /**
     * @return an unmodifiable view on the connected roads (can be empty, but never <code>null</code>)
     */
     public Set<Road> getRoads() {
        return Collections.unmodifiableSet(roads);
    }
    
    @Override
    public String toString() {
        return "Junction [" + coords + ", " + roads.size() + " roads]";
    }
}
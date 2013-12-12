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

package org.terasology.world.generator.city;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.engine.CoreRegistry;
import org.terasology.world.block.Block;
import org.terasology.world.block.BlockManager;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * A mapping from block types (as defined in {@link BlockTypes}) to actual blocks
 * @author Martin Steiger
 */
final class BlockTypeFunction implements Function<String, Block> {

    private static final Logger logger = LoggerFactory.getLogger(BlockTypeFunction.class);

    private final Map<String, Block> map = Maps.newConcurrentMap();
    private final BlockManager blockManager = CoreRegistry.get(BlockManager.class);
    private final Block defaultBlock = blockManager.getBlock("core:Stone");

    /**
     * Setup the mapping with defaults 
     */
    public BlockTypeFunction() {
        register(BlockTypes.ROAD_SURFACE, "core:Gravel");
    }

    /**
     * @param blockType the block type (as defined in BlockTypes} 
     * @param blockUri the block uri
     */
    public void register(String blockType, String blockUri) {
        Block block = blockManager.getBlock(blockUri);
        
        if (block == null) {
            logger.warn("Could not resolve block URI \"{}\" - skipping", blockUri);
        } else {
            map.put(BlockTypes.ROAD_SURFACE, block);
        }
    }
    
    /**
     * Remove blockType from the mapping
     * @param blockType the block type (as defined in BlockTypes} 
     */
    public void unregister(String blockType) {
        map.remove(blockType);
    }

    @Override
    public Block apply(String input) {

        Block block = map.get(input);

        if (block == null) {
            block = defaultBlock;
            logger.warn("Could not resolve block type \"{}\" - using default", input);
        }

        return block;
    }
}
/*
 * This file is part of xconfig / crossconfig / xcfg4j.
 * Copyright (C) 2023  Stardust Enterprises
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package enterprises.stardust.xconfig;

import org.jetbrains.annotations.Contract;

/**
 * A configuration data representation for sharing between xconfig services.
 * <p>
 * This interface is designed to lack a lot of data, and is meant to be extended
 * by the respective services to provide service-specific data.
 *
 * @author xtrm
 * @since 0.0.1
 */
public interface ServiceFacingConfiguration {
    /**
     * @return A uniquely identifying and <b>persistant</b> identifier for this
     * configuration.
     * @implNote This identifier should be generated once and then persisted
     * somewhere, so that it can be used to reference configurations anytime.
     * This might be a hash sum of the configuration name, or a stored UUIDv4,
     * depending on the back-end service.
     */
    @Contract(pure = true)
    String id();
}

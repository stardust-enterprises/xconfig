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

package enterprises.stardust.xconfig.frontend;

/**
 * Defines the basic functionality for a xconfig frontend service.
 * <p>
 * A frontend service is responsible for providing the user interface for
 * interacting with one and/or multiple xconfig middle-end/backend services.
 * <p>
 * Note that a frontend service might equally be a web application, a desktop
 * application, or a CLI.
 *
 * @implNote The frontend service might be responsible for saving/loading
 * configurations, might provide the user with a way to save/load configurations,
 * or might not provide any way to save/load configurations at all, depending on
 * the backend service(s) it is interacting with.
 *
 * @author xtrm
 * @since 0.0.1
 */
public interface Frontend {
}
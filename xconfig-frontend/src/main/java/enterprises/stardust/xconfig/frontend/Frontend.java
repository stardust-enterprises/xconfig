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

import enterprises.stardust.xconfig.middleend.Node;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Defines the basic functionality for a xconfig frontend service.
 * <p>
 * A frontend service is responsible for providing the user interface for
 * interacting with one and/or multiple xconfig middle-end/backend services.
 * <p>
 * Note that a frontend service might equally be a web application, a desktop
 * application, or a CLI.
 *
 * @author xtrm
 * @implNote The frontend service might be responsible for saving/loading
 * configurations, might provide the user with a way to save/load configurations,
 * or might not provide any way to save/load configurations at all, depending on
 * the backend service(s) it is interacting with.
 * @since 0.0.1
 */
public interface Frontend {
    @ApiStatus.Experimental
    void ensureAccessible();

    void populate(Collection<Node<?>> nodes);

    static @NotNull Frontend get() {
        return FrontendProvider.getMainFrontend();
    }
}

/**
 * @author xtrm
 * @since 0.0.1
 */
final class FrontendProvider {
    private static final Logger LOGGER =
        LoggerFactory.getLogger(FrontendProvider.class);
    private static final ServiceLoader<Frontend> FRONTEND_LOADER =
        ServiceLoader.load(Frontend.class);

    private static @Nullable Frontend MAIN_FRONTEND;

    static Frontend getMainFrontend() {
        if (MAIN_FRONTEND == null) {
            FRONTEND_LOADER.reload();

            Iterator<Frontend> iterator = FRONTEND_LOADER.iterator();
            if (iterator.hasNext()) {
                MAIN_FRONTEND = iterator.next();
                if (iterator.hasNext()) {

                }
            } else {
                throw new IllegalStateException("No frontend service found. " +
                    "Please provide a frontend service.");
            }
        }
        return MAIN_FRONTEND;
    }
}

/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.server;

import java.io.Serializable;
import java.net.URI;

/**
 * Stream resource registration result.
 * <p>
 * Use {@link #getResourceUri()} to get URI after {@link StreamResource} is
 * registered. It also allows to unregister the resource.
 * 
 * @author Vaadin Ltd
 *
 */
public interface StreamResourceRegistration extends Serializable {

    /**
     * Get resource URI for registered {@link StreamResource} instance.
     * <p>
     * The URI is relative to the application base URI.
     * 
     * @return resource URI
     */
    URI getResourceUri();

    /**
     * Unregister {@link StreamResource}.
     * <p>
     * The resource will be removed from the session and its URI won't be served
     * by the application anymore so that the resource becomes available for GC.
     * <p>
     * It's the developer's responsibility to call this method at the
     * appropriate time. Otherwise the resource instance will stay in memory
     * until the session expires.
     */
    void unregister();
}
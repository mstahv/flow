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
package com.vaadin.hummingbird.uitest.ui.prerender;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.hummingbird.testutil.PhantomJSTest;

public class PreRenderIT extends PhantomJSTest {

    @Test
    public void componentsPrendered() {
        testBench().disableWaitForVaadin();
        open("prerender=only");

        WebElement button = findElement(By.id("cmp-basic"));
        Assert.assertEquals("button", button.getTagName());
        Assert.assertEquals("A button", button.getText());

        WebElement styleButton = findElement(By.id("cmp-inline-style"));
        Assert.assertEquals("background-color: green;",
                styleButton.getAttribute("style"));

        WebElement classButton = findElement(By.id("cmp-class"));
        Assert.assertEquals("backgroundClass",
                classButton.getAttribute("class"));

        WebElement link = findElement(By.id("cmp-link"));
        Assert.assertEquals("http://localhost:8888/view",
                link.getAttribute("href"));

    }

    @Test
    public void templatePrendered() {
        testBench().disableWaitForVaadin();
        open("prerender=only");

        WebElement button = findElement(By.id("tpl-basic"));
        Assert.assertEquals("button", button.getTagName());
        Assert.assertEquals("A button", button.getText());

        WebElement styleButton = findElement(By.id("tpl-inline-style"));
        Assert.assertEquals("background-color: green;",
                styleButton.getAttribute("style"));

        WebElement classButton = findElement(By.id("tpl-class"));
        Assert.assertEquals("backgroundClass",
                classButton.getAttribute("class"));

        WebElement boundClassButton = findElement(By.id("tpl-bound-class"));
        Assert.assertEquals("backgroundClass",
                boundClassButton.getAttribute("class"));

        WebElement link = findElement(By.id("tpl-link"));
        Assert.assertEquals("http://localhost:8888/view",
                link.getAttribute("href"));

        // Bound properties do not show up in pre rendered version
        WebElement linkBound = findElement(By.id("tpl-link-bound"));
        Assert.assertEquals(null, linkBound.getAttribute("href"));

        WebElement linkBoundAttribute = findElement(
                By.id("tpl-link-bound-attribute"));
        Assert.assertEquals("http://localhost:8888/view",
                linkBoundAttribute.getAttribute("href"));

    }
}

/*******************************************************************************
 * Copyright (c)      2008  Ola Spjuth <ospjuth@users.sf.net>
 *               2008-2009  Egon Willighagen <egonw@users.sf.net>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contact: http://www.bioclipse.net/
 ******************************************************************************/
package net.bioclipse.cdk.business.test;

import static org.junit.Assert.fail;
import net.bioclipse.cdk.business.Activator;
import net.bioclipse.managers.business.IBioclipseManager;

import org.junit.BeforeClass;

public class JavaCDKManagerPluginTest extends AbstractCDKManagerPluginTest {

    @BeforeClass 
    public static void setupCDKManagerPluginTest() {
        
        AbstractCDKManagerPluginTest.setupCDKManagerPluginTest();
        
        try {
            cdk = Activator.getDefault().getJavaCDKManager();
        } 
        catch (RuntimeException exception) {
            fail("Failed to instantiate the CDK managers.");
        }
    }
}
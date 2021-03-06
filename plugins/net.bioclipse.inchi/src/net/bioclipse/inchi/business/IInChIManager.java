/*******************************************************************************
 * Copyright (c) 2008-2009  Egon Willighagen <egonw@users.sf.net>
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * www.eclipse.org—epl-v10.html <http://www.eclipse.org/legal/epl-v10.html>
 * 
 * Contact: http://www.bioclipse.net/    
 ******************************************************************************/
package net.bioclipse.inchi.business;

import java.util.List;

import net.bioclipse.core.PublishedClass;
import net.bioclipse.core.PublishedMethod;
import net.bioclipse.core.Recorded;
import net.bioclipse.core.TestClasses;
import net.bioclipse.core.TestMethods;
import net.bioclipse.core.business.BioclipseException;
import net.bioclipse.core.domain.IMolecule;
import net.bioclipse.inchi.InChI;
import net.bioclipse.jobs.BioclipseJob;
import net.bioclipse.jobs.BioclipseJobUpdateHook;
import net.bioclipse.managers.business.IBioclipseManager;

@PublishedClass ("Manager for creating InChI and InChIKeys.")
@TestClasses(
    "net.bioclipse.inchi.business.test.APITest," +
    "net.bioclipse.inchi.business.test.JavaInChIManagerPluginTest"
)
public interface IInChIManager extends IBioclipseManager {

    @Recorded
    @PublishedMethod(
        params = "IMolecule molecule",
        methodSummary = "Generates the InChI and InChIKey for the " +
        		"given molecule.")
    @TestMethods("testGenerate")
    public InChI generate(IMolecule molecule) throws Exception;
    public BioclipseJob<InChI> generate(IMolecule molecule,
            BioclipseJobUpdateHook<InChI> h );

    @Recorded
    @PublishedMethod(
        params = "IMolecule molecule, String options",
        methodSummary = "Generates the InChI and InChIKey for the " +
        		"given molecule, using the given options. This options String consists of " +
        		"one or more, space-delimited options, such as FixedH.")
    @TestMethods("testGenerateWithOptions")
    public InChI generate(IMolecule molecule, String options) throws Exception;
    public BioclipseJob<InChI> generate(IMolecule molecule, String options,
            BioclipseJobUpdateHook<InChI> h );

    @Recorded
    @PublishedMethod(
        methodSummary = "Returns a list of InChI generation options.")
    @TestMethods("testOptions")
    public List<String> options();

    @Recorded
    @PublishedMethod(
        methodSummary = "Checks the validity of an InChIKey.",
        params="String inchikey"
    )
    public boolean checkKey(String inchikey) throws BioclipseException;

    @Recorded
    @PublishedMethod(
        methodSummary = "Checks the validity of an InChI (loose).",
        params="String inchi"
    )
    public boolean check(String inchi) throws BioclipseException;

    @Recorded
    @PublishedMethod(
        methodSummary = "Checks the validity of an InChI (strict).",
        params="String inchi"
    )
    public boolean checkStrict(String inchi) throws BioclipseException;

    @Recorded
    @PublishedMethod(
        methodSummary = "Loads the InChI library.")
    public String load();

    @Recorded
    @PublishedMethod(
        methodSummary = "Returns true if the InChI library could be loaded.")
    public boolean isLoaded();

    @Recorded
    @PublishedMethod(
        methodSummary = "Returns true if the InChI library is available for your" +
        		"platform.")
    public boolean isAvailable();
}

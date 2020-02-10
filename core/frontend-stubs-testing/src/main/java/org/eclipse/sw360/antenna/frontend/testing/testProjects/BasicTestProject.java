/*
 * Copyright (c) Bosch Software Innovations GmbH 2018.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.sw360.antenna.frontend.testing.testProjects;

import org.eclipse.sw360.antenna.model.xml.generated.WorkflowStep;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.eclipse.sw360.antenna.frontend.testing.testProjects.TestProjectUtils.mkWorkflowStep;

public class BasicTestProject extends AbstractTestProjectWithExpectations implements NonExecutableTestProject {

    public BasicTestProject() {
        super();
    }

    @Override
    public List<String> getOtherFilesToCopy() {
        return Collections.singletonList("src/antennaconf2.xml");
    }

    @Override
    public Path getProjectRoot() {
        return this.projectRoot;
    }

    @Override
    public String getExpectedProjectArtifactId() {
        return "basic-test-project";
    }

    @Override
    public String getExpectedProjectVersion() {
        return "1.2-SNAPSHOT";
    }

    @Override
    public String getExpectedToolConfigurationProductName() {
        return "Product Name";
    }

    @Override
    public String getExpectedToolConfigurationProductFullName() {
        return "Super long Product Full Name";
    }

    @Override
    public String getExpectedToolConfigurationProductVersion() {
        return "3.4.0";
    }

    @Override
    public List<String> getExpectedFilesToAttach() {
        List<String> fileList = super.getExpectedFilesToAttach();
        fileList.add("sources-zip,zip,OSS-sources");
        return fileList;
    }

    @Override
    public List<String> getExpectedToolConfigurationConfigFiles() {
        List<String> fileList = super.getExpectedToolConfigurationConfigFiles();
        fileList.add("src" + File.separator + "antennaconf.xml");
        fileList.add("src" + File.separator + "antennaconf2.xml");
        return fileList;
    }

    @Override
    public List<WorkflowStep> getExpectedToolConfigurationAnalyzers() {
        final List<WorkflowStep> analyzers = super.getExpectedToolConfigurationAnalyzers();
        analyzers.add(mkWorkflowStep("Example Analyzer", "full.qualified.class.name",
                "configuration_key_1", "configuration_value_1",
                "configuration_key_2", "configuration_value_2"));
        return analyzers;
    }

    @Override
    public List<WorkflowStep> getExpectedToolConfigurationGenerators() {
        final List<WorkflowStep> generators = super.getExpectedToolConfigurationGenerators();
        WorkflowStep generator1 = mkWorkflowStep("First Generator", "full.qualified.generator1.class.name",
                "configuration_key_1", "configuration_value_1");
        generators.add(generator1);
        WorkflowStep generator2 = mkWorkflowStep("Second Generator", "full.qualified.generator2.class.name");
        generators.add(generator2);
        return generators;
    }

    @Override
    public List<WorkflowStep> getExpectedToolConfigurationProcessors() {
        final List<WorkflowStep> processors = super.getExpectedToolConfigurationProcessors();
        processors.add(
                mkWorkflowStep("Arbitrary processor", "full.qualified.processor.class.name",
                        "configuration_key_1", "configuration_value_1"));
        return processors;
    }

    @Override
    public int getExpectedProxyPort() {
        return 8734;
    }

    @Override
    public String getExpectedProxyHost() {
        return "localhost";
    }

    @Override
    public boolean getExpectedToolConfigurationSkip() {
        return true;
    }

    @Override
    public List<String> getExpectedToolConfigurationConfigFilesEndings() {
        List<String> endingsList = super.getExpectedToolConfigurationConfigFilesEndings();
        endingsList.add(File.separator + "src" + File.separator + "antennaconf.xml");
        endingsList.add(File.separator + "src" + File.separator + "antennaconf2.xml");
        return endingsList;
    }
}

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package net.sourceforge.eclipsejetty.launch.configuration;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaDependenciesTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab;

/**
 * UI
 * 
 * @author Christian K&ouml;berl
 * @author Manfred Hantschel
 */
public class JettyLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup
{
    public JettyLaunchConfigurationTabGroup()
    {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog,
     *      java.lang.String)
     */
    public void createTabs(final ILaunchConfigurationDialog dialog, final String mode)
    {
        final ILaunchConfigurationTab[] tabs =
            new ILaunchConfigurationTab[]{new JettyLaunchConfigurationTab(), new JavaArgumentsTab(),
                new JettyLaunchAdvancedConfigurationTab(), new JettyLaunchDependencyConfigurationTab(),
                new JavaJRETab(), new JavaDependenciesTab(), new SourceLookupTab(), new EnvironmentTab(), new CommonTab()};

        setTabs(tabs);
    }
}

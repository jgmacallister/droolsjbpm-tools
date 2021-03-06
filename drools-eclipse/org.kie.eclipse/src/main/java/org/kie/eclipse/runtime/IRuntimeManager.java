package org.kie.eclipse.runtime;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;



public interface IRuntimeManager {
	IRuntime getDefaultRuntime();
	IRuntime[] getConfiguredRuntimes();
	String getBundleRuntimeName();
	String getBundleRuntimeVersion();
	IRuntime createNewRuntime();
	IRuntime createBundleRuntime(String location);
	IRuntime getEffectiveRuntime(IRuntime selectedRuntime, boolean useDefault);
	boolean isMavenized(IRuntime runtime);
	void setRuntimes(IRuntime[] runtimes);
	void setRuntime(IRuntime runtime, IProject project, IProgressMonitor monitor) throws CoreException;
	IRuntime getRuntime(IProject project);
	String getSettingsFilename();
	void recognizeJars(IRuntime runtime);
	void addListener(IRuntimeManagerListener listener);
	void removeListener(IRuntimeManagerListener listener);
}

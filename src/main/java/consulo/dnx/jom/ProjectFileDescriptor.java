/*
 * Copyright 2013-2017 consulo.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package consulo.dnx.jom;

import javax.swing.Icon;

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.psi.PsiFile;
import consulo.awt.TargetAWT;
import consulo.dnx.KRuntimeIcons;
import consulo.dnx.module.extension.KRuntimeModuleExtension;
import consulo.json.jom.JomFileDescriptor;

/**
 * @author VISTALL
 * @since 13.11.2015
 */
public class ProjectFileDescriptor extends JomFileDescriptor<ProjectElement>
{
	public ProjectFileDescriptor()
	{
		super(ProjectElement.class);
	}

	@NotNull
	@Override
	public Icon getIcon()
	{
		return TargetAWT.to(KRuntimeIcons.DotnetFoundation);
	}

	@Override
	@consulo.annotations.RequiredReadAction
	public boolean isMyFile(@NotNull PsiFile psiFile)
	{
		if(KRuntimeModuleExtension.PROJECT_JSON.equals(psiFile.getName()))
		{
			if(ModuleUtilCore.getExtension(psiFile, KRuntimeModuleExtension.class) != null)
			{
				return true;
			}
		}
		return false;
	}
}

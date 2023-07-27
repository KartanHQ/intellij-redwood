package com.nekofar.milad.intellij.redwood.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.redwood.RedwoodBundle.message
import com.nekofar.milad.intellij.redwood.RedwoodIcons

class RedwoodCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "create-redwood-app"
    private val npxCommand = "create-redwood-app"

    override fun getName() = message("redwood.project.generator.name")

    override fun getDescription() = message("redwood.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName() = packageName

    override fun presentablePackageName() = message("redwood.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, npxCommand))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project, baseDir: VirtualFile) = arrayOf(project.name)

    override fun getIcon() = RedwoodIcons.ProjectGenerator
}

package com.nekofar.milad.intellij.redwood.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.redwood.RedwoodBundle
import com.nekofar.milad.intellij.redwood.RedwoodIcons
import javax.swing.Icon

class RedwoodCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "create-redwood-app"
    private val npxCommand = "create-redwood-app"

    override fun getName(): String {
        return RedwoodBundle.message("redwood.project.generator.name")
    }

    override fun getDescription(): String {
        return RedwoodBundle.message("redwood.project.generator.description")
    }

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> {
        return emptyArray()
    }

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName(): String {
        return packageName
    }

    override fun presentablePackageName(): String {
        return RedwoodBundle.message("redwood.project.generator.presentable.package.name")
    }

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, npxCommand))


    override fun generateInTemp(): Boolean {
        return true
    }

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> {
        return arrayOf(project?.name.toString())
    }

    override fun getIcon(): Icon {
        return RedwoodIcons.ProjectGenerator
    }
}

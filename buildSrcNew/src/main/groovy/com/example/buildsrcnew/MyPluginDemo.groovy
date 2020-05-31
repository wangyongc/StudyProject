package com.example.buildsrcnew

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPluginDemo implements Plugin<Project>{
    @Override
    void apply(Project project) {
        def extension = project.extensions.create("wyc", MyExtensionDemo)
        project.afterEvaluate {
            println "Hello ${extension.author}"
        }

        def transeform = new CustomTransform()
        def baseExtension = project.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(transeform)
    }
}

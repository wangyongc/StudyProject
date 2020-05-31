package com.example.buildsrcnew

import com.android.build.api.transform.DirectoryInput
import com.android.build.api.transform.JarInput
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformInvocation
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils


class CustomTransform extends Transform{
    @Override
    String getName() {
        return "CustomTransform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation)


        System.out.println(TAG + ":transform() start ...")

        //获取所有 .class 文件
        Collection<TransformInput> inputCollection = transformInvocation.inputs
        TransformOutputProvider outputProvider = transformInvocation.outputProvider

        inputCollection.each { TransformInput transformInput ->
            System.out.println(TAG + ":transform() inputCollection.each ")

            transformInput.directoryInputs.each { DirectoryInput directoryInput ->
                File dir = directoryInput.file

                System.out.println(TAG + ":transform() transformInput.directoryInputs.each ")

                if (dir) {
                    System.out.println(TAG + ":transform() transformInput.directoryInputs.each -> dir ")

                    dir.traverse(type: FileType.FILES, nameFilter: ~/.*\.class/) { File file ->
                        System.out.println("find class: " + file.name)  // ④
                    }
                }

            }
        }

//                InputStream inputStream = new FileInputStream(dest)
//                ClassReader reader = new ClassReader(inputStream)                         // 1. 创建 ClassReader 读入 .class 文件到内存中
//                ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS)    // 2. 创建 ClassWriter 对象，将操作之后的字节码的字节数组回写
//                ClassVisitor change = new ChangeVisitor(writer)                           // 3. 创建自定义的 ClassVisitor 对象
//                reader.accept(change, ClassReader.EXPAND_FRAMES)                          // 4. 将 ClassVisitor 对象传入 ClassReader 中
//
//                Class clazz = new MyClassLoader().defineClass(className, writer.toByteArray())
//                Object personObj = clazz.newInstance()
//                Method nameMethod = clazz.getDeclaredMethod("onCreate", null)
//                nameMethod.invoke(personObj, null)
//                System.out.println("transform Success!")
//                byte[] code = writer.toByteArray()                                                             // 获取修改后的 class 文件对应的字节数组
//                try {
//                    FileOutputStream fos = new FileOutputStream(dest)    // 将二进制流写到本地磁盘上
//                    fos.write(code)
//                    fos.close()
//                } catch (IOException e) {
//                    e.printStackTrace()
//                }

    }
}

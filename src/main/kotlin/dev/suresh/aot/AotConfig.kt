package dev.suresh.aot

import dev.suresh.data.JavaRec
import dev.suresh.data.KotlinData
import org.springframework.aot.hint.MemberCategory
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportRuntimeHints

@Configuration @ImportRuntimeHints(Hints::class) class AotConfig

class Hints : RuntimeHintsRegistrar {
  override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
    hints.reflection().apply {
      registerType(JavaRec::class.java, *MemberCategory.values())
      registerType(KotlinData::class.java, *MemberCategory.values())
      // registerType(GreetingsController::class.java, MemberCategory.INVOKE_DECLARED_METHODS)
    }
  }
}

package net.kigawa.kweb.bean

import net.kigawa.kweb.entity.Font
import net.kigawa.kweb.entity.Service
import net.kigawa.kweb.entity.Theme
import java.util.function.Supplier


class Preset(private val uriUtil: URIUtil) {
    val services = PresetMap<Service>()
    val themes = PresetMap<Theme>()
    val fonts = PresetMap<Font>()

    companion object {
        const val SERVICE_TOP = "top"
        const val THEME_MAIN = "main"
        const val FONT_JETBRAINS = "jetbrains"
        const val FONT_HANNARI = "hannari"
    }

    init {
        services.add(SERVICE_TOP) {
            Service.create(uriUtil.urlFromPath("/img/home-top.png"), "kigawa.net", "top",
                           "kigawa.net homepage")
        }
        fonts.add(FONT_JETBRAINS) {
            Font("jetbrains", uriUtil.urlFromPath("/font/JetBrainsMono-2.242/fonts/webfonts/JetBrainsMono-Light.woff2"))
        }
        fonts.add(FONT_HANNARI) {
            Font(FONT_HANNARI, uriUtil.urlFromPath("/font/hannari/HannariMincho-Regular.otf"))
        }
        themes.add(THEME_MAIN) {
            Theme(
                "#c7dc68", "#c3d825", "olivedrab", "#dcdcdc",
                "darkgreen", "darkgreen",
                mutableListOf(
                    fonts.get(FONT_JETBRAINS)!!,
                    fonts.get(FONT_HANNARI)!!,
                )
            )
        }
    }

}

class PresetMap<T>() {
    private val serviceMap = mutableMapOf<String, Supplier<T>>()

    fun add(id: String, supplier: Supplier<T>) {
        synchronized(serviceMap) { serviceMap.put(id, supplier) }
    }

    fun get(strId: String): T? {
        return synchronized(serviceMap) { serviceMap[strId] }?.get() ?: return null
    }

    fun getMap(): MutableMap<String, T> {
        val result = mutableMapOf<String, T>()
        val services = synchronized(serviceMap) { LinkedHashMap(serviceMap) }

        services.forEach {
            val service = it.value.get()
            result[it.key] = service
        }
        return result
    }
}
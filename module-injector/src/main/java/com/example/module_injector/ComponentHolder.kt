package com.example.module_injector

interface ComponentHolder<API : FeatureApi, Dependencies: FeatureDependencies> {
    fun init(dependencies: Dependencies)
    fun get(): API
    fun reset()
}

interface FeatureApi
interface FeatureDependencies
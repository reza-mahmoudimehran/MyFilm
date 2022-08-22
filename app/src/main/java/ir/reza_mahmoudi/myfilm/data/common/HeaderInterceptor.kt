package ir.reza_mahmoudi.myfilm.data.common

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("jsonType", "simple")
            .build()
        return chain.proceed(newRequest)
    }
}
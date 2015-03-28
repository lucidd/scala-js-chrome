package chrome.system.cpu


package object bindings {

  type Feature = String

  object Features {

    val MMX: Feature = "mmx"
    val SSE: Feature = "sse"
    val SSE2: Feature = "sse2"
    val SSE3: Feature = "sse3"
    val SSSE3: Feature = "ssse3"
    val SSE4_1: Feature = "sse4_1"
    val SSE4_2: Feature = "sse4_2"
    val AVX: Feature = "avx"

  }

}

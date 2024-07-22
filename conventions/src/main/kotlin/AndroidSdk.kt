import java.text.SimpleDateFormat


object AndroidSdk {
    const val targetSdk = 34
    const val compileSdk = 34
    const val minimumSdk = 21

    const val applicationId = "com.githukudenis.botan.android.app"


    private val code = 0
        .plus(SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis()).plus("00").toInt())
        .plus(0) // change this if you're shipping for the same day

    val versionCode = code
    val versionName = "v".plus(SimpleDateFormat("yyyy.MM (dd)").format(System.currentTimeMillis()))

}